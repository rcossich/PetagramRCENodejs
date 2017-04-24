package com.example.ricardocossich.petagramrcenodejs.restApi;

/**
 * Created by rcossich on 29/03/2017.
 */

public final class ConstantesRestApi {

    // tokens de dos usuarios especificos.
    public static final String ACCESS_TOKEN = "4868559439.f49691f.e81df5983b2644358b07a19111976c0c"; //con todos los permisos para ricardo.cossich.
    public static final String ACCESS_TOKEN2 = "4940814501.898b30d.cbe4879f13324d5ea6344f44874fecc8"; //con todos los permisos para ricardoescobar1783.


    //https://api.instagram.com/v1/
    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;

    //https://api.instagram.com/v1/users/self/media/recent/?access_token=ACCESS-TOKEN
    public static final String KEY_ACCESS_TOKEN = "?access_token=";

    public static final String KEY_GET_RECENT_MEDIA_USERID = "users/{userid}/media/recent/";
    public static final String KEY_GET_RECENT_MEDIA_USER   = "users/self/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER   = KEY_GET_RECENT_MEDIA_USER   + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
    public static final String URL_GET_RECENT_MEDIA_USER2  = KEY_GET_RECENT_MEDIA_USERID + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    //https://api.instragram.com/v1/users/search?q=consulta&access_token=ACCESS-TOKEN
    public static final String KEY_USUARIOS[] = {"juan.adeveloper27","ricardoescobar1783","android.devel"};
    public static final String KEY_USER_SEARCH= "users/search?q=";
    public static final String KEY_ACCESS_TOKEN2 = "&access_token=";
    public static final String KEY_USUARIO_BUSCAR = "usuario";
    public static final String KEY_USUARIO_BUSCAR0 = "juan.adeveloper27"; //se crearan sendoas llaves para usuarios en KEY_USUARIOS.
    public static final String KEY_USUARIO_BUSCAR1 = "ricardoescobar1783";
    public static final String URL_GET_USERS_QUERY  = KEY_USER_SEARCH+KEY_USUARIO_BUSCAR+KEY_ACCESS_TOKEN2+ACCESS_TOKEN;
    public static final String URL_GET_USERS_QUERY0 = KEY_USER_SEARCH+KEY_USUARIO_BUSCAR0+KEY_ACCESS_TOKEN2+ACCESS_TOKEN;
    public static final String URL_GET_USERS_QUERY1 = KEY_USER_SEARCH+KEY_USUARIO_BUSCAR1+KEY_ACCESS_TOKEN2+ACCESS_TOKEN;

    //POST del like
    public static final String URL_POST_LIKE = "media/{media-id}/likes";



    //PARA LA PARTE DE HEROKU.
    public static final String ROOT_URL_HEROKU = "https://whispering-cliffs-37590.herokuapp.com/";
    public static final String KEY_POST_REGISTRA_USUARIO = "registrar-usuario/";

    //PARA LA PARTE de FIREBASE.
    public static final String ROOT_URL_FIREBASE = "https://petragramrcenodejs.firebaseio.com/";
    public static final String KEY_GET_REGISTRAR_USUARIO ="registrar-usuario.json";
}
