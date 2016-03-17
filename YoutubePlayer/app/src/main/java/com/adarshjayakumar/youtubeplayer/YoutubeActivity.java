package com.adarshjayakumar.youtubeplayer;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeActivity extends YouTubeBaseActivity
    implements YouTubePlayer.OnInitializedListener
{
    private String GOOGLE_API_KEY ="AIzaSyBi59wLtpX-HxUZFoBpzoJFXGtpCqHDuik";
    private String YOUTUBE_VIDEO_ID = "C_3d6GntKbk";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(GOOGLE_API_KEY, this);
    }



    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        Toast.makeText(this, " Initialized Youtube player Successfully...", Toast.LENGTH_SHORT).show();
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        youTubePlayer.setPlaybackEventListener(playbackEventListener);

        if(!wasRestored)
        {
            youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID);
        }
    }

    YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener(){

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onPaused() {
            Toast.makeText(YoutubeActivity.this,"Video is Paused OK",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onPlaying() {
            Toast.makeText(YoutubeActivity.this,"Good,Video is Playing OK",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onSeekTo(int i) {

        }

        @Override
        public void onStopped() {

        }
    };
    YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener()
    {
        @Override
        public void onAdStarted() {
            Toast.makeText(YoutubeActivity.this,"Click Ad now",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onLoading() {

        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onVideoStarted() {
            Toast.makeText(YoutubeActivity.this,"Video has started",Toast.LENGTH_LONG).show();
        }
    };
    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Failed to Initialize Youtube player...", Toast.LENGTH_SHORT).show();

    }
}
