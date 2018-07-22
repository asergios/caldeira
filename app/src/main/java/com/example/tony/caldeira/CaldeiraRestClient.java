package com.example.tony.caldeira;
import com.loopj.android.http.*;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

public class CaldeiraRestClient {

    private static final String BASE_URL = "X.X.X.X"; // URL for the request here
    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void postCaldeiraState(boolean state){

        // Json Body for the POST request
        JSONObject jsonParams = new JSONObject();
        StringEntity entity;

        try {

            // Setting Action on body
            jsonParams.put("Action", state);
            entity = new StringEntity(jsonParams.toString());

            // Sending the POST request
            client.post(null, BASE_URL, entity, "application/json", new AsyncHttpResponseHandler() {

                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                    // called when response HTTP status is "200 OK"
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                    // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                }

            });
        }
        catch (Exception e) {

            System.out.println(e);

        }

    }

}
