package com.piyaso.softforest.piyaso.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.piyaso.softforest.piyaso.Interfaces.OnGridItemSelected;
import com.piyaso.softforest.piyaso.Interfaces.OnGridItemSelectedMain;
import com.piyaso.softforest.piyaso.R;
import com.piyaso.softforest.piyaso.customfonts.MyTextViewMavenPro;
import com.piyaso.softforest.piyaso.customfonts.TextView_Lato;
import com.piyaso.softforest.piyaso.customfonts.Textview_lato_thin;


/**
 * Created by intellyelabs on 20/03/17.
 */

public class MainGridAdapter extends BaseAdapter {
    private Context context;
    OnGridItemSelectedMain onGridItemSelectedMain;



    private int[] drawables = {
            R.drawable.hotel1, R.drawable.hotel3, R.drawable.hotel4,R.drawable.hotel2};

    private String[] CategoryTittle={"SELL AND BUY","SERVICES","GROSARY AND HOME DECORS","DIRECTORY"};
    public void GridItemSelectedCallbackMain(final OnGridItemSelectedMain onGridItemSelectedMain)
    {
this.onGridItemSelectedMain=onGridItemSelectedMain;
    }

    public MainGridAdapter(Context context) {
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
            grid = inflater.inflate(R.layout.main_grid_item, null);
            MyTextViewMavenPro textView = (MyTextViewMavenPro) grid.findViewById(R.id.category_txt);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_item_iv);

            textView.setText(CategoryTittle[position]);


            imageView.setImageResource(drawables[position]);
        } else {
            grid = (View) convertView;
        }
     grid.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             onGridItemSelectedMain.onGridItemSelected(v,position);


         }
     });

        return grid;
    }


}
