package com.example.songwenju.rxjavasample.example;

/**
 * songwenju on 16-8-17 : 14 : 55.
 * 邮箱：songwenju@outlook.com
 */
public class JavaBlock {

    public static final String PERIODICALLY = "//轮询请求" +
            "    Observable.create(new Observable.OnSubscribe<String>() {  \n" +
            "                @Override  \n" +
            "                public void call(final Subscriber<? super String> observer) {  \n" +
            "      \n" +
            "                    Schedulers.newThread().createWorker()  \n" +
            "                          .schedulePeriodically(new Action0() {  \n" +
            "                              @Override  \n" +
            "                              public void call() {  \n" +
            "                                  observer.onNext(doNetworkCallAndGetStringResult());  \n" +
            "                              }  \n" +
            "                          }, INITIAL_DELAY, POLLING_INTERVAL, TimeUnit.MILLISECONDS);  \n" +
            "                }  \n" +
            "            }).subscribe(new Action1<String>() {  \n" +
            "                @Override  \n" +
            "                public void call(String s) {  \n" +
            "                    log.d(\"polling….”));  \n" +
            "                }  \n" +
            "            })  ";

    public static final String MERGE = "//一组数据来自网络，一组数据来自文件，需要合并两组数据一起展示。\n" +
            "    Observable.merge(getDataFromFile(), getDataFromNet())  \n" +
            "                  .observeOn(AndroidSchedulers.mainThread())  \n" +
            "                  .subscribe(new Subscriber<String>() {  \n" +
            "                      @Override  \n" +
            "                      public void onCompleted() {  \n" +
            "                          log.d(\"done loading all data\");  \n" +
            "                      }  \n" +
            "      \n" +
            "                      @Override  \n" +
            "                      public void onError(Throwable e) {  \n" +
            "                          log.d(\"error\");  \n" +
            "                      }  \n" +
            "      \n" +
            "                      @Override  \n" +
            "                      public void onNext(String data) {  \n" +
            "                          log.d(\"all merged data will pass here one by one!\")  \n" +
            "                  });  ";

    public static final String TIMER = "//2秒后输出日志“hello world”，然后结束。\n" +
            "    Observable.timer(2, TimeUnit.SECONDS)  \n" +
            "                  .subscribe(new Observer<Long>() {  \n" +
            "                      @Override  \n" +
            "                      public void onCompleted() {  \n" +
            "                          log.d (\"completed\");  \n" +
            "                      }  \n" +
            "      \n" +
            "                      @Override  \n" +
            "                      public void onError(Throwable e) {  \n" +
            "                          log.e(\"error\");  \n" +
            "                      }  \n" +
            "      \n" +
            "                      @Override  \n" +
            "                      public void onNext(Long number) {  \n" +
            "                          log.d (\"hello world\");  \n" +
            "                      }  \n" +
            "                  });  ";


    public static final String INTERVAL = "//每隔2秒输出日志“helloworld”。\n" +
            "    Observable.interval(2, TimeUnit.SECONDS)  \n" +
            "             .subscribe(new Observer<Long>() {  \n" +
            "                 @Override  \n" +
            "                 public void onCompleted() {  \n" +
            "                    log.d (\"completed\");  \n" +
            "                 }  \n" +
            "      \n" +
            "                 @Override  \n" +
            "                 public void onError(Throwable e) {  \n" +
            "                    log.e(\"error\");  \n" +
            "                 }  \n" +
            "      \n" +
            "                 @Override  \n" +
            "                 public void onNext(Long number) {  \n" +
            "                    log.d (\"hello world\");  \n" +
            "                 }  \n" +
            "             });  ";
    public static final String THROTTLEFIRST = "//1s以内连续点击算一次点击，debounce也能达到同样的效果\n" +
            "    RxView.clicks(button)  \n" +
            "                  .throttleFirst(1, TimeUnit.SECONDS)  \n" +
            "                  .subscribe(new Observer<Object>() {  \n" +
            "                      @Override  \n" +
            "                      public void onCompleted() {  \n" +
            "                            log.d (\"completed\");  \n" +
            "                      }  \n" +
            "      \n" +
            "                      @Override  \n" +
            "                      public void onError(Throwable e) {  \n" +
            "                            log.e(\"error\");  \n" +
            "                      }  \n" +
            "      \n" +
            "                      @Override  \n" +
            "                      public void onNext(Object o) {  \n" +
            "                           log.d(\"button clicked\");  \n" +
            "                      }  \n" +
            "                  });  ";

    public static final String LIST = "    String[] names = {\"Tom\", \"Lily\", \"Alisa\", \"Sheldon\", \"Bill\"};  \n" +
            "    Observable  \n" +
            "            .from(names)  \n" +
            "            .subscribe(new Action1<String>() {  \n" +
            "                @Override  \n" +
            "                public void call(String name) {  \n" +
            "                    log.d(name);  \n" +
            "                }  \n" +
            "            });  ";
    public static final String UPDATE = "//勾选了某个checkbox，自动更新对应的preference\n" +
            "    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);  \n" +
            "    RxSharedPreferences rxPreferences = RxSharedPreferences.create(preferences);  \n" +
            "      \n" +
            "    Preference<Boolean> checked = rxPreferences.getBoolean(\"checked\", true);  \n" +
            "      \n" +
            "    CheckBox checkBox = (CheckBox) findViewById(R.id.cb_test);  \n" +
            "    RxCompoundButton.checkedChanges(checkBox)  \n" +
            "            .subscribe(checked.asAction());  ";


}
