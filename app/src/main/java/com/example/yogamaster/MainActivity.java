package com.example.yogamaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    //private Button button;
    private TextView countdownText;
    private Button countdownButton;
    private Button resetButton;
    private CountDownTimer countDownTimer;
    private long timeLeft = 30000;
    private boolean timerRunning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countdownText = findViewById(R.id.countdown_text);
        countdownButton = findViewById(R.id.countdown_button);
        resetButton = findViewById(R.id.button);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);

//        final ArrayList<Integer> selectedImages = viewPagerAdapter.selectedImages;
//        button = (Button) findViewById(R.id.button);
        countdownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
//                Bundle input = new Bundle();
//                for (int i = 0; i < selectedImages.size(); i++) {
//                    input.putInt("" + i, selectedImages.get(i));
//                }
//                intent.putExtras(input);
//                startActivity(intent);
                  startStop();
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
//                Bundle input = new Bundle();
//                for (int i = 0; i < selectedImages.size(); i++) {
//                    input.putInt("" + i, selectedImages.get(i));
//                }
//                intent.putExtras(input);
//                startActivity(intent);
                timeLeft = 30000;
                updateTimer();
            }
        });


    }
    public void startStop() {
        if (timerRunning) {
            stopTimer();
        } else {
            startTimer();
        }
    }

    public void startTimer() {
        countDownTimer = new CountDownTimer(timeLeft, 1000) {
            @Override
            public void onTick(long l) {
                timeLeft = l;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();
        countdownButton.setText("PAUSE");
        timerRunning = true;
    }
    public void stopTimer() {
        countDownTimer.cancel();
        countdownButton.setText("START");
        timerRunning = false;
    }
    public void updateTimer() {
        int minutes = (int) timeLeft / 60000;
        int seconds = (int) timeLeft % 60000 / 1000;

        String timeLeftText;

        timeLeftText = "" +minutes;
        timeLeftText += ":";
        if (seconds < 10) timeLeftText += "0";
        timeLeftText += seconds;
        countdownText.setText(timeLeftText);
    }
}
