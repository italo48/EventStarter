package com.br.italoscompany.eventstarterapp.Model.network;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AppDBFirebaseRealtime {
    private static final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static final DatabaseReference ref = database.getReference();

    public static DatabaseReference getRef(){
        return ref;
    }
}
