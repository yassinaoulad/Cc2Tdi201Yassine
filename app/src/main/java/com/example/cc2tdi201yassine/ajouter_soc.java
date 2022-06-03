package com.example.cc2tdi201yassine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ajouter_soc extends AppCompatActivity {


    EditText txtNom,txtSecteur,txtNb;
    Button btnEnreg;
    MyDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_soc);

        txtNom=findViewById(R.id.txtInputNom);
        txtSecteur=findViewById(R.id.txtInputSecteur);
        txtNb=findViewById(R.id.txtInputNbEmpl);

        db=new MyDB(this);
        btnEnreg=findViewById(R.id.btnEnreg);

        btnEnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Societe s=new Societe(txtNom.getText().toString(),txtSecteur.getText().toString(),Integer.valueOf(txtNb.getText().toString()));
                if(MyDB.addSociete(db.getWritableDatabase(),s)==-1)
                    Toast.makeText(ajouter_soc.this, "Error d'ajout", Toast.LENGTH_SHORT).show();
                else Toast.makeText(ajouter_soc.this, "Element ajouter", Toast.LENGTH_SHORT).show();
            }
        });



    }

    public void btnCancel(View view) {
        finish();
    }
}