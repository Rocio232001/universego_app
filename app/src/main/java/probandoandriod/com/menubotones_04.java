package probandoandriod.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class menubotones_04 extends AppCompatActivity {
    ImageButton Mercuriopag,Volveratras,VenusPag;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menubotones_04);
        Mercuriopag = (ImageButton)findViewById(R.id.btn_mercurio);
        Mercuriopag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mercurio = new Intent(menubotones_04.this, mercuriopag_05.class);
                startActivity(mercurio);
            }
        });
        Volveratras=(ImageButton)findViewById(R.id.btn_volveratrasmenu);
        Volveratras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent VolverMenu = new Intent(menubotones_04.this, inicio_01.class);
                startActivity(VolverMenu);
            }
        });
        VenusPag = (ImageButton)findViewById(R.id.btn_venus);
        VenusPag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Venus = new Intent(menubotones_04.this,venuspag.class);
                startActivity(Venus);
            }
        });

    }
}