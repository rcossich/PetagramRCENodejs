package com.example.ricardocossich.petagramrcenodejs;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.ricardocossich.petagramrcenodejs.adaptador.MascotaAdaptador2;
import com.example.ricardocossich.petagramrcenodejs.modelo.ConstructorMascotas2;
import com.example.ricardocossich.petagramrcenodejs.modelo.Mascota;

import java.util.ArrayList;

public class Favoritos extends AppCompatActivity {

    private ArrayList<Mascota> mascotas2;
    private RecyclerView listaMascotas2;
    private ConstructorMascotas2 constructorMascotas2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        listaMascotas2 = (RecyclerView) findViewById(R.id.rvMascotas2);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas2.setLayoutManager(llm);
        //Toast.makeText(this,"Antes de llamar a constructorMascotas2.obtenerDatosLikes",Toast.LENGTH_LONG).show();
        inicializarListaMascotas2();
        inicializarAdaptador2();
    }
    public void inicializarAdaptador2(){
        MascotaAdaptador2 adaptador = new MascotaAdaptador2(mascotas2);
        listaMascotas2.setAdapter(adaptador);
    }
    public void inicializarListaMascotas2() {

        mascotas2 = new ArrayList<Mascota>();
        constructorMascotas2 = new ConstructorMascotas2(this);
        mascotas2 = constructorMascotas2.obtenerDatosLikes();
        if (mascotas2.size()<=0) {
            Toast.makeText(this,"NO EXISTEN LIKES REGISTRADOS!!!", Toast.LENGTH_LONG).show();
        }


    }
}

