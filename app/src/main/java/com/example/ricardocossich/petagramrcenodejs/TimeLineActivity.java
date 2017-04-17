package com.example.ricardocossich.petagramrcenodejs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.example.ricardocossich.petagramrcenodejs.adaptador.MediaInstagramAdaptador;
import com.example.ricardocossich.petagramrcenodejs.modelo.InformacionUsuario;
import com.example.ricardocossich.petagramrcenodejs.modelo.MascotaInstagram;
import com.example.ricardocossich.petagramrcenodejs.restApi.ConstantesRestApi;
import com.example.ricardocossich.petagramrcenodejs.restApi.IEndpointsApi;
import com.example.ricardocossich.petagramrcenodejs.restApi.adapter.RestApiAdapter;
import com.example.ricardocossich.petagramrcenodejs.restApi.model.InformacionUsuarioResponse;
import com.example.ricardocossich.petagramrcenodejs.restApi.model.MascotaResponse;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TimeLineActivity extends AppCompatActivity {

    private ArrayList<MascotaInstagram> mascotas5=new ArrayList<MascotaInstagram>();;
    private RecyclerView listaMascotas5;
    private ArrayList<InformacionUsuario> usuarios=new ArrayList<InformacionUsuario>();
    private String usuarioid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas5 = (RecyclerView) findViewById(R.id.rvMascotas5);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas5.setLayoutManager(llm);
        recolectarusuarios();
    }


    public void inicializarListaMascotas5(String pusuario) {

        String usuarioid = pusuario;
        Log.i("antes crear restApi2"," antes");
        RestApiAdapter restApiAdapter2 = new RestApiAdapter();
        Log.i("antes crear de-serial"," antes");
        Gson gsonMediaRecent2 = restApiAdapter2.construyeGsonDeserializadorMediaRecent();
        IEndpointsApi endpointsApi2 = restApiAdapter2.establecerConexionRestApiInstagram(gsonMediaRecent2);
        Log.i("antes call gRMUI"," usuarios?: ");
        Call<MascotaResponse> mascotaResponseCall = endpointsApi2.getRecentMediaUserId(usuarioid);

        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse2 = response.body();
                mascotas5 = mascotaResponse2.getMascotas();
                inicializarAdaptador5(mascotas5);
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Log.e("FALLA MEDIA USERID", t.toString());
            }
        });

    }


    public void inicializarAdaptador5(ArrayList<MascotaInstagram> pmedia)
    {
        MascotaInstagram mascotaInstagram = new MascotaInstagram("https://scontent.cdninstagram.com/t51.2885-15/s640x640/sh0.08/e35/17333777_202722466881042_6151779626264821760_n.jpg",
                "Sin retorno de datos",0);
        if (pmedia==null) {
            pmedia = new ArrayList<MascotaInstagram>();
        }
        if (pmedia.isEmpty()) {
            pmedia.add(mascotaInstagram);
        }
        MediaInstagramAdaptador adaptador = new MediaInstagramAdaptador(pmedia,this);
        listaMascotas5.setAdapter(adaptador);
    }


    public void recolectarusuarios() {

        //aca estoy buscando usuario para obtener su id y luego llamada a traer su recent media para llevarla al adaptador enviando mascotas5 como datos.
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonListaUsuarios = restApiAdapter.construyeGsonDeserializadorBusquedaUsuarios();
        IEndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonListaUsuarios);
        Log.i("Mandando ",ConstantesRestApi.KEY_USUARIOS[0]);

        final String usuario_alterno = "uefachampionsleague";
        //Call<InformacionUsuarioResponse> informacionusuarioResponseCall = endpointsApi.getUsuariosBusqueda(usuario_alterno);
        Call<InformacionUsuarioResponse> informacionusuarioResponseCall = endpointsApi.getUsuariosBusqueda(ConstantesRestApi.KEY_USUARIOS[0]);

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
                            Log.i("ID del usuario", usuarios.get(i).getId());
                            Log.i("Nombre del usuario", usuarios.get(i).getUsername());
                            Log.i("Direccion foto perfil", usuarios.get(i).getProfile_picture_url());
                        }
                        Log.i("Final", "Saliendo de obtener datos de busqueda");
                        usuarioid=usuarios.get(0).getId();
                        inicializarListaMascotas5(usuarioid);
                    } else {
                        Toast.makeText(getBaseContext(),"No pude recuperar el id de alguno de estos usuarios: "+usuario_alterno+","+ConstantesRestApi.KEY_USUARIOS[0],Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getBaseContext(),"Aunque hay respuesta de busqueda usuario, no fue posible recuperar informacion en Instagram",Toast.LENGTH_LONG).show();
                    Log.e("onResponse con problema","");
                }
            }

            @Override
            public void onFailure(Call<InformacionUsuarioResponse> call, Throwable t) {
                Toast.makeText(getBaseContext(), "¡Algo pasó en la conexión hacia Instagram", Toast.LENGTH_LONG).show();
                Log.e("FALLO LA CONEXION2", t.toString());
            }
        });


    }

}
