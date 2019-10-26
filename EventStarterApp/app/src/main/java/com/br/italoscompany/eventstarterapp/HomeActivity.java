package com.br.italoscompany.eventstarterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.br.italoscompany.eventstarterapp.mvp.MVP;
import com.br.italoscompany.eventstarterapp.mvp.Presenter;

public class HomeActivity extends AppCompatActivity implements MVP.ViewImp {
    private EditText edt_login, edt_password;
    private Button btn_login;

    private static MVP.PresenterImp presenterImp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn_login = (Button) findViewById(R.id.buttonSalvar);
        edt_login = (EditText) findViewById(R.id.inputLogin);
        edt_password = (EditText) findViewById(R.id.inputSenha);

        if(presenterImp == null)
            presenterImp = new Presenter();
        presenterImp.setView(this);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenterImp.onLogin(edt_login.getText().toString(), edt_password.getText().toString());
            }
        });
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
