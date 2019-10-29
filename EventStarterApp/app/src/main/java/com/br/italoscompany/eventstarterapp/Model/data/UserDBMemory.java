package com.br.italoscompany.eventstarterapp.Model.data;

import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.br.italoscompany.eventstarterapp.Model.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserDBMemory implements IModel.IUserModel {
    List<User> users;

    public UserDBMemory() {
        this.users = new ArrayList<>();

        User u1 = new User();
        u1.setId(1);
        u1.setEmail("luanderson@gmail.com");
        u1.setLogin("user1");
        u1.setName("Luanderson Lindo");
        u1.setPassword("1234");
        u1.setPhotoDir("");

        User u2 = new User();
        u2.setId(2);
        u2.setEmail("italo@gmail.com");
        u2.setLogin("user2");
        u2.setName("Ítalo O Costa");
        u2.setPassword("1234");
        u1.setPhotoDir("");

        this.users.add(u1);
        this.users.add(u2);
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
