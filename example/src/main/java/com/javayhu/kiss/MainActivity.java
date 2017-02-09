package com.javayhu.kiss;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.javayhu.kiss.utils.AppUtils;
import com.javayhu.kiss.utils.Utils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Utils.init(this);
    }

    public void gotoUtils(View view) {
        String name = AppUtils.getAppPackageName(this);
        TextView textView = (TextView) findViewById(R.id.textview);
        textView.setText(name);
    }
}
