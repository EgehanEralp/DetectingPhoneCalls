package com.example.egehaneralp.challange5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;


public class InterceptCall extends BroadcastReceiver{


    String arayanNo;


    public String getArayanNo() {
        return arayanNo;
    }

    public void setArayanNo(String arayanNo) {
        this.arayanNo = arayanNo;
    }

    @Override
    public void onReceive(Context context, Intent intent) {


        try{
           /* String telNo=tMgr.getLine1Number();
            myRef.child(telNo);*/

            String durum = intent.getStringExtra(TelephonyManager.EXTRA_STATE);

            if(durum.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_RINGING)){
                Toast.makeText(context, "TELEFON ÇALIYOR !!!", Toast.LENGTH_SHORT).show();
                /*TelephonyManager tMgr=(TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
                try {
                    String telNo = tMgr.getLine1Number();
                    Intent telgonder= new Intent(context,MainActivity.class);
                    telgonder.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    telgonder.putExtra("numara",telNo);
                    context.startActivity(telgonder);  // arkaplanda çalışmasını bozuyor ama veritabanı için gerekli??
                }catch(SecurityException e){
                    e.printStackTrace();
                }*/



            }
            if(durum.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_IDLE)){
                Toast.makeText(context, "REDDEDİLDİ !!!", Toast.LENGTH_SHORT).show();
            }
            if(durum.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_OFFHOOK)){
                Toast.makeText(context, "GÖRÜŞME BAŞLATILDI !!!", Toast.LENGTH_SHORT).show();
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
