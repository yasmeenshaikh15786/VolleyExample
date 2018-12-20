package com.volleyexample.JsonRequestType;

import android.app.ProgressDialog;
import android.content.Context;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.volleyexample.AppController;
import timber.log.Timber;

public class VolleyPrioprityExample {

    // Tag used to cancel the request
    String  tag_string_req = "string_req_with_priority";
    Context mCtx;
    ProgressDialog pDialog ;
    String url = "https://api.androidhive.info/volley/person_object.json";
    public VolleyPrioprityExample(Context context) {
        mCtx=context;
    }

    public void call(){

        pDialog = new ProgressDialog(mCtx);
        pDialog.setMessage("Loading...");
        pDialog.show();

        final Request.Priority priority = Request.Priority.HIGH;

        StringRequest strReq = new StringRequest(Request.Method.GET,
                url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Timber.d(getClass().getName(),response.toString());
                //msgResponse.setText(response.toString());
                pDialog.dismiss();

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Timber.d(getClass().getName(), "Error: " + error.getMessage());
                pDialog.dismiss();
            }
        }) {
            @Override
            public Priority getPriority() {
                return priority;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }
}
