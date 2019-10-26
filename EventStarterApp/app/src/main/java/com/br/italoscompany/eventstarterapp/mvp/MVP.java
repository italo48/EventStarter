package com.br.italoscompany.eventstarterapp.mvp;

import android.content.Context;
import android.view.View;

import com.br.italoscompany.eventstarterapp.domain.User;

public interface MVP {

    interface ModelImp {
        boolean login(User user);
    }

    interface PresenterImp {
        void onLogin(String login, String pass);
        void setView(MVP.ViewImp v);
        Context getContext();
        void showToast(String msg);
    }

    interface ViewImp {
        void showToast(String msg);
    }
}