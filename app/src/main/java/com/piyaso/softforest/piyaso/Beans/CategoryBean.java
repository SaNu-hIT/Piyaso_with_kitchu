package com.piyaso.softforest.piyaso.Beans;

import java.util.ArrayList;

/**
 * Created by intellyelabs on 18/03/17.
 */

public class CategoryBean  {
    int category_id;
    String category_name;
    String category_image;



    public CategoryBean(int category_id, String category_name, String category_image) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.category_image = category_image;
    }

    public int getCategory_id() {
        return category_id;
    }



    public String getCategory_name() {
        return category_name;
    }



    public String getCategory_image() {
        return category_image;
    }


}
