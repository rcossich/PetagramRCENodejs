package com.example.ricardocossich.petagramrcenodejs.restApi.model;

import com.example.ricardocossich.petagramrcenodejs.modelo.MascotaInstagram;

import java.util.ArrayList;

/**
 * Created by rcossich on 29/03/2017.
 */

public class MascotaResponse {

    ArrayList<MascotaInstagram> mascotas;

    public ArrayList<MascotaInstagram> getMascotas() { return mascotas; }

    public void setMascotas(ArrayList<MascotaInstagram> mascotas) { this.mascotas = mascotas; }
}
