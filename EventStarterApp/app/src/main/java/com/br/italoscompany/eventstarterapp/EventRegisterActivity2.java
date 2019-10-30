package com.br.italoscompany.eventstarterapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.br.italoscompany.eventstarterapp.Model.entities.Event;
import com.br.italoscompany.eventstarterapp.Model.entities.PointOfSala;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EventRegisterActivity2 extends AppCompatActivity {

    //pegando os campos
    private EditText editTextNomeEvento;
    private EditText editTextDataEvento;
    private CheckBox checkBoxPontosdeVendas;
    private double latitudeEvento;
    private double longitudeEvento;

    //autocomplete google
    private PlacesClient placesClient;
    private List<Place.Field> placesFilds = Arrays.asList(Place.Field.ID,
            Place.Field.NAME,
            Place.Field.ADDRESS,
            Place.Field.LAT_LNG);
    private AutocompleteSupportFragment places_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_register2);

        //pegando os campos do layout
        editTextNomeEvento = findViewById(R.id.inputNomeEvento);
        editTextDataEvento = findViewById(R.id.inputData);
        checkBoxPontosdeVendas = findViewById(R.id.checkBox);

        //autocomplete google
        initPlaces();
        setupAutoCompleteFragment();
    }

    public void salvarEvento (View view){
        String nameEvent = editTextNomeEvento.getText().toString();
        String dateEvent = editTextDataEvento.getText().toString();
        LatLng locationEvent = new LatLng(latitudeEvento,longitudeEvento);
        List<PointOfSala> outlets = new ArrayList<>();

        Event event = new Event();
        event.setId(1);
        event.setNomeDoEvento(nameEvent);
        event.setData(dateEvent);
        event.setLocation(locationEvent);
        event.setPontosDevendas(outlets);

        if(checkBoxPontosdeVendas.isChecked()){
            Intent intentOutlets = new Intent(this,OutletsRegisterActivity.class);
            intentOutlets.putExtra("id", event.getId());
            startActivity(intentOutlets);
        }else{
            Toast.makeText(this,"salvo no banco",Toast.LENGTH_SHORT).show();
        }
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
                latitudeEvento = place.getLatLng().latitude;
                longitudeEvento = place.getLatLng().longitude;

                Toast.makeText(EventRegisterActivity2.this,""+place.getName(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(@NonNull Status status) {
                Toast.makeText(EventRegisterActivity2.this,""+status.getStatusMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
