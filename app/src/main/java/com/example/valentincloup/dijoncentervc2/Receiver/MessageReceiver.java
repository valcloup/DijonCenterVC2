package com.example.valentincloup.dijoncentervc2.Receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

import com.example.valentincloup.dijoncentervc2.MainActivity;
import com.example.valentincloup.dijoncentervc2.Model.PointOfInterest;
import com.example.valentincloup.dijoncentervc2.activity_poi_detail;

/**
 * Created by Valentin CLOUP on 25/10/2017.
 */

public class MessageReceiver extends BroadcastReceiver
{
    private final String ACTION_RECEIVE_SMS = "android.provider.Telephony.SMS_RECEIVED";
    @Override
    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equals(ACTION_RECEIVE_SMS))
        {
            Bundle bundle = intent.getExtras();
            if (bundle != null)
            {
                Object[] pdus = (Object[]) bundle.get("pdus");

                final SmsMessage[] messages = new SmsMessage[pdus.length];
                for (int i = 0; i < pdus.length; i++)  {  messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);  }  if (messages.length > -1)
            {
                final String messageBody = messages[0].getMessageBody();

                Toast.makeText(context, "Message : " + messageBody, Toast.LENGTH_LONG).show();

                PointOfInterest poi = MainActivity.getPoiById(messageBody);

                if( poi != null)
                {
                    Intent i = new Intent(context, activity_poi_detail.class);
                    i.putExtra("poiId",poi.getId());
                    context.startActivity(i);
                }
            }
            }
        }
    }
}
