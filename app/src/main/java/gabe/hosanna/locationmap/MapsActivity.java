package gabe.hosanna.locationmap;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(9.065434, 7.486897);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Tommy's Location Bitches!"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        // Add a marker in Sydney and move the camera
        LatLng sydney2 = new LatLng(9.085434, 7.506897);
        mMap.addMarker(new MarkerOptions().position(sydney2).title("Tommy's 2nd Location Bitches!"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney2));

        LatLng place1 = new LatLng(9.070885, 7.483397);
        LatLng place2 = new LatLng(9.070620, 7.483147);
        LatLng place3 = new LatLng(9.070940, 7.483783);
        LatLng place4 = new LatLng(9.070678, 7.484156);
        LatLng place5 = new LatLng(9.070614, 7.483907);






        CameraUpdate zoom = CameraUpdateFactory.zoomTo(11);
        mMap.moveCamera(zoom);
        mMap.animateCamera(zoom);

        mMap.addPolyline(
                new PolylineOptions()
                        .add(sydney)
                        .add(sydney2)
//                        .add(place3)
//                        .add(sydney2)
                        .width(2f)
                        .color(Color.RED)


        );

        mMap.addMarker(new MarkerOptions().position(place2).title("place 2"));
        mMap.addMarker(new MarkerOptions().position(place3).title("place 3"));
        mMap.addMarker(new MarkerOptions().position(place4).title("place 4"));
        mMap.addMarker(new MarkerOptions().position(place5).title("place 5"));

        mMap.addPolyline(
                new PolylineOptions()
//                        .add(place1)

                        .add(place2)
                        .add(place3)
                        .add(place4)
                        .add(place5)
                        .add(place2)
                        .width(4f)
                        .color(Color.BLUE)


        );

        mMap.moveCamera(CameraUpdateFactory.newLatLng(place3));
        zoom = CameraUpdateFactory.zoomTo(20);
        mMap.moveCamera(zoom);
        mMap.animateCamera(zoom);
    }
}
