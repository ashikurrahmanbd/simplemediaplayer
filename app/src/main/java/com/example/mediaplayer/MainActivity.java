package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton playButton;
    ImageButton pauseButton;

    MediaPlayer mediaPlayer;

    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        playButton = (ImageButton) findViewById(R.id.playbutton);

        pauseButton = (ImageButton) findViewById(R.id.pausebutton);

        mediaPlayer = MediaPlayer.create(this, R.raw.jareure);

        textView = (TextView) findViewById(R.id.durationid);



        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mediaPlayer != null ){
                    mediaPlayer.start();
                    int duration = mediaPlayer.getDuration()/1000;

                    int minute = duration/60;

                    int remainderSecond = duration%60;

                    textView.setText("Song Duration "+minute+":"+remainderSecond);

                    Toast.makeText(MainActivity.this, "Song playing", Toast.LENGTH_SHORT).show();
                }



            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer != null){

                    mediaPlayer.pause();

                }
            }
        });

    }


    //ondestroy method


    @Override
    protected void onDestroy() {

        if (mediaPlayer != null && mediaPlayer.isPlaying() ){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }

        super.onDestroy();
    }
}
