package com.example.ricardocossich.petagramrcenodejs.adaptador;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ricardocossich.petagramrcenodejs.R;
import com.example.ricardocossich.petagramrcenodejs.modelo.Mascota;

import java.util.ArrayList;

/**
 * Created by rcossich on 23/03/2017.
 */

public class MascotaAdaptador3 extends RecyclerView.Adapter<MascotaAdaptador3.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;

    public MascotaAdaptador3(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota3,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, final int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto3.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvLikes3.setText(""+mascota.getLikes());
    }


    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto3;
        private TextView tvLikes3;
        private ImageView   ivTlikes3;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto3  = (ImageView)   itemView.findViewById(R.id.imgFoto3);
            tvLikes3  = (TextView)    itemView.findViewById(R.id.tvLikes3);
            ivTlikes3 = (ImageView)   itemView.findViewById(R.id.ivTlikes3);
        }
    }
}
