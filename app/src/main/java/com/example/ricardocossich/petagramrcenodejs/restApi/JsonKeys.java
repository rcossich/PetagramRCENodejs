package com.example.ricardocossich.petagramrcenodejs.restApi;

/**
 * Created by rcossich on 29/03/2017.
 */

public class JsonKeys {

    //para la parte de INSTAGRAM.
    public static final String MEDIA_RESPONSE_ARRAY         = "data";
    public static final String USER                         = "user";
    public static final String USER_ID                      = "id";
    public static final String MEDIA_ID                     = "id";
    public static final String USER_FULLNAME                = "full_name";
    public static final String MEDIA_IMAGES                 = "images";
    public static final String MEDIA_STANDARD_RESOLUTION    = "standard_resolution";
    public static final String MEDIA_URL                    = "url";
    public static final String MEDIA_LIKES                  = "likes";
    public static final String MEDIA_LIKES_COUNT            = "count";

    public static final String USER_RESPONSE_ARRAY          = "data";
    public static final String USERNAME                     = "username";
    public static final String PROFILE_PICTURE_URL          = "profile_picture";

    // para la parte de HEROKU.
    public static final String META                         = "meta";
    public static final String CODIGO                       = "code";
    public static final String TIPO_ERROR                   = "error_type";
    public static final String MENSAJE_ERROR                = "error_message";
    public static final int    CODIGO_OK                    = 200;

    //para la parte de Firebase.
    public static final String ID_DISPOSITIVO               = "id_dispositivo";
    public static final String ID_USUARIO_INSTAGRAM         = "id_usuario_instagram";
}
