package ripo.com.jsonparsing;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("v1/ticker/?limit=")
    Call<ArrayList<JSONResponse>> getJSON();
}
