package com.br.italoscompany.eventstarterapp.Functionalities.ListEvents;

import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.br.italoscompany.eventstarterapp.Model.data.EventDBMemory;
import com.br.italoscompany.eventstarterapp.Model.entities.Event;


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
        mrsView.showToast(event.getNomeDoEvento() + ": O evento ocorrerá no dia {Data} no local {Endereço}");
    }
}
