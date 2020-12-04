package hr.ferit.osnove_rwma_dz4;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("products.json?brand=maybelline")
    Call<List<Makeup>> getMaybellineElements();

    @GET("products.json")
    Call<List<Makeup>> getProducts(@Query("brand")String brand);
}
