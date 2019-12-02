package com.br.italoscompany.eventstarterapp.Functionalities.UserDashboard;

import android.widget.SearchView;

import com.br.italoscompany.eventstarterapp.Model.entities.Event;
import com.br.italoscompany.eventstarterapp.Model.entities.Location;
import com.br.italoscompany.eventstarterapp.Model.entities.Outlets;

import java.util.List;

public interface IUserDashboard {

    interface IView extends SearchView.OnQueryTextListener {
        void showToast(String msg);
        void showListEventAdapter(List<Event> events);
        void goUserPerfilActivity(String userId);
        void goAddEventActivity();
        void goMapsActivity(Location loc);
        //testando
        void goMapsActivity2(Event event, List<Outlets> outlets, Location loc);
    }

    interface IPresenter {
        void showDetails(int id);
        void searchEvent(String nameEvent);
        void showEvents();
        void onDestroy();
    }
}
