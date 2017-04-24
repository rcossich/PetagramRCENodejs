package com.example.ricardocossich.petagramrcenodejs.restApi;

import com.example.ricardocossich.petagramrcenodejs.restApi.model.RegistrosUsuarioResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rcossich on 23/04/2017.
 */

public interface IEndpointsFirebase {
    @GET(ConstantesRestApi.KEY_GET_REGISTRAR_USUARIO)
    Call<RegistrosUsuarioResponse> getDispositivosRegistrados();
}
