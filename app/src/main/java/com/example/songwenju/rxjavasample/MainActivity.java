package com.example.songwenju.rxjavasample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> mImageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mImageList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            mImageList.add("http://17tv.com/imges/product-1.png");
        }
    }

    @OnClick({R.id.btn_new_thread, R.id.btn_async_task, R.id.btn_rxjava})
    void requestData(View view) {

        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_new_thread:
                intent = new Intent(this, NewThreadActivity.class);
                intent.putStringArrayListExtra("imageList",mImageList);
                break;
            case R.id.btn_async_task:
                intent = new Intent(this, AsyncTaskActivity.class);
                intent.putStringArrayListExtra("imageList",mImageList);
                break;
            case R.id.btn_rxjava:
                intent = new Intent(this, RxJavaActivity.class);
                intent.putStringArrayListExtra("imageList",mImageList);
                break;
        }
        startActivity(intent);
    }
}
