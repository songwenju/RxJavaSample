package com.example.songwenju.rxjavasample;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import com.example.songwenju.rxjavasample.util.BitmapUtil;
import com.example.songwenju.rxjavasample.util.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * songwenju on 16-8-11 : 14 : 21.
 * 邮箱：songwenju@outlook.com
 */
public class RxJavaActivity extends Activity {
    private static final int BITMAP_WHAT = 0;
    @BindView(R.id.image)
    ImageView mImage;

    String url = "http://17tv.com/imges/product-1.png";

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case BITMAP_WHAT:
                    Bitmap bitmap = (Bitmap) msg.obj;
                    LogUtil.i(this,"RxJavaActivity.handleMessage."+bitmap);
                    mImage.setImageBitmap(bitmap);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);
        ButterKnife.bind(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Bitmap httpBitmap = BitmapUtil.getHttpBitmap(url);
                Message message = Message.obtain();
                message.obj = httpBitmap;
                message.what = BITMAP_WHAT;
                mHandler.sendMessage(message);
            }
        }).start();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }
}
