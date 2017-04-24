package com.example.ricardocossich.petagramrcenodejs.restApi.model;

/**
 * Created by rcossich on 20/04/2017.
 */

public class LikeResponse {

    private int codigo;
    private String tipo_error;
    private String mensaje_error;

    public LikeResponse() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo_error() {
        return tipo_error;
    }

    public void setTipo_error(String tipo_error) {
        this.tipo_error = tipo_error;
    }

    public String getMensaje_error() {
        return mensaje_error;
    }

    public void setMensaje_error(String mensaje_error) {
        this.mensaje_error = mensaje_error;
    }
}
