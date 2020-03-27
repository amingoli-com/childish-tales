package a.childish_tales.activtiy;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.ui.TimeBar;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import a.childish_tales.R;

public class VideoPlayerActivity extends AppCompatActivity {
    String TAG = "amingoli78-VideoPlayerActivity";

    String url = "https://goo.gl/PyKasq";
    TrackSelector trackSelector;
    ExoPlayer exoPlayer;
    PlayerView playerView;
    DataSource.Factory dataSourceFactory;
    MediaSource videoSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        url = getIntent().getStringExtra("url");

        trackSelector = new DefaultTrackSelector();
        exoPlayer = ExoPlayerFactory.newSimpleInstance(this, trackSelector);
        playerView = findViewById(R.id.player_view);
        playerView.setPlayer(exoPlayer);
        exoPlayer.setPlayWhenReady(true);
        dataSourceFactory = new DefaultDataSourceFactory(this, Util.getUserAgent(this, "VideoPlayer"));
        videoSource = new ExtractorMediaSource.Factory(dataSourceFactory).createMediaSource(Uri.parse(url));
        exoPlayer.prepare(videoSource);
    }


    @Override
    protected void onPause() {
        super.onPause();
        exoPlayer.release();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        exoPlayer.release();
    }
}
