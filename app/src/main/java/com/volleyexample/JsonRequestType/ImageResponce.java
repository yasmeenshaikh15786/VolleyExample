package com.volleyexample.JsonRequestType;

import android.content.Context;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.volleyexample.AppController;
import com.volleyexample.R;
import timber.log.Timber;

public class ImageResponce {

    Context mCtx;
    public static final String URL_IMAGE = "";
    public ImageResponce(Context context) {
        mCtx=context;
    }

    public void call(){

        ImageLoader imageLoader = AppController.getInstance().getImageLoader();

        // If you are using normal ImageView
        imageLoader.get(URL_IMAGE, new ImageLoader.ImageListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Timber.d(getClass().getName(),"Image Load Error: " + error.getMessage());
            }

            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean arg1) {
                if (response.getBitmap() != null) {

                    Timber.d(getClass().getName(),"Image Load Success: ");

                    // load image into imageview
                    //imageView.setImageBitmap(response.getBitmap());
                }
            }
        });

        // Loading image with placeholder and error image
        //imageLoader.get(URL_IMAGE, ImageLoader.getImageListener(
        //        imageView, R.drawable.ico_loading, R.drawable.ico_error));
    }
}
