package com.br.italoscompany.eventstarterapp.Functionalities.UserResgister;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.br.italoscompany.eventstarterapp.Model.entities.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.br.italoscompany.eventstarterapp.Model.data.AppDBMemory.dbUser;

public class UserRegisterPresenter implements IUserRegister.IPresenter {

    private FirebaseAuth mAuth;
    private IUserRegister.IView iViewUserRegister;
    private IModel.IUserModel userModel;

    public UserRegisterPresenter(IUserRegister.IView v) {
        this.iViewUserRegister = v;
        this.userModel = dbUser;
        this.mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void registerUser(final String name, final String email, String login, String password, final String picPath) {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener((Activity) iViewUserRegister, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            registerDataUser(name, email, picPath, user.getUid());
                            iViewUserRegister.goDashboard(user.getUid());
                            iViewUserRegister.showToast("Success on create account");
                        } else {
                            // If sign in fails, display a message to the user.
                            iViewUserRegister.showToast("Error on create account");
                        }
                    }
                });

//        if (name.isEmpty() || email.isEmpty() || login.isEmpty() || password.isEmpty() || picPath.isEmpty()) {
//            iViewUserRegister.showToast("Erro ao cadastrar, algum campo não foi preenchido");
//        } else {
//            //id = this.userModel.getAllUsers().size() + 1;
//            User user = new User();
//            //user.setId(id);
//            user.setName(name);
//            user.setEmail(email);
//            user.setLogin(login);
//            user.setPassword(password);
//            user.setPhotoDir(picPath);
//
//            //fica faltando setar o id do usuario
//
//            this.userModel.saveUser(user);
//            iViewUserRegister.showToast("Cadastro realizado");
//            iViewUserRegister.goLoginActivity();
//        }
    }

    private void registerDataUser(String name, String email, String picPath, String uuid) {
        User user = new User();
        user.setId(uuid);
        user.setName(name);
        user.setEmail(email);
        user.setPhotoDir(picPath);

        userModel.saveUser(user);
    }
}
