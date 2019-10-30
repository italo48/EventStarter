package com.br.italoscompany.eventstarterapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;

import java.util.Arrays;
import java.util.List;

public class EventRegisterActivity2 extends AppCompatActivity {

    //autocomplete google
    private PlacesClient placesClient;
    private List<Place.Field> placesFilds = Arrays.asList(Place.Field.ID,
            Place.Field.NAME,
            Place.Field.ADDRESS,
            Place.Field.LAT_LNG);
    private AutocompleteSupportFragment places_fragment;

    private double latitude;
    private double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_register2);

        //autocomplete google
        initPlaces();
        setupAutoCompleteFragment();
    }

    private void initPlaces() {
        Places.initialize(this,"AIzaSyAwTGV4CTXz02nESBRPZ3KLsbtbCeXcTCc");
        placesClient = Places.createClient(this);
    }

    private void setupAutoCompleteFragment() {
        places_fragment = (AutocompleteSupportFragment) getSupportFragmentManager()
                .findFragmentById(R.id.inputEnderecoEvento);
        places_fragment.setPlaceFields(placesFilds);
        places_fragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(@NonNull Place place) {
                //localTeste = place.getLatLng();
                //local = place.getLatLng();
                latitude = place.getLatLng().latitude;
                longitude = place.getLatLng().longitude;

                Toast.makeText(EventRegisterActivity2.this,""+place.getName(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(@NonNull Status status) {
                Toast.makeText(EventRegisterActivity2.this,""+status.getStatusMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
