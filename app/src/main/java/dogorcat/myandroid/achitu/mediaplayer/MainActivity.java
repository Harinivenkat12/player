package dogorcat.myandroid.achitu.mediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mediaPlayerPlayButton;
    //private Button mediaPlayerPauseButton;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayerPlayButton = (Button) findViewById(R.id.playButtonId);
        //mediaPlayerPauseButton = (Button) findViewById(R.id.pauseButtonId);



        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.song);

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                int duration=mp.getDuration()/1000;
                Toast.makeText(getApplicationContext() ,"Duration: " +duration,Toast.LENGTH_LONG).show();

            }
        });

        mediaPlayerPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer == null) {
                    return;
                }

                if (mediaPlayer.isPlaying()) {
                    pauseMusic();
                } else {
                    playMusic();
                }
            }
        });
    }

    private void playMusic() {
        mediaPlayer.start();
        mediaPlayerPlayButton.setText("Pause");
    }

    private void pauseMusic() {
        mediaPlayer.pause();
        mediaPlayerPlayButton.setText("Play");
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
    //       // mediaPlayerPauseButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (mediaPlayer.isPlaying()) {
//
//
//                }
//
//            }
//        });

}






