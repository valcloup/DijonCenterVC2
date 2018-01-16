package com.example.valentincloup.dijoncentervc2;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.valentincloup.dijoncentervc2.Adapter.PoiAdapter;
import com.example.valentincloup.dijoncentervc2.Helper.LoadPoiHelper;
import com.example.valentincloup.dijoncentervc2.Helper.ParsePoiHelper;
import com.example.valentincloup.dijoncentervc2.Model.PointOfInterest;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<PointOfInterest> _allPoi;
    ListView lvPoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(ContextCompat.checkSelfPermission(this,Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED)
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.RECEIVE_SMS)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.RECEIVE_SMS},
                        0);
            }
        }




        _allPoi = new ArrayList<>();

        LoadPoiHelper helper = new LoadPoiHelper();
        try
        {
            String jsonResult = helper.execute().get();
            _allPoi = ParsePoiHelper.GetPoiFromJsonStr(jsonResult);

            PoiAdapter adapter = new PoiAdapter(this,_allPoi);
            lvPoi = (ListView) findViewById(R.id.lvPoi);
            lvPoi.setAdapter(adapter);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
            Log.e("Error", e.getMessage());
        }
        catch (ExecutionException e) {
            e.printStackTrace();
            Log.e("Error", e.getMessage());
        }

    }

    public static PointOfInterest getPoiById(String id)
    {
        for (PointOfInterest poi:_allPoi)
        {
            if(poi.getId().equals(id))
            {
                return poi;
            }
        }

        return null;
    }
}
