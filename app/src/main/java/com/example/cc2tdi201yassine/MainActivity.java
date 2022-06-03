package com.example.cc2tdi201yassine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnMainActClick(View view) {
        Intent i=null;
        switch(view.getId()){
            case R.id.btnAjoSoc: i=new Intent(this,ajouter_soc.class);break;
            case R.id.btnEditSic: i=new Intent(this,editer_soc.class);break;
            case R.id.btnListSoc: i=new Intent(this,listcos.class);break;
        }
        startActivity(i);
    }
}