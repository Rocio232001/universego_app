package probandoandriod.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class mercuriopag_05 extends AppCompatActivity {
    ImageButton Volvermercurio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercuriopag_05);
        Volvermercurio= (ImageButton)findViewById(R.id.btn_volver);
        Volvermercurio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent VolverMercurio = new Intent(mercuriopag_05.this, menubotones_04.class);
                startActivity(VolverMercurio);

            }
        });
    }
}