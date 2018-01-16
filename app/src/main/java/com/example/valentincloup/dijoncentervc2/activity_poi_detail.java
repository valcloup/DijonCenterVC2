package com.example.valentincloup.dijoncentervc2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.valentincloup.dijoncentervc2.Adapter.PoiAdapter;
import com.example.valentincloup.dijoncentervc2.Model.PointOfInterest;

public class activity_poi_detail extends AppCompatActivity {

    private PointOfInterest _poi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poi_detail);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String poiId = extras.getString("poiId");

            PointOfInterest poi = MainActivity.getPoiById(poiId);

            TextView textViewItemName = (TextView)
                    this.findViewById(R.id.txtName);

            textViewItemName.setText(poi.getName());

            TextView textViewItemAdress = (TextView)
                    this.findViewById(R.id.txtAdress);

            textViewItemAdress.setText(poi.getLocation().getAdresse());

            TextView textViewLong = (TextView)
                    this.findViewById(R.id.txtLong);

            textViewLong.setText(String.valueOf(poi.getPosition().getLon()));

            TextView textViewLat = (TextView)
                    this.findViewById(R.id.txtLat);

            textViewLat.setText(String.valueOf(poi.getPosition().getLat()));

            ImageView img = (ImageView)this.findViewById(R.id.imgIcon);
            String type = poi.getType();
            if(type.equals("CINE") )
            {
                img.setImageResource(R.drawable.cine);
            }
            else// if(currentItem.getType().toLowerCase() == "rest")
            {
                img.setImageResource(R.drawable.rest);
            }
        }
    }
}
