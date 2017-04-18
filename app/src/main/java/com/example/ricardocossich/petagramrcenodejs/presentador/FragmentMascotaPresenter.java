package com.example.ricardocossich.petagramrcenodejs.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.ricardocossich.petagramrcenodejs.MainActivity;
import com.example.ricardocossich.petagramrcenodejs.fragmento.IFragmentMascotaView;
import com.example.ricardocossich.petagramrcenodejs.modelo.ConstructorMascotas;
import com.example.ricardocossich.petagramrcenodejs.modelo.InformacionUsuario;
import com.example.ricardocossich.petagramrcenodejs.modelo.MascotaInstagram;
import com.example.ricardocossich.petagramrcenodejs.restApi.IEndpointsApi;
import com.example.ricardocossich.petagramrcenodejs.restApi.adapter.RestApiAdapter;
import com.example.ricardocossich.petagramrcenodejs.restApi.model.InformacionUsuarioResponse;
import com.example.ricardocossich.petagramrcenodejs.restApi.model.MascotaResponse;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rcossich on 28/03/2017.
 */

public class FragmentMascotaPresenter  implements IFragmentMascotaPresenter {

    private IFragmentMascotaView iFragmentMascotaView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<InformacionUsuario> usuarios=new ArrayList<InformacionUsuario>();
    private ArrayList<MascotaInstagram> mascotas=new ArrayList<>();
    private String idusuario;
    private String nombreusuario;

    public FragmentMascotaPresenter(IFragmentMascotaView iFragmentMascotaView, Context context) {
        this.iFragmentMascotaView = iFragmentMascotaView;
        this.context = context;
        recolectarusuarios();
    }

    @Override
    public void obtenerMediosRecientes(String pcuenta) {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        IEndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        Call<MascotaResponse> mascotaResponseCall = endpointsApi.getRecentMediaUserId(pcuenta);


        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();
                mascotas = mascotaResponse.getMascotas();
                mostrarMascotasRV();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "¡Al pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e("FALLO LA CONEXION", t.toString());
            }
        });



    }

    public void recolectarusuarios() {

        //aca estoy buscando usuario para obtener su id y luego llamada a traer su recent media para llevarla al adaptador enviando mascotas5 como datos.
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonListaUsuarios = restApiAdapter.construyeGsonDeserializadorBusquedaUsuarios();
        IEndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonListaUsuarios);
        nombreusuario = MainActivity.cuentaInstagram;

        final String usuario_alterno = "uefachampionsleague";
        //Call<InformacionUsuarioResponse> informacionusuarioResponseCall = endpointsApi.getUsuariosBusqueda(usuario_alterno);
        Call<InformacionUsuarioResponse> informacionusuarioResponseCall = endpointsApi.getUsuariosBusqueda(nombreusuario);

        informacionusuarioResponseCall.enqueue(new Callback<InformacionUsuarioResponse>(){
            @Override
            public void onResponse(Call<InformacionUsuarioResponse> call, Response<InformacionUsuarioResponse> response) {
                Log.d("Deja",""+ response.errorBody());
                if (response.isSuccessful()) {
                    InformacionUsuarioResponse informacionusuarioResponse = response.body();
                    usuarios = null;
                    usuarios = informacionusuarioResponse.getInformacionUsuarios();
                    if (!usuarios.isEmpty()) {
                        //Toast.makeText(getBaseContext(),"Tamaño de la respuesta"+usuarios.size(),Toast.LENGTH_LONG).show();
                        for (int i = 0; i < usuarios.size(); i++) {
                            //Toast.makeText(getBaseContext(),"ID: "+i+">>"+usuarios.get(i).getId(),Toast.LENGTH_LONG).show();
                            Log.d("ID del usuario", usuarios.get(i).getId());
                            Log.d("Nombre del usuario", usuarios.get(i).getUsername());
                            Log.d("Direccion foto perfil", usuarios.get(i).getProfile_picture_url());
                        }
                        Log.d("Final", "Saliendo de obtener datos de busqueda");
                        idusuario =usuarios.get(0).getId();
                        //Toast.makeText(context,"se recupera id "+idusuario+" para "+nombreusuario,Toast.LENGTH_LONG).show();
                        obtenerMediosRecientes(idusuario);
                        MainActivity.idUsuarioInstagram = idusuario;
                    } else {
                        Toast.makeText(context,"No pude recuperar el id del usuario: "+nombreusuario,Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(context,"Aunque hay respuesta de busqueda usuario, no fue posible recuperar informacion en Instagram",Toast.LENGTH_LONG).show();
                    Log.e("onResponse con problema","");
                }
            }

            @Override
            public void onFailure(Call<InformacionUsuarioResponse> call, Throwable t) {
                Toast.makeText(context, "¡Algo pasó en la conexión hacia Instagram", Toast.LENGTH_LONG).show();
                Log.e("FALLO LA CONEXION2", t.toString());
            }
        });


    }


    @Override
    public void mostrarMascotasRV() {
        iFragmentMascotaView.inicializarAdaptadorRV(iFragmentMascotaView.crearAdaptador(mascotas));
        iFragmentMascotaView.generarGridLayout();
    }
}


