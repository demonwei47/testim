package com.demon.testim;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import io.rong.imkit.RongIM;
import io.rong.imlib.model.UserInfo;

public class SuccessActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        btn1 = (Button) findViewById(R.id.btn_chat1);
        btn2 = (Button) findViewById(R.id.btn_chat2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (RongIM.getInstance() != null)
                    RongIM.getInstance().startPrivateChat(SuccessActivity.this, "10000", "与电信聊天");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (RongIM.getInstance() != null)
                    RongIM.getInstance().startPrivateChat(SuccessActivity.this, "10086", "与移动聊天");
            }
        });

    }

}
