package com.br.italoscompany.eventstarterapp.Functionalities.UserPerfil;

import com.br.italoscompany.eventstarterapp.Model.IModel;

import static com.br.italoscompany.eventstarterapp.Model.data.AppDBMemory.dbUser;

public class UserPerfilPresenter implements IUserPerfil.IPresenter {

    private IUserPerfil.IView userIView;
    private IModel.IUserModel userModel;


    public UserPerfilPresenter(IUserPerfil.IView v) {
        this.userIView = v;
        this.userModel = dbUser;
    }

    @Override
    public void onShowUser(String userId) {
        userIView.showUser(this.userModel.findUserById(userId));
    }
}
