package com.example.ricardocossich.petagramrcenodejs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.ricardocossich.petagramrcenodejs.restApi.ConstantesRestApi;
import com.example.ricardocossich.petagramrcenodejs.restApi.IEndpointsApi;
import com.example.ricardocossich.petagramrcenodejs.restApi.JsonKeys;
import com.example.ricardocossich.petagramrcenodejs.restApi.adapter.RestApiAdapter;
import com.example.ricardocossich.petagramrcenodejs.restApi.model.RelacionResponse;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rcossich on 24/05/2017.
 */

public class ReceptorNotificaciones extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        String accion =intent.getAction();

        if(ConstantesApp.MI_PERFIL_ACTION.equals(accion)) {
            Mostrar_Perfil(context);
        }
        else if (ConstantesApp.SEGUIR_INSTAGRAM.equals(accion)) {
            Seguir_Usuario(context);
            }
        else if (ConstantesApp.VER_OTRO_PERFIL.equals(accion)) {
            Otro_Perfil(context);
        }
    }

    public void Seguir_Usuario(final Context context) {
        Toast.makeText(context,"Tu usuario("+MainActivity.cuentaInstagram+"), seguira en Instagram a: "+MainActivity.cuentaInstagramInvitado, Toast.LENGTH_LONG).show();
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonRelaciones = restApiAdapter.construyeGsonDeserializadorRelacion();
        IEndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonRelaciones);
        final Call<RelacionResponse> RelacionResponseCall = endpointsApi.setRelationShip("follow",MainActivity.idUsuarioInstagramInvitado);

        RelacionResponseCall.enqueue(new Callback<RelacionResponse>() {
            @Override
            public void onResponse(Call<RelacionResponse> call, Response<RelacionResponse> response) {
                RelacionResponse informacionrespuestarelacion = response.body();
                if (informacionrespuestarelacion!=null) {
                    if (informacionrespuestarelacion.getCodigo()!= JsonKeys.CODIGO_OK) {
                        Log.e("ERROR_EN_FOLLOW","Codigo: "+informacionrespuestarelacion.getCodigo());
                    } else {
                        //reportamos el outgoing_status

                        Toast.makeText(context,"Estado de instagram "+informacionrespuestarelacion.getOutgoing_status(),Toast.LENGTH_LONG).show();
                    }

                } else { //el cuerpo de la respuesta venia vacio (follow a instagram).
                    if (response.errorBody()!= null) {
                        Log.e("Error al dar follow",response.errorBody().toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<RelacionResponse> call, Throwable t) {
                Log.e("FALLO LA CONEXION2", t.toString());
            }
        });

    }

    public void Mostrar_Perfil(Context context) {
        Toast.makeText(context, "Se selecciona ver el perfil propio", Toast.LENGTH_LONG).show();
    }

    public void Otro_Perfil(Context context) {
        Toast.makeText(context,"Se selecciona ver le perfil de usuario", Toast.LENGTH_LONG).show();
    }
}
