package com.br.italoscompany.eventstarterapp.Functionalities.UserResgister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.br.italoscompany.eventstarterapp.Functionalities.Login.LoginActivity;
import com.br.italoscompany.eventstarterapp.R;

public class UserRegisterActivity extends AppCompatActivity implements IUserRegister.IView{

    private IUserRegister.IPresenter mrPresenter;

    private ImageView imageViewProfilePicture;
    private EditText editTextNameUser, editTextPasswordUser, editTextEmailUser, editTextLoginUser;
    private Button btnSave, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        if (mrPresenter == null)
            mrPresenter = new UserRegisterPresenter(this);

        editTextNameUser = (EditText) findViewById(R.id.inputNome);
        editTextEmailUser = (EditText) findViewById(R.id.inputEmail);
        editTextLoginUser = (EditText) findViewById(R.id.inputLogin);
        editTextPasswordUser = (EditText) findViewById(R.id.inputSenha);

        btnSave = (Button) findViewById(R.id.buttonSalvar);
        btnCancel = (Button) findViewById(R.id.buttonCancelar);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mrPresenter.registerUser(
                        editTextNameUser.getText().toString(),
                        editTextEmailUser.getText().toString(),
                        editTextLoginUser.getText().toString(),
                        editTextPasswordUser.getText().toString()
                );
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLoginActivity();
            }
        });
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void goLoginActivity() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}
