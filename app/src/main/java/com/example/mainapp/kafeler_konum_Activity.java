package com.example.mainapp;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mainapp.databinding.ActivityKafelerKonumBinding;

import java.util.ArrayList;

public class kafeler_konum_Activity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityKafelerKonumBinding binding;
    ArrayList<LatLng> arrayList=new ArrayList<LatLng>();
    LatLng OruçReis = new LatLng(37.17269600504533, 33.24855018963238);
    LatLng Mackbear = new LatLng(37.185384378333566, 33.2135664495987);
    LatLng Starbucks = new LatLng(37.18352233414257, 33.18816043992353);
    LatLng Heffalump = new LatLng(37.18543527361935, 33.21460115172582);
    LatLng Osmanlı = new LatLng(37.18473088043545, 33.21452458423304);
    LatLng Henry = new LatLng(37.186565373923415, 33.214029434022414);
    LatLng VosVos = new LatLng(37.18551874009636, 33.21347082323285);
    LatLng Vagon = new LatLng(37.18810420690069, 33.21521420924554);
    LatLng BlackFox = new LatLng(37.18972058583444, 33.21560442352023);
    LatLng ChefBurger = new LatLng(37.18524554013666, 33.2138757687587);
    LatLng Kahverengi = new LatLng(37.18558275966753, 33.21356318594468);
    LatLng Referans = new LatLng(37.18699000924044, 33.21340026709228);
    LatLng VessieVolke = new LatLng(37.18729600549768, 33.21409751171446);
    LatLng Cacaron = new LatLng(37.18394664714823, 33.214781539923564);
    LatLng Yemen = new LatLng(37.18581824926903, 33.21392132642889);
    LatLng HbWaffle = new LatLng(37.18582956963826, 33.21372608810176);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityKafelerKonumBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        arrayList.add(OruçReis);
        arrayList.add(Mackbear);
        arrayList.add(Heffalump);
        arrayList.add(Starbucks);
        arrayList.add(BlackFox);
        arrayList.add(Cacaron);
        arrayList.add(Referans);
        arrayList.add(HbWaffle);
        arrayList.add(Kahverengi);
        arrayList.add(Henry);
        arrayList.add(VosVos);
        arrayList.add(Osmanlı);
        arrayList.add(Vagon);
        arrayList.add(Yemen);
        arrayList.add(VessieVolke);
        arrayList.add(ChefBurger);

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