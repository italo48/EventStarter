package com.br.italoscompany.eventstarterapp.Model.data;

import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.br.italoscompany.eventstarterapp.Model.entities.User;
import com.br.italoscompany.eventstarterapp.Model.network.AppDBFirebaseRealtime;

import java.util.ArrayList;
import java.util.List;

public class UserDBMemory implements IModel.IUserModel {
    List<User> users;

    public UserDBMemory() {
        this.users = new ArrayList<>();
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
