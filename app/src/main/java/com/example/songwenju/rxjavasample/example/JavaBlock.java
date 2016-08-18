package com.example.songwenju.rxjavasample.example;

/**
 * songwenju on 16-8-17 : 14 : 55.
 * 邮箱：songwenju@outlook.com
 */
public class JavaBlock {
    public static final String SCHEDULER = "    Observable.just(1, 2, 3, 4)  \n" +
            "                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程  \n" +
            "                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程  \n" +
            "                .subscribe(new Action1<Integer>() {  \n" +
            "            @Override  \n" +
            "            public void call(Integer number) {  \n" +
            "                Log.d(tag, \"number:\" + number);  \n" +
            "            }  \n" +
            "        });  ";


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

    public static final String CACHE_CHECK = "//依次检查memory、disk和network中是否存在数据，任何一步一旦发现数据后面的操作都不执行。\n" +
            "Observable<String> memory = Observable.create(new Observable.OnSubscribe<String>() {  \n" +
            "        @Override  \n" +
            "        public void call(Subscriber<? super String> subscriber) {  \n" +
            "            if (memoryCache != null) {  \n" +
            "                subscriber.onNext(memoryCache);  \n" +
            "            } else {  \n" +
            "                subscriber.onCompleted();  \n" +
            "            }  \n" +
            "        }  \n" +
            "    });  \n" +
            " Observable<String> disk = Observable.create(new Observable.OnSubscribe<String>() {  \n" +
            "        @Override  \n" +
            "        public void call(Subscriber<? super String> subscriber) {  \n" +
            "            String cachePref = rxPreferences.getString(\"cache\").get();  \n" +
            "            if (!TextUtils.isEmpty(cachePref)) {  \n" +
            "                subscriber.onNext(cachePref);  \n" +
            "            } else {  \n" +
            "                subscriber.onCompleted();  \n" +
            "            }  \n" +
            "        }  \n" +
            "    });  \n" +
            "    \n" +
            "    Observable<String> network = Observable.just(\"network\");  \n" +
            "    //依次检查memory、disk、network  \n" +
            "    Observable.concat(memory, disk, network)  \n" +
            "    .first()  \n" +
            "    .subscribeOn(Schedulers.newThread())  \n" +
            "    .subscribe(s -> {  \n" +
            "        memoryCache = \"memory\";  \n" +
            "        System.out.println(\"--------------subscribe: \" + s);  \n" +
            "    });  \n";
    public static final String COMBINE_LATEST = "//注册的时候所有输入信息（邮箱、密码等）合法才点亮注册按钮。\n " +
            "    Observable<CharSequence> _emailObservable = RxTextView.textChanges(_email).skip(1);  \n" +
            "    Observable<CharSequence> _passwordObservable = RxTextView.textChanges(_password).skip(1);  \n" +
            "      \n" +
            "    Observable.combineLatest(_emailObservable,  _passwordObservable,   \n" +
            "                  new Func2<CharSequence, CharSequence, Boolean>() {  \n" +
            "               @Override  \n" +
            "               public Boolean call(CharSequence newEmail,  CharSequence newPassword) {  \n" +
            "                          boolean emailValid = !isEmpty(newEmail) &&  \n" +
            "                                               EMAIL_ADDRESS.matcher(newEmail).matches();  \n" +
            "                   if (!emailValid) {  \n" +
            "                              _email.setError(\"Invalid Email!\");  \n" +
            "                    }  \n" +
            "                    boolean passValid = !isEmpty(newPassword) && newPassword.length() > 8;  \n" +
            "                    if (!passValid) {  \n" +
            "                              _password.setError(\"Invalid Password!\");  \n" +
            "                    }  \n" +
            "                         return emailValid && passValid;  \n" +
            "                      }  \n" +
            "                  }) .subscribe(new Observer<Boolean>() {  \n" +
            "                      @Override  \n" +
            "                      public void onCompleted() { }  \n" +
            "                      @Override  \n" +
            "                      public void onError(Throwable e) {  \n" +
            "                         log.d(\"Error\");  \n" +
            "                      } \n" +
            "                      @Override  \n" +
            "                      public void onNext(Boolean formValid) {  \n" +
            "                         _btnValidIndicator.setEnabled(formValid);    \n" +
            "                      }  \n" +
            "                  });  \n";
    public static final String TEXT_SEARCH = "//  N个结点发生的时间太靠近（即发生的时间差小于设定的值T），debounce就会自动过滤掉前N-1个结点。比如在做搜索的时候，可以使用debounce减少频繁的网络请求。避免每输入（删除）一个字就做一次联想\n" +
            "RxTextView.textChangeEvents(inputEditText)  \n" +
            "          .debounce(400, TimeUnit.MILLISECONDS)   \n" +
            "          .observeOn(AndroidSchedulers.mainThread())  \n" +
            "          .subscribe(new Observer<TextViewTextChangeEvent>() {  \n" +
            "        @Override  \n" +
            "        public void onCompleted() {  \n" +
            "            log.d(\"onComplete\");  \n" +
            "        }  \n" +
            "      \n" +
            "        @Override  \n" +
            "        public void onError(Throwable e) {  \n" +
            "            log.d(\"Error\");  \n" +
            "        }  \n" +
            "      \n" +
            "        @Override  \n" +
            "        public void onNext(TextViewTextChangeEvent onTextChangeEvent) {  \n" +
            "            log.d(format(\"Searching for %s\", onTextChangeEvent.text().toString()));  \n" +
            "        }  \n" +
            "    });  \n";
}
