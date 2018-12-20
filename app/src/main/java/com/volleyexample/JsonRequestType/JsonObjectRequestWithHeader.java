package com.volleyexample.JsonRequestType;

import android.app.ProgressDialog;
import android.content.Context;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.volleyexample.AppController;
import org.json.JSONObject;
import timber.log.Timber;

import java.util.HashMap;
import java.util.Map;

public class JsonObjectRequestWithHeader {

    // Tag used to cancel the request
    String tag_json_obj = "json_obj_req";

    ProgressDialog pDialog ;
    String url = "https://api.androidhive.info/volley/person_object.json";

    Context mCtx;

    public JsonObjectRequestWithHeader(Context context) {
        this.mCtx=context;
    }

    public void Call(){
        pDialog = new ProgressDialog(mCtx);
        pDialog.setMessage("Loading...");
        pDialog.show();

        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Timber.d(getClass().getName(),String.valueOf(response));
                pDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Timber.d(getClass().getName(),String.valueOf(error));
                pDialog.dismiss();
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                headers.put("apiKey", "xxxxxxxxxxxxxxx");
                return headers;
            }
        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjectRequest, tag_json_obj);
    }

}
