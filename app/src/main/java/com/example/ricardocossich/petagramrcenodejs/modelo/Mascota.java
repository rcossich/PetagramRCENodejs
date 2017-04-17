package com.example.ricardocossich.petagramrcenodejs.modelo;

/**
 * Created by rcossich on 23/03/2017.
 */

public class Mascota {
    private int id;
    private String nombre;
    private int foto;
    private int cantidad_likes;

    public Mascota(int foto, String nombre, int cantidad_likes) {
        this.foto = foto;
        this.nombre = nombre;
        this.cantidad_likes = cantidad_likes;
    }

    public Mascota() {

    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLikes() {
        return cantidad_likes;
    }

    public void setLikes(int cantidad_likes) {
        this.cantidad_likes = cantidad_likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }
}
