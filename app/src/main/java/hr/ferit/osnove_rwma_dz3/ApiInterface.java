package hr.ferit.osnove_rwma_dz3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("users")
    Call<List<User>> getUsers();

    @GET("users/{id}")
    Call<User> getUser(@Path("id")String userId);

    //@GET("products.json")
    //Call<List<Makeup>> getUser(@Query("brand")String brand);
}
