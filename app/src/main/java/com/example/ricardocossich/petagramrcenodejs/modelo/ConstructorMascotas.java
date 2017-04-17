package com.example.ricardocossich.petagramrcenodejs.modelo;


import android.content.ContentValues;
import android.content.Context;
import android.widget.Toast;

import com.example.ricardocossich.petagramrcenodejs.R;
import com.example.ricardocossich.petagramrcenodejs.db.BaseDatos;
import com.example.ricardocossich.petagramrcenodejs.db.ConstantesBaseDatos;

import java.util.ArrayList;

/**
 * Created by rcossich on 23/03/2017.
 */

public class ConstructorMascotas {
    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos() {
        BaseDatos db = new BaseDatos(context);
        int mascotas_actuales = db.contarMascotas();
        if ( mascotas_actuales> 15) {
            Toast.makeText(context,"Borrando tablas",Toast.LENGTH_SHORT).show();
            db.borrarTablas();
            Toast.makeText(context,"Insertando 15 mascotas",Toast.LENGTH_SHORT).show();
            insertarQuinceMascotas(db);
        } else if (mascotas_actuales==0) {
            Toast.makeText(context,"Insertando por primera vez 15 mascotas",Toast.LENGTH_SHORT).show();
            insertarQuinceMascotas(db);
        }
        Toast.makeText(context,"Obteniendo las mascotas ",Toast.LENGTH_SHORT).show();
        return  db.obtenerTodosLasMascotas();
    }



    public void insertarQuinceMascotas(BaseDatos db){

        //MASCOTA 1.
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mascota 01");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog_pet_01);
        db.insertarMascota(contentValues);

        //MASCOTA 2.
        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mascota 02");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog_pet_02);
        db.insertarMascota(contentValues);

        //MASCOTA 3.
        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mascota 03");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog_pet_03);
        db.insertarMascota(contentValues);

        //MASCOTA 4.
        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mascota 04");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog_pet_04);
        db.insertarMascota(contentValues);

        //MASCOTA 5.
        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mascota 05");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog_pet_05);
        db.insertarMascota(contentValues);

        //MASCOTA 6.
        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mascota 06");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog_pet_06);
        db.insertarMascota(contentValues);

        //MASCOTA 7.
        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mascota 07");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog_pet_07);
        db.insertarMascota(contentValues);

        //MASCOTA 8.
        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mascota 08");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog_pet_08);
        db.insertarMascota(contentValues);

        //MASCOTA 9.
        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mascota 09");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog_pet_09);
        db.insertarMascota(contentValues);

        //MASCOTA 10.
        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mascota 10");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog_pet_10);
        db.insertarMascota(contentValues);

        //MASCOTA 11.
        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mascota 11");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog_pet_11);
        db.insertarMascota(contentValues);

        //MASCOTA 12.
        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mascota 12");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog_pet_12);
        db.insertarMascota(contentValues);

        //MASCOTA 13.
        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mascota 13");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog_pet_13);
        db.insertarMascota(contentValues);

        //MASCOTA 14.
        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mascota 14");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog_pet_14);
        db.insertarMascota(contentValues);

        //MASCOTA 15.
        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mascota 15");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog_pet_15);
        db.insertarMascota(contentValues);

    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }


}
