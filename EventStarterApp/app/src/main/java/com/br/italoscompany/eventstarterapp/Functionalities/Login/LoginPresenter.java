package com.br.italoscompany.eventstarterapp.Functionalities.Login;

import com.br.italoscompany.eventstarterapp.Model.IUserModel;
import com.br.italoscompany.eventstarterapp.Model.data.UserDBMemory;

public class LoginPresenter implements ILoginPresenter{

    private ILoginView loginView;
    private IUserModel userModel;

    public LoginPresenter(ILoginView loginView) {
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
