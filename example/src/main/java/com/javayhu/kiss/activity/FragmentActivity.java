package com.javayhu.kiss.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.javayhu.kiss.R;
import com.javayhu.kiss.fragment.Demo0Fragment;
import com.javayhu.kiss.utils.FragmentUtils;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 17/02/01
 *     desc  :
 * </pre>
 */
public class FragmentActivity extends AppCompatActivity {

    public Fragment rootFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        rootFragment = FragmentUtils.addFragment(getSupportFragmentManager(), Demo0Fragment.newInstance(), R.id.fragment_container);
    }


    @Override
    public void onBackPressed() {
        if (!FragmentUtils.dispatchBackPress(getSupportFragmentManager())) {
            super.onBackPressed();
        }
    }
}