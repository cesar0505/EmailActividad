package com.example.emailactividad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etDireccion, txtTema, txtContenido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDireccion = findViewById(R.id.etDireccion);
        txtTema = findViewById(R.id.txtTema);
        txtContenido = findViewById(R.id.txtContenido);

    }

    public void enviar(View v) {

        if (!etDireccion.getText().toString().isEmpty() && !txtTema.getText().toString().isEmpty() && !txtContenido.getText().toString().isEmpty()) {

            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{etDireccion.getText().toString()});
            intent.putExtra(Intent.EXTRA_SUBJECT, txtTema.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT, txtContenido.getText().toString());
            startActivity(Intent.createChooser(intent, "SELECCIONA UNA APLICACION"));

        } else {
            Toast.makeText(MainActivity.this, "Por favor ingrese los datos solicitados", Toast.LENGTH_SHORT).show();

        }

    }
}