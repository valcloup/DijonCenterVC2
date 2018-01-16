package com.example.valentincloup.dijoncentervc2.Helper;

import com.example.valentincloup.dijoncentervc2.Model.Location;
import com.example.valentincloup.dijoncentervc2.Model.PointOfInterest;
import com.example.valentincloup.dijoncentervc2.Model.Position;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Valentin CLOUP on 20/09/2017.
 */

public class ParsePoiHelper
{
    public static ArrayList<PointOfInterest> GetPoiFromJsonStr(String jsonStr){
        ArrayList<PointOfInterest> lesPOI = new ArrayList<>();

        try
        {
            JSONArray jsonPOI = new JSONObject(jsonStr).getJSONArray("pois");

            for (int i = 0; i< jsonPOI.length();i++)
            {
                JSONObject json = jsonPOI.getJSONObject(i);
                String id = json.getString("id");
                String type = json.getString("type");
                String name = json.getString("name");

                PointOfInterest poi = new PointOfInterest();
                poi.setId(id);
                poi.setType(type);
                poi.setName(name);

                JSONObject locationJson = json.getJSONObject("location");
                Location l = new Location();
                l.setAdresse(locationJson.getString("adress"));
                l.setPostalCode(locationJson.getString("postalCode"));
                l.setCity(locationJson.getString("city"));

                poi.setLocation(l);

                JSONObject position = locationJson.getJSONObject("position");
                Position p = new Position();
                p.setLat(position.getLong("lat"));
                p.setLon(position.getLong("lon"));

                poi.setPosition(p);

                lesPOI.add(poi);
            }

        }
        catch(JSONException e)
        {
            e.printStackTrace();
        }


        return lesPOI;
    }
}
