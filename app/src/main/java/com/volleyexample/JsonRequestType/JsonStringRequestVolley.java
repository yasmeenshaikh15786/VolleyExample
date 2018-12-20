package com.volleyexample.JsonRequestType;

import android.app.ProgressDialog;
import android.content.Context;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.volleyexample.AppController;
import org.json.JSONArray;
import org.json.JSONStringer;
import timber.log.Timber;

public class JsonStringRequestVolley {

    ProgressDialog pDialog ;
    String url = "https://api.androidhive.info/volley/person_object.json";

    // Tag used to cancel the request
    String  tag_string_req = "string_req";

    Context mCtx;
    public JsonStringRequestVolley(Context context) {
        mCtx=context;
    }

    public void Call(){
        pDialog = new ProgressDialog(mCtx);
        pDialog.setMessage("Loading...");
        pDialog.show();

        StringRequest stringRequest= new StringRequest(Request.Method.GET,url,new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                Timber.d(getClass().getName(),String.valueOf(response));
                pDialog.dismiss();
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Timber.d(getClass().getName(),String.valueOf(error));
                pDialog.dismiss();
            }
        });
        AppController.getInstance().addToRequestQueue(stringRequest,tag_string_req);
    }
}
