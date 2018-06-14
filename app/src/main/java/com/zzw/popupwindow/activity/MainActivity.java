package com.zzw.popupwindow.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.zzw.popupwindow.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button lgdemoBt;
    private Button ppdemoBt;
    private Button mLgdemoBt;
    private Button mPpdemoBt;
    private Button mBtn;
    private LinearLayout mActivityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        lgdemoBt = (Button) findViewById(R.id.lgdemo_bt);
        lgdemoBt.setOnClickListener(this);
        ppdemoBt = (Button) findViewById(R.id.ppdemo_bt);
        ppdemoBt.setOnClickListener(this);
        mLgdemoBt = (Button) findViewById(R.id.lgdemo_bt);
        mLgdemoBt.setOnClickListener(this);
        mPpdemoBt = (Button) findViewById(R.id.ppdemo_bt);
        mPpdemoBt.setOnClickListener(this);
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
        mActivityMain = (LinearLayout) findViewById(R.id.activity_main);
        mActivityMain.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lgdemo_bt:
                Intent intent1 = new Intent(this, GravityActivity.class);
                startActivity(intent1);
                break;
            case R.id.ppdemo_bt:
                Intent intent2 = new Intent(this, PopupActivity.class);
                startActivity(intent2);
                break;

            case R.id.btn:
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                 startActivity(intent);
                break;
        }
    }
}
