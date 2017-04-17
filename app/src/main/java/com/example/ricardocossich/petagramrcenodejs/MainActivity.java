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





public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public static String cuentaInstagram;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar   = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            Log.i("En main"," con parametros");
            Toast.makeText(this,"Con parametros en main",Toast.LENGTH_LONG).show();
            String cuentaRecupera  = extras.getString("cuenta_instagram");
            cuentaInstagram = cuentaRecupera;
        } else {
            Log.i("Main sin"," parametros");
            Toast.makeText(this,"Sin parametros en main",Toast.LENGTH_LONG).show();
            cuentaInstagram = "ricardo.cossich";
        }

        setUpViewPager();

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

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
            case R.id.mUsuario:
                Intent l = new Intent(this,UsuarioInstagramActivity.class);
                startActivity(l);
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


}
