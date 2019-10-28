package com.br.italoscompany.eventstarterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.br.italoscompany.eventstarterapp.Functionalities.EventResgister.EventRegisterActivity;
import com.br.italoscompany.eventstarterapp.Functionalities.ListEvents.ListEventsActivity;
import com.br.italoscompany.eventstarterapp.Functionalities.Login.LoginActivity;
import com.br.italoscompany.eventstarterapp.Functionalities.SplashScreenActivity;
import com.br.italoscompany.eventstarterapp.Functionalities.UserDashboard.UserDashboardActivity;
import com.br.italoscompany.eventstarterapp.Functionalities.UserPerfil.UserPerfilActivity;
import com.br.italoscompany.eventstarterapp.Functionalities.UserResgister.UserRegisterActivity;

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

    public void Cadastro(View view) {
        Intent intent = new Intent(this, UserRegisterActivity.class);
        startActivity(intent);
    }

    public void Login(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void CadastroEvento(View view) {
        Intent intent = new Intent(this, EventRegisterActivity.class);
        startActivity(intent);
    }

    public void ListaEventos(View view) {
        Intent intent = new Intent(this, ListEventsActivity.class);
        startActivity(intent);
    }

    public void UsuarioDashboard(View view) {
        Intent intent = new Intent(this, UserDashboardActivity.class);
        startActivity(intent);
    }

    public void UsuarioPerfil(View view) {
        Intent intent = new Intent(this, UserPerfilActivity.class);
        startActivity(intent);
    }
}
