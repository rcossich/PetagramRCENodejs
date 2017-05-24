package com.example.ricardocossich.petagramrcenodejs.restApi.model;

/**
 * Created by rcossich on 24/05/2017.
 */

public class RelacionResponse {
    private String outgoing_status;
    private int    codigo;

    public RelacionResponse() {
    }

    public String getOutgoing_status() {
        return outgoing_status;
    }

    public void setOutgoing_status(String outgoing_status) {
        this.outgoing_status = outgoing_status;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
