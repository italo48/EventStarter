package com.br.italoscompany.eventstarterapp.Functionalities.Login;

import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.br.italoscompany.eventstarterapp.Model.data.UserDBMemory;

public class LoginPresenter implements ILogin.IPresenter {

    private ILogin.IView loginView;
    private IModel.IUserModel userModel;

    public LoginPresenter(ILogin.IView loginView) {
        this.loginView = loginView;
        this.userModel = new UserDBMemory();
    }

    @Override
    public void onDestroy() {
        this.loginView = null;
    }


    @Override
    public void onLogin(String login, String password) {
        if (userModel.existsUserByLoginAndPassword(login, password)){
            loginView.onLoginResult("Login success");
            loginView.goHome();
        }
        else
            loginView.onLoginResult("Login fail");
    }
}
