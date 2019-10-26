package com.br.italoscompany.eventstarterapp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.br.italoscompany.eventstarterapp.R;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    private LoginPresenter presenter;

    private EditText edt_login, edt_password;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if ( presenter == null)
            presenter = new LoginPresenter(this);

        btn_login = (Button) findViewById(R.id.buttonSalvar);
        edt_login = (EditText) findViewById(R.id.inputLogin);
        edt_password = (EditText) findViewById(R.id.inputSenha);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onLogin(edt_login.getText().toString(), edt_password.getText().toString());
            }
        });
    }

    @Override
    public void onLoginResult(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

   @Override
   public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
   }
}
