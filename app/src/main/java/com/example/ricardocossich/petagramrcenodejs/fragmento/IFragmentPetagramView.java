package com.example.ricardocossich.petagramrcenodejs.fragmento;


import com.example.ricardocossich.petagramrcenodejs.adaptador.MascotaAdaptador;
import com.example.ricardocossich.petagramrcenodejs.modelo.Mascota;

import java.util.ArrayList;

/**
 * Created by rcossich on 23/03/2017.
 */

public interface IFragmentPetagramView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
