package com.demon.testim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.orhanobut.logger.Logger;

public class ConversationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

        Intent intent=getIntent();

        String mTargetId = intent.getData().getQueryParameter("targetId");
        String title = intent.getData().getQueryParameter("title");
        setTitle(title);

        Logger.e(" title "+title+"  mTargetId "+mTargetId);
    }


}
