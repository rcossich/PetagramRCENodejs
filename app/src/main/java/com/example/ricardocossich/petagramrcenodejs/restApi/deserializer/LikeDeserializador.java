package com.example.ricardocossich.petagramrcenodejs.restApi.deserializer;

import android.util.Log;

import com.example.ricardocossich.petagramrcenodejs.restApi.ConstantesRestApi;
import com.example.ricardocossich.petagramrcenodejs.restApi.JsonKeys;
import com.example.ricardocossich.petagramrcenodejs.restApi.model.LikeResponse;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by rcossich on 20/04/2017.
 */

public class LikeDeserializador implements JsonDeserializer<LikeResponse> {
    @Override
    public LikeResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        int codigo;
        String tipo_error=null;
        String mensaje_error=null;
        LikeResponse likeResponse = gson.fromJson(json,LikeResponse.class);
        JsonObject likeResponseData = json.getAsJsonObject();
        JsonObject likecodigo       = likeResponseData.getAsJsonObject(JsonKeys.META);
        codigo = likecodigo.get(JsonKeys.CODIGO).getAsInt();
        if (codigo!=JsonKeys.CODIGO_OK) {
            tipo_error    = likecodigo.get(JsonKeys.TIPO_ERROR).getAsString();
            mensaje_error = likecodigo.get(JsonKeys.MENSAJE_ERROR).getAsString();
        }

        LikeResponse respuestaLike = new LikeResponse();
        respuestaLike.setCodigo(codigo);
        respuestaLike.setTipo_error(tipo_error);
        respuestaLike.setMensaje_error(mensaje_error);
        return respuestaLike;
    }
}
