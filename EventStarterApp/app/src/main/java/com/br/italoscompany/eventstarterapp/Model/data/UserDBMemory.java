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
    public void saveUser(String name, String email, String picPath, String uuid) {
        AppDBFirebaseRealtime.getRef().child("Users").child(uuid).child("nome").setValue(name);
        AppDBFirebaseRealtime.getRef().child("Users").child(uuid).child("email").setValue(email);
        AppDBFirebaseRealtime.getRef().child("Users").child(uuid).child("picPath").setValue(picPath);
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
            if (u.getLogin().equals(login) && u.getPassword().equals(password))
                return true;
        }
        return false;
    }
}
