package com.labcnt.sttq;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class mimin_login extends AppCompatActivity {

    DatabaseReference databaseReference;
    Button btnAdminOn, btnAdminOff;
    TextView textAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mimin_login);

        databaseReference = FirebaseDatabase.getInstance().getReference("AdminAktifasi");
        btnAdminOn = findViewById(R.id.tmbl);
        btnAdminOff = findViewById(R.id.tmbl2);
        textAdmin = findViewById(R.id.teks);
        String AktifasiAdmin = "Admin";
       
        btnAdminOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Aktifasi = "Admin";
                String ValueA = "On";
                String id = databaseReference.push().getKey();

                Mimin user = new Mimin(id, Aktifasi, ValueA);

                databaseReference.child(user.getAktifasi()).setValue(user);
            }
        });

        btnAdminOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Aktifasi = "Admin";
                String ValueA = "Off";
                String id = databaseReference.push().getKey();

                Mimin user = new Mimin(id, Aktifasi, ValueA);

                databaseReference.child(user.getAktifasi()).setValue(user);
            }
        });


        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.child(AktifasiAdmin).exists()) {
                    Mimin value = snapshot.child(AktifasiAdmin).getValue(Mimin.class);
                    textAdmin.setText(value.getValueA());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }
}