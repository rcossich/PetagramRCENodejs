package com.example.ricardocossich.petagramrcenodejs.restApi.adapter;

import com.example.ricardocossich.petagramrcenodejs.restApi.ConstantesRestApi;
import com.example.ricardocossich.petagramrcenodejs.restApi.IEndpointsApi;
import com.example.ricardocossich.petagramrcenodejs.restApi.deserializer.InformacionUsuarioDeserializador;
import com.example.ricardocossich.petagramrcenodejs.restApi.deserializer.LikeDeserializador;
import com.example.ricardocossich.petagramrcenodejs.restApi.deserializer.MascotaDeserializador;
import com.example.ricardocossich.petagramrcenodejs.restApi.deserializer.RelacionDeserializador;
import com.example.ricardocossich.petagramrcenodejs.restApi.model.InformacionUsuarioResponse;
import com.example.ricardocossich.petagramrcenodejs.restApi.model.LikeResponse;
import com.example.ricardocossich.petagramrcenodejs.restApi.model.MascotaResponse;
import com.example.ricardocossich.petagramrcenodejs.restApi.model.RelacionResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rcossich on 29/03/2017.
 */

public class RestApiAdapter {

    public IEndpointsApi establecerConexionRestApiInstagram(Gson gson){
        HttpLoggingInterceptor logging =  new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .addInterceptor(logging);
        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(IEndpointsApi.class);
    }

    public Gson construyeGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new MascotaDeserializador());
        return gsonBuilder.create();
    }

    public Gson construyeGsonDeserializadorBusquedaUsuarios(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(InformacionUsuarioResponse.class, new InformacionUsuarioDeserializador());
        return gsonBuilder.create();
    }

    public Gson construyeGsonDeserializadorDarLike() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LikeResponse.class, new LikeDeserializador());
        return gsonBuilder.create();
    }

    public Gson construyeGsonDeserializadorRelacion() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(RelacionResponse.class, new RelacionDeserializador());
        return gsonBuilder.create();
    }

}
