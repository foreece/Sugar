package com.reece.sugar;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by foreece@gmail.com on 17-2-13.
 */

public class TestActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Test.test1();
    }
}
