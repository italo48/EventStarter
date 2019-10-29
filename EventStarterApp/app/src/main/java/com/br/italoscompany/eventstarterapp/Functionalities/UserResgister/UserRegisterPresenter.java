package com.br.italoscompany.eventstarterapp.Functionalities.UserResgister;

import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.br.italoscompany.eventstarterapp.Model.entities.User;

import static com.br.italoscompany.eventstarterapp.Model.data.AppDBMemory.dbUser;

public class UserRegisterPresenter implements IUserRegister.IPresenter {

    private static long id = 0;
    private IUserRegister.IView iViewUserRegister;
    private IModel.IUserModel userModel;

    public UserRegisterPresenter(IUserRegister.IView v) {
        this.iViewUserRegister = v;
        this.userModel = dbUser;
    }

    @Override
    public void registerUser(String name, String email, String login, String password) {
        if (name.isEmpty() || email.isEmpty() || login.isEmpty() || password.isEmpty()) {
            iViewUserRegister.showToast("Erro ao cadastrar, algum campo não foi preenchido");
        } else {
            id++;
            User user = new User();
            user.setId(id);
            user.setName(name);
            user.setEmail(email);
            user.setLogin(login);
            user.setPassword(password);
            this.userModel.saveUser(user);
            iViewUserRegister.showToast("Cadastro realizado");
            iViewUserRegister.goLoginActivity();
        }
    }
}
