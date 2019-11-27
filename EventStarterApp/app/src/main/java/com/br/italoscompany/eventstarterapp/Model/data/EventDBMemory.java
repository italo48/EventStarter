package com.br.italoscompany.eventstarterapp.Model.data;

import androidx.annotation.NonNull;

import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.br.italoscompany.eventstarterapp.Model.entities.Event;
import com.br.italoscompany.eventstarterapp.Model.entities.Outlets;
import com.br.italoscompany.eventstarterapp.Model.network.AppDBFirebaseRealtime;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EventDBMemory implements IModel.IEventModel {
    private List<Event> events = new ArrayList<>();
    private List<Outlets> outlets;
    private List<Outlets> outlets2;

    //mudança
    private String idEvent;

    public EventDBMemory() {
        AppDBFirebaseRealtime.getRef().child("Events").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                events.clear();
                for (DataSnapshot dt : dataSnapshot.getChildren()) {
                    events.add(dt.getValue(Event.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void addEvent(Event e) {
        if (e.getPontosDevendas() == null) {
            List<Outlets> standartOut = new ArrayList<>();
            standartOut.add(new Outlets());
            e.setPontosDevendas(standartOut);
        }
        //AppDBFirebaseRealtime.getRef().child("Events").push().setValue(e);

        //mudança
        idEvent = AppDBFirebaseRealtime.getRef().child("Events").getKey();
        AppDBFirebaseRealtime.getRef().child("Events").child(idEvent).setValue(e);
    }

    @Override
    public void deleteEvent(String id) {
        for (Event e : events) {
            if (e.getId().equals(id)) {
                events.remove(id);
            }
        }
    }

    @Override
    public Event findEventById(String id) {
        for (Event e : this.events)
            if (e.getId().equals(id))
                return e;
        return null;
    }

    @Override
    public List<Event> getAllEvents() {
        return this.events;
    }

    public int size() {
        return events.size();
    }
}
