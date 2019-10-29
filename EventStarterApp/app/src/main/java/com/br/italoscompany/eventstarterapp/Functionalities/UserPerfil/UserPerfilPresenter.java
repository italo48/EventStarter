package com.br.italoscompany.eventstarterapp.Functionalities.UserPerfil;

import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.br.italoscompany.eventstarterapp.Model.data.UserDBMemory;

public class UserPerfilPresenter implements IUserPerfil.IPresenter {

    private IUserPerfil.IView userIView;
    private IModel.IUserModel userModel;


    public UserPerfilPresenter(IUserPerfil.IView v) {
        this.userIView = v;
        this.userModel = new UserDBMemory();
    }

    @Override
    public void onShowUser(long userId) {
        userIView.showUser(this.userModel.findUserById(userId));
    }
}
