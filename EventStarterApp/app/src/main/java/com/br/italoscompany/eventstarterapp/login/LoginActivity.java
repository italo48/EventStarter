package com.br.italoscompany.eventstarterapp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.br.italoscompany.eventstarterapp.MainActivity;
import com.br.italoscompany.eventstarterapp.R;

public class LoginActivity extends AppCompatActivity implements ILoginView {
    private ILoginPresenter mrPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if ( mrPresenter == null)
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
    }

    @Override
    public void onLoginResult(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void goHome() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    @Override
   protected void onDestroy() {
       mrPresenter.onDestroy();
       super.onDestroy();
   }
}
