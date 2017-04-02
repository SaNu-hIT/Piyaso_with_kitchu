package com.piyaso.softforest.piyaso.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.piyaso.softforest.piyaso.Beans.CategoryBean;
import com.piyaso.softforest.piyaso.R;
import com.piyaso.softforest.piyaso.customfonts.TextView_Lato;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by intellyelabs on 18/03/17.
 */

public class ProductListingAdapter extends RecyclerView.Adapter<ProductListingAdapter.MyViewHolder> {
    Context context;
  List<CategoryBean>  categoryBeanList;


    public ProductListingAdapter(Context context, List<CategoryBean> categoryBeanList) {
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
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String category_id= String.valueOf(categoryBeanList.get(position).getCategory_id());
        holder.title.setText(categoryBeanList.get(position).getCategory_name());
        holder.category_ids.setText(category_id);




    }

    @Override
    public int getItemCount() {
        return categoryBeanList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        CircleImageView image_view;
        TextView_Lato title;
        TextView_Lato category_ids;

        public MyViewHolder(View itemView) {
            super(itemView);

            image_view= (CircleImageView) itemView.findViewById(R.id.circle_imageview);
            title= (TextView_Lato) itemView.findViewById(R.id.category_tittle);
            category_ids= (TextView_Lato) itemView.findViewById(R.id.category_id_main);

        }
    }
}
