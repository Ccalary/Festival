package com.example.caohouhong.festival.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.caohouhong.festival.BaseActivity;
import com.example.caohouhong.festival.R;
import com.example.caohouhong.festival.bean.FestivalLab;
import com.example.caohouhong.festival.bean.Msg;
import com.example.caohouhong.festival.fragment.FestivalCategoryFragment;

public class ChooseMsgActivity extends BaseActivity {

    private ListView mLvMsgs;
    private ArrayAdapter<Msg> mAdapter;
    private int mFestivalId;
    private LayoutInflater mInflater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_msg);

        mInflater = LayoutInflater.from(this);

        mFestivalId = getIntent().getIntExtra(FestivalCategoryFragment.ID_FESTIVAL, -1);

        setTitle(FestivalLab.getInstance().getFestivalById(mFestivalId).getName());
        initView();
    }

    private void initView() {
        mLvMsgs = (ListView) findViewById(R.id.id_lv_msgs);
        mLvMsgs.setAdapter(mAdapter = new ArrayAdapter<Msg>(this, -1, FestivalLab.getInstance().getMsgsByFestivalId(mFestivalId)) {
            @NonNull
            @Override
            public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                if (convertView == null) {
                    convertView = mInflater.inflate(R.layout.item_msg, parent, false);
                }

                TextView tv = (TextView) convertView.findViewById(R.id.id_item_msg_text);
                tv.setText(getItem(position).getContent());

                Button button = (Button) convertView.findViewById(R.id.id_button_send);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SendMsgActivity.toActivity(ChooseMsgActivity.this, mFestivalId, getItem(position).getId());
                    }
                });

                return convertView;
            }
        });
    }

}
