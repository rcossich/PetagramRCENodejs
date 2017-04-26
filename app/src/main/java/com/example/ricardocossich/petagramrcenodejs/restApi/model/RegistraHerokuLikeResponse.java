package com.example.ricardocossich.petagramrcenodejs.restApi.model;

/**
 * Created by rcossich on 25/04/2017.
 */

public class RegistraHerokuLikeResponse {
    private String id;
    private String id_dispositivo;
    private String id_owner_instagram;
    private String id_media_instagram;
    private String id_sender_instagram;

    public RegistraHerokuLikeResponse() {
    }

    public RegistraHerokuLikeResponse(String id, String id_dispositivo, String id_owner_instagram, String id_media_instagram, String id_sender_instagram) {
        this.id = id;
        this.id_dispositivo = id_dispositivo;
        this.id_owner_instagram = id_owner_instagram;
        this.id_media_instagram = id_media_instagram;
        this.id_sender_instagram = id_sender_instagram;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_dispositivo() {
        return id_dispositivo;
    }

    public void setId_dispositivo(String id_dispositivo) {
        this.id_dispositivo = id_dispositivo;
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
}
