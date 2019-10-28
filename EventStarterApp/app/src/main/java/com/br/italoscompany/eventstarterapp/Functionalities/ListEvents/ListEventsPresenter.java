package com.br.italoscompany.eventstarterapp.Functionalities.ListEvents;

import android.content.Context;
import android.content.Intent;

import com.br.italoscompany.eventstarterapp.Functionalities.UserDashboard.UserDashboardActivity;
import com.br.italoscompany.eventstarterapp.MapsActivity;
import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.br.italoscompany.eventstarterapp.Model.data.EventDBMemory;
import com.br.italoscompany.eventstarterapp.Model.entities.Event;

import java.util.ArrayList;
import java.util.List;


public class ListEventsPresenter implements IListEvents.IPresenter {
    private IListEvents.IView mrsView;
    private IModel.IEventModel eventModel;

    public ListEventsPresenter(IListEvents.IView mrsView) {
        this.mrsView = mrsView;
        this.eventModel = new EventDBMemory();
    }

    @Override
    public void showEvents() {
        mrsView.showListEventAdapter(eventModel.getAllEvents());
    }

    @Override
    public void showDetails(int id) {

        Event event = eventModel.getAllEvents().get(id);

        if (event.getEndereco() == null || event.getData() == null)

            mrsView.showToast("Erro ao exibir detalhes. Endereço ou data do evento é inválido");
        else
            mrsView.showToast(event.getNomeDoEvento() + ": O evento ocorrerá no dia"
                    + event.getData().toString()
                    + " no local: Rua " + event.getEndereco().getRua()
                    + " no bairro " + event.getEndereco().getBairro()
                    + " numero " + event.getEndereco().getNumero());
    }

    @Override
    public void searchEvent(String nameEvent) {
        List<Event> finddedEvents = new ArrayList<>();
        for(Event e : this.eventModel.getAllEvents()) {
            if(e.getNomeDoEvento().toLowerCase().contains(nameEvent.toLowerCase())) {
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
