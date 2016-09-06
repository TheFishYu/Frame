package com.qianfeng.okhttputils_1605;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.qianfeng.okhttputils_1605.modle.GETM;
import com.qianfeng.okhttputils_1605.modle.LoginM;
import com.qianfeng.okhttputils_1605.modle.RegistM;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.FileCallBack;

import java.io.File;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 语言就是一种工具
 * 开发过程中到底在做哪些事情？
 * <p/>
 * <p/>
 * 解决问题的能力  （筛选，购物车）
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected Button mGet;
    protected Button mPost;
    protected Button mDownload;
    protected Button mUpload;
    protected TextView mText;
    protected ImageView mImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.get) {
            testGet();

        } else if (view.getId() == R.id.post) {

            testPost();

        } else if (view.getId() == R.id.download) {
            testDownload();

        } else if (view.getId() == R.id.upload) {

        }
    }

    private void testPost() {

        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download/1605.png";

        File file = new File(path);
        OkHttpUtils.post().url(Consts.POST_URL)
                .addParams("nikename", "pfdu")
                .addParams("username", "pfduz12z23")
                .addParams("password", "123456")
                        //文件上传  键    文件名字     文件file对象
                .addFile("portrait", "1605.png", file)
                .build().execute(new Callback<RegistM>() {
            @Override
            public RegistM parseNetworkResponse(Response response, int id) throws Exception {

                Gson gson = new Gson();
                String string = response.body().string();
                RegistM loginM = gson.fromJson(string, RegistM.class);
                return loginM;
            }

            @Override
            public void onError(Call call, Exception e, int id) {

                Log.e("onError", e.getMessage());
            }

            @Override
            public void onResponse(RegistM response, int id) {

                mText.setText(response.toString());

            }

            //可以选择性的重写进度回调
            @Override
            public void inProgress(float progress, long total, int id) {
                super.inProgress(progress, total, id);

                Log.e("progress", "" + progress);
            }
        });

    }


    private void testDownload() {
        Callback<LoginM> callback = new Callback<LoginM>() {
            @Override
            public LoginM parseNetworkResponse(Response response, int id) throws Exception {

                Gson gson1 = new Gson();
                LoginM loginM = gson1.fromJson(response.body().string(), LoginM.class);
                return loginM;
            }

            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(LoginM response, int id) {

                //TODO 使用网络数据尽量都进行判断
                String portrait = response.getData().getPortrait();

                String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();

                String dir = absolutePath + "/Download";

                String file = "1605okhttpu.png";
                //文件下载
                FileCallBack callback1 = new FileCallBack(dir, file) {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                        Log.e("onError", e.getMessage());
                    }

                    @Override
                    public void onResponse(File response, int id) {


                        Log.e("onResponse", response.getAbsolutePath());

                    }

                    //添加进度
                    @Override
                    public void inProgress(float progress, long total, int id) {
                        super.inProgress(progress, total, id);
                    }
                };


                //开发过程中并不使用此方式去加载图片
                //okhttputils的侧重点是网络请求，所以图片处理的相关功能比较少
                //okhttputils 的图片吃力只是简单的把网络图片转成bitmap，没有三级缓存
                OkHttpUtils.get().url("http://139.129.19.51/story/Uploads/portrait/" + portrait)
                        .build().execute(new BitmapCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(Bitmap response, int id) {
                        mImg.setImageBitmap(response);
                    }
                });


            }
        };
        OkHttpUtils.post()
                .url(Consts.POST_LOGIN_URL)
                .addParams("username", "pfduz12z23")
                .addParams("password", "123456")
                .build()
                .execute(callback);

    }

    private void initView() {
        mGet = (Button) findViewById(R.id.get);
        mGet.setOnClickListener(MainActivity.this);
        mPost = (Button) findViewById(R.id.post);
        mPost.setOnClickListener(MainActivity.this);
        mDownload = (Button) findViewById(R.id.download);
        mDownload.setOnClickListener(MainActivity.this);
        mUpload = (Button) findViewById(R.id.upload);
        mUpload.setOnClickListener(MainActivity.this);
        mText = (TextView) findViewById(R.id.text);
        mImg = (ImageView) findViewById(R.id.img);
    }


    private void testGet() {


        OkHttpUtils.get()
                //路径
                .url(Consts.GET_URL)
                        //参数
                .addParams("id", "100003")
                        //完成配置
                .build()
                        //开启一个异步请求
                .execute(new Callback<GETM>() {

                    //解析json
                    //执行在子线程中
                    @Override
                    public GETM parseNetworkResponse(Response response, int id) throws Exception {
                        Gson gson = new Gson();
                        //拿到一个返回的json字符串
                        String string = response.body().string();
                        GETM getm = gson.fromJson(string, GETM.class);
                        return getm;
                    }

                    //请求失败
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        //不要
                        Toast.makeText(MainActivity.this, "请求异常", Toast.LENGTH_SHORT).show();
                        Log.e("onError", e.getMessage());
                    }

                    //请求成功+解析之后
                    //UI线程
                    @Override
                    public void onResponse(GETM response, int id) {

                        //如果数据量比较大，数据解析也是耗时的

                        mText.setText(response.toString());


                    }
                });

    }

}
