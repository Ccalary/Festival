package com.example.caohouhong.festival.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.caohouhong.festival.BaseActivity;
import com.example.caohouhong.festival.R;
import com.example.caohouhong.festival.adapter.BrandListAdapter;
import com.example.caohouhong.festival.model.AdvertiseListModel;
import com.example.caohouhong.festival.model.AdvertiseModel;
import com.example.caohouhong.festival.request.CBHttpRequest;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by caohouhong on 17/5/12.
 */

public class BrandActivity extends BaseActivity implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {

    private ArrayList<AdvertiseModel> mAdsList = new ArrayList<>();

    @BindView(R.id.id_listView)
    ListView listView;

    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefreshLayout;

    private BrandListAdapter mAdapter;

    private LinearLayout layout1;
    private LinearLayout layout2;
    private LinearLayout layout3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand);

        ButterKnife.bind(this);
        View headerView = getLayoutInflater().inflate(R.layout.header_brand_main, null);

        layout1 = (LinearLayout) headerView.findViewById(R.id.id_buy);
        layout2 = (LinearLayout) headerView.findViewById(R.id.id_cate);
        layout3 = (LinearLayout) headerView.findViewById(R.id.id_sale);

        layout1.setOnClickListener(this);
        layout2.setOnClickListener(this);
        layout3.setOnClickListener(this);

        swipeRefreshLayout.setOnRefreshListener(this);

        //设置header
        listView.addHeaderView(headerView);

        mAdapter = new BrandListAdapter(this, mAdsList);

        listView.setAdapter(mAdapter);

        requestData();
    }

    /**
     * 数据请求
     */
    private void requestData() {

        CBHttpRequest.getBrandInterface()
                .getBrandHomeAdsList("3")
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AdvertiseListModel>() {
                    @Override
                    public void onCompleted() {
                        Log.d("brand","complete");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("brand","error");
                    }

                    @Override
                    public void onNext(AdvertiseListModel advertiseListModel) {

                        mAdsList.clear();
                        mAdsList.addAll(advertiseListModel.data);
                        Log.d("brand",mAdsList.toString());

                        mAdapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.id_buy:

                RecycleActivity.actionStart(BrandActivity.this,"这是标题");

                break;

            case R.id.id_cate:
                Toast.makeText(this,"cate",Toast.LENGTH_SHORT).show();
                break;

            case R.id.id_sale:
                Toast.makeText(this,"sale",Toast.LENGTH_SHORT).show();
                break;
        }

    }

    @Override
    public void onRefresh() {
        requestData();
    }
}
