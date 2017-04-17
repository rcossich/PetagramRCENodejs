package com.example.ricardocossich.petagramrcenodejs.restApi.model;

import com.example.ricardocossich.petagramrcenodejs.modelo.InformacionUsuario;

import java.util.ArrayList;

/**
 * Created by rcossich on 02/04/2017.
 */

public class InformacionUsuarioResponse {
    ArrayList <InformacionUsuario> informacionUsuarios;

    public ArrayList<InformacionUsuario> getInformacionUsuarios() {
        return informacionUsuarios;
    }

    public void setInformacionUsuarios(ArrayList<InformacionUsuario> informacionUsuarios) {
        this.informacionUsuarios = informacionUsuarios;
    }
}
