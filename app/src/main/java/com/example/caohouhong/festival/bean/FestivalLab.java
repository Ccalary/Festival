package com.example.caohouhong.festival.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caohouhong on 17/5/9.
 */

public class FestivalLab {

    public static FestivalLab mInstance;

    private List<Festival> mFestivals = new ArrayList<Festival>();
    private List<Msg> mMsgs = new ArrayList<Msg>();


    private FestivalLab()
    {
        mFestivals.add(new Festival(1,"国庆节"));
        mFestivals.add(new Festival(2,"中秋节"));
        mFestivals.add(new Festival(3,"元旦"));
        mFestivals.add(new Festival(4,"春节"));
        mFestivals.add(new Festival(5,"清明节"));
        mFestivals.add(new Festival(6,"端午节"));
        mFestivals.add(new Festival(7,"劳动节"));

        mMsgs.add(new Msg(1,1,"1今天是个说的就是垃圾分类就啊撸杜纱礼服将阿里风景善良的风景老师"));
        mMsgs.add(new Msg(2,1,"2今天是个说的就是垃圾分类就啊撸杜纱礼服将阿里风景善良的风景老师"));
        mMsgs.add(new Msg(3,2,"3今天是个说的就是垃sdjflas 圾分类就啊撸杜纱礼服将阿里风景善良的风景老师"));
        mMsgs.add(new Msg(4,2,"4今天是个说的就是垃圾分类就啊safdjal afa撸杜纱礼服将阿里风景善良的风景老师"));
        mMsgs.add(new Msg(5,5,"5今天是个说的就是垃圾分类就啊撸杜纱礼服将打扫家里封疆大吏上飞机阿龙福建阿兰德斯肌肤垃圾堆里撒阿里风景善良的风景老师"));
        mMsgs.add(new Msg(6,6,"6今天是个说的就是垃圾分类就啊撸杜纱礼服将阿里风景善良的风景老师"));
        mMsgs.add(new Msg(7,4,"7今天是个说的就是垃圾分类就啊撸杜纱礼服将阿里风景善良的风景老师"));
        mMsgs.add(new Msg(8,3,"8今天是个说的就是垃圾分类就啊撸杜纱礼服将阿里风景善良的风景老师"));
        mMsgs.add(new Msg(9,4,"9今天是个说的就是垃圾分类就啊撸杜纱礼服将阿里风景善良的风景老师"));
    }

    public List<Msg> getMsgsByFestivalId(int fesId){
        List<Msg> msgs = new ArrayList<>();
        for (Msg msg : mMsgs){
            if (msg.getFestivalId() == fesId){
                msgs.add(msg);
            }
        }
        return msgs;
    }

    public  Msg getMsgByMsgId(int id){
        for (Msg msg: mMsgs){
            if (msg.getId() == id){
                return msg;
            }
        }
        return null;
    }

    /**
     * 查询数据
     */
    public List<Festival> getFestivals()
    {
        /*返回副本*/
       return new ArrayList<Festival>(mFestivals);
    }

    /**
     * 单个查询
     */
    public Festival getFestivalById(int fesId)
    {
       for (Festival festival : mFestivals){
           if (festival.getId() == fesId){
               return festival;
           }
       }
        return null;
    }

    public static FestivalLab getInstance()
    {
        if (mInstance == null)
        {
            synchronized (FestivalLab.class)
            {
               if (mInstance == null)
               {
                   mInstance = new FestivalLab();
               }
            }
        }
        return mInstance;
    }
}
