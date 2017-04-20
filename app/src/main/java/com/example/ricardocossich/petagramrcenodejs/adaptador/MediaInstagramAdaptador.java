package com.example.ricardocossich.petagramrcenodejs.adaptador;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ricardocossich.petagramrcenodejs.R;
import com.example.ricardocossich.petagramrcenodejs.modelo.MascotaInstagram;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by rcossich on 03/04/2017.
 */

public class MediaInstagramAdaptador extends RecyclerView.Adapter<MediaInstagramAdaptador.MediaInstagramViewHolder> {

    ArrayList<MascotaInstagram> mediaInstagram;
    Activity activity;

    public MediaInstagramAdaptador(ArrayList<MascotaInstagram> mediaInstagram, Activity activity) {
        this.mediaInstagram = mediaInstagram;
        this.activity = activity;
    }


    @Override
    public MediaInstagramAdaptador.MediaInstagramViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota5,parent,false);
        return new MediaInstagramAdaptador.MediaInstagramViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MediaInstagramAdaptador.MediaInstagramViewHolder mediaInstagramViewHolder, final int position) {
        final MascotaInstagram publicacion = mediaInstagram.get(position);

        Picasso.with(activity)
                .load(publicacion.getUrlFoto())
                .placeholder(R.drawable.dog_pet_06)
                .into(mediaInstagramViewHolder.imgFoto5);
        mediaInstagramViewHolder.tvUserName.setText(publicacion.getNombreCompleto());
        mediaInstagramViewHolder.tvLikes5.setText(String.valueOf(publicacion.getLikes()));

        mediaInstagramViewHolder.btLike05.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,"Has dado like a "+publicacion.getMedia_id(),Toast.LENGTH_SHORT).show();

            }

        });

        }

    @Override
    public int getItemCount() {
        return mediaInstagram.size();
    }

    public static class MediaInstagramViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto5;
        private TextView  tvUserName;
        private TextView tvLikes5;
        private ImageView ivTlikes5;
        private ImageButton btLike05;

        public MediaInstagramViewHolder(View itemView) {
            super(itemView);
            imgFoto5   = (ImageView)   itemView.findViewById(R.id.imgFoto5);
            tvUserName = (TextView)    itemView.findViewById(R.id.tvUserName);
            tvLikes5   = (TextView)    itemView.findViewById(R.id.tvLikes5);
            ivTlikes5  = (ImageView)   itemView.findViewById(R.id.ivTlikes5);
            btLike05  = (ImageButton) itemView.findViewById(R.id.btLike05);
        }
    }
}
