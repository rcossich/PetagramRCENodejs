package com.example.ricardocossich.petagramrcenodejs.restApi.adapter;

import com.example.ricardocossich.petagramrcenodejs.restApi.ConstantesRestApi;
import com.example.ricardocossich.petagramrcenodejs.restApi.IEndpointsHeroku;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rcossich on 18/04/2017.
 */

public class RestApiHerokuAdapter {
    public IEndpointsHeroku establecerConexionRestAPIHeroku(){
        HttpLoggingInterceptor logging =  new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .addInterceptor(logging);
        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .baseUrl(ConstantesRestApi.ROOT_URL_HEROKU)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                ;

        return retrofit.create(IEndpointsHeroku.class);
    }


}
