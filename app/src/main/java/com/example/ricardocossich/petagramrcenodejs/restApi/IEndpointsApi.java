package com.example.ricardocossich.petagramrcenodejs.restApi;

import com.example.ricardocossich.petagramrcenodejs.restApi.model.InformacionUsuarioResponse;
import com.example.ricardocossich.petagramrcenodejs.restApi.model.LikeResponse;
import com.example.ricardocossich.petagramrcenodejs.restApi.model.MascotaResponse;
import com.example.ricardocossich.petagramrcenodejs.restApi.model.RelacionResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by rcossich on 29/03/2017.
 */

public interface IEndpointsApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<MascotaResponse> getRecentMedia();
    //aca va por cada usuario a buscar su @GET
    @GET(ConstantesRestApi.URL_GET_USERS_QUERY0)
    Call<InformacionUsuarioResponse> getUsuariosBusqueda0();
    @GET(ConstantesRestApi.URL_GET_USERS_QUERY1)
    Call<InformacionUsuarioResponse> getUsuariosBusqueda1();
    //aca probamos uno con parametro
    @GET(ConstantesRestApi.URL_GET_USERS_QUERY)
    Call<InformacionUsuarioResponse> getUsuariosBusqueda(@Query("q") String usuario_a_buscar);
    //aca probamos la recent media con user-id
    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER2)
    Call<MascotaResponse> getRecentMediaUserId(@Path("userid") String usuario_id);

    //para el POST del LIKE
    @FormUrlEncoded
    @POST(ConstantesRestApi.URL_POST_LIKE)
    Call<LikeResponse> postLikeInstagram(@Path("media-id") String id_media_instagram,@Field("access_token") String access_token);

    //para el GET de Follow
    @GET(ConstantesRestApi.URL_GET_RELATIONSHIP)
    Call<RelacionResponse> getRelationship(@Path("userid") String usuario_id);

    //para el POST de Follow
    @FormUrlEncoded
    @POST(ConstantesRestApi.URL_GET_RELATIONSHIP)
    Call<RelacionResponse> setRelationShip(@Field("action") String accion, @Path("userid") String usuario_id);

}
