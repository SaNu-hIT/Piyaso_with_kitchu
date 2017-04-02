package com.piyaso.softforest.piyaso.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.piyaso.softforest.piyaso.Beans.CategoryBean;
import com.piyaso.softforest.piyaso.Connection.HttpRequestForCategorys;
import com.piyaso.softforest.piyaso.Connection.HttpRequestForSubcategory;
import com.piyaso.softforest.piyaso.HttpInterfaces.OnHttpRequestresponceListerForSubcategory;
import com.piyaso.softforest.piyaso.HttpInterfaces.OnHttpRequestresponseListnerCategory;
import com.piyaso.softforest.piyaso.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by intellyelabs on 02/04/17.
 */

public class PostAddpage1 extends AppCompatActivity implements OnHttpRequestresponceListerForSubcategory,OnHttpRequestresponseListnerCategory{

    ArrayList<String> categorySpinnerList;
    ArrayList<String> categorySpinnerIdList;
    ArrayList<String> SubcategorySpinnerList;
    private static final String TAG = PostAddpage1.class.getSimpleName();
    Spinner CategorySpinner,SubcategorySpinner;


    EditText TittleEdt,KeywordsEdt,PriceEdt,ContactEdt,CityEdt,LocationEdt,DiscriptionEdt;
    RelativeLayout ProceedButton;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addpage_layout1);

        categorySpinnerList=new ArrayList<>();
        SubcategorySpinnerList=new ArrayList<>();
        categorySpinnerIdList=new ArrayList<>();

        CategorySpinner=(Spinner)findViewById(R.id.categoryspinner);
        SubcategorySpinner=(Spinner)findViewById(R.id.subcategory);

        TittleEdt=(EditText)findViewById(R.id.tittle);
        KeywordsEdt=(EditText)findViewById(R.id.keywords);
        PriceEdt=(EditText)findViewById(R.id.price);
        ContactEdt=(EditText)findViewById(R.id.number);
        CityEdt=(EditText)findViewById(R.id.city);
        LocationEdt=(EditText)findViewById(R.id.location);
        DiscriptionEdt=(EditText)findViewById(R.id.discription);

        ProceedButton=(RelativeLayout)findViewById(R.id.relativebutton);
        ProceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getApplicationContext(),Postaddpage2.class);
                startActivity(in);
            }
        });


        HttpRequestForCategorys httpRequestForCategorys=new HttpRequestForCategorys(this);
        httpRequestForCategorys.getCategorys(this);

//
//        CategorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//            public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
//                                       long arg3) {
//
//                String catid=categorySpinnerIdList.get(position);
//                Log.e(TAG, "onItemSelected: " +catid);
//                Toast.makeText(PostAddpage1.this, "Catid= "+catid, Toast.LENGTH_SHORT).show();
//                HttpRequestForSubcategory httpRequestForSubcategory=new HttpRequestForSubcategory(PostAddpage1.this);
//                httpRequestForSubcategory.getSubcategory(Integer.parseInt(catid));
//
//
//            }
//
//            public void onNothingSelected(AdapterView<?> arg0) {
//                // TODO Auto-generated method stub
//
//            }
//        });



    }

    @Override
    public void HttpRequestForSubCategorySuccess(boolean error, JSONArray subcategorys) {

        Log.e(TAG, "HttpRequestForSubCategorySuccess: "+subcategorys.toString());

        SubcategorySpinnerList.clear();
        for (int i=0;i<subcategorys.length();i++) {
            try {
                JSONObject jsob = subcategorys.getJSONObject(i);
                String subcat_catname = jsob.getString("subcat_name");
                String subcat_id = jsob.getString("subcat_id");
                SubcategorySpinnerList.add(subcat_catname);

                Log.e(TAG, "CATEGORYLIST: " + subcat_catname);

                ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        SubcategorySpinnerList);
                SubcategorySpinner.setAdapter(spinnerArrayAdapter);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void HttpRequestForSubCategoryFailure(Throwable t, boolean error) {

    }

    @Override
    public void OnHttpCategoryResponceSuccess(ArrayList<CategoryBean> categoryBeen, String error, JSONArray categories) {

        Log.e(TAG, "OnHttpCategoryResponceSuccess: "+categories.toString());
        for (int i=0;i<categories.length();i++)
        {
            try {
                JSONObject jsob=categories.getJSONObject(i);
                String catname=jsob.getString("category_name");
                String catid=jsob.getString("category_id");
                categorySpinnerList.add(catname);
                Log.e(TAG, "CATEGORYLIST: "+catname);
                categorySpinnerIdList.add(catid);

                ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        categorySpinnerList);
                CategorySpinner.setAdapter(spinnerArrayAdapter);

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }


    }

    @Override
    public void OnHttpCategoryResponceFailure(Throwable throwable, boolean error) {

    }
}
