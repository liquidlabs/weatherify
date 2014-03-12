package ca.liquidlabs.android.weather.model;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

/**
 * Model for retrieving Weather Data
 * Abstracts the accessing of Weather Data.
 *
 * Created by Alif on 3/12/14.
 */
public class WeatherDAO {

    // TAG
    private static final String TAG = "WeatherData";

    // activity using this model must override this data
    public interface OnChangeListener<T> {

        // callbacks invoked
        public void onSuccess(T data);

        public void onError(Object e);
    }

    // context of the Application
    private Context mContext;

    // reference to dataListener
    private OnChangeListener listener;
    private static WeatherDAO instance;


    //
    private WeatherDAO(Context c) {
        mContext = c;
    }

    /**
     * @param ctx Pass the Application Context
     * @param ls
     * @return
     */
    private WeatherDAO getInstance(Context ctx, Activity ls) {
        if (instance == null) {
            instance = new WeatherDAO(ctx);
        }

        try {
            listener = (OnChangeListener) ls;
        } catch (ClassCastException e) {
            Log.d(TAG, e.toString());
        }

        return instance;
    }


    /**
     * Gets the Weather Data of the specific city
     * @param city
     */
    public void getData(String city)
    {
        // sees if the data exists in the local database
        // if it exists, checks if cached/recent enough
        // otherwise, makes a request via Android Volley
        // and returns the data via callback to Activity


    }

    /**
     * Returns all datas based in collection
     */
    public void getData() {

    }




}
