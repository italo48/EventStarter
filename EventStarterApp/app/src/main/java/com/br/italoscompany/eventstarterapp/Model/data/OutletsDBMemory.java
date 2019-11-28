package com.br.italoscompany.eventstarterapp.Model.data;

import androidx.annotation.NonNull;

import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.br.italoscompany.eventstarterapp.Model.entities.Outlets;
import com.br.italoscompany.eventstarterapp.Model.network.AppDBFirebaseRealtime;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class OutletsDBMemory implements IModel.IOutletsModel {
    private List<Outlets> outlets = new ArrayList<>();

    public OutletsDBMemory() {
    }

    @Override
    public void addOutlets(String idEvent, Outlets o) {
        AppDBFirebaseRealtime.getRef().child("Events").child(idEvent).child("Outlets").child(o.getId()).setValue(o);
        outlets.add(o);
    }

    @Override
    public void deleteOutlets(String idEvent, String idOutlets) {
        AppDBFirebaseRealtime.getRef().child("Events").child(idEvent).child("Outlets").child(idOutlets).removeValue();
        for (Outlets o : outlets) {
            if (o.getId().equals(idOutlets)) {
                outlets.remove(outlets.indexOf(o));
            }
        }
    }

    @Override
    public List<Outlets> getAllOutlets() {
        AppDBFirebaseRealtime.getRef().child("Events").child("Outlets ").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                outlets.clear();
                for (DataSnapshot dt : dataSnapshot.getChildren()) {
                    outlets.add(dt.getValue(Outlets.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return this.outlets;
    }
}
