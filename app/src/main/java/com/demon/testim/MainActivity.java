package com.demon.testim;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.orhanobut.logger.Logger;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.UserInfo;

public class MainActivity extends AppCompatActivity implements RongIM.UserInfoProvider {

    private String token1="iRyKj1WX96TYU/S6hBKR+zIgjTcjMBvVc6U6DWj3wwe1lOHvh0L+eauZmBsQRiHkwcD9yGTU4r5Pid/QPcXWvA==";
    private String token2="RaTzIGTfzFhIObO9vjwKfzIgjTcjMBvVc6U6DWj3wwe1lOHvh0L+eWbpUR6gZRuGBMzVmCThlo464TR7YEV+Bg==";

    private Button btn1;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

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
                        RongIM.setUserInfoProvider(MainActivity.this, true);
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
                        RongIM.setUserInfoProvider(MainActivity.this, true);
                        startActivity(new Intent(MainActivity.this,SuccessActivity.class));
                    }

                    @Override
                    public void onError(RongIMClient.ErrorCode errorCode) {
                        Logger.e("onError2 "+errorCode);
                    }
                });
            }
        });



    }


    @Override
    public UserInfo getUserInfo(String id) {
        //通过id 返回 userinfo
        if (id.equals("10000")){
            return new UserInfo("10000","电信",Uri.parse("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2344898212,1488474846&fm=58&s=2BBD278EC1647D131A7384700300503B"));
        }else if (id.equals("10086")){
            return new UserInfo("10086","移动",Uri.parse("https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=2670985913,3041367251&fm=58"));
        }else {
            return null;
        }

    }
}
