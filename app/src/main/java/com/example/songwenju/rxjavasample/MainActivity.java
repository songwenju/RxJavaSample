package com.example.songwenju.rxjavasample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.songwenju.rxjavasample.rxJavaSimple.RxJavaSceneActivity;
import com.example.songwenju.rxjavasample.rxJavaSimple.RxJavaSimpleActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn_rx_simple)
    Button mBtnRxSimple;
    @BindView(R.id.btn_rx_recycler)
    Button mBtnRxRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_rx_simple,R.id.btn_rx_recycler})
    void selectActivity(View view){
        Intent intent = null;
        switch (view.getId()){
            case R.id.btn_rx_simple:
                intent = new Intent(this, RxJavaSimpleActivity.class);
                break;
            case R.id.btn_rx_recycler:
                intent = new Intent(this, RxJavaSceneActivity.class);
                break;
        }

        startActivity(intent);
    }

}
