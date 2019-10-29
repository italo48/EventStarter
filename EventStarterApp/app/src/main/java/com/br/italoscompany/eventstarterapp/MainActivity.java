package com.br.italoscompany.eventstarterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.br.italoscompany.eventstarterapp.Functionalities.EventResgister.EventRegisterActivity;
import com.br.italoscompany.eventstarterapp.Functionalities.Maps.MapsActivity;
import com.br.italoscompany.eventstarterapp.Functionalities.UserDashboard.UserDashboardActivity;
import com.br.italoscompany.eventstarterapp.Functionalities.Login.LoginActivity;
import com.br.italoscompany.eventstarterapp.Functionalities.SplashScreenActivity;
import com.br.italoscompany.eventstarterapp.Functionalities.UserPerfil.UserPerfilActivity;
import com.br.italoscompany.eventstarterapp.Functionalities.UserResgister.UserRegisterActivity;
import com.br.italoscompany.eventstarterapp.Model.entities.Location;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SplashScreen(View view) {
        Intent intent = new Intent(this, SplashScreenActivity.class);
        startActivity(intent);
    }

    public void CadastroUsuario(View view) {
        Intent intent = new Intent(this, UserRegisterActivity.class);
        startActivity(intent);
    }

    public void Login(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra("userId", 1L);
        startActivity(intent);
    }

    public void CadastroEvento(View view) {
        Intent intent = new Intent(this, EventRegisterActivity.class);
        startActivity(intent);
    }

    public void UsuarioDashboard(View view) {
        Intent intent = new Intent(this, UserDashboardActivity.class);
        intent.putExtra("userId", 1L);
        startActivity(intent);
    }

    public void UsuarioPerfil(View view) {
        Intent intent = new Intent(this, UserPerfilActivity.class);
        intent.putExtra("userId", 1L);
        startActivity(intent);
    }

    public void Maps(View v) {
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("location", new Location(-4.97813, -39.0188));
        startActivity(intent);
    }
}
