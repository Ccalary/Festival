package com.example.caohouhong.festival.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.caohouhong.festival.BaseActivity;
import com.example.caohouhong.festival.R;
import com.example.caohouhong.festival.bean.Festival;
import com.example.caohouhong.festival.bean.FestivalLab;
import com.example.caohouhong.festival.bean.Msg;

/**
 * Created by caohouhong on 17/5/11.
 */

public class SendMsgActivity extends BaseActivity implements View.OnClickListener {

    public static final String KEY_FESTIVAL_ID = "festivalId";
    public static final String KEY_MSG_ID = "msgId";
    private int mFestivalId;
    private int msgId;

    private Festival mFestival;
    private Msg mMsg;

    private EditText mEditText;

    private Button sendButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_msg);

        initData();

        initView();
    }

    private void initView() {
        mEditText = (EditText) findViewById(R.id.id_edit_text);
        sendButton = (Button) findViewById(R.id.id_send_msg_btn);
        sendButton.setOnClickListener(this);

        if (msgId != -1) {
            mMsg = FestivalLab.getInstance().getMsgByMsgId(msgId);
            mEditText.setText(mMsg.getContent());
        }
    }

    private void initData() {
        mFestivalId = getIntent().getIntExtra(KEY_FESTIVAL_ID, -1);
        msgId = getIntent().getIntExtra(KEY_MSG_ID, -1);

        setTitle(FestivalLab.getInstance().getFestivalById(mFestivalId).getName());
    }

    public static void toActivity(Context context, int mFestivalId, int msgId) {

        Intent intent = new Intent(context, SendMsgActivity.class);
        intent.putExtra(KEY_FESTIVAL_ID, mFestivalId);
        intent.putExtra(KEY_MSG_ID, msgId);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
      if (v.getId() == R.id.id_send_msg_btn){
         Intent intent = new Intent(Intent.ACTION_VIEW);
          intent.setData(Uri.parse("http://www.baidu.com"));
          startActivity(intent);

      }
    }
}