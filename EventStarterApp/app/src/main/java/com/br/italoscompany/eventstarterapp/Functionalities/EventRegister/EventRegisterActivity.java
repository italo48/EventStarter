package com.br.italoscompany.eventstarterapp.Functionalities.EventRegister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.br.italoscompany.eventstarterapp.Functionalities.OutletsRegister.OutletsRegisterActivity;
import com.br.italoscompany.eventstarterapp.Functionalities.UserDashboard.UserDashboardActivity;
import com.br.italoscompany.eventstarterapp.Model.entities.Outlets;
import com.br.italoscompany.eventstarterapp.R;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EventRegisterActivity extends AppCompatActivity implements IEventRegister.IView{

    private int userId;

    private IEventRegister.IPresenter mrPresenter;

    private EditText editTextNomeEvento;
    private EditText editTextDataEvento;
    private CheckBox checkBoxPontosdeVendas;
    private Button btnSaveEvent;
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

        userId = getIntent().getExtras().getInt("idUser");
       //autocomplete google
       initPlaces();
       setupAutoCompleteFragment();

        if (mrPresenter == null)
            mrPresenter = new EventRegisterPresenter(this);

        editTextNomeEvento = findViewById(R.id.inputNomeEvento);
        editTextDataEvento = findViewById(R.id.inputData);
        checkBoxPontosdeVendas = findViewById(R.id.checkBox);
        btnSaveEvent = findViewById(R.id.buttonSalvarEvent);

        btnSaveEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mrPresenter.saveEvent(
                        editTextNomeEvento.getText().toString(),
                        editTextDataEvento.getText().toString(),
                        new LatLng(latitudeEvento,longitudeEvento),
                        Collections.<Outlets>emptyList());

                if(checkBoxPontosdeVendas.isChecked()){
                    mrPresenter.addIdGoOutletsActivit();
                }else {
                    showToast("Evento cadastrado sem pontos de venda");
                    goUserDashboard();
                }
            }
        });
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

                Toast.makeText(EventRegisterActivity.this,""+place.getName(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(@NonNull Status status) {
                Toast.makeText(EventRegisterActivity.this,""+status.getStatusMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goOutletsActivity(int idEvent) {
        Intent intentOutlets = new Intent(this, OutletsRegisterActivity.class);
        intentOutlets.putExtra("idEvent", idEvent);
        intentOutlets.putExtra("idUser", userId);
        startActivity(intentOutlets);
        finish();
    }
    public void goUserDashboard() {
        Intent i = new Intent(this, UserDashboardActivity.class);
        i.putExtra("idUser", userId);
        startActivity(i);
        finish();
    }
}
