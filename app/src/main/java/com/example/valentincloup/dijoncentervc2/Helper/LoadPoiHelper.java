package com.example.valentincloup.dijoncentervc2.Helper;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Valentin CLOUP on 20/09/2017.
 */

public class LoadPoiHelper extends AsyncTask<Void, Void, String>
{

    @Override
    protected String doInBackground(Void... params) {

        String jsonResult = "";
        try {
            URL url = new URL("https://raw.githubusercontent.com/lpotherat/pois/master/db.json");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while (( line = bufferedReader.readLine()) != null) {
                    jsonResult = jsonResult.concat(line);
                }
                bufferedReader.close();
                return jsonResult;
            }
            finally{
                urlConnection.disconnect();
            }
        }
        catch(Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            return null;
        }
    }
}
