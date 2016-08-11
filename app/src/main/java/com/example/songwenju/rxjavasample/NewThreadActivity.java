package com.example.songwenju.rxjavasample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.songwenju.rxjavasample.util.LogUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * songwenju on 16-8-11 : 14 : 20.
 * 邮箱：songwenju@outlook.com
 */
public class NewThreadActivity extends Activity {
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        ButterKnife.bind(this);
        ArrayList<String> imageLists = getIntent().getStringArrayListExtra("imageList");

        for (String imageUrl : imageLists) {
            LogUtil.i(this, "NewThreadActivity.onCreate." + imageUrl);
        }
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));

    }
}
