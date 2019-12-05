package com.br.italoscompany.eventstarterapp.Functionalities.UserDashboard;

import androidx.annotation.NonNull;

import com.br.italoscompany.eventstarterapp.Model.entities.Event;
import com.br.italoscompany.eventstarterapp.Model.entities.Location;
import com.br.italoscompany.eventstarterapp.Model.entities.Outlets;
import com.br.italoscompany.eventstarterapp.Model.network.AppDBFirebaseRealtime;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class UserDashboardPresenter implements IUserDashboard.IPresenter {
    private IUserDashboard.IView mrsView;
    private List<Event> events;

    public UserDashboardPresenter(IUserDashboard.IView mrsView) {
        this.mrsView = mrsView;
        this.events = new ArrayList<>();
    }

    @Override
    public void showEvents() {
        AppDBFirebaseRealtime.getRef().child("Events").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                events.clear();
                for (DataSnapshot event : dataSnapshot.getChildren()) {
                    if (event.getValue(Event.class) != null) {
                        events.add(event.getValue(Event.class));
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        mrsView.showListEventAdapter(events);
    }

    @Override
    public void showDetails(final int id) {
        final Event event = events.get(id);
        DatabaseReference outletsRef = AppDBFirebaseRealtime.getRef().child("Events").child(event.getId()).child("Outlets");
//        if (outletsRef != null) {
        outletsRef.addValueEventListener(new ValueEventListener() {
            List<Outlets> outlets = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                outlets.clear();
                for (DataSnapshot outlet : dataSnapshot.getChildren()) {
                    outlets.add(outlet.getValue(Outlets.class));
                }
                mrsView.goMapsActivity2(event, outlets, new Location(event.getLocation().getLatidude(), event.getLocation().getLongitude()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
//        }
    }

    @Override
    public void searchEvent(String nameEvent) {
        List<Event> finddedEvents = new ArrayList<>();
        for (Event e : this.events) {
            if (e.getNomeDoEvento().toLowerCase().contains(nameEvent.toLowerCase())) {
                finddedEvents.add(e);
            }
        }
        if (finddedEvents.size() == 0) {
            mrsView.showListEventAdapter(this.events);
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
