package com.example.ricardocossich.petagramrcenodejs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class UsuarioInstagramActivity extends AppCompatActivity {

    private EditText etUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_instagram);
        Log.i("onCreate cuenta"," finalizando");
    }

    public void guardarcuenta(View v) {
        Log.i("guardarcuenta"," Entrando");
        etUsuario = (EditText) findViewById(R.id.etUsuario);
        String usuarioinstagram = etUsuario.getText().toString();
        if (usuarioinstagram== null || usuarioinstagram.isEmpty()) {
            usuarioinstagram = "ricardo.cossich";
        }
            //llamar a activity_main pasando parametros
            Intent myIntent = new Intent(getBaseContext(), MainActivity.class); //en luagar de Intent intent = new Intent(this, MainActivity.class);
            myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            Log.i("De regreso a Main","pasanado "+usuarioinstagram);
            myIntent.putExtra("cuenta_instagram", usuarioinstagram);
            startActivity(myIntent);

    }
}
