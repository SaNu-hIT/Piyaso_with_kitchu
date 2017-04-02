package com.piyaso.softforest.piyaso.HttpInterfaces;

import com.piyaso.softforest.piyaso.Beans.CategoryBean;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by intellyelabs on 30/03/17.
 */

public interface OnHttpRequestresponseListnerCategory {

    void OnHttpCategoryResponceSuccess(ArrayList<CategoryBean> categoryBeen, String error, JSONArray categories);
    void OnHttpCategoryResponceFailure(Throwable throwable, boolean error);
}
