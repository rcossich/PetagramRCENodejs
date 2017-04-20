package com.example.ricardocossich.petagramrcenodejs.modelo;

/**
 * Created by rcossich on 29/03/2017.
 */

public class MascotaInstagram {
    private String id;
    private String nombreCompleto;
    private String media_id;
    private String urlFoto;
    private int likes = 0;


    public MascotaInstagram(String urlFoto, String nombreCompleto, int likes) {
        this.urlFoto = urlFoto;
        this.nombreCompleto = nombreCompleto;
        this.likes = likes;
    }

    public MascotaInstagram() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getMedia_id() { return media_id; }

    public void setMedia_id(String media_id) { this.media_id = media_id; }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}


