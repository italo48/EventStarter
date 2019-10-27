package com.br.italoscompany.eventstarterapp.model.data;

import com.br.italoscompany.eventstarterapp.model.IUserModel;
import com.br.italoscompany.eventstarterapp.model.entities.User;

import java.util.List;

public class UserDBMemory implements IUserModel {
    @Override
    public void saveUser(User u) {

    }

    @Override
    public User findUserById(long id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public boolean existsUserByLoginAndPassword(String login, String password) {
        return false;
    }
}
