package tt.escom.ipn.avalosbarrera.transportec;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Debug;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by laavalos on 5/22/2018.
 */

public class OrigenActivity extends FragmentActivity implements OnMapReadyCallback {

    private  final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 100;
    private  final int PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION = 101;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_origen);
        try {
            MapFragment mapFragment = (MapFragment) getFragmentManager()
                    .findFragmentById(R.id.fragmentmap);
            mapFragment.getMapAsync(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onMapReady(GoogleMap map){
        LatLng ubicacionActual = new LatLng(19.504539 ,-99.146996);
        Log.d("", "esta es la longitud obtenida " + ubicacionActual);
        map.addMarker(new MarkerOptions().position(ubicacionActual)
                .title("Usted está aqui"));
        map.moveCamera(CameraUpdateFactory.newLatLng(ubicacionActual));
        map.animateCamera(CameraUpdateFactory.newLatLng(ubicacionActual));
        map.setMinZoomPreference(12);
        map.setMaxZoomPreference(12);
    }

    public LatLng obtenerUbicacion(){
        LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Location l = new Location(LocationManager.NETWORK_PROVIDER);

        try {
            if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ||
                    ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                double latitud = 19.504539;
                double longitud = -99.146996;
                LatLng ubicacion = new LatLng(latitud, longitud);
                return ubicacion;
            }
            else{
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
                ActivityCompat.requestPermissions((Activity) getApplicationContext(),new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                        PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }





}
