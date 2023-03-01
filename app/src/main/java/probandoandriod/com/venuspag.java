package probandoandriod.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class venuspag extends AppCompatActivity {
    ImageButton volveratras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venuspag);
        volveratras = (ImageButton)findViewById(R.id.btn_volvervenus);
        volveratras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Volver = new Intent(venuspag.this, menubotones_04.class);
                startActivity(Volver);
            }
        });

    }
}