package com.piyaso.softforest.piyaso.Connection;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.piyaso.softforest.piyaso.Fragments.BuyAndSellproductFragment;
import com.piyaso.softforest.piyaso.HttpInterfaces.OnHttpRequestResponceListnerProdutListing;
import com.piyaso.softforest.piyaso.Rest.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by intellyelabs on 30/03/17.
 */

public class HttpRequestForProducts {
OnHttpRequestResponceListnerProdutListing onHttpRequestResponceListnerProdutListing;


    public HttpRequestForProducts(OnHttpRequestResponceListnerProdutListing onHttpRequestResponceListnerProdutListing) {
        this.onHttpRequestResponceListnerProdutListing=onHttpRequestResponceListnerProdutListing;
    }

    public void GetProduCtListings() {


        String url = "http://jinodemos.esy.es/PISCO_API/v1/GetAllProducts";
        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("Respocne",response.toString());


                try {
                    boolean error=response.getBoolean("error");
                    Log.d("onResponse: ",""+error);

                    if(!error)
                    {
                        JSONArray products_list=response.getJSONArray("products_list");
                        onHttpRequestResponceListnerProdutListing.OnHttprequestProductListingSuccess(products_list,error);
                    }
                    else
                    {
                        Log.d("onResponse: ","Error list product");
                    }



                } catch (JSONException e) {
                    e.printStackTrace();
                    onHttpRequestResponceListnerProdutListing.OnHttpRequestProductListingFailure(e,false);
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
