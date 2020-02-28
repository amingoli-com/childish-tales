package a.childish_tales;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class InfoStoryActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener, SeekBar.OnSeekBarChangeListener {
    MediaPlayer mp;
    ImageView bg_image,btn_play;
    TextView title,desc,writer_narrator,time,
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

        bg_image.setImageResource(getIntent().getIntExtra("image",R.drawable.s_1));
        title.setText(getIntent().getStringExtra("title"));
        desc.setText(getIntent().getStringExtra("desc"));
        writer_narrator.setText(getIntent().getStringExtra("writer"));
        writer_narrator.append(", "+getIntent().getStringExtra("narrator"));
        time.setText(getIntent().getStringExtra("time"));
        seekBar.setOnSeekBarChangeListener(this);
        time_music_player.setText(getIntent().getStringExtra("time"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopMedia();
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
    /**
     * private void */
    private void playtMedia(){
        if (mp==null){
            btn_play.setTag("stop");
            btn_play.setImageResource(R.drawable.ic_pause);
            mp = MediaPlayer.create(getApplication(), R.raw.story);
            mp.setOnCompletionListener(this);
            seekBar.setMax(mp.getDuration());
            mSeekbarUpdateHandler.postDelayed(mUpdateSeekbar, 0);
            setTimePlayer(mp.getDuration(),time_music_player);
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
        seekBar = layout_play_sound.findViewById(R.id.seekbar);
        time_player_now = layout_play_sound.findViewById(R.id.time_player_now);
        time_music_player = layout_play_sound.findViewById(R.id.time_music_player);
        btn_play = layout_play_sound.findViewById(R.id.btn_play);
        bg_image = findViewById(R.id.background_image);
        title = findViewById(R.id.title);
        desc = findViewById(R.id.desc);
        writer_narrator = findViewById(R.id.writer_narrator);
        time = findViewById(R.id.time);
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