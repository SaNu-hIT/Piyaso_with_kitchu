package com.piyaso.softforest.piyaso.Beans;

/**
 * Created by intellyelabs on 19/03/17.
 */

public class ProductListBean {
    int product_id;
    String product_name;
    String image_url;

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    String product_description;
    String category;

    public ProductListBean(int product_id, String product_name, String product_description, String category,String image_url) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.category = category;
        this.image_url=image_url;
    }
}
