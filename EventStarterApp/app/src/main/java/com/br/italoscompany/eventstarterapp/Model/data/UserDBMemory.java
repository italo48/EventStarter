package com.br.italoscompany.eventstarterapp.Model.data;

import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.br.italoscompany.eventstarterapp.Model.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserDBMemory implements IModel.IUserModel {
    List<User> users;

    public UserDBMemory() {
        this.users = new ArrayList<>();
        this.users.add(new User("user1", "1234"));
    }

    @Override
    public void saveUser(User u) {
        this.users.add(u);
    }

    @Override
    public User findUserById(long id) {
        for (User u : this.users) {
            if (u.getId() == id)
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
