package com.example.caohouhong.festival.adapter;

import android.speech.tts.TextToSpeech;
import android.support.v7.util.SortedList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.caohouhong.festival.R;
import com.example.caohouhong.festival.bean.Festival;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @author caohouhong
 * @creat 17/5/17 下午1:20
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {

    private List<Festival> mFestival;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View festivalView;
        TextView festivalName;
        public ViewHolder(View itemView) {
            super(itemView);
            festivalView = itemView;
            festivalName = (TextView) itemView.findViewById(R.id.id_tv_recy_festival);
        }
    }

    public RecycleAdapter(List<Festival> mFestival) {
        this.mFestival = mFestival;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle_festival, parent, false);

        final ViewHolder holder = new ViewHolder(view);

        holder.festivalView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Festival festival = mFestival.get(position);
                Toast.makeText(v.getContext(), "Click" + festival.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.festivalName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Festival festival = mFestival.get(position);
                Toast.makeText(v.getContext(),"Click text " + festival.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Festival festival = mFestival.get(position);
        holder.festivalName.setText(festival.getName());
    }

    @Override
    public int getItemCount() {
        return mFestival.size();
    }

}


