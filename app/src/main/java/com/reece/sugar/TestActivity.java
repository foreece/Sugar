package com.reece.sugar;

import android.os.Bundle;

import com.reece.sugar.common.ui.BaseActivity;

/**
 * Created by foreece@gmail.com on 17-2-13.
 */

public class TestActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        //Test.testGet();
        Test.testPost();

    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void loadData() {

    }
}
