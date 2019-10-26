package com.br.italoscompany.eventstarterapp.model.data;

import com.br.italoscompany.eventstarterapp.model.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users = new ArrayList<>();

    public  UserRepository() {
        this.users.add(new User("user1", "1234"));
    }

    public boolean userExists(String login, String password) {
        for (User u : users){
            if (u.getLogin().equals(login) && u.getPassword().equals(password))
                return true;

        }
        return false;
    }

    public List<User> getAllUsers() {
        return this.users;
    }
}
