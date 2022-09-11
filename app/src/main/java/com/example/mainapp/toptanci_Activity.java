package com.example.mainapp;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mainapp.databinding.ActivityToptanciBinding;

import java.util.ArrayList;

public class toptanci_Activity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityToptanciBinding binding;
    ArrayList<LatLng>arrayList=new ArrayList<LatLng>();
    LatLng HasEminUn = new LatLng(37.1875436105916, 33.218912264897476);
    LatLng HasyıldızToptan = new LatLng(37.18318992507806, 33.22401855773139);
    LatLng DogruGida = new LatLng(37.18471791997954, 33.2459077109089);
    LatLng Baylan = new LatLng(37.172792095389745, 33.242280365760884);
    LatLng Gross70 = new LatLng(37.17491828559702, 33.23219050854657);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityToptanciBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        arrayList.add(HasEminUn);
        arrayList.add(HasyıldızToptan);
        arrayList.add(DogruGida);
        arrayList.add(Baylan);
        arrayList.add(Gross70);
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