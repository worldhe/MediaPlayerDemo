package com.rhct.mediaplayerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int[] buttons = new int[]{
            R.id.btn_a,
            R.id.btn_b,
            R.id.btn_c,
            R.id.btn_d
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 0; i < buttons.length; i++){
            findViewById(buttons[i]).setOnClickListener(this);
        }



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_a:
                Intent intent_a = new Intent(this, VideoViewActivity.class);
                startActivity(intent_a);
                break;
            case R.id.btn_b:

                break;
            case R.id.btn_c:

                break;
            case R.id.btn_d:

                break;
            default:
                break;
        }
    }
}
