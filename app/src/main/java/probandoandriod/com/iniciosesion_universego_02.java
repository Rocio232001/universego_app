package probandoandriod.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class iniciosesion_universego_02 extends AppCompatActivity {
    ImageButton Volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciosesion_universego_02);
        Volver=(ImageButton)findViewById(R.id.btn_volveratrasinicio);
        Volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(iniciosesion_universego_02.this, inicio_01.class);
                startActivity(i);
            }
        });
    }
}