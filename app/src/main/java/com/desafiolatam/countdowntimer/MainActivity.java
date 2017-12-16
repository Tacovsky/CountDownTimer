package com.desafiolatam.countdowntimer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    Button button;
    TextView textView;
    long mInitialTime = DateUtils.DAY_IN_MILLIS*6 + DateUtils.HOUR_IN_MILLIS*23
            + DateUtils.MINUTE_IN_MILLIS*59 + DateUtils.SECOND_IN_MILLIS*59;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        button= (Button) findViewById(R.id.button);
        textView= (TextView) findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                new CountDownTimer(mInitialTime, 1000){
                    StringBuilder time = new StringBuilder();
                    public void onTick(long millisUntilFinished){
                        time.setLength(0);
                        if(millisUntilFinished > DateUtils.DAY_IN_MILLIS){
                            long count = millisUntilFinished/DateUtils.DAY_IN_MILLIS;
                            if(count > 1){
                                time.append(count).append(" days ");
                            }else{
                                time.append(count).append(" day ");
                            }
                            millisUntilFinished %= DateUtils.DAY_IN_MILLIS;

                        }
                        time.append(DateUtils.formatElapsedTime(Math.round(millisUntilFinished / 1000)));
                        textView.setText(time.toString());

                    }
                    public  void onFinish(){
                        textView.setText("FINISH!!");
                    }
                }.start();
            }
        });
    }
}
