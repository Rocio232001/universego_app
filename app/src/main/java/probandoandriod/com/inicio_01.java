package probandoandriod.com;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class inicio_01 extends AppCompatActivity {

    ImageButton Registro;
    ImageButton Salir;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_01);
        Registro=(ImageButton)findViewById(R.id.btn_pagregistro);
        Registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(inicio_01.this, registro_universego_03.class);
                startActivity(a);
            }
        });
        Salir=(ImageButton)findViewById(R.id.btn_salirapp);



    }
    @SuppressLint("")
    public void salirapp (View view){
        finishAffinity();
    }

}