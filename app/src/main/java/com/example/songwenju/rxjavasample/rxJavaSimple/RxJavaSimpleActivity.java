package com.example.songwenju.rxjavasample.rxJavaSimple;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;

import com.example.songwenju.rxjavasample.AppConstant;
import com.example.songwenju.rxjavasample.R;
import com.example.songwenju.rxjavasample.util.BitmapUtil;
import com.example.songwenju.rxjavasample.util.LogUtil;

import java.util.concurrent.Callable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * songwenju on 16-8-12 : 10 : 00.
 * 邮箱：songwenju@outlook.com
 */
public class RxJavaSimpleActivity extends Activity {
    @BindView(R.id.image)
    ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_new_thread, R.id.btn_rxjava, R.id.btn_async_task})
    void queryData(View view) {
        switch (view.getId()) {
            case R.id.btn_new_thread:
                newThread();
                break;
            case R.id.btn_async_task:
                asyncTask();
                break;
            case R.id.btn_rxjava:
                rxJava();
                break;
        }
    }

    //new thread about
    private final int BITMAP_WHAT = 0;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case BITMAP_WHAT:
                    Bitmap bitmap = (Bitmap) msg.obj;
                    LogUtil.i(this, "RxJavaActivity.handleMessage." + bitmap);
                    mImage.setImageBitmap(bitmap);
                    break;
            }
        }
    };

    /**
     * 开启线程请求网络
     */
    private void newThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Bitmap httpBitmap = BitmapUtil.getHttpBitmap(AppConstant.URL_PRODUCT_1);
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

    //asyncTask about
    private void asyncTask() {

        new AsyncTask<Void, Void, Bitmap>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected Bitmap doInBackground(Void... params) {
                return BitmapUtil.getHttpBitmap(AppConstant.URL_PRODUCT_2);
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                super.onPostExecute(bitmap);
                mImage.setImageBitmap(bitmap);
            }

        }.execute();
    }


    //rxJava about
    private void rxJava() {
        Observable
                .fromCallable(new Callable<Bitmap>() {
                    @Override
                    public Bitmap call() throws Exception {
                        return BitmapUtil.getHttpBitmap(AppConstant.URL_PRODUCT_3);
                    }
                })
                .subscribeOn(Schedulers.newThread())  //订阅在子线程
                .observeOn(AndroidSchedulers.mainThread()) //在主线程进行
                .subscribe(new Observer<Bitmap>() {
                    @Override
                    public void onCompleted() {
                        LogUtil.i(this,"RxJavaSimpleActivity.onCompleted.");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Bitmap s) {
                        mImage.setImageBitmap(s);
                    }
                });

    }


}
