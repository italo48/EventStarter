package com.br.italoscompany.eventstarterapp.Functionalities.UserResgister;

public interface IUserRegister {
    interface IView {
        void showToast(String msg);

        void goLoginActivity();

        void goDashboard(String idUser);
    }

    interface IPresenter {
        void registerUser(String name, String email, String password, String picPath);
    }
}
