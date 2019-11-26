package com.br.italoscompany.eventstarterapp.Functionalities.Login;

public interface ILogin {

    interface IPresenter {
        void onLogin(String login, String password);
        void verifyCurrentUser();
        void onDestroy();
    }

    interface IView {
        void onLoginResult(String msg);
        void goHome(int userId);
        void makeToast(String msg);
    }
}
