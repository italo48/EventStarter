package com.br.italoscompany.eventstarterapp.Functionalities.UserDashboard;

import androidx.annotation.NonNull;

import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.br.italoscompany.eventstarterapp.Model.entities.Event;
import com.br.italoscompany.eventstarterapp.Model.entities.Location;
import com.br.italoscompany.eventstarterapp.Model.entities.Outlets;
import com.br.italoscompany.eventstarterapp.Model.network.AppDBFirebaseRealtime;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.InternalHelpers;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.br.italoscompany.eventstarterapp.Model.data.AppDBMemory.dbEvent;
import static com.br.italoscompany.eventstarterapp.Model.data.AppDBMemory.dbOutlets;


public class UserDashboardPresenter implements IUserDashboard.IPresenter {
    private IUserDashboard.IView mrsView;
    private IModel.IEventModel eventModel;
    private IModel.IOutletsModel outletsModel;
    //private int qtdTickets = 0;

    public UserDashboardPresenter(IUserDashboard.IView mrsView) {
        this.mrsView = mrsView;
        this.eventModel = dbEvent;
        this.outletsModel = dbOutlets;
    }

    @Override
    public void showEvents() {
        mrsView.showListEventAdapter(eventModel.getAllEvents());
    }

    @Override
    public void showDetails(int id) {

        //antes estava assim, nao entendi o motivo
        Event event = eventModel.getAllEvents().get(id);

        List<Outlets> outlets = outletsModel.getAllOutlets(event.getId());

        //DatabaseReference referenceOutlets = AppDBFirebaseRealtime.getRef().child("Events").child(event.getId()).child("Outlets");

        //pegando o evento que tem o id passado
        //Event event = eventModel.findEventById(id);
        //Log.e("erro", "evento null");

        //ta aqui, agora so precisamos saber de onde tirar essa latitude e longitude
        //mrsView.goMapsActivity(new Location(-4.97813, -39.0188));
        //mrsView.goMapsActivity(new Location(event.getLocation().getLatidude(), event.getLocation().getLongitude()));

        //novo metodo
        mrsView.goMapsActivity2(event, outlets, new Location(event.getLocation().getLatidude(), event.getLocation().getLongitude()));
    }

    @Override
    public void searchEvent(String nameEvent) {
        List<Event> finddedEvents = new ArrayList<>();
        for (Event e : this.eventModel.getAllEvents()) {
            if (e.getNomeDoEvento().toLowerCase().contains(nameEvent.toLowerCase())) {
                finddedEvents.add(e);
            }
        }
        if (finddedEvents.size() == 0) {
            mrsView.showListEventAdapter(this.eventModel.getAllEvents());
            mrsView.showToast("Nenhum evento foi encontrado");
        } else {
            mrsView.showListEventAdapter(finddedEvents);
        }
    }

    @Override
    public void onDestroy() {
        this.mrsView = null;
    }
}
