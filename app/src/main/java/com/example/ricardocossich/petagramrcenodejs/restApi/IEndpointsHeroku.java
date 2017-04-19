package com.example.ricardocossich.petagramrcenodejs.restApi;

import com.example.ricardocossich.petagramrcenodejs.restApi.model.RegistraUsuarioResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by rcossich on 18/04/2017.
 */

public interface IEndpointsHeroku {
    @FormUrlEncoded
    @POST(ConstantesRestApi.KEY_POST_REGISTRA_USUARIO)
    Call<RegistraUsuarioResponse> registrarUsuario(@Field("id_dispositivo") String id_dispositivo, @Field("id_usuario_instagram") String id_usuario_instagram);
}
