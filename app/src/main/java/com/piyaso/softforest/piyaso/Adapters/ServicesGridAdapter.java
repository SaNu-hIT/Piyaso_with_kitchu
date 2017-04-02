package com.piyaso.softforest.piyaso.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.piyaso.softforest.piyaso.Interfaces.OnGridItemSelectedMain;
import com.piyaso.softforest.piyaso.Interfaces.OnServicegridItemSelected;
import com.piyaso.softforest.piyaso.R;
import com.piyaso.softforest.piyaso.customfonts.MyTextViewMavenPro;


/**
 * Created by intellyelabs on 20/03/17.
 */

public class ServicesGridAdapter extends BaseAdapter {
    private Context context;
    OnServicegridItemSelected onServicegridItemSelected;



    private int[] drawables = {
            R.drawable.hotel1, R.drawable.hotel3, R.drawable.hotel4,R.drawable.hotel2};

    private String[] CategoryTittle={" REAL ESTATE","TOURS AND TRAVEL","EVENT MANAGEMENT","LOANS AND INSURENCE"};
    public void GridItemSelectedCallbackServices(final OnServicegridItemSelected onServicegridItemSelected)
    {
this.onServicegridItemSelected=onServicegridItemSelected;
    }

    public ServicesGridAdapter(Context context) {
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

             onServicegridItemSelected.onGridItemSelected(v,position);


         }
     });

        return grid;
    }


}
