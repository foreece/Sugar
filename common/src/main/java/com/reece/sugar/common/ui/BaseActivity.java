package com.reece.sugar.common.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.reece.sugar.common.CLog;

/**
 * @author Reece
 * @version V1.0
 * @Date 2/15/17
 * @Description
 */

public abstract class BaseActivity extends FragmentActivity {

    protected final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CLog.i(TAG, "onCreate()");
        initVariables();
        initViews();
        loadData();
    }

    @Override
    protected void onStart() {
        super.onStart();
        CLog.i(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        CLog.i(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        CLog.i(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        CLog.i(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        CLog.i(TAG, "onDestroy()");
    }

    protected abstract void initVariables();
    protected abstract void initViews();
    protected abstract void loadData();
}
