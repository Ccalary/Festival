package com.example.caohouhong.festival.bean;

/**
 * Created by caohouhong on 17/5/10.
 */

public class ItemBean {
    public int itemImageResid;
    public String itemTitle;
    public String itemContent;

    public ItemBean(int itemImageResid, String itemTitle, String itemContent) {
        this.itemImageResid = itemImageResid;
        this.itemTitle = itemTitle;
        this.itemContent = itemContent;
    }
}
