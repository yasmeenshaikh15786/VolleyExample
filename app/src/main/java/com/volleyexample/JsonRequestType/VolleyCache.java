package com.volleyexample.JsonRequestType;

import android.content.Context;
import com.android.volley.Cache;
import com.volleyexample.AppController;

import java.io.UnsupportedEncodingException;

public class VolleyCache {

    Context mCtx;
    public static final String url = "";

    public VolleyCache(Context context) {
        context=mCtx;
    }

    public void call(){

        Cache cache = AppController.getInstance().getRequestQueue().getCache();
        Cache.Entry entry = cache.get(url);
        if(entry != null){
            try {
                String data = new String(entry.data, "UTF-8");
                // handle data, like converting it to xml, json, bitmap etc.,
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }else{
        // Cached response doesn't exists. Make network call here
        }


        //TODO Invalidate cache
        //AppController.getInstance().getRequestQueue().getCache().invalidate(url, true);

        //TODO Turning off cache
        //String request
        //StringRequest stringReq = new StringRequest(....);

        //TODO disable cache
        //stringReq.setShouldCache(false);

        //TODO Deleting cache for particular URL
        //AppController.getInstance().getRequestQueue().getCache().remove(url);

        //TODO Deleting all the cache
        //AppController.getInstance().getRequestQueue().getCache().clear(url);

        //TODO Cancel single request
        //String tag_json_arry = "json_req";
        //ApplicationController.getInstance().getRequestQueue().cancelAll("feed_request");

        //TODO Cancel all requests
        //ApplicationController.getInstance().getRequestQueue().cancelAll();
    }
}
