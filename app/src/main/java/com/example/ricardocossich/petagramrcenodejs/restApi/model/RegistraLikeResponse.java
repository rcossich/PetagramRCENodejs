package com.example.ricardocossich.petagramrcenodejs.restApi.model;

/**
 * Created by rcossich on 22/04/2017.
 */

public class RegistraLikeResponse {

    private String id;
    private String id_owner_instagram;
    private String id_media_instagram;
    private String id_sender_instagram;
    private String mensaje;

    public RegistraLikeResponse(String id, String id_owner_instagram, String id_media_instagram, String id_sender_instagram, String mensaje) {
        this.id = id;
        this.id_owner_instagram = id_owner_instagram;
        this.id_media_instagram = id_media_instagram;
        this.id_sender_instagram = id_sender_instagram;
        this.mensaje = mensaje;
    }


    public RegistraLikeResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_owner_instagram() {
        return id_owner_instagram;
    }

    public void setId_owner_instagram(String id_owner_instagram) {
        this.id_owner_instagram = id_owner_instagram;
    }

    public String getId_media_instagram() {
        return id_media_instagram;
    }

    public void setId_media_instagram(String id_media_instagram) {
        this.id_media_instagram = id_media_instagram;
    }

    public String getId_sender_instagram() {
        return id_sender_instagram;
    }

    public void setId_sender_instagram(String id_sender_instagram) {
        this.id_sender_instagram = id_sender_instagram;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
