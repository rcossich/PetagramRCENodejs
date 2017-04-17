package com.example.ricardocossich.petagramrcenodejs.restApi.deserializer;

import android.util.Log;

import com.example.ricardocossich.petagramrcenodejs.modelo.InformacionUsuario;
import com.example.ricardocossich.petagramrcenodejs.restApi.JsonKeys;
import com.example.ricardocossich.petagramrcenodejs.restApi.model.InformacionUsuarioResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by rcossich on 02/04/2017.
 */

public class InformacionUsuarioDeserializador implements JsonDeserializer<InformacionUsuarioResponse> {
    @Override
    public InformacionUsuarioResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        InformacionUsuarioResponse informacionUsuarioResponse = gson.fromJson(json,InformacionUsuarioResponse.class);
        JsonArray informacionusuarioResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.USER_RESPONSE_ARRAY);

        informacionUsuarioResponse.setInformacionUsuarios(deserealizaInformacionUsuariodeJson(informacionusuarioResponseData));
        return informacionUsuarioResponse;
    }

    public ArrayList<InformacionUsuario> deserealizaInformacionUsuariodeJson(JsonArray informacionusuarioResponseData){
        ArrayList<InformacionUsuario> informacionUsuarios = new ArrayList<>();
        String id =null;
        String userName=null;
        String urlFoto=null;

        for (int i = 0; i < informacionusuarioResponseData.size() ; i++) {
            JsonObject informacionusuarioResponseDataObject = informacionusuarioResponseData.get(i).getAsJsonObject();
            Log.e("Recorriendo"+i+ "de"+informacionusuarioResponseData.size(),informacionusuarioResponseDataObject.toString());
            Log.e("Es Arreglo", String.valueOf(informacionusuarioResponseDataObject.isJsonArray()));
            Log.e("Es Objeto", String.valueOf(informacionusuarioResponseDataObject.isJsonObject()));
            Log.e("Es Primitiva", String.valueOf(informacionusuarioResponseDataObject.isJsonPrimitive()));
            Log.e("Es Nulo", String.valueOf(informacionusuarioResponseDataObject.isJsonNull()));
            Log.e("Que tipo es ",JsonKeys.USERNAME);
            if (informacionusuarioResponseDataObject.get(JsonKeys.USERNAME).isJsonObject()||informacionusuarioResponseDataObject.get(JsonKeys.USERNAME).isJsonArray())
            {
                JsonObject userJson     = informacionusuarioResponseDataObject.getAsJsonObject(JsonKeys.USERNAME);
                Log.e("Es objeto"+JsonKeys.USERNAME,""+userJson);

                id               = userJson.get(JsonKeys.USER_ID).getAsString();
                userName         = userJson.get(JsonKeys.USERNAME).getAsString();
                urlFoto          = userJson.get(JsonKeys.PROFILE_PICTURE_URL).getAsString();
            }
            if (informacionusuarioResponseDataObject.get(JsonKeys.USERNAME).isJsonPrimitive())
            {
                JsonPrimitive userJson = informacionusuarioResponseDataObject.getAsJsonPrimitive(JsonKeys.USERNAME);
                Log.e("Primitiva Json"+JsonKeys.USERNAME,""+userJson);

                id               = informacionusuarioResponseDataObject.getAsJsonPrimitive(JsonKeys.USER_ID).getAsString();
                userName         = informacionusuarioResponseDataObject.getAsJsonPrimitive(JsonKeys.USERNAME).getAsString();
                urlFoto          = informacionusuarioResponseDataObject.getAsJsonPrimitive(JsonKeys.PROFILE_PICTURE_URL).getAsString();
            }




            InformacionUsuario usuarioActual = new InformacionUsuario();
            usuarioActual.setId(id);
            usuarioActual.setUsername(userName);
            usuarioActual.setProfile_picture_url(urlFoto);

            informacionUsuarios.add(usuarioActual);

        }

        return informacionUsuarios;
    }
}
