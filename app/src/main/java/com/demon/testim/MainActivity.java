package com.demon.testim;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.orhanobut.logger.Logger;

import java.net.URL;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.UserInfo;

public class MainActivity extends AppCompatActivity implements RongIM.UserInfoProvider {

    private String id1="10086";
    private String id2="10000";

    private String name1="移动";
    private String name2="电信";

    private String url1="https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=2670985913,3041367251&fm=58";
    private String url2="https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2344898212,1488474846&fm=58&s=2BBD278EC1647D131A7384700300503B";



    private String token1="iRyKj1WX96TYU/S6hBKR+zIgjTcjMBvVc6U6DWj3wwe1lOHvh0L+eauZmBsQRiHkwcD9yGTU4r5Pid/QPcXWvA==";
    private String token2="RaTzIGTfzFhIObO9vjwKfzIgjTcjMBvVc6U6DWj3wwe1lOHvh0L+eWbpUR6gZRuGBMzVmCThlo464TR7YEV+Bg==";

    private Button btn1;
    private Button btn2;
    private Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RongIM.connect(token1, new RongIMClient.ConnectCallback() {
                    @Override
                    public void onTokenIncorrect() {
                        Logger.e("token1 过期");
                    }

                    @Override
                    public void onSuccess(String id) {
                        Logger.e("移动 onSuccess1 id "+id);
                        //RongIM.setUserInfoProvider(MainActivity.this, true);
                        RongIM.getInstance().setCurrentUserInfo(new UserInfo(id1,name1,Uri.parse(url1)));
                        startActivity(new Intent(MainActivity.this,SuccessActivity.class));
                    }

                    @Override
                    public void onError(RongIMClient.ErrorCode errorCode) {
                        Logger.e("onError1 "+errorCode);
                    }
                });
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RongIM.connect(token2, new RongIMClient.ConnectCallback() {
                    @Override
                    public void onTokenIncorrect() {
                        Logger.e("token2 过期");

                    }

                    @Override
                    public void onSuccess(String id) {
                        Logger.e("onSuccess2 id "+id);
                        //RongIM.setUserInfoProvider(MainActivity.this, true);
                        RongIM.getInstance().setCurrentUserInfo(new UserInfo(id2,name2,Uri.parse(url2)));
                        startActivity(new Intent(MainActivity.this,SuccessActivity.class));
                    }

                    @Override
                    public void onError(RongIMClient.ErrorCode errorCode) {
                        Logger.e("onError2 "+errorCode);
                    }
                });
            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name1="联通";
                url1="https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=1354220069,2074630107&fm=58";
                RongIM.getInstance().refreshUserInfoCache(new UserInfo(id1,name1,Uri.parse(url1)));

            }
        });
    }


    @Override
    public UserInfo getUserInfo(String id) {
        //通过id 返回 userinfo
        if (id.equals("10000")){
            return new UserInfo(id1,name1,Uri.parse(url1));
        }else if (id.equals("10086")){
            return new UserInfo(id2,name2,Uri.parse(url2));
        }else {
            return null;
        }
    }
}
