package com.example.caohouhong.festival.request;

import com.example.caohouhong.festival.request.brand.BrandInterface;


public class CBHttpRequest {
    private static BrandInterface mBrandInterface;


    /**
     * @return 商标首页接口
     */
    public static BrandInterface getBrandInterface() {
        if (mBrandInterface == null) {
            mBrandInterface = ApiConfig.getDefault().create(BrandInterface.class);
        }
        return mBrandInterface;
    }
}
