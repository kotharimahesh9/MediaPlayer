package com.mahesh.hp.mediaplayer;

import android.icu.util.TimeUnit;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4;
    ToggleButton t;
    MediaPlayer mediaPlayer;
    ImageView imageView;
    TextView t1,t2,t3,t4;
    SeekBar seekBar;
    int firstTime=0;
    int flag=0;
    int startTime=0;
    int finalTime=0;
    int forwardTime=5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.forward);
        t=(ToggleButton)findViewById(R.id.onOff);
        b2=(Button)findViewById(R.id.next);
        b3=(Button)findViewById(R.id.backward);
        t1=(TextView)findViewById(R.id.textView);
        t2=(TextView)findViewById(R.id.textView3);
        imageView=(ImageView)findViewById(R.id.image);

     
        mediaPlayer=MediaPlayer.create(this,R.raw.song);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    Toast.makeText(getApplicationContext(), "Pausing audio", Toast.LENGTH_LONG).show();

                } else
                {
                    mediaPlayer.start();
                    Toast.makeText(getApplicationContext(), "Playing audio", Toast.LENGTH_LONG).show();

                }
            }
            });



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalTime=mediaPlayer.getDuration();
                int temp=mediaPlayer.getCurrentPosition();
                if(temp+forwardTime<=finalTime){
                 mediaPlayer.seekTo((int) temp+forwardTime);
                }

            }
        });


        //F:\androidProjects\MediaPlayer\app\src\main\res\drawable
    }
}
