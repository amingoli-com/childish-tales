package a.childish_tales.activtiy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.bumptech.glide.Glide;
import com.downloader.Error;
import com.downloader.OnDownloadListener;
import com.downloader.PRDownloader;

import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import a.childish_tales.R;
import a.childish_tales.util.view.ColorUtil;
import a.childish_tales.util.file.FileUtil;
import a.childish_tales.util.view.ViewUtil;

public class InfoStoryActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener, SeekBar.OnSeekBarChangeListener {
    private String TAG = "amingoli78-InfoStoryActivity";
    int downloadId = 0;
    String sound_name = null;
    String sound_url = null;
    MediaPlayer mp;
    ImageView bg_image,btn_play;
    TextView title,desc,writer_narrator,
            time_player_now,time_music_player;
    View layout_play_sound;
    SeekBar seekBar;

    Handler mSeekbarUpdateHandler = new Handler();
    Runnable mUpdateSeekbar = new Runnable() {
        @Override
        public void run() {
            seekBar.setProgress(mp.getCurrentPosition());
            setTimePlayer(mp.getCurrentPosition(),time_player_now);
            mSeekbarUpdateHandler.postDelayed(this, 50);
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        onWindowFocusChanged(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_story);
        idFinder();
        ColorUtil.setGradient(title,"#00000000","#333333");

        sound_name = getIntent().getStringExtra("sound_name");
        sound_url = getIntent().getStringExtra("sound_url");

        if (sound_url!=null){
            Log.d(TAG, "onCreate: "+sound_url);
            layout_play_sound.setVisibility(View.VISIBLE);
            if (!audioExists(sound_name)){
                download(sound_url,sound_name);
            }
        }
        Glide.with(this).load(getIntent().getStringExtra("imageـurl")).into(bg_image);
        title.setText(getIntent().getStringExtra("title"));
        desc.setText(getIntent().getStringExtra("desc"));
        writer_narrator.setText(getIntent().getStringExtra("recorder"));
        seekBar.setOnSeekBarChangeListener(this);
        time_music_player.setText(getIntent().getStringExtra("time"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopMedia();
        PRDownloader.cancelAll();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    /**
     * OnClick */
    public void back(View view) {
        finish();
    }

    public void play_sound(View view) {
        switch (view.getTag().toString()){
            case "play":
                playtMedia();
                break;
            case "stop":
                pausetMedia();
                break;
            default:
                stopMedia();
                break;
        }
    }

    public void intent(View view) {
        switch (view.getTag().toString()){
            case "":

                break;
        }
    }

    /**
     * private void */
    private void playtMedia(){
        if (mp==null){
            btn_play.setTag("stop");
            btn_play.setImageResource(R.drawable.ic_pause);
            mp = new MediaPlayer();
            try {
                if (audioExists(sound_name)){
                    mp.setDataSource(FileUtil.getFileAudioStory(this, sound_name)
                            .getAbsolutePath());
                }else {
                    mp.setDataSource(sound_url);
                }
                mp.prepare();
                mp.setOnCompletionListener(this);
                seekBar.setMax(mp.getDuration());
                mSeekbarUpdateHandler.postDelayed(mUpdateSeekbar, 0);
                setTimePlayer(mp.getDuration(),time_music_player);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            btn_play.setTag("stop");
            btn_play.setImageResource(R.drawable.ic_pause);
        }
        mp.start();
    }
    private void pausetMedia(){
        if (mp!=null){
            btn_play.setTag("play");
            btn_play.setImageResource(R.drawable.ic_play);
            mp.pause();
        }
    }
    private void stopMedia(){
        if (mp!=null){
            btn_play.setTag("play");
            btn_play.setImageResource(R.drawable.ic_play);
            seekBar.setProgress(0);
            mp.stop();
            mp.release();
            mSeekbarUpdateHandler.removeCallbacks(mUpdateSeekbar);
            mp = null;
            time_player_now.setText(R.string.sec_zero);
        }
    }

    private void setTimePlayer(int duration , TextView textView){
        @SuppressLint("DefaultLocale")
        String time = String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(duration),
                TimeUnit.MILLISECONDS.toSeconds(duration) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration))
        );
        textView.setText(time);
    }

    private void idFinder(){
        layout_play_sound = findViewById(R.id.layout_play_sound);
        writer_narrator = layout_play_sound.findViewById(R.id.writer_narrator);
        seekBar = layout_play_sound.findViewById(R.id.seekbar);
        time_player_now = layout_play_sound.findViewById(R.id.time_player_now);
        time_music_player = layout_play_sound.findViewById(R.id.time_music_player);
        btn_play = layout_play_sound.findViewById(R.id.btn_play);

        bg_image = findViewById(R.id.background_image);
        title = findViewById(R.id.title);
        desc = findViewById(R.id.desc);
    }

    private Boolean audioExists(String fileName){
        return FileUtil.getFileAudioStory(this,fileName).exists();
    }

    private void download(String url,String fileName){
        final View customView = getLayoutInflater().inflate(R.layout.item_progress_dialog, null);

        RoundCornerProgressBar cornerProgressBar = customView.findViewById(R.id.RoundCornerProgressBar);
        LottieAnimationView lottie = customView.findViewById(R.id.lottie);
        TextView try_again = customView.findViewById(R.id.try_again);

        AlertDialog alertdialog = new AlertDialog.Builder(this).create();
        alertdialog.setView(customView);
        alertdialog.setCancelable(false);
        alertdialog.setButton(AlertDialog.BUTTON_POSITIVE, getString(R.string.exit), (dialogInterface, i) -> {
            PRDownloader.cancelAll();
            finish();
        });
        alertdialog.show();

        downloadId =
                PRDownloader.download(url,FileUtil.getFileAudioDirectory(this), fileName)
                .build()
                .setOnStartOrResumeListener(() -> {
                    try_again.setText("درحال دریافت");
                    cornerProgressBar.animate().setDuration(500).alpha(1);
                    Log.d(TAG, "setOnStartOrResumeListener: ");
                })
                .setOnPauseListener(() -> {
                    try_again.setText("دانلود متوقف شد");
                    Log.d(TAG, "setOnPauseListener: ");
                })
                .setOnCancelListener(() -> {
                    lottie.setAnimation("error.json");
                })
                .setOnProgressListener(progress -> {

                    String kb = String.valueOf(progress.currentBytes/1024/512);
                    String mb = String.valueOf(progress.currentBytes/1024/1024);
                    try_again.setText(mb+"."+kb+"MP");

                    cornerProgressBar.setMax((int) progress.totalBytes);
                    cornerProgressBar.setProgress((int) progress.currentBytes);
                    Log.d(TAG, "setOnProgressListener: "+progress);
                })
                .start(new OnDownloadListener() {
                    @Override
                    public void onDownloadComplete() {
                        try_again.setText("دانلود تمام شد");
                        alertdialog.dismiss();
                        Log.d(TAG, "onDownloadComplete: ");
                    }

                    @Override
                    public void onError(Error error) {
                        try_again.setText("دانلود ارور داد");
                        Log.d(TAG, "onError: "+error);
                        lottie.setAnimation("error.json");
                        lottie.playAnimation();
                    }
                });



    }

    /**
     *  Listener */
    /* Media Player */
    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        stopMedia();
    }
    /* Seek Bar*/
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (mp!=null){
            if (fromUser && progress != mp.getDuration())
                mp.seekTo(progress);
        }
    }
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {}
}