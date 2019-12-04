package com.br.italoscompany.eventstarterapp.Functionalities.UserPerfil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.br.italoscompany.eventstarterapp.Adapters.EventListUserAdapter;
import com.br.italoscompany.eventstarterapp.Functionalities.Login.LoginActivity;
import com.br.italoscompany.eventstarterapp.Functionalities.Maps.EventUpdateActivity;
import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.br.italoscompany.eventstarterapp.Model.entities.Event;
import com.br.italoscompany.eventstarterapp.Model.entities.User;
import com.br.italoscompany.eventstarterapp.R;

import java.util.List;

import static com.br.italoscompany.eventstarterapp.Model.data.AppDBMemory.dbEvent;

public class UserPerfilActivity extends AppCompatActivity implements IUserPerfil.IView {

    private String userId;

    private IUserPerfil.IPresenter mrPresenter;
    private IModel.IEventModel eventModel;

    private ImageView imageViewFtPerfil;
    private TextView textViewUseName;
    private TextView textViewUseEmail;

    private RecyclerView rv;
    private LinearLayoutManager llm;
    private EventListUserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_perfil);
        userId = getIntent().getExtras().getString("idUser");
        if (mrPresenter == null)
            mrPresenter = new UserPerfilPresenter(this);
        this.eventModel = dbEvent;

        imageViewFtPerfil = (ImageView) findViewById(R.id.foto_perfil);
        textViewUseName = (TextView) findViewById(R.id.name_user);
        textViewUseEmail = (TextView) findViewById(R.id.email_user);

        rv = (RecyclerView) findViewById(R.id.my_events_rc);
        rv.setHasFixedSize(true);

        llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        adapter = new EventListUserAdapter(mrPresenter);
        mrPresenter.onShowUser(userId);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mrPresenter.showMyEvents(userId);
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
        textViewUseName.setText("Nome: " + user.getName());
        textViewUseEmail.setText("Email: " + user.getEmail());
    }

    public void vLogout(View v) {
        mrPresenter.logout();
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void setAdapter (List<Event> e) {
        adapter.setEventList(e);
        rv.setAdapter(adapter);
    }

    @Override
    public void editEvView(String idEv) {
        Intent i = new Intent(this, EventUpdateActivity.class);
        i.putExtra("idEvent", idEv);
        startActivity(i);
    }
}
