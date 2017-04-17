package com.example.ricardocossich.petagramrcenodejs.adaptador;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ricardocossich.petagramrcenodejs.MascotaDetalle;
import com.example.ricardocossich.petagramrcenodejs.R;
import com.example.ricardocossich.petagramrcenodejs.modelo.MascotaInstagram;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by rcossich on 28/03/2017.
 */

public class MascotaAdaptador4 extends RecyclerView.Adapter<MascotaAdaptador4.MascotaViewHolder>{

    ArrayList<MascotaInstagram> mascotas;
    Activity activity;

    public MascotaAdaptador4(ArrayList<MascotaInstagram> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaAdaptador4.MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_mascota,parent,false);
        return new MascotaAdaptador4.MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaAdaptador4.MascotaViewHolder mascotaViewHolder, final int position) {
        final MascotaInstagram mascota = mascotas.get(position);

        //mascotaViewHolder.imgFotoGrid.setImageResource(mascota.getUrlFoto());
        Picasso.with(activity)
                .load(mascota.getUrlFoto())
                .placeholder(R.drawable.dog_pet_06)
                .into(mascotaViewHolder.imgFotoGrid);
        //mascotaViewHolder.tvNombreGrid.setText(mascota.getNombreCompleto());
        mascotaViewHolder.tvLikesGrid.setText(String.valueOf(mascota.getLikes()));

        mascotaViewHolder.imgFotoGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, MascotaDetalle.class);
                intent.putExtra("url", mascota.getUrlFoto());
                intent.putExtra("like", mascota.getLikes());
                //intent.putExtra("email", contacto.getEmail());
                activity.startActivity(intent);
            }
        });


    }


    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFotoGrid;
        //private TextView  tvNombreGrid;
        private TextView  tvLikesGrid;
        private ImageView ivTlikesGrid;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFotoGrid  = (ImageView)   itemView.findViewById(R.id.imgFotoGrid);
            //tvNombreGrid = (TextView)    itemView.findViewById(R.id.tvNombreGrid);
            tvLikesGrid  = (TextView)    itemView.findViewById(R.id.tvLikesGrid);
            ivTlikesGrid = (ImageView)   itemView.findViewById(R.id.ivTlikesGrid);
        }
    }
}