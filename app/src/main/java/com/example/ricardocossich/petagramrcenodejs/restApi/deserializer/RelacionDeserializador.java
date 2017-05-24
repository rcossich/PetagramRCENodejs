package com.example.ricardocossich.petagramrcenodejs.restApi.deserializer;

import com.example.ricardocossich.petagramrcenodejs.restApi.JsonKeys;
import com.example.ricardocossich.petagramrcenodejs.restApi.model.RelacionResponse;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by rcossich on 24/05/2017.
 */

public class RelacionDeserializador implements JsonDeserializer<RelacionResponse> {
    @Override
    public RelacionResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        int codigo;
        String outgoing_status=null;
        RelacionResponse relacionResponse = gson.fromJson(json,RelacionResponse.class);
        JsonObject relacionResponseData   = json.getAsJsonObject();
        JsonObject relacioncodigo         = relacionResponseData.getAsJsonObject(JsonKeys.META_INST);
        JsonObject relaciondatos          = relacionResponseData.getAsJsonObject(JsonKeys.DATOS);
        codigo = relacioncodigo.get(JsonKeys.CODIGO_INST).getAsInt();
        if (codigo==JsonKeys.CODIGO_INST_OK) {  //solamente si el codigo retornado es OK
            //JsonObject relacionestado     = relaciondatos.getAsJsonObject(JsonKeys.ESTADO);
            outgoing_status = relaciondatos.get(JsonKeys.ESTADO).getAsString();
        }

        RelacionResponse respuestaRelacion = new RelacionResponse();
        respuestaRelacion.setCodigo(codigo);
        respuestaRelacion.setOutgoing_status(outgoing_status);
        return respuestaRelacion;

    }
}
