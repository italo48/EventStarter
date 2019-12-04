package com.br.italoscompany.eventstarterapp.Functionalities.Maps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.br.italoscompany.eventstarterapp.Functionalities.UserDashboard.UserDashboardActivity;
import com.br.italoscompany.eventstarterapp.Model.entities.Event;
import com.br.italoscompany.eventstarterapp.Model.network.AppDBFirebaseRealtime;
import com.br.italoscompany.eventstarterapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class EventUpdateActivity extends AppCompatActivity {
    private EditText editTextEvName, editTextEvDate;
    private String idEvnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_update);
        idEvnt = getIntent().getExtras().getString("idEvent");

        editTextEvName = findViewById(R.id.edt_name_event);
        editTextEvDate = findViewById(R.id.edt_date_event);

        setEventData();
    }

    public void setEventData() {
        AppDBFirebaseRealtime.getRef().child("Events").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot event : dataSnapshot.getChildren()) {
                    if (event.getValue(Event.class).getId().equals(idEvnt)) {
                        editTextEvName.setText(event.getValue(Event.class).getNomeDoEvento());
                        editTextEvDate.setText(event.getValue(Event.class).getData());
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void editEvent(View v) {

        AppDBFirebaseRealtime.getRef()
                .child("Events")
                .child(idEvnt).child("nomeDoEvento").setValue(editTextEvName.getText().toString());
        AppDBFirebaseRealtime.getRef()
                .child("Events")
                .child(idEvnt).child("data").setValue(editTextEvDate.getText().toString());
        finish();
    }
}
