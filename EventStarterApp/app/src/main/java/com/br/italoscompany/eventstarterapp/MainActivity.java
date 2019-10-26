package com.br.italoscompany.eventstarterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SplashScreen(View view){
        Intent intent = new Intent(this, SplashScreenActivity.class);
        startActivity(intent);
    }

    public void Cadastro(View view){
        Intent intent = new Intent(this, UserRegisterActivity.class);
        startActivity(intent);
    }

    public void Home(View view){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void CadastroEvento(View view){
        Intent intent = new Intent(this, EventRegisterActivity.class);
        startActivity(intent);
    }
}
