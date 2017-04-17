package com.example.ricardocossich.petagramrcenodejs.fragmento;

import com.example.ricardocossich.petagramrcenodejs.adaptador.MascotaAdaptador4;
import com.example.ricardocossich.petagramrcenodejs.modelo.MascotaInstagram;

import java.util.ArrayList;

/**
 * Created by rcossich on 28/03/2017.
 */

public interface IFragmentMascotaView {

    public void generarGridLayout();

    public MascotaAdaptador4 crearAdaptador(ArrayList<MascotaInstagram> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador4 adaptador);

}
