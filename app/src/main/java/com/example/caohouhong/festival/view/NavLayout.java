package com.example.caohouhong.festival.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.caohouhong.festival.R;

/**
 * @author caohouhong
 * @creat 17/5/16 下午3:58
 */

public class NavLayout extends LinearLayout implements View.OnClickListener{

    private ImageView leftItem;
    private RelativeLayout rightLLyout;
    private TextView titleTextView;
    private TextView rightTextView;
    private ImageView rightImageView;

    private String titleStr;
    private String rightText;
    private boolean leftShow;
    private boolean rightButtonShow;
    private int sreRightImage;

    public NavLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.nav_bar, this);

        initAttrs(attrs);
        initView();
    }

    private void initView(){

        leftItem = (ImageView) findViewById(R.id.left_item);
        rightLLyout = (RelativeLayout) findViewById(R.id.right_item);
        titleTextView = (TextView) findViewById(R.id.center_title);
        rightTextView = (TextView) findViewById(R.id.right_text);
        rightImageView = (ImageView) findViewById(R.id.right_image);

        leftItem.setOnClickListener(this);
        rightLLyout.setOnClickListener(this);

        //判断是否为空-标题
        if (!TextUtils.isEmpty(titleStr)){
            titleTextView.setText(titleStr);
        }

        if (!TextUtils.isEmpty(rightText)){
            rightTextView.setText(rightText);
        }

        //右图
        if (sreRightImage != 0){
            rightImageView.setImageResource(sreRightImage);
        }

        leftItem.setVisibility(leftShow ? View.VISIBLE : View.INVISIBLE);
        rightImageView.setVisibility(rightButtonShow ? View.VISIBLE : View.INVISIBLE);
    }

    public void setTitleStr(String titleStr) {
        this.titleStr = titleStr;
        //判断是否为空-标题
        if (!TextUtils.isEmpty(titleStr)){
            titleTextView.setText(titleStr);
        }
    }

    private void initAttrs(AttributeSet atts){
        TypedArray typedArray = getContext().obtainStyledAttributes(atts,R.styleable.NavBar);
        //标题
        titleStr = typedArray.getString(R.styleable.NavBar_title);
        //右按钮文字
        rightText = typedArray.getString(R.styleable.NavBar_rightText);
        //右图片
        sreRightImage = typedArray.getResourceId(R.styleable.NavBar_rightImage,0);
        //左按钮是否显示
        leftShow = typedArray.getBoolean(R.styleable.NavBar_isShowLeftBtn,true);
        //右按钮是否显示
        rightButtonShow = typedArray.getBoolean(R.styleable.NavBar_isShowRightBtn,false);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.left_item:
                //返回
                ((Activity)getContext()).finish();
                break;
            case R.id.right_item:
                Toast.makeText(getContext(),"You click right item", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
