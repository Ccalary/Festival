package com.example.caohouhong.festival;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * @author caohouhong
 * @creat 17/5/16 上午11:08
 */

public class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //打印类的消息
        Log.d("BaseActivity",getClass().getSimpleName());
    }
}
