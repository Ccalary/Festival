package com.example.caohouhong.festival.request.brand;

import com.example.caohouhong.festival.model.AdvertiseListModel;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by caohouhong on 17/5/12.
 */

public interface BrandInterface {

    @FormUrlEncoded
    @POST("ad/listAds")
    Observable<AdvertiseListModel> getBrandHomeAdsList(@Field("adPosition") String adPosition);

}
