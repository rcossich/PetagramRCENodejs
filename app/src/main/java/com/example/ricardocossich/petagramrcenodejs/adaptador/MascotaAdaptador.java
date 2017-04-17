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
import com.example.ricardocossich.petagramrcenodejs.modelo.ConstructorMascotas;
import com.example.ricardocossich.petagramrcenodejs.modelo.Mascota;

import java.util.ArrayList;

/**
 * Created by rcossich on 23/03/2017.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        //View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, final int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        mascotaViewHolder.tvLikes.setText(String.valueOf(mascota.getLikes()));

        //mascotaViewHolder.imgFotoGrid.setImageResource(mascota.getFoto());
        //mascotaViewHolder.tvNombreGrid.setText(mascota.getNombre());
        //mascotaViewHolder.tvLikesGrid.setText(String.valueOf(mascota.getLikes()));

       mascotaViewHolder.btLike.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,"Has dado like a "+mascota.getNombre(),Toast.LENGTH_SHORT).show();
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);
                mascotaViewHolder.tvLikes.setText(constructorMascotas.obtenerLikesMascota(mascota)+"");
            }

        });

    }


    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombre;
        //private ImageView imgFotoGrid;
        //private TextView tvNombreGrid;
        private ImageButton btLike;
        private TextView    tvLikes;
        //private TextView    tvLikesGrid;
        //private ImageView   ivTlikesGrid;
        private ImageView   ivTlikes;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto  = (ImageView)   itemView.findViewById(R.id.imgFoto);
            tvNombre = (TextView)    itemView.findViewById(R.id.tvNombre);
            //imgFotoGrid  = (ImageView)   itemView.findViewById(R.id.imgFotoGrid);
            //tvNombreGrid = (TextView)    itemView.findViewById(R.id.tvNombreGrid);
            btLike   = (ImageButton) itemView.findViewById(R.id.btLike);
            tvLikes  = (TextView)    itemView.findViewById(R.id.tvLikes);
            ivTlikes = (ImageView)   itemView.findViewById(R.id.ivTlikes);
            //tvLikesGrid  = (TextView)    itemView.findViewById(R.id.tvLikesGrid);
            //ivTlikesGrid = (ImageView)   itemView.findViewById(R.id.ivTlikesGrid);
        }
    }
}
