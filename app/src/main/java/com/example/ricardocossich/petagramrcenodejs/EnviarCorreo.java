package com.example.ricardocossich.petagramrcenodejs;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnviarCorreo extends AppCompatActivity {

    EditText etNombre;
    EditText etEmailr;
    EditText etEmaild;
    EditText etContenido;
    Button btEnvio;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_correo);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etNombre    = (EditText) findViewById(R.id.etNombre);
        etEmailr    = (EditText) findViewById(R.id.etEmailr);
        etEmaild    = (EditText) findViewById(R.id.etEmaild);
        etContenido = (EditText) findViewById(R.id.etContenido);
        btEnvio     = (Button)   findViewById(R.id.btEnvio);

        etNombre.setText(R.string.nombre_inicial);
        etEmailr.setText(R.string.remitente_original);
        etEmaild.setText(R.string.destinatario_original);
        etContenido.setText(R.string.contenido_original);

    }


    public void enviar(View v) {
        System.out.println("Entrando al metodo de enviar");
        String direccionRemitente = etEmailr.getText().toString();
        String direccionDestino   = etEmaild.getText().toString();
        String contenido          = etContenido.getText().toString();
        //llamando de forma asincronica a JavaMail.
        btEnvio.setText("Enviando Comentario...");
        final SendMail mail = new SendMail(direccionDestino,direccionDestino);

        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPreExecute()  {
                Log.d("Check", "onPreExecute()");
            }

            @Override
            protected Void doInBackground(Void... params)    {
                Log.d("Check", "doInBackground() -- Here is the download");
                mail.GMailSender();
                return null;
            }

            @Override
            protected void onPostExecute(Void res)    {
                Log.d("Check", "onPostExecute()");
            }
        }.execute();
        btEnvio.setText("Comentario Enviado.");
        btEnvio.setEnabled(false);

    }
}