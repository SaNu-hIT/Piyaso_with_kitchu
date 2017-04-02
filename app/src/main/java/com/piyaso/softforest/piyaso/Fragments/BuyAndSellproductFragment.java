package com.piyaso.softforest.piyaso.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ProgressBar;

import com.piyaso.softforest.piyaso.Activitys.ProductDetails_Actvity;
import com.piyaso.softforest.piyaso.Adapters.CategoryAdapter;
import com.piyaso.softforest.piyaso.Adapters.GridViewAdapter;
import com.piyaso.softforest.piyaso.Beans.CategoryBean;
import com.piyaso.softforest.piyaso.Beans.ProductListBean;
import com.piyaso.softforest.piyaso.Connection.HttpRequestForCategorys;
import com.piyaso.softforest.piyaso.Connection.HttpRequestForProducts;
import com.piyaso.softforest.piyaso.HttpInterfaces.OnHttpRequestResponceListnerProdutListing;
import com.piyaso.softforest.piyaso.HttpInterfaces.OnHttpRequestresponseListnerCategory;
import com.piyaso.softforest.piyaso.Interfaces.OnCategoryIteSelected;
import com.piyaso.softforest.piyaso.Interfaces.OnGridItemSelected;
import com.piyaso.softforest.piyaso.R;
import com.piyaso.softforest.piyaso.customfonts.TextView_Lato;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BuyAndSellproductFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BuyAndSellproductFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BuyAndSellproductFragment extends Fragment implements OnGridItemSelected,OnCategoryIteSelected,CategorySelectFragment.OnFragmentInteractionListener,OnHttpRequestresponseListnerCategory,OnHttpRequestResponceListnerProdutListing {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String ARG_PAGE = "ARG_PAGE";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public ArrayList<CategoryBean> categoryBeen;
    ArrayList<ProductListBean> productListBeen;
    CategoryAdapter categoryAdapter;

    public String[] category = {"Mobile", "Tv", "Watch", "Dish", "Mixi", "Dress"};
    public String[] category_image = {"Mobile", "Tv", "Watch", "Dish", "Mixi", "Dress"};
    public int[] category_id = {1, 2, 3, 4, 5, 6};
    RecyclerView recyclerView;
    GridViewAdapter gridViewAdapter;
    private OnFragmentInteractionListener mListener;
    Context mContext;
    ProgressBar progBar;
    ProgressBar progBar2;


@BindView(R.id.location_select) TextView_Lato location_select;
    private String TAG="BuyAndSellproductFragment";


    public BuyAndSellproductFragment() {

    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    public static BuyAndSellproductFragment newInstance(int pageNo) {

        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNo);

        BuyAndSellproductFragment fragment = new BuyAndSellproductFragment();
        fragment.setArguments(args);



        return fragment;
    }


//    public static BuyAndSellproductFragment newInstance(ArrayList<>) {
//
//        Bundle args = new Bundle();
//        args.putInt(ARG_PAGE, pageNo);
//
//        BuyAndSellproductFragment fragment = new BuyAndSellproductFragment();
//        fragment.setArguments(args);
//
//
//
//        return fragment;
//    }
//

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View itemview = inflater.inflate(R.layout.fragment_category, container, false);


         recyclerView = (RecyclerView) itemview.findViewById(R.id.category_items_recyclerview);
        GridView gridview = (GridView) itemview.findViewById(R.id.gridview);
        ButterKnife.bind(this, itemview);

        progBar=(ProgressBar)itemview.findViewById(R.id.progressbar);
        progBar2=(ProgressBar)itemview.findViewById(R.id.progressbar2);
        progBar.setVisibility(View.VISIBLE);
        progBar2.setVisibility(View.VISIBLE);


        categoryBeen=new ArrayList<>();
        productListBeen=new ArrayList<>();
//        for (int i = 0; i < category_id.length; i++) {
//
//            CategoryBean categoryBean = new CategoryBean(category_id[i], category[i], category_image[i]);
//            categoryBeen.add(categoryBean);
//
//
//        }
        HttpRequestForCategorys httpRequestForCategorys=new HttpRequestForCategorys(this);
        httpRequestForCategorys.getCategorys(getContext());
        HttpRequestForProducts httpRequestForProducts=new HttpRequestForProducts(this);
        httpRequestForProducts.GetProduCtListings();





         categoryAdapter = new CategoryAdapter(getContext(), categoryBeen);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(categoryAdapter);
        categoryAdapter.OnCategorySelectionCallBack(this);





         gridViewAdapter=new GridViewAdapter(getContext(),productListBeen);

        gridview.setAdapter(gridViewAdapter);

        gridViewAdapter.GridItemSelectedCallback(this);




        location_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              mListener.onFragmentInteraction();


            }
        });

        return itemview;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }



    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onGridItemSelected(View view, int possition) {

        Intent intent=new Intent(getActivity(), ProductDetails_Actvity.class);
        startActivity(intent);


    }

    @Override
    public void OnClickCatagoryItem(View view, int Position) {

        String catego=category[Position];


//
//        Intent intent=new Intent(getActivity(), CategoryAndLocationActivity.class);
//        startActivity(intent);


    }

    @Override
    public void onFragmentInteraction(Uri uri) {
//        Log.e(TAG,"om");
    }

    @Override
    public void OnHttpCategoryResponceSuccess(ArrayList<CategoryBean> categoryBeens, String error, JSONArray categories) {


        for (int i=0;i<categories.length();i++)
        {
            JSONObject catego= null;
            try {
                progBar.setVisibility(View.GONE);
                catego = categories.getJSONObject(i);
              CategoryBean  bean=new CategoryBean(catego.getInt("category_id"),catego.getString("category_name"),"");
                categoryBeen.add(bean);

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
    public void OnHttprequestProductListingSuccess(JSONArray jsonArray, boolean error) {

        int count=jsonArray.length();
        if (count!=0)
        {
            productListBeen.clear();
            Log.e("Product Fetch Success", "he yllp" );
            for (int i=0;i<count;i++)
            {
                try {
                    JSONObject prodctlist=jsonArray.getJSONObject(i);
//                    int product_id, String product_name, String product_description, String category
                    ProductListBean productbean=new ProductListBean(prodctlist.getInt("sell_id"),prodctlist.getString("product_title"),prodctlist.getString("description"),prodctlist.getString("category_name"),prodctlist.getString("image1"));
                    productListBeen.add(productbean);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            progBar2.setVisibility(View.GONE);

        }
        else{
            Log.e("Product Fetch Success", "But empty" );
        }

        gridViewAdapter.notifyDataSetChanged();


    }

    @Override
    public void OnHttpRequestProductListingFailure(Throwable t, boolean error) {
        Log.e("Product Listing failure",t.toString());
    }



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction();
    }












}
