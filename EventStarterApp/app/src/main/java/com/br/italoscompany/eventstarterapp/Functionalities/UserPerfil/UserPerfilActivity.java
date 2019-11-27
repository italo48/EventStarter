package com.br.italoscompany.eventstarterapp.Functionalities.UserPerfil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.br.italoscompany.eventstarterapp.Functionalities.Login.LoginActivity;
import com.br.italoscompany.eventstarterapp.Model.entities.User;
import com.br.italoscompany.eventstarterapp.R;

public class UserPerfilActivity extends AppCompatActivity implements IUserPerfil.IView {

    private String userId;

    private IUserPerfil.IPresenter mrPresenter;

    private ImageView imageViewFtPerfil;
    private TextView textViewIdUser;
    private TextView textViewUseName;
    private TextView textViewUseEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_perfil);
        userId = getIntent().getExtras().getString("idUser");
        if (mrPresenter == null)
            mrPresenter = new UserPerfilPresenter(this);

        imageViewFtPerfil = (ImageView) findViewById(R.id.foto_perfil);
        textViewIdUser = (TextView) findViewById(R.id.idUser);
        textViewUseName = (TextView) findViewById(R.id.name_user);
        textViewUseEmail = (TextView) findViewById(R.id.email_user);

        mrPresenter.onShowUser(userId);
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUser(User user) {
        if (user.getPhotoDir().isEmpty() || user.getPhotoDir() == null)
            showToast("Foto não encontrada");
        else
            imageViewFtPerfil.setImageURI(Uri.parse(user.getPhotoDir()));
        textViewIdUser.setText("ID: " + user.getId());
        textViewUseName.setText("Nome: " + user.getName());
        textViewUseEmail.setText("Email: " + user.getEmail());
    }

    public void vLogout(View v) {
        mrPresenter.logout();
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}
