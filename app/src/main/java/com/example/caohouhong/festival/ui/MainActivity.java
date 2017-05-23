package com.example.caohouhong.festival.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.caohouhong.festival.BaseActivity;
import com.example.caohouhong.festival.R;
import com.example.caohouhong.festival.fragment.FestivalCategoryFragment;
import com.example.caohouhong.festival.me.MeActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    //广播接受测试
    private IntentFilter intentFilter;

    private NetworkChangeReceiver networkChangeReceiver;

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private String[] mTitles = new String[]{"节日短信","发送记录"};

    @BindView(R.id.id_main_button) Button mButton;
    @BindView(R.id.id_btn2) Button btn2;
    @BindView(R.id.id_ui_button) Button button_ui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //注册监听通知
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver, intentFilter);

        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
    }

    private void initView(){
        mTabLayout = (TabLayout) findViewById(R.id.id_tablayout);
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);

        mButton.setOnClickListener(this);
        btn2.setOnClickListener(this);
        button_ui.setOnClickListener(this);

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager())
        {
            @Override
            public Fragment getItem(int position) {
                if (position == 0){
                    return new Fragment();
                }
                return new FestivalCategoryFragment();
            }

            @Override
            public int getCount() {
                return mTitles.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles[position];
            }
        });

        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.id_menu_main_add:
                Toast.makeText(this,"you click add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.id_menu_main_reduce:
                Toast.makeText(this,"you click reduce",Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.id_main_button:

                intent.setClass(this, MeActivity.class);
                startActivityForResult(intent, 1);
                break;
            case R.id.id_btn2:
                intent.setClass(this, BrandActivity.class);
                startActivity(intent);
//                /**
//                 * 取出数据
//                 */
//                SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
//                String name = pref.getString("name","");
//                btn2.setText(name);

                break;
            case R.id.id_ui_button:
                 PercentViewActivity.actionStart(MainActivity.this, "data1", "data2");

//                /**
//                 * 存储数据
//                 */
//                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
//                editor.putString("name","Tony");
//                editor.putInt("age",28);
//                editor.putBoolean("married", false);
//                editor.apply();

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * 广播接收器
     */
    class NetworkChangeReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            //获得系统服务类（用来管理网络连接的）
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context
                    .CONNECTIVITY_SERVICE);
            //通过服务类的方法获得NetworkInfo实例
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            //判断网络是否可用
            if (networkInfo != null && networkInfo.isAvailable()){
                Toast.makeText(context, "网络可用", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context, "网络不可用", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void doTheAlgorithm(){

        long startTime = System.nanoTime();
        solution();
        long endTime = System.nanoTime();
        String time = (endTime-startTime) + "";
        Log.d("算法耗时",time);
    }

    public int solution(){
        int num = 10;
        int[] array = new int[num];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < num; i++){
            array[i] = array[i-1] + array[i-2];
        }
        return array[num-1];
    }
}
