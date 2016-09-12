package nd.chris.moviefinder;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

public class MovieMap extends FragmentActivity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    private GoogleMap mMap;

    private GoogleApiClient mGoogleApiClient;
    public static final String TAG = MovieMap.class.getSimpleName();
    private final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;
    private LocationRequest mLocationRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_map);
        setUpMapIfNeeded();
/*
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String bestProvider = locationManager.getBestProvider(criteria,true);
        locationManager.requestLocationUpdates(bestProvider,20000,0,this);
*/
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        // Create the LocationRequest object
        mLocationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(10 * 1000)        // 10 seconds, in milliseconds
                .setFastestInterval(1 * 1000); // 1 second, in milliseconds

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        //SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
        //        .findFragmentById(R.id.map);
        //mapFragment.getMapAsync(this);


        //setContentView(R.layout.activity_movie_map);

        SupportMapFragment supportMapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.googleMap);
        mMap = supportMapFragment.getMap();
        mMap.setMyLocationEnabled(true);
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        //senSensorManager.registerListener(this, senAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        Criteria criteria = new Criteria();
        String bestProvider = locationManager.getBestProvider(criteria, true);
        if (checkPermission(Manifest.permission.ACCESS_FINE_LOCATION,1,0) != PackageManager.PERMISSION_GRANTED
                && checkPermission(Manifest.permission.ACCESS_COARSE_LOCATION,1,0) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

    /*
        Location location2 = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        //Location location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

        if (location2 != null) {
            onLocationChanged(location2);
        }
        //locationManager.requestLocationUpdates(bestProvider, 20000, 0, this);
        android.location.LocationListener locationListener = new android.location.LocationListener() {
            public void onLocationChanged(Location location2) {
                //Any method here
            }
            public void onStatusChanged (String provider, int status, Bundle extras){}
            public void onProviderEnabled(String provider) {}
            public void onProviderDisabled (String provider){}
        };
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,20000,0,locationListener);
    */


    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mGoogleApiClient.isConnected()) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
            mGoogleApiClient.disconnect();
        }
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.googleMap))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    private void setUpMap() {
        //mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
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

    //public void onMapReady(GoogleMap googleMap) {
    //    mMap = googleMap;

        // Add a marker in Sydney and move the camera
    //    LatLng sydney = new LatLng(-34, 151);
    //    mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
    //    mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    //}

    @Override
    public void onConnected(Bundle bundle) {
        Log.i(TAG, "Location services connected.");
        Location location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (location == null) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        } else {
            handleNewLocation(location);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i(TAG, "Location services suspended. Please reconnect.");
    }

    @Override
    public void onLocationChanged(Location location) {
        handleNewLocation(location);
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        if (connectionResult.hasResolution()) {
            try {
                // Start an Activity that tries to resolve the error
                connectionResult.startResolutionForResult(this, CONNECTION_FAILURE_RESOLUTION_REQUEST);
            } catch (IntentSender.SendIntentException e) {
                e.printStackTrace();
            }
        } else {
            Log.i(TAG, "Location services connection failed with code " + connectionResult.getErrorCode());
        }
    }

    private void handleNewLocation(Location location) {
        Log.d(TAG, location.toString());
        double currentLatitude = location.getLatitude();
        double currentLongitude = location.getLongitude();
        LatLng latLng = new LatLng(currentLatitude, currentLongitude);

        BitmapDescriptor bd = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE);
        MarkerOptions options = new MarkerOptions()
                .position(latLng)
                .title("Current Position")
                .icon(bd);
        mMap.addMarker(options);
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        String theatrelat = getIntent().getExtras().getString("theatrelat");
        String theatrelong = getIntent().getExtras().getString("theatrelong");
        Log.d("DEBUG_theatrelat", theatrelat);
        Log.d("DEBUG_theatrelong", theatrelong);
        double theatreLat = Double.valueOf(theatrelat);
        double theatreLong = Double.valueOf(theatrelong);
        LatLng MovieTheatre = new LatLng(theatreLat,theatreLong);
        mMap.addMarker(new MarkerOptions().position(MovieTheatre).title("Movie Theatre Location"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));

        double maxlat;
        double maxlong;
        double minlat;
        double minlong;

        if(currentLatitude > theatreLat) {
            maxlat = currentLatitude;
            minlat = theatreLat;
        } else {
            maxlat = theatreLat;
            minlat = currentLatitude;
        }

        if(currentLongitude > theatreLong) {
            maxlong = currentLongitude;
            minlong = theatreLong;
        } else {
            maxlong = theatreLong;
            minlong = currentLongitude;
        }

        //mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        final LatLngBounds square = new LatLngBounds(new LatLng(minlat,minlong),new LatLng(maxlat,maxlong));

        mMap.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() {
            @Override
            public void onCameraChange(CameraPosition cameraPosition) {
                mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(square, 100));
                mMap.setOnCameraChangeListener(null);
            }
        });
    }

}

/*
import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

//http://javapapers.com/android/android-show-current-location-on-map-using-google-maps-api/ used for code help

public class MovieMap extends FragmentActivity implements LocationListener{
    GoogleMap googleMap;
    //double latitude = 41.6725, longitude = -86.2553;

    public MovieMap() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //show error dialog if GooglePlayServices not available
        if (!isGooglePlayServicesAvailable()) {
            /*Intent i = new Intent(this, MovieList.class);
            i.putExtra("zipCode", "06902");
            i.putExtra("date", "2015-12-01");
            startActivity(i);*/
/*
            finish();
        }
        setContentView(R.layout.activity_movie_map);
        SupportMapFragment supportMapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.googleMap);
        googleMap = supportMapFragment.getMap();
        googleMap.setMyLocationEnabled(true);
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        //senSensorManager.registerListener(this, senAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        Criteria criteria = new Criteria();
        String bestProvider = locationManager.getBestProvider(criteria, true);
        if (checkPermission(Manifest.permission.ACCESS_FINE_LOCATION,1,0) != PackageManager.PERMISSION_GRANTED
                && checkPermission(Manifest.permission.ACCESS_COARSE_LOCATION,1,0) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        //Location location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

        if (location != null) {
            onLocationChanged(location);
        }
        locationManager.requestLocationUpdates(bestProvider, 20000, 0, this);
    }

    @Override
    public void onLocationChanged(Location location) {

        GPSTracker gpsTracker = new GPSTracker(this);

        // TextView locationTv = (TextView) findViewById(R.id.latlongLocation);
        //double latitude = location.getLatitude();
        //double longitude = location.getLongitude();
        double latitude = gpsTracker.latitude;
        double longitude = gpsTracker.longitude;
        LatLng latLng = new LatLng(latitude, longitude);
        Log.d("DEBUG_latitude", String.valueOf(latitude));
        Log.d("DEBUG_longitude", String.valueOf(longitude));
        googleMap.addMarker(new MarkerOptions().position(latLng));

        String theatrelat = getIntent().getExtras().getString("theatrelat");
        String theatrelong = getIntent().getExtras().getString("theatrelong");
        Log.d("DEBUG_theatrelat", theatrelat);
        Log.d("DEBUG_theatrelong", theatrelong);
        double theatreLat = Double.valueOf(theatrelat);
        double theatreLong = Double.valueOf(theatrelong);
        LatLng MovieTheatre = new LatLng(theatreLat,theatreLong);
        //googleMap.addMarker(new MarkerOptions().position(MovieTheatre));


        MarkerOptions options = new MarkerOptions()
                .position(MovieTheatre)
                .title("Movie Theatre");
        googleMap.addMarker(options);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));


        double maxlat;
        double maxlong;
        double minlat;
        double minlong;

        if(latitude > theatreLat) {
            maxlat = latitude;
            minlat = theatreLat;
        } else {
            maxlat = theatreLat;
            minlat = latitude;
        }

        if(longitude > theatreLong) {
            maxlong = longitude;
            minlong = theatreLong;
        } else {
            maxlong = theatreLong;
            minlong = longitude;
        }

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        //LatLngBounds square = new LatLngBounds(new LatLng(minlat,minlong),new LatLng(maxlat,maxlong));
        //googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(square,15,15,15));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(15));
        //locationTv.setText("Latitude:" + latitude + ", Longitude:" + longitude);
    }

    @Override
    public void onProviderDisabled(String provider) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onProviderEnabled(String provider) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub
    }

    private boolean isGooglePlayServicesAvailable() {
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (ConnectionResult.SUCCESS == status) {
            return true;
        } else {
            GooglePlayServicesUtil.getErrorDialog(status, this, 0).show();
            return false;
        }
    }

}
*/