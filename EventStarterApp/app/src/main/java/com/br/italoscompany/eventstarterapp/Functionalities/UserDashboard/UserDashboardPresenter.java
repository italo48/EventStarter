package com.br.italoscompany.eventstarterapp.Functionalities.UserDashboard;

import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.br.italoscompany.eventstarterapp.Model.entities.Event;
import com.br.italoscompany.eventstarterapp.Model.entities.Location;

import java.util.ArrayList;
import java.util.List;

import static com.br.italoscompany.eventstarterapp.Model.data.AppDBMemory.dbEvent;


public class UserDashboardPresenter implements IUserDashboard.IPresenter {
    private IUserDashboard.IView mrsView;
    private IModel.IEventModel eventModel;
    private int qtdTickets = 0;

    public UserDashboardPresenter(IUserDashboard.IView mrsView) {
        this.mrsView = mrsView;
        this.eventModel = dbEvent;
    }

    @Override
    public void showEvents() {
        mrsView.showListEventAdapter(eventModel.getAllEvents());
    }

    @Override
    public void showDetails(int id) {

        //antes estava assim, nao entendi o motivo
        Event event = eventModel.getAllEvents().get(id);

        //pegando o evento que tem o id passado
        //Event event = eventModel.findEventById(id);
        //Log.e("erro", "evento null");

        //ta aqui, agora so precisamos saber de onde tirar essa latitude e longitude
        //mrsView.goMapsActivity(new Location(-4.97813, -39.0188));
        //mrsView.goMapsActivity(new Location(event.getLocation().getLatidude(), event.getLocation().getLongitude()));

        //novo metodo
        mrsView.goMapsActivity2(event, new Location(event.getLocation().getLatidude(), event.getLocation().getLongitude()));
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
