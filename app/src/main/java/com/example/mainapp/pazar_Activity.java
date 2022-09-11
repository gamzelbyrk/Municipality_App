package com.example.mainapp;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mainapp.databinding.ActivityPazarBinding;

import java.util.ArrayList;

public class pazar_Activity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityPazarBinding binding;
    ArrayList<LatLng>arrayList=new ArrayList<LatLng>();
    LatLng CumartesiPazari = new LatLng(37.18567969618364, 33.22561491022285);
    LatLng HalkMeyveSebze = new LatLng(37.18059982402422, 33.21955184164313);
    LatLng PazarAlani = new LatLng(37.169110391818535, 33.22680453428796);
    LatLng KapaliPazar = new LatLng(37.15655892621231, 33.23169688422815);
    LatLng SosyetePazari = new LatLng(37.167095891666136, 33.248153306516066);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPazarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        arrayList.add(CumartesiPazari);
        arrayList.add(HalkMeyveSebze);
        arrayList.add(PazarAlani);
        arrayList.add(KapaliPazar);
        arrayList.add(SosyetePazari);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        for(int i=0; i<arrayList.size(); i++)
        {
            mMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title("Marker"));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(arrayList.get(i),13));


        }
    }
}