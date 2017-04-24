package com.example.ricardocossich.petagramrcenodejs.restApi.model;

import java.util.ArrayList;

/**
 * Created by rcossich on 23/04/2017.
 */

public class RegistrosUsuarioResponse {

    ArrayList<RegistraUsuarioResponse> registros_usuarios;

    public ArrayList<RegistraUsuarioResponse> getRegistros_usuarios() {
        return registros_usuarios;
    }

    public void setRegistros_usuarios(ArrayList<RegistraUsuarioResponse> registros_usuarios) {
        this.registros_usuarios = registros_usuarios;
    }
}
