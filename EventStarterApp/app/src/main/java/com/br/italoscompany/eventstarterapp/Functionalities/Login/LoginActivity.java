package com.br.italoscompany.eventstarterapp.Functionalities.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.br.italoscompany.eventstarterapp.Functionalities.UserDashboard.UserDashboardActivity;
import com.br.italoscompany.eventstarterapp.Functionalities.UserResgister.UserRegisterActivity;
import com.br.italoscompany.eventstarterapp.R;

public class LoginActivity extends AppCompatActivity implements ILogin.IView {
    private ILogin.IPresenter mrPresenter;

    private Button btnGoUserRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (mrPresenter == null)
            mrPresenter = new LoginPresenter(this);

        ((Button) findViewById(R.id.buttonSalvar))
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mrPresenter.onLogin(
                                ((EditText) findViewById(R.id.inputLogin)).getText().toString(),
                                ((EditText) findViewById(R.id.inputSenha)).getText().toString());
                    }
                });

//        ((Button) findViewById(R.id.buttonDev)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                goMain();
//            }
//        });

        btnGoUserRegister = (Button) findViewById(R.id.btnUserRegister);
        btnGoUserRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goUserRegisterForm();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        this.mrPresenter.verifyCurrentUser();
    }

    @Override
    public void onLoginResult(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void goHome(String userId) {
        Intent i = new Intent(this, UserDashboardActivity.class);
        i.putExtra("idUser", userId);
        startActivity(i);
        finish();
    }

    public void goUserRegisterForm() {
        Intent i = new Intent(this, UserRegisterActivity.class);
        startActivity(i);
        finish();
    }

    public void makeToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        mrPresenter.onDestroy();
        super.onDestroy();
    }
}
