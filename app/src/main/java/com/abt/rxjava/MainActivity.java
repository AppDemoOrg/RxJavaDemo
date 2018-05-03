package com.abt.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.show)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //Observable部分, 被观察者部分
        Observable<String> myObservable = Observable.create(
                new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        Logger.d("myObservable, call");
                        subscriber.onNext("John");
                        subscriber.onCompleted();
                    }
                });


        //Subscriber部分，观察者部分
        Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Logger.d("mySubscriber, onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Logger.d("mySubscriber, onError");
            }

            @Override
            public void onNext(String s) {
                textView.setText(s);
                Logger.d("mySubscriber, onNext");
            }
        };

        //将观察者和被观察者相关联，完成subscriber对observable的订阅
        myObservable.subscribe(mySubscriber);
        Logger.d("myObservable.subscribe(mySubscriber)");
    }
}
