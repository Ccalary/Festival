package com.example.caohouhong.festival.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.caohouhong.festival.BaseActivity;
import com.example.caohouhong.festival.R;

/**
 * @author caohouhong
 * @creat 17/5/16 下午1:13
 */

public class PercentViewActivity extends BaseActivity {
    @Override


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_percentview);

    }


    /** 启动活动的最佳写法
     * @param context activity
     * @param str1 参数1
     * @param str2 参数2
     */
    public static void actionStart(Context context, String str1, String str2){
        Intent intent = new Intent(context, PercentViewActivity.class);
        intent.putExtra("param1",str1);
        intent.putExtra("param2",str2);
        context.startActivity(intent);
    }
}
