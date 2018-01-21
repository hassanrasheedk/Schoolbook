package com.schoolbook;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap;
    int r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



        Button button= (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                r=2000;
                mMap.clear();
                onMapReady(mMap);
            }
        });

        Button button2= (Button) findViewById(R.id.button3);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                r=5000;
                mMap.clear();
                onMapReady(mMap);
            }
        });

        Button button3= (Button) findViewById(R.id.button4);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                r=10000;
                mMap.clear();
                onMapReady(mMap);
            }
        });

        Button buttonclear= (Button) findViewById(R.id.clearButton);
        buttonclear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                r=0;
                mMap.clear();
                onMapReady(mMap);
            }
        });

//        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
//            @Override
//            public void onInfoWindowClick(Marker marker) {
//                String s = marker.getTitle();
//                Intent intent = new Intent(getBaseContext(),SchoolDetail.class);
//                intent.putExtra("title", s);
//                startActivity(intent);
//            }
//        });
    }




    private Marker marker1;
    private Marker marker2;
    private Marker marker3;
    private Marker marker4;
    private Marker marker5;
    private Marker marker6;
    private Marker marker7;


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    String s="Hello world";




    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnInfoWindowClickListener(this);


        //add markers of schools
        marker1=mMap.addMarker(new MarkerOptions()
                .position(new LatLng(33.679566, 72.995959))
                .title("Froebels School F-11 Campus")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.school_building)));

        marker2=mMap.addMarker(new MarkerOptions()
                .position(new LatLng(33.679956, 72.998575))
                .title("Beaconhouse School F-11 Campus")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.school_building)));

        marker3=mMap.addMarker(new MarkerOptions()
                .position(new LatLng(33.648500, 72.999559))
                .title("NUST Creative Learning School")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.school_building)));

        marker4=mMap.addMarker(new MarkerOptions()
                .position(new LatLng(33.667728, 73.006221))
                .title("SLS School G-11 Branch")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.school_building)));

        marker5=mMap.addMarker(new MarkerOptions()
                .position(new LatLng(33.691292, 73.008926))
                .title("Pak Turk School")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.school_building)));

        marker6=mMap.addMarker(new MarkerOptions()
                .position(new LatLng(33.681814, 73.065765))
                .title("Beaconhouse Margalla Campus")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.school_building)));

        marker7=mMap.addMarker(new MarkerOptions()
                .position(new LatLng(33.679017, 73.061413))
                .title("LGS H-8 Branch")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.school_building)));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(33.711957, 73.055801))
                .title("Headstart School")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.school_building)));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(33.681703, 73.071085))
                .title("Convent School")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.school_building)));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(33.689210, 72.985564))
                .title("City School")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.school_building)));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(33.704080, 72.976598))
                .title("City School Campus")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.school_building)));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(33.687612, 73.031500))
                .title("Smart School")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.school_building)));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(33.700251, 73.007041))
                .title("Imperial School and College")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.school_building)));


        Circle circle = mMap.addCircle(new CircleOptions()
                        .center(new LatLng(33.642380, 72.990096))
                        .radius(r)
                        .strokeWidth(10)
                        .strokeColor(Color.GREEN)
                        .fillColor(Color.argb(128, 173,216,230))
                        .clickable(true));

        LatLng seecs = new LatLng(33.642380, 72.990096);
        mMap.addMarker(new MarkerOptions().position(seecs).title("Marker in Seecs"));
        float zoomLevel = 12.0f; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(seecs, zoomLevel));

    }


    @Override
    public void onInfoWindowClick(Marker marker) {
        String t = marker.getTitle();
        Intent intent = new Intent(getBaseContext(),SchoolDetail.class);
        intent.putExtra("title", t);
        startActivity(intent);
    }
}
