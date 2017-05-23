package com.example.caohouhong.festival.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.caohouhong.festival.BaseActivity;
import com.example.caohouhong.festival.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author caohouhong
 * @creat 17/5/16 下午1:13
 */

public class PercentViewActivity extends BaseActivity  implements View.OnClickListener{

    @BindView(R.id.button1)
    Button photoButton;

    @BindView(R.id.button2)
    Button imageButton;

    @BindView(R.id.imageview)
    ImageView picture;

    private Uri imageUri;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_percentview);

        ButterKnife.bind(this);
        photoButton.setOnClickListener(this);
        imageButton.setOnClickListener(this);

    }


    /** 启动活动的最佳写法
     * @param context activity
     * @param str1 参数1
     * @param str2 参数2
     */
    public static void actionStart(Context context, String str1, String str2){
        Intent intent = new Intent(context, PercentViewActivity.class);
        intent.putExtra("param1",str1);
        intent.putExtra("param2",str2);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1: {
                //创建文件夹
                File outputImage = new File(getExternalCacheDir(), "output_image.jpg");
                try{
                    if (outputImage.exists()){
                        outputImage.delete();
                    }
                    outputImage.createNewFile();
                }catch (IOException e){
                    e.printStackTrace();
                }
                if (Build.VERSION.SDK_INT >= 24){
                    imageUri = FileProvider.getUriForFile(PercentViewActivity.this,"com.caohouhong.festival1",outputImage);
                }else {
                    imageUri = Uri.fromFile(outputImage);
                }
            }
            //启动相机
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(intent, 111);

                break;
            case R.id.button2:

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 111){
            if (resultCode == RESULT_OK){
                try {
                    //将拍摄的照片显示出来
                    Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                    picture.setImageBitmap(bitmap);

                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
