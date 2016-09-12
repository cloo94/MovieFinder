package nd.chris.moviefinder;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 11/11/2015.
 * Last modified by Kevin on 11/17/2015
 */
public class CustomAdapter extends BaseAdapter {

    private List<Response.MoviesType> mShowtimeitem;
    private Context mContext;
    private String movie;
    private LayoutInflater inflater;

    public CustomAdapter(Context mContext, List<Response.MoviesType> mShowtimeitem, String movie) {
        this.mContext = mContext;
        this.mShowtimeitem = mShowtimeitem;
        this.movie = movie;
    }

    @Override
    public int getCount() {
        return mShowtimeitem.size();
    }

    @Override
    public Object getItem(int position) {
        return mShowtimeitem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.each_list_item, parent, false);
        View fakeRow = inflater.inflate(R.layout.fake_item, parent, false);
        Response.MoviesType item = (Response.MoviesType) getItem(position);
        //Response item = (Response) getItem(position);
        TextView title = (TextView) rowView.findViewById(R.id.title);
        TextView theatre = (TextView) rowView.findViewById(R.id.theatre);
        TextView theatreid = (TextView) rowView.findViewById(R.id.theatreid);
        TextView showtimes = (TextView) rowView.findViewById(R.id.showtimes);
        TextView desc = (TextView) rowView.findViewById(R.id.desc);

        //TextView showtimes = (TextView) rowView.findViewById(R.id.showtimes);
        if((movie.isEmpty() || movie==null) || (movie.toLowerCase().equals(item.getTitle().toLowerCase()))) {
            title.setText("Title: " + item.getTitle() + "\n");
            int numShowtimes = item.getShowtimes().size();

            String theatreID = item.getShowtimes().get(0).getTheatre().getId();
            //Intent newintent = new Intent(mContext, MovieList.class);
            //newintent.putExtra("TheatreID", theatreID);

            String shows = "Showtimes:\n";
            //theatre.setText(Integer.toString(numShowtimes));
            theatre.setText("Theater: " + item.getShowtimes().get(0).getTheatre().getName());
            theatreid.setText("TheaterID: " + theatreID + "\n");
            for (int i = 0; i < numShowtimes; i++) {
                String show = item.getShowtimes().get(i).getDateTime(); //yyyy-mm-ddThh:mm
                String monthS = "";
                String hour = show.substring(11, 13);
                int hh = Integer.valueOf(hour);
                String cycle = "A.M.";
                if (hh > 12) {
                    hh = hh - 12;
                    cycle = "P.M";
                }
                if (hh == 12) {
                    cycle = "P.M";
                }

                if (Integer.valueOf(show.substring(5, 7)) == 1) {
                    monthS = "January";
                } else if (Integer.valueOf(show.substring(5, 7)) == 2) {
                    monthS = "February";
                } else if (Integer.valueOf(show.substring(5, 7)) == 3) {
                    monthS = "March";
                } else if (Integer.valueOf(show.substring(5, 7)) == 4) {
                    monthS = "April";
                } else if (Integer.valueOf(show.substring(5, 7)) == 5) {
                    monthS = "May";
                } else if (Integer.valueOf(show.substring(5, 7)) == 6) {
                    monthS = "June";
                } else if (Integer.valueOf(show.substring(5, 7)) == 7) {
                    monthS = "July";
                } else if (Integer.valueOf(show.substring(5, 7)) == 8) {
                    monthS = "August";
                } else if (Integer.valueOf(show.substring(5, 7)) == 9) {
                    monthS = "September";
                } else if (Integer.valueOf(show.substring(5, 7)) == 10) {
                    monthS = "October";
                } else if (Integer.valueOf(show.substring(5, 7)) == 11) {
                    monthS = "November";
                } else if (Integer.valueOf(show.substring(5, 7)) == 12) {
                    monthS = "December";
                }

                shows += Integer.toString(hh) + ":" + show.substring(14) + " " + cycle + " - " + monthS + " " + show.substring(8, 10) + ", " + show.substring(0, 4) + "\n";
            }
            showtimes.setText(shows + "\n");
            desc.setText("Description:\n" + item.getShortDescription() + "\n");
            return rowView;
        }else{
            return fakeRow;
        }


        //List
        //showtimes.setText(item.getShowtimes(item.getTheatre(item.getName())));
        //        getName(item.getTheatre(item.getShowtimes())));


    }
}