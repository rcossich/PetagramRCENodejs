package com.example.ricardocossich.petagramrcenodejs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class UsuarioTimeLine extends AppCompatActivity {


    private EditText etUsuario22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_time_line);
    }

    public void guardarcuenta2(View v) {
        Log.d("guardarcuentatimeline"," Entrando");
        etUsuario22 = (EditText) findViewById(R.id.etUsuario22);
        String usuarioinstagram = etUsuario22.getText().toString();
        if (usuarioinstagram== null || usuarioinstagram.isEmpty()) {
            usuarioinstagram = "ricardo.cossich";
        }
        MainActivity.cuentaInstagramInvitado = usuarioinstagram;
        //llamar a activity_timeline
        Intent myIntent = new Intent(getBaseContext(), TimeLineActivity.class);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Log.d("De regreso a TimeLine","pasando "+usuarioinstagram);
        //myIntent.putExtra("cuenta_instagram", usuarioinstagram);
        startActivity(myIntent);

    }
}





