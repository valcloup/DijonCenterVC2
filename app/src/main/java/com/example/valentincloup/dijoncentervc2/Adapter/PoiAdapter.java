package com.example.valentincloup.dijoncentervc2.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.valentincloup.dijoncentervc2.MainActivity;
import com.example.valentincloup.dijoncentervc2.Model.PointOfInterest;
import com.example.valentincloup.dijoncentervc2.R;
import com.example.valentincloup.dijoncentervc2.activity_poi_detail;

import java.io.Console;
import java.util.ArrayList;

/**
 * Created by Valentin CLOUP on 20/09/2017.
 */

public class PoiAdapter extends BaseAdapter {

    private static final String IMG_DIRECTORY = "..\\..\\Image";
    private Context context;

    ArrayList<PointOfInterest> lesPoi;

    public PoiAdapter(Context context)
    {
        this.context = context;
        lesPoi = new ArrayList<>();
    }

    public PoiAdapter(Context context, ArrayList<PointOfInterest> pois)
    {
        this.context = context;
        lesPoi = pois;
    }

    @Override
    public int getCount()
    {
        return lesPoi.size();
    }

    @Override
    public Object getItem(int position)
    {
        return lesPoi.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if (convertView == null)
        {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.layout_listview_poi, parent, false);
        }

        // get current item to be displayed
        final PointOfInterest currentItem = (PointOfInterest) getItem(position);

        // get the TextView for item name and item description
        TextView textViewItemName = (TextView)
                convertView.findViewById(R.id.text_view_poi_name);

        TextView textViewItemAdress = (TextView)
                convertView.findViewById(R.id.text_view_poi_adress);

        //sets the text for item name and item description from the current item object
        textViewItemName.setText(currentItem.getName());
        textViewItemAdress.setText(currentItem.getLocation().getAdresse());

        ImageView img = (ImageView)convertView.findViewById(R.id.icon);
        String type = currentItem.getType();
        if(type.equals("CINE") )
        {
            img.setImageResource(R.drawable.cine);
        }
        else// if(currentItem.getType().toLowerCase() == "rest")
        {
            img.setImageResource(R.drawable.rest);
        }

        Button cmdDetail = (Button)convertView.findViewById(R.id.cmd_detail);
        cmdDetail.setText(R.string.cmd_detail);

        cmdDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, activity_poi_detail.class);
                i.putExtra("poiId",currentItem.getId());
                context.startActivity(i);
            }
        });


        return convertView;
    }

}
