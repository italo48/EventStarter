package com.br.italoscompany.eventstarterapp.Functionalities.EventRegister;

import androidx.annotation.NonNull;

import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.br.italoscompany.eventstarterapp.Model.entities.Event;
import com.br.italoscompany.eventstarterapp.Model.entities.MyLatLong;
import com.br.italoscompany.eventstarterapp.Model.entities.Outlets;
import com.br.italoscompany.eventstarterapp.Model.network.AppDBFirebaseRealtime;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import static com.br.italoscompany.eventstarterapp.Model.data.AppDBMemory.dbEvent;

public class EventRegisterPresenter implements IEventRegister.IPresenter {
    private String nextIdEvent;
    //private String nextEvent;
    private IEventRegister.IView iViewEventRegister;
    private IModel.IEventModel iEventModel;

    public EventRegisterPresenter(IEventRegister.IView iView) {
        this.iViewEventRegister = iView;
        this.iEventModel = dbEvent;
        //this.nextIdEvent = iEventModel.getAllEvents().size();
    }

    @Override
    public void saveEvent(String name, String date, MyLatLong loc, List<Outlets> outletsList, String idCreator) {
        if (name.isEmpty() || date.isEmpty() || loc == null || outletsList == null) {
            iViewEventRegister.showToast("Evento tem campos não preechidos");
        } else {
            //nextIdEvent++;
            Event e = new Event();
            e.setIdCreator(idCreator);
            e.setPontosDevendas(outletsList);
            e.setNomeDoEvento(name);
            e.setData(date);
            e.setLocation(loc);

            //anttigo metodo de add
            //iEventModel.addEvent(e);

            //mudança
            String idEvent = AppDBFirebaseRealtime.getRef().child("Events").push().getKey();
            e.setId(idEvent);
            AppDBFirebaseRealtime.getRef().child("Events").child(idEvent).setValue(e);

            //dps de cadastrado, buscar o evento ja com o id
            //exemplo
            nextIdEvent = idEvent;
        }
    }

    @Override
    public void addIdGoOutletsActivit() {
        //so pra nao ficar sem nada
        iViewEventRegister.goOutletsActivity(nextIdEvent);
    }

    @Override
    public void editEvent(final String eventName) {}

}
