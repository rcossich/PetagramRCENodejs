package com.example.ricardocossich.petagramrcenodejs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class AcercaDe extends AppCompatActivity {

    TextView tvBiografia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        tvBiografia = (TextView) findViewById(R.id.tvBiografia);
        tvBiografia.setText("Ricardo Cossich: \n Ingeniero en Sistemas que actualmente se desempeña como \n" +
                "Gerente de Gestion de Calidad en uno de mos mayores \n"+
                "ingenios azucareros de Guatemala.\n"+
                "\n"+
                "Como parte de la mejora de los procesos de analisis de \n"+
                "informacion que se brinda al grupo gerencial de la empresa \n"+
                "se encuentra desarrollando la habilidad de presentar analisis \n"+
                "de informacion oportuna y sensible para la toma de decisiones \n"+
                "en plataformas moviles como Android y iOS. \n"+
                "\n"+
                "El poder contar con este curso de programacion de aplicaciones \n"+
                "para dispositivos moviles en Android le ha permitido acortar el \n"+
                "tiempo de respuesta para desarrollo de aplicaciones, mejorando\n"+
                "el impacto de la unidad de Gestion de Calidad como ayuda para\n"+
                "la toma de decisiones especialmente durante temporada de zafra.");

    }

    public void enterado(View v) {
        finish();
    }
}
