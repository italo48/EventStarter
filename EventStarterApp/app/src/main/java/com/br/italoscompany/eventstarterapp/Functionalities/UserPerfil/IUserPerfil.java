package com.br.italoscompany.eventstarterapp.Functionalities.UserPerfil;

import com.br.italoscompany.eventstarterapp.Model.entities.User;

public interface IUserPerfil {

    interface IView {
        void showUser(User user);
    }

    interface IPresenter {
        void onShowUser(long userId) ;
    }
}
