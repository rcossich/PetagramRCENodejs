package com.example.ricardocossich.petagramrcenodejs.adaptador;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ricardocossich.petagramrcenodejs.R;
import com.example.ricardocossich.petagramrcenodejs.modelo.Mascota;

import java.util.ArrayList;

/**
 * Created by rcossich on 23/03/2017.
 */

public class MascotaAdaptador2 extends RecyclerView.Adapter<MascotaAdaptador2.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador2(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota2,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, final int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto2.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombre2.setText(mascota.getNombre());
        mascotaViewHolder.tvLikes2.setText(mascota.getLikes()+"");

       /* mascotaViewHolder.btLike2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Mascota amascota = mascotas.get(position);
                int likes_ahora = amascota.getLikes()+1;
                amascota.setLikes(likes_ahora);
                mascotaViewHolder.tvLikes2.setText(""+likes_ahora);
            }

        });*/

    }


    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto2;
        private TextView tvNombre2;
        private ImageButton btLike2;
        private TextView    tvLikes2;
        private ImageView   ivTlikes2;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto2  = (ImageView)   itemView.findViewById(R.id.imgFoto2);
            tvNombre2 = (TextView)    itemView.findViewById(R.id.tvNombre2);
            btLike2   = (ImageButton) itemView.findViewById(R.id.btLike2);
            tvLikes2  = (TextView)    itemView.findViewById(R.id.tvLikes2);
            ivTlikes2 = (ImageView)   itemView.findViewById(R.id.ivTlikes2);
        }
    }
}
