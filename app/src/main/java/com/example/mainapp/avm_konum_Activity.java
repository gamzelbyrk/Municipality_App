package com.example.mainapp;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mainapp.databinding.ActivityAvmKonumBinding;

import java.util.ArrayList;

public class avm_konum_Activity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityAvmKonumBinding binding;
    ArrayList<LatLng> arrayList=new ArrayList<LatLng>();
    LatLng ParkKaraman = new LatLng(37.18417747483122, 33.187057104528115);
    LatLng NasAvm = new LatLng(37.185357049032135, 33.21520389948329);
    LatLng VadiPark = new LatLng(37.167629728757255, 33.24785238580483);
    LatLng Armagan = new LatLng(37.180883111127216, 33.21898396957201);
    LatLng yhm = new LatLng(37.18768590683696, 33.221215883634706);
    LatLng Makro = new LatLng(37.19242673636182, 33.209434298468274);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAvmKonumBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        arrayList.add(ParkKaraman);
        arrayList.add(NasAvm);
        arrayList.add(VadiPark);
        arrayList.add(Armagan);
        arrayList.add(yhm);
        arrayList.add(Makro);
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