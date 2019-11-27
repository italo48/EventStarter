package com.br.italoscompany.eventstarterapp.Functionalities.UserPerfil;

import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.google.firebase.auth.FirebaseAuth;

import static com.br.italoscompany.eventstarterapp.Model.data.AppDBMemory.dbUser;

public class UserPerfilPresenter implements IUserPerfil.IPresenter {
    private FirebaseAuth mAuth;
    private IUserPerfil.IView userIView;
    private IModel.IUserModel userModel;


    public UserPerfilPresenter(IUserPerfil.IView v) {
        this.userIView = v;
        this.userModel = dbUser;
        this.mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onShowUser(String userId) {
        userIView.showUser(this.userModel.findUserById(userId));
    }

    @Override
    public void logout() {
        mAuth.signOut();
    }
}
