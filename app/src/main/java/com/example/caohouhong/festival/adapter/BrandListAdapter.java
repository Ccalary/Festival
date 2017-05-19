package com.example.caohouhong.festival.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.caohouhong.festival.R;
import com.example.caohouhong.festival.model.AdvertiseModel;

import java.util.ArrayList;

import static com.example.caohouhong.festival.request.URLConfig.BASE_IMAGE_URL;

/**
 * @author caohouhong
 */

public class BrandListAdapter extends BaseAdapter {

    private ArrayList<AdvertiseModel> mDatas;

    private LayoutInflater mLayoutInflater;

    private Context mContext;

    public BrandListAdapter(Context context, ArrayList<AdvertiseModel> datas) {

        mDatas = datas;
        mLayoutInflater = LayoutInflater.from(context);
        mContext = context;
    }


    @Override
    public int getCount() {
        return mDatas.size();
    }

    /**
     * 行号
     * @return 每行的内容
     */
    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.item_brand_main, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.id_brand_image);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        AdvertiseModel advertiseModel = mDatas.get(position);
        Glide.with(mContext).load(BASE_IMAGE_URL + advertiseModel.adImg)
                .placeholder(R.drawable.pic_wait).into(viewHolder.imageView);

        return convertView;
    }

   class ViewHolder{
        public ImageView imageView;
    }
}
