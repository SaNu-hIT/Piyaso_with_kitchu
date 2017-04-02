package com.piyaso.softforest.piyaso.Connection;


import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.piyaso.softforest.piyaso.Activitys.BuyAndSellActivity;
import com.piyaso.softforest.piyaso.Beans.CategoryBean;
import com.piyaso.softforest.piyaso.HttpInterfaces.OnHttpRequestresponseListnerCategory;
import com.piyaso.softforest.piyaso.Rest.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by intellyelabs on 28/03/17.
 */

public class HttpRequestForCategorys {

    private String TAG="HttpRequestForCategorys";
    ArrayList<CategoryBean>  categoryBeanList ;

    OnHttpRequestresponseListnerCategory category;

    public HttpRequestForCategorys(OnHttpRequestresponseListnerCategory category) {
        this.category=category;
    }

    public void getCategorys(Context activity)
    {
        Log.e("CALL","CAlling getCategprys");
//        final OnHttpRequestresponseListnerCategory category= (OnHttpRequestresponseListnerCategory) activity;
        String url="http://jinodemos.esy.es/PISCO_API/v1/Categories";

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                categoryBeanList=new ArrayList<CategoryBean>();

                String respo=response.toString();



                try {
                    Boolean status=response.getBoolean("error");

                    if(!status)
                    {

                        JSONArray Categories=response.getJSONArray("Categories");
                        for (int i=0;i<Categories.length();i++)
                        {
                            JSONObject object=Categories.getJSONObject(i);
                            CategoryBean categoryBean=new CategoryBean(object.getInt("category_id"),object.getString("category_name").toString(),object.getString("category_id").toString());
                            categoryBeanList.add(categoryBean);




//                            categoryBean=new CategoryBean(object.getInt("category_id"),object.getString("category_id").toString(),object.getString("category_id").toString())
                        }
//                        category.OnHttpCategoryResponceSuccess(categoryBeanList,status);

                        category.OnHttpCategoryResponceSuccess(categoryBeanList,"return success in fragment",Categories);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
//                    OnHttpRequestresponseListnerCategory category= (OnHttpRequestresponseListnerCategory) activity;

                    category.OnHttpCategoryResponceFailure(e,false);


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
