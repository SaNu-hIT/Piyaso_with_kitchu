package com.piyaso.softforest.piyaso.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.piyaso.softforest.piyaso.Beans.ProductListBean;
import com.piyaso.softforest.piyaso.Interfaces.OnGridItemSelected;
import com.piyaso.softforest.piyaso.R;
import com.piyaso.softforest.piyaso.customfonts.TextView_Lato;
import com.piyaso.softforest.piyaso.customfonts.Textview_lato_thin;

import java.util.ArrayList;


/**
 * Created by intellyelabs on 20/03/17.
 */

public class FavorateGridViewAdapter extends BaseAdapter {
    private Context context;
    OnGridItemSelected onGridItemSelected;



    private int[] drawables = {
            R.drawable.hotel1, R.drawable.hotel1};
    public void GridItemSelectedCallback(final OnGridItemSelected onGridItemSelected)
    {
        this.onGridItemSelected=onGridItemSelected;
    }
    ArrayList<ProductListBean> productListBeen;

    public FavorateGridViewAdapter(Context context) {
        this.context = context;

    }

    @Override
    public int getCount() {

        return drawables.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {


//        ImageView iv = (ImageView) findViewById(R.id.grid_item_iv);
//        iv.setImageResource(drawables[position]);
//
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context, "Position: " + position, Toast.LENGTH_SHORT).show();
//            }
//        });
//        return view;





        View grid;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(context);
            grid = inflater.inflate(R.layout.grid_items_view, null);
            TextView_Lato textView = (TextView_Lato) grid.findViewById(R.id.product_name);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_item_iv);
            Textview_lato_thin description= (Textview_lato_thin) grid.findViewById(R.id.descriptions);
            textView.setText("New");
            String ss="details ";
            description.setText(ss);

            String url="";

            Glide
                    .with(context)
                    .load(url)
                    .centerCrop()
                    .placeholder(R.drawable.hotel1)
                    .crossFade()
                    .into(imageView);

//            imageView.setImageResource(drawables[position]);
        } else {
            grid = (View) convertView;
        }
        grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("POSITION",""+position);
                onGridItemSelected.onGridItemSelected(v,position);


            }
        });

        return grid;
    }


}
