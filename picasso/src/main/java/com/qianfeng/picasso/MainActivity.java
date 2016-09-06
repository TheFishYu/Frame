package com.qianfeng.picasso;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected Button mBtn;
    protected ImageView mImg;
    protected Button mBtn2;

    private Object mObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();

        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/1605picassso";

        Picasso build = new Picasso.Builder(this)
                .downloader(new OkHttpDownloader(new File(path)))
                .build();
        Picasso.setSingletonInstance(build);

        mObject = new Object();

        /**
         *
         * picasso控制图片加载与暂停加载
         *
         *
         */


//        ListView listView = null;
//
//        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(AbsListView view, int scrollState) {
//
//                //当listview暂停滑动的时候
//                if (scrollState == SCROLL_STATE_IDLE) {
//                    //开始加载图片
//                    Picasso.with(MainActivity.this).resumeTag(mObject);
//                } else {
//                    //暂停加载
//                    Picasso.with(MainActivity.this).pauseTag(mObject);
//                }
//
//            }
//
//            @Override
//            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn) {
            //加载图片
            //自己封装了三级缓存
            //默认缓存路径在data/data/包名/cache/picasso-cache
            /**
             * 在处理大图或者单一的图片的时候可以放弃存入内存缓存中
             *
             *picasso没有提供一个直接的用于设置自定义缓存路径的方法
             *
             *重写picasso的下载器
             *picasso的下载器是基于okhttp的
             *
             *
             */


            Picasso.with(this).load(Consts.IMG_URL)
                    //默认是 ARGB_8，改为RGB_565舍弃透明度
//                    .config(Bitmap.Config.RGB_565)
//                            //重新设置宽高
//                            //在代码中使用到宽高的时候的单位一般都是px
//                            //占用内存要比在xml中直接给图片设置宽高占用内存少
//                    .resize(200, 200)
//                            //图片加载失败时候的资源
//                    .error(R.mipmap.ic_launcher)
//                            //默认图片，占位图
//                    .placeholder(R.mipmap.ic_launcher)
//
//                            //旋转带黑边
                    .rotate(80)

//                            //使用centerCrop的前提条件是一定要先调用resize
//                    .centerCrop()
//                            //预加载
//                            //.fetch();
                            //设置内存缓存方案，  跳过从内存中查找，跳过存入内存
                    .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)

                    .tag(mObject)
                    .into(mImg);


        } else if (view.getId() == R.id.btn2) {
            /**
             * 预加载使用场景
             * 淘宝首页推荐位置viewpager的图片的预加载
             *
             *viewpager 自己本身就有预加载，可以通过setonnscreenlimit设置预加载个数
             *
             */

            Picasso.with(this).load(Consts.IMG_URL).fetch(new Callback() {
                @Override
                public void onSuccess() {

                    Log.e("fetch", "onSuccess");
                }

                @Override
                public void onError() {

                }
            });

        }
    }

    private void initView() {
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(MainActivity.this);
        mImg = (ImageView) findViewById(R.id.img);
        mBtn2 = (Button) findViewById(R.id.btn2);
        mBtn2.setOnClickListener(MainActivity.this);
    }
}
