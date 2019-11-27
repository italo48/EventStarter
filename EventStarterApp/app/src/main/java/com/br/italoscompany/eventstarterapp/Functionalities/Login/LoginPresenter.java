package com.br.italoscompany.eventstarterapp.Functionalities.Login;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.br.italoscompany.eventstarterapp.Model.data.AppDBMemory.dbUser;

public class LoginPresenter implements ILogin.IPresenter {

    private ILogin.IView loginView;
    private IModel.IUserModel userModel;

    private FirebaseAuth mAuth;

    public LoginPresenter(ILogin.IView loginView) {
        this.loginView = loginView;
        this.userModel = dbUser;
        this.mAuth = FirebaseAuth.getInstance();
    }


    @Override
    public void onDestroy() {
        this.loginView = null;
    }

    @Override
    public void verifyCurrentUser() {
        /*FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null)
            loginView.goHome(currentUser.getUid());*/
        mAuth.signOut();
    }


    public void onLogin(String login, String password) {
        mAuth.signInWithEmailAndPassword(login, password)
                .addOnCompleteListener((Activity) this.loginView, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            loginView.goHome(user.getUid());
                            loginView.makeToast("Login success");
                        } else {
                            // If sign in fails, display a message to the user
                            loginView.makeToast("Login fail");
                        }
                    }
                });
    }
}