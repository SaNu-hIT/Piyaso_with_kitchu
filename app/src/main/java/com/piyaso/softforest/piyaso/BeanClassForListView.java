package com.piyaso.softforest.piyaso;

/**
 * Created by admin on 3/22/2016.
 */
public class  BeanClassForListView {

    private int image;
    private String awesom;
    private String rate;
    private String number;
    private int city;

    public BeanClassForListView(int image, String awesom, String rate, String number) {
        this.image = image;
        this.awesom = awesom;
        this.rate = rate;
        this.number = number;
    }

    public BeanClassForListView(int i, String s, String s1) {

    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getAwesom() {
        return awesom;
    }

    public void setAwesom(String awesom) {
        this.awesom = awesom;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }



}
