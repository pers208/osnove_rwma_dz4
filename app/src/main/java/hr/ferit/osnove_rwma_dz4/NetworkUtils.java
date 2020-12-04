package hr.ferit.osnove_rwma_dz4;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkUtils {


    private static ApiInterface apiInterface;

    private static final String BASE_API="https://makeup-api.herokuapp.com/api/v1/";

    public static ApiInterface getApiInterface() {
        if(apiInterface==null){
            Retrofit retrofit= new Retrofit.Builder()
                    .baseUrl(BASE_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiInterface=retrofit.create(ApiInterface.class);
        }
        return apiInterface;
    }
}
