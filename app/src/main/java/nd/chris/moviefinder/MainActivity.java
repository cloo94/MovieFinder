package nd.chris.moviefinder;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.graphics.Typeface;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity{

    //double latitude=0,longitude=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Font path
        String AlegreyaBoldFont = "fonts/Alegreya-Bold.ttf";

        // text view label
        TextView textView1 = (TextView) findViewById(R.id.textView1);

        // Loading Font Face
        Typeface tf = Typeface.createFromAsset(getAssets(), AlegreyaBoldFont);

        // Applying font
        textView1.setTypeface(tf);

        // for the search bar
        //Intent intent = getIntent();
        //if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
        //    String query = intent.getStringExtra(SearchManager.QUERY);
        //    doMySearch(query);
        //}



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Spinner dropdown = (Spinner)findViewById(R.id.dates);
        String[] items = new String[]{"1","2","3","4","5"};
        dropdown.setSelection(0);
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
        //String timeStamp = "2013-12-20";
        String year = timeStamp.substring(0, 4);
        String month = timeStamp.substring(5, 7);
        String day = timeStamp.substring(8,10);
        for(int i = 0; i < 5 ; i++){
            items[i] = month + "/" + day + "/" + year;
            int yyyy = Integer.valueOf(year);
            if(day.equals("28") && month.equals("02") && ((yyyy%4==0 && yyyy%100==0 && yyyy%400==0) || (yyyy%4==0 && yyyy%100!=0))){
                day = "29";
            }else if((day.equals("28") && month.equals("02")) || (day.equals("29") && month.equals("02"))){
                month = "03";
                day = "01";
            }else if(day.equals("30") && (month.equals("04") || month.equals("06") || month.equals("09") || month.equals("11"))){
                month = Integer.toString(Integer.valueOf(month) + 1);
                day = "01";
            }else if(day.equals("31") && month.equals("12")){
                month = "01";
                day = "01";
                year = Integer.toString(Integer.valueOf(year) + 1);
            }else if(day.equals("31") && (month.equals("01") || month.equals("03") || month.equals("05") || month.equals("07")|| month.equals("08") || month.equals("10"))){
                month = Integer.toString(Integer.valueOf(month) + 1);
                day = "01";
            }else{
                day = String.format("%02d",Integer.valueOf(day) + 1);
            }
        }
        //String[] items = new String[]{"1", "2", "three"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);


//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        Intent i = new Intent(this, MovieList.class);

        EditText editText = (EditText) findViewById(R.id.zipText);
        String zip = editText.getText().toString();

        EditText search = (EditText) findViewById(R.id.movie);
        String movie = search.getText().toString();

        Spinner dropdown = (Spinner) findViewById(R.id.dates);
        String dateExtra = dropdown.getSelectedItem().toString();
        String date = dateExtra.substring(6) + "-" + dateExtra.substring(0,2) + "-" + dateExtra.substring(3,5);

        double latitude = 0, longitude = 0;
        GPSTracker gpsTracker = new GPSTracker(this);

        //if (gpsTracker.getIsGPSTrackingEnabled()){
            latitude = gpsTracker.latitude;
            longitude = gpsTracker.longitude;
        /*}else{
            latitude = 41.6725;
            longitude = -86.2553;
        }*/

        i.putExtra("zipCode", zip);
        i.putExtra("movie", movie);
        i.putExtra("date", date);
        i.putExtra("lat", String.valueOf(latitude));
        i.putExtra("long", String.valueOf(longitude));
        startActivity(i);
    }
}