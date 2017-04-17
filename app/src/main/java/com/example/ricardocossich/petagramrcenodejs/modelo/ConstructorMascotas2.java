package com.example.ricardocossich.petagramrcenodejs.modelo;

import android.content.Context;

import com.example.ricardocossich.petagramrcenodejs.db.BaseDatos;

import java.util.ArrayList;

/**
 * Created by rcossich on 23/03/2017.
 */

public class ConstructorMascotas2 {

    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascotas2(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatosLikes() {
        BaseDatos db = new BaseDatos(context);
        //Toast.makeText(context,"Obteniendo mascotas (maximo 5) con los likes mas recientes ",Toast.LENGTH_SHORT).show();
        return  db.obtenerCincoMascotasConLikesMasRecientes();
    }
}
