package com.qianfeng.xunfei1605;

import android.app.Application;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;

/**
 * Created by dupengfei on 16/8/16.
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化
        SpeechUtility.createUtility(this, SpeechConstant.APPID + "=57b28531");
    }
}
