package com.example.caohouhong.festival.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.ListView;

import com.example.caohouhong.festival.BaseActivity;
import com.example.caohouhong.festival.R;
import com.example.caohouhong.festival.adapter.RecycleAdapter;
import com.example.caohouhong.festival.bean.Festival;
import com.example.caohouhong.festival.bean.FestivalLab;
import com.example.caohouhong.festival.view.NavLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author caohouhong
 * @creat 17/5/17 下午1:05
 */

public class RecycleActivity extends BaseActivity {

    @BindView(R.id.id_nav_layout)
    NavLayout navLayout;

    private List<Festival> festivals = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");

        //设置标题
        navLayout.setTitleStr(title);

        initFestival();

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.id_recycle);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        RecycleAdapter adapter = new RecycleAdapter(festivals);
        recyclerView.setAdapter(adapter);
    }

    private void initFestival() {

      festivals = FestivalLab.getInstance().getFestivals();
    }

    /**
     * @param context activity
     * @param title   标题
     */
    public static void actionStart(Context context, String title){
        Intent intent = new Intent(context, RecycleActivity.class);
        intent.putExtra("title", title);
        context.startActivity(intent);
    }
}
