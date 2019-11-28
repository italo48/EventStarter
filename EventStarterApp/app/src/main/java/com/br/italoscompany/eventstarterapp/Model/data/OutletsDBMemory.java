package com.br.italoscompany.eventstarterapp.Model.data;

import androidx.annotation.NonNull;

import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.br.italoscompany.eventstarterapp.Model.entities.Event;
import com.br.italoscompany.eventstarterapp.Model.entities.Outlets;
import com.br.italoscompany.eventstarterapp.Model.network.AppDBFirebaseRealtime;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class OutletsDBMemory implements IModel.IOutletsModel {
    private List<Outlets> outlets = new ArrayList<>();

    public OutletsDBMemory(){
        AppDBFirebaseRealtime.getRef().child("Events").child("List<Outlets>").addValueEventListener(new ValueEventListener() {
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
    }

    @Override
    public void addOutlets(String idEvent,Outlets o) {
        //this.outlets.add(o);
        AppDBFirebaseRealtime.getRef().child("Events").child(idEvent).child("List<Outlets>").child(o.getId()).setValue(o);
    }

    @Override
    public void deleteOutlets(String id) {
        //this.outlets.remove(id);
        for (Outlets o : outlets) {
            if (o.getId().equals(id)) {
                outlets.remove(id);
            }
        }
    }

    @Override
    public List<Outlets> getAllOutlets() {
        return this.outlets;
    }
}
