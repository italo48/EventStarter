package com.br.italoscompany.eventstarterapp.Functionalities.UserDashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import com.br.italoscompany.eventstarterapp.Adapters.EventListAdapter;
import com.br.italoscompany.eventstarterapp.Functionalities.EventResgister.EventRegisterActivity;
import com.br.italoscompany.eventstarterapp.Functionalities.Maps.MapsActivity;
import com.br.italoscompany.eventstarterapp.Functionalities.UserPerfil.UserPerfilActivity;
import com.br.italoscompany.eventstarterapp.Model.entities.Event;
import com.br.italoscompany.eventstarterapp.Model.entities.Location;
import com.br.italoscompany.eventstarterapp.R;

import java.util.List;

public class UserDashboardActivity extends AppCompatActivity implements IUserDashboard.IView  {

    private long userId;

    private IUserDashboard.IPresenter mrPresenter;

    private RecyclerView rv;
    private LinearLayoutManager llm;
    private EventListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdashboard);
        userId = getIntent().getExtras().getLong("userId");

        if (mrPresenter == null)
            mrPresenter = new UserDashboardPresenter(this);

        rv = (RecyclerView)findViewById(R.id.rv_event_list);
        rv.setHasFixedSize(true);

        llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        adapter = new EventListAdapter(mrPresenter);
//        isso ta certo?
        mrPresenter.showEvents();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_userdashboard, menu);

        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.perfil:
                goUserPerfilActivity(userId);
                return true;

            case R.id.add_event:
                goAddEventActivity();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        // User pressed the search button
        mrPresenter.searchEvent(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        // User changed the text
        mrPresenter.searchEvent(newText);
        return false;
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showListEventAdapter(List<Event> events) {
        adapter.setEventList(events);
        rv.setAdapter(adapter);
    }

    @Override
    public void goUserPerfilActivity(long userId) {
        Intent i = new Intent(this, UserPerfilActivity.class);
        i.putExtra("userId", userId);
        startActivity(i);
    }

    @Override
    public void goAddEventActivity() {
        Intent i = new Intent(this, EventRegisterActivity.class);
        startActivity(i);
    }

    @Override
    public void goMapsActivity(Location loc) {
        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("location", loc);
        startActivity(i);
    }

    @Override
    protected void onDestroy() {
        mrPresenter.onDestroy();
        super.onDestroy();
    }
}
