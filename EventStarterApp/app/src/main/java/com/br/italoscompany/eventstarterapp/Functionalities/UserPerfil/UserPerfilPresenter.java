package com.br.italoscompany.eventstarterapp.Functionalities.UserPerfil;

import android.content.Intent;

import androidx.annotation.NonNull;

import com.br.italoscompany.eventstarterapp.Functionalities.Maps.EventUpdateActivity;
import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.br.italoscompany.eventstarterapp.Model.entities.Event;
import com.br.italoscompany.eventstarterapp.Model.entities.User;
import com.br.italoscompany.eventstarterapp.Model.network.AppDBFirebaseRealtime;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.br.italoscompany.eventstarterapp.Model.data.AppDBMemory.dbEvent;
import static com.br.italoscompany.eventstarterapp.Model.data.AppDBMemory.dbUser;

public class UserPerfilPresenter implements IUserPerfil.IPresenter {
    private FirebaseAuth mAuth;
    private IUserPerfil.IView userIView;
    private IModel.IUserModel userModel;
    private List<Event> events;


    public UserPerfilPresenter(IUserPerfil.IView v) {
        this.userIView = v;
        this.userModel = dbUser;
        this.mAuth = FirebaseAuth.getInstance();
        this.events = new ArrayList<>();
    }

    @Override
    public void onShowUser(final String userId) {
        AppDBFirebaseRealtime.getRef().child("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot user : dataSnapshot.getChildren())
                    if (user.getKey().equals(userId)) {
                        userIView.showUser(user.getValue(User.class));
                    }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    @Override
    public void showMyEvents(final String userId) {
        AppDBFirebaseRealtime.getRef().child("Events").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                events.clear();
                for (DataSnapshot event : dataSnapshot.getChildren()) {
                    if (event.getValue(Event.class).getIdCreator().equals(userId))
                        events.add(event.getValue(Event.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        userIView.setAdapter(events);
    }

    @Override
    public void logout() {
        mAuth.signOut();
    }

    @Override
    public void showOptions(final int i) {
        String idE = events.get(i).getId();
        AppDBFirebaseRealtime.getRef().child("Events").child(idE).removeValue();
        events.remove(i);
    }

    @Override
    public void editEv(final int i) {
        userIView.editEvView(events.get(i).getId());
    }
}
