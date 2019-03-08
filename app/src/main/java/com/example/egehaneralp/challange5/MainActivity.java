package com.example.egehaneralp.challange5;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    //INTERCEPT SINIFINDA BİRİNCİ İF İÇİNDE TOAST ALTINI COMMENTE ALIRSAN
    //MAİNACTİVİTY DE BURASI YAZILAN YERİ COMMENTE ALIRSAN
    //SADECE DETECT OLARAK ÇALIŞACAKTIR.
    //GELEN NUMARAYA ERİŞME OLAYI ÜSTÜNDE ÇALIŞILMAKTADIR ...


    Button buttonReddet,buttonOnayla;
    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("arayanlar");


        buttonOnayla=findViewById(R.id.buttonAccept);
        buttonReddet=findViewById(R.id.buttonRed);

        //BURASI

        /*String no;
        Bundle extras = getIntent().getExtras();
        if(extras !=null){
            no=extras.getString("numara");

            InterceptCall ic= new InterceptCall();
            ic.setArayanNo(no);
            myRef.push().child(no).setValue(ic);
        }*/


        if(ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED){

            if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,

                    Manifest.permission.READ_PHONE_STATE)){
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.READ_PHONE_STATE},1);
            }else{
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.READ_PHONE_STATE},1);
            }
        }
        else{
            //boş
        }
        //TELEFON ARAMASI YAPABİLMEK İÇİN -> UYGULAMA DEVAMINDA KULLANILACAK
        if(ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.READ_PHONE_NUMBERS) != PackageManager.PERMISSION_GRANTED){

            if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,

                    Manifest.permission.READ_PHONE_NUMBERS)){
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.READ_PHONE_NUMBERS},2); //READ_PHONW_NUMBER
            }else{
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.READ_PHONE_NUMBERS},2);
            }
        } else{
            //do nothing

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch(requestCode){
            case 1: {
                if(grantResults.length>0  && grantResults[0] ==PackageManager.PERMISSION_GRANTED){
                    if(ContextCompat.checkSelfPermission(MainActivity.this,
                            Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this, "Permission was not granted", Toast.LENGTH_SHORT).show();
                }
                return;
            }
            case 2:{
                if(grantResults.length>0  && grantResults[0] ==PackageManager.PERMISSION_GRANTED){
                    if(ContextCompat.checkSelfPermission(MainActivity.this,
                            Manifest.permission.READ_PHONE_NUMBERS) == PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(this, "Permission Granted (NUM)", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this, "Permission was not granted", Toast.LENGTH_SHORT).show();
                }
                return;
            }

        }
    }
}
