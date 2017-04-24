package com.example.ricardocossich.petagramrcenodejs.adaptador;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ricardocossich.petagramrcenodejs.R;
import com.example.ricardocossich.petagramrcenodejs.modelo.MascotaInstagram;
import com.example.ricardocossich.petagramrcenodejs.restApi.ConstantesRestApi;
import com.example.ricardocossich.petagramrcenodejs.restApi.IEndpointsApi;
import com.example.ricardocossich.petagramrcenodejs.restApi.JsonKeys;
import com.example.ricardocossich.petagramrcenodejs.restApi.adapter.RestApiAdapter;
import com.example.ricardocossich.petagramrcenodejs.restApi.model.LikeResponse;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                Toast.makeText(activity,"Has dado like a "+publicacion.getMedia_id()+" del usuario "+publicacion.getId(),Toast.LENGTH_SHORT).show();
                //aqui va el RESTFUL POST de like hacia instagram
                RestApiAdapter restApiAdapter = new RestApiAdapter();
                Gson gsonLikeMedia = restApiAdapter.construyeGsonDeserializadorDarLike();
                IEndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonLikeMedia);
                final Call<LikeResponse> likeResponseCall = endpointsApi.postLikeInstagram(publicacion.getMedia_id(), ConstantesRestApi.ACCESS_TOKEN);

                likeResponseCall.enqueue(new Callback<LikeResponse>() {
                    @Override
                    public void onResponse(Call<LikeResponse> call, Response<LikeResponse> response) {
                        LikeResponse informacionrespuestalike = response.body();
                        if (informacionrespuestalike.getCodigo()!= JsonKeys.CODIGO_OK) {
                            Log.e("ERROR_DE_LIKE","Codigo: "+informacionrespuestalike.getCodigo());
                            Log.e("TIPO_ERROR LIKE",informacionrespuestalike.getTipo_error());
                            Log.e("MENSAJE_ERROR_LIKE",informacionrespuestalike.getMensaje_error());
                        } else {
                            //aqui debo de insertar el like en la base de datos de firebase y programar la notificacion.
                            //por complejidades con Heroku que no se pudieron resolver, vamos a
                            // 1} Por medio de un GET a FireBase recuperaremos el id_dispositivo (solo uno), del dueño de la media que recibe el like.
                            // 2) Mandamos con un POST a Heroku a registrar el like enviando el id_dispositivo
                            // 3) Heroku se encarga de enviar la notificacion al dispositivo.

                            //Implementacion:
                            // 1) Por medio de un GET a FireBase recuperaremos el id_dispositivo (solo uno), del dueño de la media que recibe el like.
                            // OJO: Este GET se puede hacer asi ya que la base de datos no tieme restricciones de permisos actualmente.
                            // caso contrario se tendria que implementar el acceso desde aca, lo cual no es muy recomendable.
                            // esto se implementa porque no pude resolverlo en Heroku.

                        }
                    }

                    @Override
                    public void onFailure(Call<LikeResponse> call, Throwable t) {
                        Log.e("FALLO LA CONEXION2", t.toString());
                    }
                });

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
