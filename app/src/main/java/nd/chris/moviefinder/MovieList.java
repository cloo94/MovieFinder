package nd.chris.moviefinder;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.app.ListActivity;

import com.google.android.gms.location.LocationServices;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;


import org.json.JSONObject;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import cz.msebera.android.httpclient.Header;

import android.content.Intent;

/**
 * Created by Chris on 11/11/2015.
 * Last modified by Kevin on 11/30/2015
 */

public class MovieList extends Activity {

    //static final String[] MOVIES = new String[] { "Back", "The Martian", "Sicario", "The Walk", "Black Mass", "Pan", "Avengers: Age of Ultron", "The Intern", "Everest", "The Green Inferno", "Hotel Transylvania 2" };


    ListView listview;
    Response responseObj;
    Response2 responseObj2;
    CustomAdapter adapter;
    String url; // = "http://data.tmsapi.com/v1.1/movies/showings?startDate=2015-11-24&zip=46637&api_key=h68g4gu4kyn42xwxuqfh3evd";
    String url2;
    Gson gson;
    Gson gson2;
    AsyncHttpClient client;
    AsyncHttpClient client2;
    List<Response.MoviesType> thelist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        //String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
        String timeStamp = getIntent().getExtras().getString("date");

        url = "http://data.tmsapi.com/v1.1/movies/showings?startDate=" + timeStamp + "&zip=46637&api_key=h68g4gu4kyn42xwxuqfh3evd";

        String zip = getIntent().getExtras().getString("zipCode");
        final String movieSearch = getIntent().getExtras().getString("movie");
        if(zip != null && !zip.isEmpty()){
            url = "http://data.tmsapi.com/v1.1/movies/showings?startDate=" + timeStamp + "&zip=" + zip + "&api_key=h68g4gu4kyn42xwxuqfh3evd";
        }else{
            String lat = getIntent().getExtras().getString("lat");
            String lng = getIntent().getExtras().getString("long");
            url = "http://data.tmsapi.com/v1.1/movies/showings?startDate=" + timeStamp + "&lat=" + lat + "&lng=" + lng + "&api_key=h68g4gu4kyn42xwxuqfh3evd";
        }

        listview = (ListView) findViewById(R.id.list);
        client = new AsyncHttpClient();
        client.get(MovieList.this, url, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String responsestr = new String(responseBody);

                String str;
                str = "{\"movies\":" + responsestr + "}";
                gson = new Gson();
                responseObj = gson.fromJson(str,Response.class);
                adapter = new CustomAdapter(MovieList.this, responseObj.getMovies(), movieSearch);
                listview.setAdapter(adapter);
                Log.d("DEBUGTEST2", "test message");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //switch(position){
                Log.d("DEBUGTEST3", "test");
                TextView text = (TextView) findViewById(R.id.theatreid);
                String theatreID = text.getText().toString().substring(11,15);
                Log.d("DEBUGTheatreID", theatreID);
                //String theatreID = getIntent().getExtras().getString("TheatreID");
                url2 = "http://data.tmsapi.com/v1.1/theatres/" + theatreID + "?api_key=h68g4gu4kyn42xwxuqfh3evd";
                Log.d("DEBUGURL2", url2);
                client2 = new AsyncHttpClient();
                client2.get(MovieList.this, url2, new AsyncHttpResponseHandler() {

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        String responsestr2 = new String(responseBody);

                        Intent i = new Intent(MovieList.this, MovieMap.class);
                        //String str2;
                        //str2 = "{\"theatre\":" + responsestr2 + "}";
                        gson2 = new Gson();
                        responseObj2 = gson2.fromJson(responsestr2, Response2.class);
                        //adapter = new CustomAdapter(MovieList.this, responseObj.getMovies(), movieSearch);
                        //listview.setAdapter(adapter);
                        String thelat = responseObj2.getLocation().getGeoCode().getLatitude();
                        String thelong = responseObj2.getLocation().getGeoCode().getLongitude();
                        Log.d("DEBUGTEST4", responsestr2);
                        //Intent newintent = new Intent(getApplicationContext(),MovieMap.class);
                        i.putExtra("theatrelat", thelat);
                        i.putExtra("theatrelong", thelong);
                        startActivity(i);
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Log.d("DEBUGTESTfail", "test");
                    }
                });
                //break;




            }
            @SuppressWarnings("unused")
            public void onClick(View v){
            };
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_list, menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        Log.d("DEBUGTEST", "test");

        TextView text = (TextView) findViewById(R.id.theatreid);
        String theatreID = text.getText().toString();

        //String theatreID = getIntent().getExtras().getString("TheatreID");
        url2 = "http://data.tmsapi.com/v1.1/theatres/" + theatreID + "?api_key=h68g4gu4kyn42xwxuqfh3evd";
        client2 = new AsyncHttpClient();
        client2.get(MovieList.this, url2, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String responsestr2 = new String(responseBody);

                Intent i = new Intent(MovieList.this, MovieMap.class);
                //String str2;
                //str2 = "{\"theatre\":" + responsestr2 + "}";
                gson2 = new Gson();
                responseObj2 = gson2.fromJson(responsestr2,Response2.class);
                //adapter = new CustomAdapter(MovieList.this, responseObj.getMovies(), movieSearch);
                //listview.setAdapter(adapter);
                String thelat = responseObj2.getLocation().getGeoCode().getLatitude();
                String thelong = responseObj2.getLocation().getGeoCode().getLongitude();
                Log.d("DEBUG", responsestr2);
                //Intent newintent = new Intent(getApplicationContext(),MovieMap.class);
                i.putExtra("theatrelat", thelat);
                i.putExtra("theatrelong", thelong);
                startActivity(i);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

        //String lat = getIntent().getExtras().getString("lat");
        //String lng = getIntent().getExtras().getString("long");

        //i.putExtra("lat", lat);
        //i.putExtra("lng", lng);

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}