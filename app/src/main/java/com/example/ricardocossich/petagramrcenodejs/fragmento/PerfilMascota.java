package com.example.ricardocossich.petagramrcenodejs.fragmento;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ricardocossich.petagramrcenodejs.R;
import com.example.ricardocossich.petagramrcenodejs.adaptador.MascotaAdaptador3;
import com.example.ricardocossich.petagramrcenodejs.modelo.Mascota;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilMascota extends Fragment {

    ArrayList<Mascota> mascotas3;
    private RecyclerView listaMascotas3;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil_mascota,container,false); //equivale a asignarle la clase al layout

        listaMascotas3 = (RecyclerView) v.findViewById(R.id.rvMascotas3);
        GridLayoutManager llm = new GridLayoutManager(getActivity(),3);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas3.setLayoutManager(llm);
        inicializarListaMascotas3();
        inicializarAdaptador3();

        return v;
    }

    public void inicializarAdaptador3(){
        MascotaAdaptador3 adaptador = new MascotaAdaptador3(mascotas3);
        listaMascotas3.setAdapter(adaptador);
    }
    public void inicializarListaMascotas3() {
        mascotas3 = new ArrayList<Mascota>();
        mascotas3.add(new Mascota(R.drawable.dog_pet_06,"Mascota 06",1));
        mascotas3.add(new Mascota(R.drawable.dog_pet_06,"Mascota 06",2));
        mascotas3.add(new Mascota(R.drawable.dog_pet_06,"Mascota 06",3));
        mascotas3.add(new Mascota(R.drawable.dog_pet_06,"Mascota 06",4));
        mascotas3.add(new Mascota(R.drawable.dog_pet_06,"Mascota 06",5));
        mascotas3.add(new Mascota(R.drawable.dog_pet_06,"Mascota 06",6));
        mascotas3.add(new Mascota(R.drawable.dog_pet_06,"Mascota 06",7));
        mascotas3.add(new Mascota(R.drawable.dog_pet_06,"Mascota 06",8));
        mascotas3.add(new Mascota(R.drawable.dog_pet_06,"Mascota 06",9));
        mascotas3.add(new Mascota(R.drawable.dog_pet_06,"Mascota 06",10));
        mascotas3.add(new Mascota(R.drawable.dog_pet_06,"Mascota 06",11));
        mascotas3.add(new Mascota(R.drawable.dog_pet_06,"Mascota 06",12));
    }

}
