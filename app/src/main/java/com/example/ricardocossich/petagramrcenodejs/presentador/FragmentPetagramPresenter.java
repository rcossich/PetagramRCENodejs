package com.example.ricardocossich.petagramrcenodejs.presentador;

import android.content.Context;

import com.example.ricardocossich.petagramrcenodejs.fragmento.IFragmentPetagramView;
import com.example.ricardocossich.petagramrcenodejs.modelo.ConstructorMascotas;
import com.example.ricardocossich.petagramrcenodejs.modelo.Mascota;

import java.util.ArrayList;

/**
 * Created by rcossich on 23/03/2017.
 */

public class FragmentPetagramPresenter implements IFragmentPetagramPresenter {

    private IFragmentPetagramView iFragmentPetagramView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public FragmentPetagramPresenter(IFragmentPetagramView iFragmentPetagramView, Context context) {
        this.iFragmentPetagramView = iFragmentPetagramView;
        this.context = context;
        obtenerMascotas();
    }

    @Override
    public void obtenerMascotas() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();

    }

    @Override
    public void mostrarMascotasRV() {
        iFragmentPetagramView.inicializarAdaptadorRV(iFragmentPetagramView.crearAdaptador(mascotas));
        iFragmentPetagramView.generarLinearLayoutVertical();

    }
}
