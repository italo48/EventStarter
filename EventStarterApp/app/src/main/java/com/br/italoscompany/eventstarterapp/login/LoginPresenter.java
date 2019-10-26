package com.br.italoscompany.eventstarterapp.login;

import com.br.italoscompany.eventstarterapp.model.data.UserRepository;

public class LoginPresenter implements ILoginPresenter{

    private ILoginView loginView;
    private UserRepository userRepo;

    public LoginPresenter(ILoginView view) {
        this.userRepo = new UserRepository();
        this.loginView = view;
    }

    public void onDestroy() {
        this.loginView = null;
    }


    @Override
    public void onLogin(String login, String password) {
        if (userRepo.userExists(login, password))
            loginView.onLoginResult("Login success");
        else
            loginView.onLoginResult("Login fail");
    }
}
