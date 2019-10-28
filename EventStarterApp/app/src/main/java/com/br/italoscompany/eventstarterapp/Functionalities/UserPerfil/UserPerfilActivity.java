package com.br.italoscompany.eventstarterapp.Functionalities.UserPerfil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.br.italoscompany.eventstarterapp.R;

public class UserPerfilActivity extends AppCompatActivity implements IUserPerfil.IView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_perfil);
    }
}
