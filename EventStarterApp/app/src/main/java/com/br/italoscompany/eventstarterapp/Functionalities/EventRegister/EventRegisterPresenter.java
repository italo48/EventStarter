package com.br.italoscompany.eventstarterapp.Functionalities.EventRegister;

import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.br.italoscompany.eventstarterapp.Model.entities.Event;
import com.br.italoscompany.eventstarterapp.Model.entities.MyLatLong;
import com.br.italoscompany.eventstarterapp.Model.entities.Outlets;

import java.util.List;

import static com.br.italoscompany.eventstarterapp.Model.data.AppDBMemory.dbEvent;

public class EventRegisterPresenter implements IEventRegister.IPresenter {
    //private String nextIdEvent;
    private Event nextEvent;
    private IEventRegister.IView iViewEventRegister;
    private IModel.IEventModel iEventModel;

    public EventRegisterPresenter(IEventRegister.IView iView) {
        this.iViewEventRegister = iView;
        this.iEventModel = dbEvent;
        //this.nextIdEvent = iEventModel.getAllEvents().size();
    }

    @Override
    public void saveEvent(String name, String date, MyLatLong loc, List<Outlets> outletsList) {
        if (name.isEmpty() || date.isEmpty() || loc == null || outletsList == null) {
            iViewEventRegister.showToast("Evento tem campos não preechidos");
        } else {
            //nextIdEvent++;
            Event e = new Event();
            //e.setId(nextIdEvent);
            e.setPontosDevendas(outletsList);
            e.setNomeDoEvento(name);
            e.setData(date);
            e.setLocation(loc);

            iEventModel.addEvent(e);

            //dps de cadastrado, buscar o evento ja com o id
            //exemplo
            nextEvent = e;
        }
    }

    @Override
    public void addIdGoOutletsActivit() {
        //so pra nao ficar sem nada
        iViewEventRegister.goOutletsActivity(nextEvent.getId());
    }
}
