package com.example.ricardocossich.petagramrcenodejs;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import com.example.ricardocossich.petagramrcenodejs.adaptador.PageAdapter;
import com.example.ricardocossich.petagramrcenodejs.db.BaseDatos;
import com.example.ricardocossich.petagramrcenodejs.fragmento.FragmentMascota;
import com.example.ricardocossich.petagramrcenodejs.fragmento.FragmentPetagram;
import com.example.ricardocossich.petagramrcenodejs.fragmento.PerfilMascota;
import com.example.ricardocossich.petagramrcenodejs.restApi.IEndpointsHeroku;
import com.example.ricardocossich.petagramrcenodejs.restApi.adapter.RestApiAdapter;
import com.example.ricardocossich.petagramrcenodejs.restApi.adapter.RestApiHerokuAdapter;
import com.example.ricardocossich.petagramrcenodejs.restApi.model.RegistraUsuarioResponse;
import com.google.firebase.iid.FirebaseInstanceId;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private static final String token_tablet_AOC = "djU9b5izw3g:APA91bHdTAqx-IVBkryFJ-46lBy4TqnzD8-h84GoIo0sKNzt2evOqq2Hh7KXYIHgsoZBdeccJnPMhRuM_m5uQBFR4uXhcr2kRrqk6-pnxsrNVv6lGrZq_YDOxEZqfSjlPFnnGzvHQm0Y";
    private static final String token_emulator_nexus_5_api_24_PC_rcossich_santaana = "fqES8mbc3GM:APA91bEjmoC7yoORQBvUINjDQwjOkj3mzWY1Zqi_76KZATenYc49pZ8dXqFioePmly7-IhQDVW3uTQfxhb4k3SWiSB5t4S1h66e2pArWpIV53LIOgDjRTSjCw0Vnob6BM1MOAv67dV53";
                                                                                    //fqES8mbc3GM:APA91bEjmoC7yoORQBvUINjDQwjOkj3mzWY1Zqi_76KZATenYc49pZ8dXqFioePmly7-IhQDVW3uTQfxhb4k3SWiSB5t4S1h66e2pArWpIV53LIOgDjRTSjCw0Vnob6BM1MOAv67dV53
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public static String cuentaInstagram;
    public static String idUsuarioInstagram;
    public static String cuentaInstagramInvitado;
    public static String idUsuarioInstagramInvitado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar   = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        //dejamos fija la cuenta del usuario instagram invitado (para el timeline).
        cuentaInstagramInvitado = "ricardoescobar1783";

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            Log.i("En main"," con parametros");
            //Toast.makeText(this,"Con parametros en main",Toast.LENGTH_LONG).show();
            String cuentaRecupera  = extras.getString("cuenta_instagram");
            cuentaInstagram = cuentaRecupera;
        } else {
            Log.i("Main sin"," parametros");
            //Toast.makeText(this,"Sin parametros en main",Toast.LENGTH_LONG).show();
            if (cuentaInstagram.isEmpty()) {
                cuentaInstagram = "ricardo.cossich";
            }
        }



        setUpViewPager();

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        //viendo el token del dispositivo en FireBase
        String token2 = FirebaseInstanceId.getInstance().getToken();
        Log.d("TOKEN_INICIO",token2);
        enviarTokenRegistro("Desde inicio",token2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.mFavoritos:
                Intent intent = new Intent(this,Favoritos.class);
                startActivity(intent);
                break;
            case R.id.mContacto:
                Intent i = new Intent(this,EnviarCorreo.class);
                startActivity(i);
                break;
            case R.id.mAcerca:
                Intent j = new Intent(this,AcercaDe.class);
                startActivity(j);
                break;
            case R.id.mBorrarLikes:
                borrarLikesMascotas();
                setUpViewPager();
                break;
            case R.id.mTimeLine:
                Intent k = new Intent(this,TimeLineActivity.class);
                startActivity(k);
                break;
            case R.id.mUsuarioTL:
                Intent l = new Intent(this,UsuarioTimeLine.class);
                startActivity(l);
                break;
            case R.id.mUsuario:
                Intent m = new Intent(this,UsuarioInstagramActivity.class);
                startActivity(m);
                break;
            case R.id.mTokenID:
                String token = FirebaseInstanceId.getInstance().getToken();
                Log.d("TOKEN",token);
                enviarTokenRegistro("Desde menu",token);
                break;

            case R.id.mRecibeNotificaciones:
                String token1 = FirebaseInstanceId.getInstance().getToken();
                Log.d("TOKEN",token1);
                enviarTokenRegistro("En Recibe notif.",token1);
                insertaRegistroFirebase(token1,cuentaInstagram);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new FragmentMascota());
        fragments.add(new FragmentPetagram());
        fragments.add(new PerfilMascota());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.instagramold48);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_dog);
    }

    private void borrarLikesMascotas() {
        BaseDatos db = new BaseDatos(this);
        db.borrarLikes();
        Toast.makeText(this,"Se han borrado los likes de las mascotas.",Toast.LENGTH_LONG).show();
    }

    private void enviarTokenRegistro(String donde,String token) {

        Log.d(donde,token);
        Toast.makeText(this,"Se obtuvo el siguiente Id de dispositivo: "+token,Toast.LENGTH_LONG).show();
    }

    private void insertaRegistroFirebase(String id_dispositivo,String id_usuario_instagram) {

        RestApiHerokuAdapter restApiHerokuAdapter = new RestApiHerokuAdapter();
        IEndpointsHeroku iEndpointsHeroku = restApiHerokuAdapter.establecerConexionRestAPIHeroku();
        Call<RegistraUsuarioResponse> registraUsuarioResponseCall = iEndpointsHeroku.registrarUsuario(id_dispositivo,id_usuario_instagram);

        registraUsuarioResponseCall.enqueue(new Callback<RegistraUsuarioResponse>() {

            @Override
            public void onResponse(Call<RegistraUsuarioResponse> call, Response<RegistraUsuarioResponse> response) {
                RegistraUsuarioResponse registraUsuarioResponse = response.body();
                Log.d("ID_FIREBASE_DB", registraUsuarioResponse.getId());
                Log.d("ID_DISPOSITIVO", registraUsuarioResponse.getId_dispositivo());
                Log.d("ID_USUARIO_INSTAGRAM", registraUsuarioResponse.getId_usuario_instagram());
            }

            @Override

            public void onFailure(Call<RegistraUsuarioResponse> call, Throwable t) {
            }

        });
    }
}
