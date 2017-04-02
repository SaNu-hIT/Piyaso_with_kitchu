package com.piyaso.softforest.piyaso.HttpInterfaces;

import org.json.JSONArray;

/**
 * Created by intellyelabs on 02/04/17.
 */

public interface OnHttpRequestresponceListerForSubcategory {

void HttpRequestForSubCategorySuccess(boolean error, JSONArray subcategorys);

    void HttpRequestForSubCategoryFailure(Throwable t, boolean error);
}
