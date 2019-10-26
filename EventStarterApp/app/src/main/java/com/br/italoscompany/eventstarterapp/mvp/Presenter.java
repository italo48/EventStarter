package com.br.italoscompany.eventstarterapp.mvp;

import android.content.Context;

import com.br.italoscompany.eventstarterapp.model.User;

public class Presenter implements MVP.PresenterImp {

    private MVP.ModelImp modelImp;
    private MVP.ViewImp viewImp;

    public Presenter(){
        modelImp = new Model( this );
    }

    @Override
    public void onLogin(String login, String pass) {
        if(modelImp.login(new User(login,pass))) {
            showToast("Success");
        } else {
            showToast("Fail");
        }
    }

    @Override
    public void setView(MVP.ViewImp v) {
        this.viewImp = v;
    }

    @Override
    public Context getContext() {
        return (Context) viewImp;
    }

    @Override
    public void showToast(String msg) {
        viewImp.showToast(msg);
    }
}
