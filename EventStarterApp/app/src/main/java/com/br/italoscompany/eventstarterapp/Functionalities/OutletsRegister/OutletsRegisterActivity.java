package com.br.italoscompany.eventstarterapp.Functionalities.OutletsRegister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.br.italoscompany.eventstarterapp.Adapters.OutletsAdapter;
import com.br.italoscompany.eventstarterapp.Functionalities.UserDashboard.UserDashboardActivity;
import com.br.italoscompany.eventstarterapp.Model.entities.MyLatLong;
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
import java.util.List;

public class OutletsRegisterActivity extends AppCompatActivity implements IOutlets.IView {

    private String idEvent;
    private String idUser;

    private IOutlets.IPresenter mrPresenter;
    private OutletsAdapter outletsAdapter;

    private EditText editTextNameestablishment;
    private EditText editTextNumTickets;
    private RecyclerView recyclerViewOutlets;
    private LinearLayoutManager linearLayoutManager;
    private Button btnSaveOutlet;
    private Button btnFinish;

    //autocomplete google
    private PlacesClient placesClient;
    private List<Place.Field> placesFilds = Arrays.asList(Place.Field.ID,
            Place.Field.NAME,
            Place.Field.ADDRESS,
            Place.Field.LAT_LNG);
    private AutocompleteSupportFragment places_fragment;
    private double latitudeOutlets;
    private double longitudeOutlets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outlets_register);

        //autocomplete google
        initPlaces();
        setupAutoCompleteFragment();

        //idEvent = getIntent().getExtras().getInt("idEvent");
        idEvent = getIntent().getExtras().getString("idEvent");
        idUser = getIntent().getExtras().getString("idUser");

        if (mrPresenter == null)
            mrPresenter = new OutletsPesenter(this);

        editTextNameestablishment = (EditText) findViewById(R.id.inputNomeDoEstabelecimento);
        editTextNumTickets = (EditText) findViewById(R.id.inputQtdDeIngressos);
        recyclerViewOutlets = (RecyclerView) findViewById(R.id.recyclerViewOutlets);
        btnSaveOutlet = (Button) findViewById(R.id.buttonSalvarPontoVenda);
        btnFinish = (Button) findViewById(R.id.btnFinish);

        recyclerViewOutlets.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewOutlets.setLayoutManager(linearLayoutManager);

        outletsAdapter = new OutletsAdapter(mrPresenter);

        btnSaveOutlet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Outlets o = new Outlets();
                String nameS = editTextNameestablishment.getText().toString();
                if (!nameS.isEmpty() && !editTextNumTickets.getText().toString().isEmpty()) {
                    int numTcks = Integer.parseInt(editTextNumTickets.getText().toString());
                    o.setNomeDoEstabelecimento(nameS);
                    o.setQtdIngressos(numTcks);

                    mrPresenter.saveOutlets(
                            idEvent,
                            editTextNameestablishment.getText().toString(),
                            Integer.parseInt(editTextNumTickets.getText().toString()),
                            new MyLatLong(latitudeOutlets, longitudeOutlets));

                    mrPresenter.getOutlets();

                    editTextNameestablishment.setText("");
                    editTextNumTickets.setText("");
                } else {
                    showToast("Preencha os campos");
                }
            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!mrPresenter.isOutletsEmpty()){
                    mrPresenter.outletsLinkEvent(idEvent);
                } else {
                    mrPresenter.setEmptyOutlets(idEvent);
                    showToast("Nenhum ponto de venda cadastrado");
                }
                goBack();
            }
        });
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showOutlets(List<Outlets> outletsList) {
        outletsAdapter.setOutlets(outletsList);
        recyclerViewOutlets.setAdapter(outletsAdapter);
    }

    public void goBack() {
        Intent i = new Intent(this, UserDashboardActivity.class);
        i.putExtra("userId", idUser);
        startActivity(i);
        finish();
    }

    private void initPlaces() {
        Places.initialize(this,"AIzaSyAwTGV4CTXz02nESBRPZ3KLsbtbCeXcTCc");
        placesClient = Places.createClient(this);
    }

    private void setupAutoCompleteFragment() {
        places_fragment = (AutocompleteSupportFragment) getSupportFragmentManager()
                .findFragmentById(R.id.inputEnderecoPontoDeVenda);
        places_fragment.setPlaceFields(placesFilds);
        places_fragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(@NonNull Place place) {
                latitudeOutlets = place.getLatLng().latitude;
                longitudeOutlets = place.getLatLng().longitude;

                Toast.makeText(OutletsRegisterActivity.this,""+place.getName(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(@NonNull Status status) {
                Toast.makeText(OutletsRegisterActivity.this,""+status.getStatusMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
