package com.piyaso.softforest.piyaso.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.GridView;

import com.piyaso.softforest.piyaso.Adapters.CategoryAdapter;
import com.piyaso.softforest.piyaso.Beans.CategoryBean;
import com.piyaso.softforest.piyaso.Connection.HttpRequestForCategorys;
import com.piyaso.softforest.piyaso.HttpInterfaces.OnHttpRequestresponseListnerCategory;
import com.piyaso.softforest.piyaso.Interfaces.OnCategoryIteSelected;
import com.piyaso.softforest.piyaso.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CategorysAndSearchLocation extends AppCompatActivity implements OnHttpRequestresponseListnerCategory, OnCategoryIteSelected {
    @OnClick(R.id.button_onclick)
    public void Click()
    {
        Intent inte=new Intent(getBaseContext(),BuyAndSellActivity.class);
        startActivity(inte);
        finish();
    }

    public String[] category = {"Mobile", "Tv", "Watch", "Dish", "Mixi", "Dress"};
    public String[] category_image = {"Mobile", "Tv", "Watch", "Dish", "Mixi", "Dress"};
    public int[] category_id = {1, 2, 3, 4, 5, 6};
    @BindView(R.id.category_items_recyclerview)
    RecyclerView recyclerView;
  ArrayList<CategoryBean> categoryBean;
    CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorys_and_search_location);
        ButterKnife.bind(this);

        categoryBean=new ArrayList<>();
        HttpRequestForCategorys httpRequestForCategorys=new HttpRequestForCategorys(this);
        httpRequestForCategorys.getCategorys(getBaseContext());

//        for (int i = 0; i < category_id.length; i++) {
//
//            CategoryBean bean = new CategoryBean(category_id[i], category[i], category_image[i]);
//            categoryBean.add(bean);
//
//
//        }


        categoryAdapter = new CategoryAdapter(this, categoryBean);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(categoryAdapter);
        categoryAdapter.OnCategorySelectionCallBack(this);



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent inte=new Intent(getBaseContext(),BuyAndSellActivity.class);
        startActivity(inte);
        finish();
    }

    public void onBackClic(View view) {
        onBackPressed();
    }

    @Override
    public void OnHttpCategoryResponceSuccess(ArrayList<CategoryBean> categoryBeen, String error, JSONArray categories) {

        Log.e("Category call back","in search and location");
        for (int i=0;i<categories.length();i++)
        {
            JSONObject catego= null;
            try {
                catego = categories.getJSONObject(i);
                CategoryBean  bean=new CategoryBean(catego.getInt("category_id"),catego.getString("category_name"),"");
                categoryBean.add(bean);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }


        categoryAdapter.notifyDataSetChanged();
    }

    @Override
    public void OnHttpCategoryResponceFailure(Throwable throwable, boolean error) {
        Log.e("Category failure",throwable.toString());
    }

    @Override
    public void OnClickCatagoryItem(View view, int Position) {

    }
}
