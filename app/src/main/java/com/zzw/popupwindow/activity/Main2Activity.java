package com.zzw.popupwindow.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.zzw.popupwindow.R;
import com.zzw.popupwindow.view.CommonPopupWindow;

import java.util.Timer;
import java.util.TimerTask;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private CommonPopupWindow window;
    private ImageView mIv;
    private LinearLayout mRoot;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initPopupWindow() {
        // get the height of screen
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int screenHeight = metrics.heightPixels;
//        (int) (screenHeight * 0.7)
        // create popup window
        window = new CommonPopupWindow(this, R.layout.layout, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT ) {

            private EditText et;

            @Override
            protected void initView() {
                View view = getContentView();
                et = (EditText) view.findViewById(R.id.et);
            }

            @Override
            protected void initEvent() {
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    public void run() {
                        et.setFocusable(true);
                        et.setFocusableInTouchMode(true);
                        et.requestFocus();
                        InputMethodManager inputManager = (InputMethodManager) et.getContext()
                                .getSystemService(Context.INPUT_METHOD_SERVICE);
                        inputManager.showSoftInput(et, 0);
                    }
                }, 300);

            }

            @Override
            protected void initWindow() {
                super.initWindow();
                PopupWindow instance = getPopupWindow();
                instance.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        WindowManager.LayoutParams lp = getWindow().getAttributes();
                        lp.alpha = 1.0f;
                        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                        getWindow().setAttributes(lp);
                    }
                });
            }
        };
        window.showAtLocation(mRoot, Gravity.BOTTOM, 0, 0);
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.3f;
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setAttributes(lp);
    }

    private void initView() {
        mContext = this;
        mIv = (ImageView) findViewById(R.id.iv);
        mIv.setOnClickListener(this);
        mRoot = (LinearLayout) findViewById(R.id.root);
        mRoot.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        { case R.id.iv :
            initPopupWindow();
              break;
          default:
              break;
        }
    }
}
