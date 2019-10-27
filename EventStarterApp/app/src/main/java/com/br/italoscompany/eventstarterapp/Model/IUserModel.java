package com.br.italoscompany.eventstarterapp.Model;

import com.br.italoscompany.eventstarterapp.Model.entities.User;

import java.util.List;

public interface IUserModel {
    void saveUser(User u);
    User findUserById(long id);
    List<User> getAllUsers();
    boolean existsUserByLoginAndPassword(String login, String password);

}
