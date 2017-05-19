package com.example.caohouhong.festival.me;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.caohouhong.festival.BaseActivity;
import com.example.caohouhong.festival.R;
import com.example.caohouhong.festival.adapter.MyAdapter;
import com.example.caohouhong.festival.adapter.MyNewAdapter;
import com.example.caohouhong.festival.bean.ItemBean;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caohouhong on 17/5/10.
 */

public class MeActivity extends BaseActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        mTextView = (TextView) findViewById(R.id.id_textview);

        Intent getIntent = getIntent();
        mTextView.setText(getIntent.getStringExtra("name"));

        final List<ItemBean> itemBeanList = new ArrayList<>();
        for (int i = 0; i < 50 ; i++){
            itemBeanList.add(new ItemBean(R.mipmap.ic_launcher_round, "title"+i, "content"+i));
        }


        ListView listView = (ListView) findViewById(R.id.id_me_listView);

        //HeaderView
        View headerView = View.inflate(this,R.layout.me_header_view, null);
        listView.addHeaderView(headerView);

        listView.setAdapter(new MyNewAdapter(this,itemBeanList));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MeActivity.this, "click" + position, Toast.LENGTH_SHORT).show();

                showNormalDialog();


            }
        });
    }

    private void showNormalDialog(){
        /* @setIcon 设置对话框图标
         * @setTitle 设置对话框标题
         * @setMessage 设置对话框消息提示
         * setXXX方法返回Dialog对象，因此可以链式设置属性
         */
        final AlertDialog.Builder normalDialog =
                new AlertDialog.Builder(MeActivity.this);
        normalDialog.setTitle("我是一个普通Dialog");
        normalDialog.setMessage("你要点击哪一个按钮呢?");
        normalDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                    }
                });
        normalDialog.setNegativeButton("关闭",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                    }
                });
        // 显示
        normalDialog.show();
    }
}
