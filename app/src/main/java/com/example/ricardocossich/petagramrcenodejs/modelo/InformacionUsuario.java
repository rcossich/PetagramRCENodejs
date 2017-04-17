package com.example.ricardocossich.petagramrcenodejs.modelo;

/**
 * Created by rcossich on 02/04/2017.
 */

public class InformacionUsuario {
    private String id;
    private String  username;
    private String  profile_picture_url;

    public InformacionUsuario(String id, String username, String profile_picture_url) {
        this.id = id;
        this.username = username;
        this.profile_picture_url = profile_picture_url;
    }

    public InformacionUsuario() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfile_picture_url() {
        return profile_picture_url;
    }

    public void setProfile_picture_url(String profile_picture_url) {
        this.profile_picture_url = profile_picture_url;
    }
}
