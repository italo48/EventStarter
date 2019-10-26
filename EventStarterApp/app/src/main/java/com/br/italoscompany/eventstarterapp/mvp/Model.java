package com.br.italoscompany.eventstarterapp.mvp;

import com.br.italoscompany.eventstarterapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class Model implements MVP.ModelImp {
    List<User> users  = new ArrayList<>();


    private MVP.PresenterImp presenter;

    public Model (MVP.PresenterImp p) {
        this.presenter = p;

        users.add( new User("user1", "1234"));
    }

    @Override
    public boolean login(User user) {
        if (user.getLogin().equals(users.get(0).getLogin()) &&
        user.getPassword().equals(users.get(0).getPassword()))
            return true;
        return false;
    }
}
