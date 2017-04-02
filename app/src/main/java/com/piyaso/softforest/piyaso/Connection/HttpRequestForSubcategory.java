package com.piyaso.softforest.piyaso.Connection;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.piyaso.softforest.piyaso.HttpInterfaces.OnHttpRequestresponceListerForSubcategory;
import com.piyaso.softforest.piyaso.Rest.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by intellyelabs on 02/04/17.
 */

public class HttpRequestForSubcategory {
    OnHttpRequestresponceListerForSubcategory subcategory;


    public HttpRequestForSubcategory(OnHttpRequestresponceListerForSubcategory onHttpRequestresponceListerForSubcategory)
    {
        this.subcategory=onHttpRequestresponceListerForSubcategory;
    }

public void getSubcategory(int id)
{
    String url="http://jinodemos.esy.es/PISCO_API/v1/ListProductsSubCategories/"+id;
    JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {

            Log.e("RESPO", "onResponse: "+response.toString() );
            try {
                boolean status=response.getBoolean("error");
                if(!status)
                {
                    JSONArray subcata=response.getJSONArray("SubCategories");
                    subcategory.HttpRequestForSubCategorySuccess(status,subcata);
                    Log.e("SUBCATEGORIES", "onResponse: "+subcata.toString() );

                }






            } catch (JSONException e) {
                e.printStackTrace();

                    subcategory.HttpRequestForSubCategoryFailure(e,false);

            }


        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    });
    AppController.getInstance().addToRequestQueue(jsonObjectRequest);
}





}
