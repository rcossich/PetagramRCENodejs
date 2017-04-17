package com.example.ricardocossich.petagramrcenodejs.fragmento;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ricardocossich.petagramrcenodejs.R;
import com.example.ricardocossich.petagramrcenodejs.adaptador.MascotaAdaptador4;
import com.example.ricardocossich.petagramrcenodejs.modelo.Mascota;
import com.example.ricardocossich.petagramrcenodejs.modelo.MascotaInstagram;
import com.example.ricardocossich.petagramrcenodejs.presentador.FragmentMascotaPresenter;
import com.example.ricardocossich.petagramrcenodejs.presentador.IFragmentMascotaPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMascota extends Fragment implements IFragmentMascotaView {


    private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas4;
    private IFragmentMascotaPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mascota,container,false); //equivale a asignarle la clase al layout

        rvMascotas4 = (RecyclerView) v.findViewById(R.id.rvMascotas4);
        presenter = new FragmentMascotaPresenter(this,getContext());
        return v;
    }


    @Override
    public void generarGridLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        rvMascotas4.setLayoutManager(gridLayoutManager);

    }

    @Override
    public MascotaAdaptador4 crearAdaptador(ArrayList<MascotaInstagram> mascotas) {
        MascotaAdaptador4 adaptador = new MascotaAdaptador4(mascotas,getActivity());
        return adaptador;

    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador4 adaptador) {
        rvMascotas4.setAdapter(adaptador);
    }
}
