package com.qianfeng.glide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Glide 默认是rgb565 ，支持gif
 * <p/>
 * 把自己的想法通过set方法或者建造者,框架通过回调告知我们状态
 * <p/>
 * 开发过成功到底使用哪一个？
 * 老员工和领导指定
 * 首先看需求{
 * xutils（个人开发者）
 * ormlite+glie(picasso)+okhttp
 * 自己公司内部封装 (有些公司虽然表面上看不出来使用第三方开源的
 * ，但是你进入源码中之后发现其实是对第三方做了一个封装)
 * 场景：
 * 之前有一个项目使用x2去做http请求，x2在6.0之后缺少支持。
 * 换框架。
 * 就算第三方框架使用起来多么简单，也不要在activity中直接使用第三方的代码，
 * <p/>
 * 而是封装成一个工具类。便于框架的更改和代码的维护。
 * <p/>
 * 假设封装一个图片处理框架
 * 1创建一个单例的类
 * 2传递参数的方法，个人建议采用Picasso这种传参传参，链式，建造者
 * 3图片加载是否成功的状态,回调
 * <p/>
 * <p/>
 * <p/>
 * }
 */
public class MainActivity extends AppCompatActivity {

    protected ImageView mImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);

        initView();
        Glide.with(this).load(Consts.IMG_URL)
                //.downloadOnly()仅下载
                .override(200, 200)//重新设置宽高
                .into(mImg);
    }

    private void initView() {
        mImg = (ImageView) findViewById(R.id.img);
    }
}
