package com.example.ricardocossich.petagramrcenodejs.db;

/**
 * Created by rcossich on 23/03/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ricardocossich.petagramrcenodejs.modelo.Mascota;

import java.util.ArrayList;
import java.util.Arrays;


public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" +
                ConstantesBaseDatos.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_FOTO + " INTEGER" +
                ")";
        String queryCrearTablaLikesMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA + "(" +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + " INTEGER, " +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" + ConstantesBaseDatos.TABLE_MASCOTAS_ID + ")" +
                ")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikesMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA);
        onCreate(db);
    }

    public void borrarTablas() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DELETE FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA);
    }

    public void borrarLikes() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA);
    }


    public ArrayList<Mascota> obtenerTodosLasMascotas() {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES +") as likes " +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaActual.setLikes(registrosLikes.getInt(0));
            }else {
                mascotaActual.setLikes(0);
            }

            mascotas.add(mascotaActual);

        }

        db.close();

        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS,null, contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_MASCOTA, null, contentValues);
        db.close();
    }


    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;

        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES +")" +
                " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + "="+mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }

    public int contarMascotas() {
        int cantidad_mascotas = 0;
        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_MASCOTAS_ID +")"+
                "FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);
        if (registros.moveToNext()) {
            cantidad_mascotas = registros.getInt(0);
        }
        db.close();
        return cantidad_mascotas;
    }

    public int totalLikes(){
        int likes = 0;

        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES +")" +
                " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();
        return likes;
    }

    public ArrayList<Mascota> obtenerCincoMascotasConLikesMasRecientes() {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        int conteoMascotas = 0; //contar mascotas diferentes que tienen likes recientes.

        Integer [] idMascotasRecientes = new Integer[5];

        String queryExterno = "SELECT * FROM "+ ConstantesBaseDatos.TABLE_LIKES_MASCOTA+
                " ORDER BY "+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID + " DESC";
        //Toast.makeText(context,"A ejecutar "+queryExterno,Toast.LENGTH_LONG).show();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(queryExterno, null);


        while (registros.moveToNext() && conteoMascotas<=4){
            int idMascotaActual = registros.getInt(1);
            if(!(Arrays.asList(idMascotasRecientes).contains(idMascotaActual)) || conteoMascotas==0) {
                idMascotasRecientes[conteoMascotas] = idMascotaActual; //añado el codigo de mascota a las 5 mas recientes
                conteoMascotas++;

                String queryIntermedio = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS+
                        " WHERE "+ ConstantesBaseDatos.TABLE_MASCOTAS_ID + "=" + idMascotaActual;
                //Toast.makeText(context,"A ejecutar intermedio "+queryIntermedio,Toast.LENGTH_LONG).show();

                Cursor registroMascota = db.rawQuery(queryIntermedio,null);
                while (registroMascota.moveToNext()) {  //ya que la mascota existe (por tener like asociado), es un unico registro
                    Mascota mascotaActual = new Mascota();
                    mascotaActual.setId(registroMascota.getInt(0));
                    mascotaActual.setNombre(registroMascota.getString(1));
                    mascotaActual.setFoto(registroMascota.getInt(2));

                    // ahora recuperamos el total de likes de esta mascota.
                    String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES +") as likes " +
                            " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                            " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + "=" + mascotaActual.getId();
                    //Toast.makeText(context,"A ejecutar Likes"+queryLikes,Toast.LENGTH_LONG).show();
                    Cursor registrosLikes = db.rawQuery(queryLikes, null);
                    if (registrosLikes.moveToNext()){
                        mascotaActual.setLikes(registrosLikes.getInt(0));
                    }else {
                        mascotaActual.setLikes(0);
                    }
                    mascotas.add(mascotaActual); //añado la mascota al arreglo ArrayList que se regresara al presentador.
                }
            }
        }
        db.close();
        return mascotas;
    }

}
