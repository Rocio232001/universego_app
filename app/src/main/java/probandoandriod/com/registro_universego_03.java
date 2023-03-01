package probandoandriod.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class registro_universego_03 extends AppCompatActivity {
    ImageButton Volver,registrar,iniciarsesion;
    EditText registrocorreo,passwordcorreo;
    TextView UpdateStateText;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_universego_03);
        mAuth = FirebaseAuth.getInstance();
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if(user == null){
                    Log.d("TAG","Registro exitoso: " +user.getUid());

                }else{
                    Log.d("TAG","Usted no está registrado");
                }

            }
        };
        registrocorreo = (EditText)findViewById(R.id.registrocorreo);
        passwordcorreo = (EditText)findViewById(R.id.passwordcorreo);
        Volver=(ImageButton)findViewById(R.id.btn_volveratrasregistro);
        registrar = (ImageButton)findViewById(R.id.btn_registrarse);
        iniciarsesion=(ImageButton)findViewById(R.id.iniciarsesion_);
        UpdateStateText = (TextView)findViewById(R.id.UpdateState);

        //BOTONES

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearusuario();
                //Prueba Intent


            }
        });
        iniciarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Entrada();


            }
        });
        Volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salida();

            }
        });

        UpdateState();

    }
    private void UpdateState(){
        FirebaseUser user = mAuth.getCurrentUser();
        if(user != null){
            UpdateStateText.setText("Sesión iniciada: " +user.getEmail());
        }else{
            UpdateStateText.setText("Sin sesión iniciada");
        }


    }
    private void crearusuario(){
        String email, password;
        if(!checkFormulario()){
            Toast.makeText(getApplicationContext(),"Error al crear usuario", Toast.LENGTH_SHORT).show();

        }else{
            email = registrocorreo.getText().toString();
            password = passwordcorreo.getText().toString();
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(registro_universego_03.this,"se creo el usuario",Toast.LENGTH_SHORT).show();
                        Intent registrosesion = new Intent(registro_universego_03.this, menubotones_04.class);
                        startActivity(registrosesion);


                    }else{
                        Toast.makeText(registro_universego_03.this,"Ha fallado la creación de usuario", Toast.LENGTH_SHORT).show();

                    }

                }
            });

        }
    }

    private void Entrada(){
        String email, password;
        if(!checkFormulario()){
            Toast.makeText(getApplicationContext(),"Datos incorrectos", Toast.LENGTH_SHORT).show();

        }else{
            email = registrocorreo.getText().toString();
            password = passwordcorreo.getText().toString();

            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(registro_universego_03.this,"Inicio de sesión", Toast.LENGTH_SHORT).show();

                        Intent iniciosesion = new Intent(registro_universego_03.this, menubotones_04.class);
                        startActivity(iniciosesion);


                    }else{
                        Toast.makeText(registro_universego_03.this,"Inicio de sesión fallida", Toast.LENGTH_SHORT).show();

                    }
                    UpdateState();
                }
            });

        }

    }
    private void salida(){
        mAuth.signOut();
        UpdateState();
    }

    private boolean checkFormulario(){
        String correo, contrasena;
        correo = registrocorreo.getText().toString();
        contrasena = passwordcorreo.getText().toString();
        if(correo.isEmpty()){
            Toast.makeText(registro_universego_03.this,"Escribir Correo", Toast.LENGTH_SHORT).show();
            return false;


        }
        if(contrasena.isEmpty()){
            Toast.makeText(registro_universego_03.this,"Escribir Contraseña", Toast.LENGTH_SHORT).show();
            return false;

        }
        return true;

    }
}