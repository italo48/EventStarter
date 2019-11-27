package com.br.italoscompany.eventstarterapp.Model.data;

import androidx.annotation.NonNull;

import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.br.italoscompany.eventstarterapp.Model.entities.User;
import com.br.italoscompany.eventstarterapp.Model.network.AppDBFirebaseRealtime;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UserDBMemory implements IModel.IUserModel {
    private List<User> users = new ArrayList<>();

    public UserDBMemory() {
        AppDBFirebaseRealtime.getRef().child("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                users.clear();
                for (DataSnapshot user : dataSnapshot.getChildren()) {
                    users.add(user.getValue(User.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void saveUser(User u) {
        AppDBFirebaseRealtime.getRef().child("Users").child(u.getId()).setValue(u);

    }

    @Override
    public User findUserById(String id) {
        for (User u : this.users) {
            if (u.getId().equals(id))
                return u;
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return this.users;
    }

    @Override
    public boolean existsUserByLoginAndPassword(String login, String password) {
        for (User u : this.users) {
            if (u.getEmail().equals(login))
                return true;
        }
        return false;
    }
}
