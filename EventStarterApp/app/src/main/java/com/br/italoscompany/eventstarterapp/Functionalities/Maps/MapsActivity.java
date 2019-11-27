package com.br.italoscompany.eventstarterapp.Functionalities.Maps;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.br.italoscompany.eventstarterapp.Model.data.EventDBMemory;
import com.br.italoscompany.eventstarterapp.Model.entities.Event;
import com.br.italoscompany.eventstarterapp.Model.entities.Location;
import com.br.italoscompany.eventstarterapp.Model.entities.Outlets;
import com.br.italoscompany.eventstarterapp.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    //informacoes do evento
    private Location location;
    private TextView titleEventMap;
    private TextView dateEventMap;
    private TextView ticketsEventMap;

    //dados do mapa
    private GoogleMap mMap;
    private LatLng city;
    private MapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        location = getIntent().getExtras().getParcelable("location");
        city = new LatLng(location.getLatitude(), location.getLongitude());

        String nameEvent = getIntent().getExtras().getString("nameEvent");
        String dateEvent = getIntent().getExtras().getString("dateEvent");

        //pegando campos com informacoes do evento
        titleEventMap = findViewById(R.id.titleEventMap);
        dateEventMap = findViewById(R.id.dateEventMap);
        ticketsEventMap = findViewById(R.id.titleEventMap);

        //setando os campos
        titleEventMap.setText(nameEvent);
        dateEventMap.setText(dateEvent);
        //ticketsEventMap.setText(qtdTicket);

        //dados do mapa
        mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(MapsActivity.this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(city, 17.0f));
        mMap.addMarker(new MarkerOptions()
                .position(city)
                .title(titleEventMap.getText().toString())
                .snippet("String.valueOf(qtdTicketsEvent)")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
    }
}
