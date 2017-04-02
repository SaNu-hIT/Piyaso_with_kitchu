package com.piyaso.softforest.piyaso.HttpInterfaces;

import org.json.JSONArray;

/**
 * Created by intellyelabs on 30/03/17.
 */

public interface OnHttpRequestResponceListnerProdutListing {


     void OnHttprequestProductListingSuccess(JSONArray jsonArray,boolean error);
    void OnHttpRequestProductListingFailure(Throwable t,boolean error);
}
