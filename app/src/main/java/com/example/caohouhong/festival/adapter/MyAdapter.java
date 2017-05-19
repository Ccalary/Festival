package com.example.caohouhong.festival.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.caohouhong.festival.R;
import com.example.caohouhong.festival.bean.ItemBean;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by caohouhong on 17/5/10.
 */

public class MyAdapter extends BaseAdapter {

    private List<ItemBean> mList;
    private LayoutInflater mInflater;
    private long mSumTime;

    public MyAdapter(Context context, List<ItemBean> list){

        mList = list;
        mInflater = LayoutInflater.from(context);
    }
   /*row的个数*/
    @Override
    public int getCount() {
        return mList.size();
    }

    /*对应的Item*/
    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    /*对应的索引项*/
    @Override
    public long getItemId(int position) {
        return position;
    }

    /*返回每一项的显示内容*/
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /*逗比式，没有走缓存*/
        /*利用LayoutInflater将xml文件转化为可视图片，后面的参数通常写null*/
//        View view = mInflater.inflate(R.layout.item_me, null);
//        ImageView imageView = (ImageView) view.findViewById(R.id.iv_image);
//        TextView title = (TextView) view.findViewById(R.id.tv_title);
//        TextView content = (TextView) view.findViewById(R.id.tv_des);
//
//        ItemBean bean = mList.get(position);
//        imageView.setImageResource(bean.itemImageResid);
//        title.setText(bean.itemTitle);
//        content.setText(bean.itemContent);
//
//        return view;

        /*普通式*/
//        if (convertView == null){
//            convertView = mInflater.inflate(R.layout.item_me, null);
//        }
//
//        ImageView imageView = (ImageView) convertView.findViewById(R.id.iv_image);
//        TextView title = (TextView) convertView.findViewById(R.id.tv_title);
//        TextView content = (TextView) convertView.findViewById(R.id.tv_des);
//
//        ItemBean bean = mList.get(position);
//        imageView.setImageResource(bean.itemImageResid);
//        title.setText(bean.itemTitle);
//        content.setText(bean.itemContent);
//        return null;

        /*文艺式*/
        long start = System.nanoTime();
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = mInflater.inflate(R.layout.item_me, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.iv_image);
            viewHolder.title = (TextView) convertView.findViewById(R.id.tv_title);
            viewHolder.content = (TextView) convertView.findViewById(R.id.tv_des);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ItemBean bean = mList.get(position);
        viewHolder.imageView.setImageResource(bean.itemImageResid);
        viewHolder.title.setText(bean.itemTitle);
        viewHolder.content.setText(bean.itemContent);

        long end = System.nanoTime();
        long mValue = end - start;
        mSumTime += mValue;
        Log.d("abc",String.valueOf(mSumTime));

        return convertView;
    }

    class ViewHolder{
        public ImageView imageView;
        public TextView title;
        public TextView content;
    }
}
