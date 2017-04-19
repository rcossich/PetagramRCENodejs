package com.example.ricardocossich.petagramrcenodejs.restApi.adapter;

import com.example.ricardocossich.petagramrcenodejs.restApi.ConstantesRestApi;
import com.example.ricardocossich.petagramrcenodejs.restApi.IEndpointsHeroku;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rcossich on 18/04/2017.
 */

public class RestApiHerokuAdapter {
    public IEndpointsHeroku establecerConexionRestAPIHeroku(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL_HEROKU)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                ;

        return retrofit.create(IEndpointsHeroku.class);
    }


}
