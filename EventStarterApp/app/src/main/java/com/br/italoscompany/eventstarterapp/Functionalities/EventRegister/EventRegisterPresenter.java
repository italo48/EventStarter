package com.br.italoscompany.eventstarterapp.Functionalities.EventRegister;

import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.br.italoscompany.eventstarterapp.Model.entities.Event;
import com.br.italoscompany.eventstarterapp.Model.entities.Outlets;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

import static com.br.italoscompany.eventstarterapp.Model.data.AppDBMemory.dbEvent;

public class EventRegisterPresenter implements IEventRegister.IPresenter {
    private IEventRegister.IView iViewEventRegister;
    private IModel.IEventModel iEventModel;

    public EventRegisterPresenter(IEventRegister.IView iView) {
        this.iViewEventRegister = iView;
        this.iEventModel = dbEvent;
    }

    private int takeId() {
        return iEventModel.getAllEvents().size() + 1;
    }

    @Override
    public void saveEvent(String name, String date, LatLng loc, List<Outlets> outletsList) {
        if (name.isEmpty() || date.isEmpty() || loc == null || outletsList == null) {
            iViewEventRegister.showToast("Evento tem campos não preechidos");
        } else {
            Event e = new Event();
            e.setId(takeId());
            e.setPontosDevendas(outletsList);
            e.setNomeDoEvento(name);
            e.setData(date);
            e.setLocation(loc);

            iEventModel.addEvent(e);
        }
    }

    @Override
    public void addIdGoOutletsActivit() {
        iViewEventRegister.goOutletsActivity(takeId());
    }
}
