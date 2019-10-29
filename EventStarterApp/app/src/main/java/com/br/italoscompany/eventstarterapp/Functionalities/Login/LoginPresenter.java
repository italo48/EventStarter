package com.br.italoscompany.eventstarterapp.Functionalities.Login;

import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.br.italoscompany.eventstarterapp.Model.entities.User;

import static com.br.italoscompany.eventstarterapp.Model.data.AppDBMemory.dbUser;

public class LoginPresenter implements ILogin.IPresenter {

    private ILogin.IView loginView;
    private IModel.IUserModel userModel;

    public LoginPresenter(ILogin.IView loginView) {
        this.loginView = loginView;
        this.userModel = dbUser;
    }

    @Override
    public void onDestroy() {
        this.loginView = null;
    }


    @Override
    public void onLogin(String login, String password) {
        boolean loginFalied = true;
        for (User u : this.userModel.getAllUsers()) {
            if (u.getLogin().equals(login) && u.getPassword().equals(password)) {
                loginFalied = false;
                loginView.onLoginResult("Login success");
                loginView.goHome(u.getId());
            }
        }
        if(loginFalied)
            loginView.onLoginResult("Login fail");
    }
}
