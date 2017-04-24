package com.example.ricardocossich.petagramrcenodejs.restApi.adapter;

import com.example.ricardocossich.petagramrcenodejs.restApi.ConstantesRestApi;
import com.example.ricardocossich.petagramrcenodejs.restApi.IEndpointsFirebase;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rcossich on 23/04/2017.
 */

public class RestApiFirebaseAdapter  {
    public IEndpointsFirebase establecerConexionFiurebase() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL_FIREBASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                ;

        return retrofit.create(IEndpointsFirebase.class);
    }
}
