package com.example.caohouhong.festival.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.caohouhong.festival.R;
import com.example.caohouhong.festival.bean.ItemBean;

import java.util.List;

/**
 * Created by caohouhong on 17/5/10.
 */

public class MyNewAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    List<ItemBean> mList;
    ViewHolder viewHolder;

    public MyNewAdapter(Context context, List<ItemBean> mList) {
        this.mList = mList;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*为了复用*/
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

        return convertView;
    }

    class ViewHolder {
        ImageView imageView;
        TextView title;
        TextView content;
    }
}
