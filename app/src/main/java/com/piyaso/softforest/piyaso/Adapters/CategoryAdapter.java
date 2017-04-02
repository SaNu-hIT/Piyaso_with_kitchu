package com.piyaso.softforest.piyaso.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.piyaso.softforest.piyaso.Beans.CategoryBean;
import com.piyaso.softforest.piyaso.Interfaces.OnCategoryIteSelected;
import com.piyaso.softforest.piyaso.R;
import com.piyaso.softforest.piyaso.customfonts.TextView_Lato;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by intellyelabs on 18/03/17.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    Context context;
    ArrayList<CategoryBean>  categoryBeanList;
    OnCategoryIteSelected onCategoryIteSelected;


   public void OnCategorySelectionCallBack(final OnCategoryIteSelected onCategoryIteSelected)
    {
        this.onCategoryIteSelected=onCategoryIteSelected;
    }


    public CategoryAdapter(Context context, ArrayList<CategoryBean> categoryBeanList) {
        this.context=context;
        this.categoryBeanList=categoryBeanList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        String category_id= String.valueOf(categoryBeanList.get(position).getCategory_id());
        holder.title.setText(categoryBeanList.get(position).getCategory_name());
        holder.category_ids.setText(category_id);
        String urlimage=categoryBeanList.get(position).getCategory_image();
               Glide .with(context)
                .load(urlimage)
                .centerCrop()
                .placeholder(R.drawable.category_placeholder)
                .crossFade()
                .into(holder.image_view);

        holder.rootid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "ID"+position, Toast.LENGTH_SHORT).show();
        onCategoryIteSelected.OnClickCatagoryItem(v,position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return categoryBeanList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

CircleImageView image_view;
        TextView_Lato title;
        TextView_Lato category_ids;
        LinearLayout rootid;

        public MyViewHolder(final View itemView) {
            super(itemView);

            image_view= (CircleImageView) itemView.findViewById(R.id.circle_imageview);
            title= (TextView_Lato) itemView.findViewById(R.id.category_tittle);
            category_ids= (TextView_Lato) itemView.findViewById(R.id.category_id_main);
            rootid= (LinearLayout) itemView.findViewById(R.id.linear_id);

        }
    }
}
