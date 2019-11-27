package com.br.italoscompany.eventstarterapp.Functionalities.Login;

public interface ILogin {

    interface IPresenter {
        void onLogin(String login, String password);
        void verifyCurrentUser();
        void onDestroy();
    }

    interface IView {
        void onLoginResult(String msg);
<<<<<<< HEAD
        void goHome(String userId);
=======
        void goHome(int userId);
        void makeToast(String msg);
>>>>>>> 621ec72e3d223f5ff583e27a39f1da150eeccd25
    }
}
