package com.br.italoscompany.eventstarterapp.Functionalities.UserPerfil;

import com.br.italoscompany.eventstarterapp.Model.entities.Event;
import com.br.italoscompany.eventstarterapp.Model.entities.User;

import java.util.List;

public interface IUserPerfil {

    interface IView {
        void showToast(String msg);

        void showUser(User user);

        void setAdapter(List<Event> e);
    }

    interface IPresenter {
        void onShowUser(String userId);

        void logout();

        void showOptions(int i);

        void showMyEvents(String userId);
    }
}
