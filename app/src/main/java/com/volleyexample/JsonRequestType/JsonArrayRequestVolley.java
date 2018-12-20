package com.volleyexample.JsonRequestType;

import android.app.ProgressDialog;
import android.content.Context;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.volleyexample.AppController;
import org.json.JSONArray;
import org.json.JSONObject;
import timber.log.Timber;

public class JsonArrayRequestVolley {

    // Tag used to cancel the request
    String tag_json_arry = "json_array_req";
    ProgressDialog pDialog ;
    String url = "https://api.androidhive.info/volley/person_array.json";

    Context mCtx;
    public JsonArrayRequestVolley(Context context) {
        mCtx=context;
    }

    public void Call(){
        pDialog = new ProgressDialog(mCtx);
        pDialog.setMessage("Loading...");
        pDialog.show();

        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Timber.d(getClass().getName(),String.valueOf(response));
                pDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Timber.d(getClass().getName(),String.valueOf(error));
                pDialog.dismiss();
            }
        });

        AppController.getInstance().addToRequestQueue(jsonArrayRequest,tag_json_arry);
    }
}
