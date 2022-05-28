package com.example.finalproject;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class AreaFragment extends Fragment {
    EditText sisiPersegi, alasSegitiga, tinggiSegitiga, ruasLingkaran;
    TextView areaPersegi, areaSegitiga, areaLingkaran;
    Button hitungPersegi, hitungSegitiga, hitungLingkaran;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_area);
        sisiPersegi = (EditText) getView().findViewById(R.id.sisiPersegi);
        alasSegitiga = (EditText) getView().findViewById(R.id.alasSegitiga);
        tinggiSegitiga = (EditText) getView().findViewById(R.id.tinggiSegitiga);
        ruasLingkaran = (EditText) getView().findViewById(R.id.ruasLingkaran);
        areaPersegi = (TextView) getView().findViewById(R.id.areaPersegi);
        areaSegitiga = (TextView) getView().findViewById(R.id.areaSegitiga);
        areaLingkaran = (TextView) getView().findViewById(R.id.areaLingkaran);
        hitungPersegi = (Button) getView().findViewById(R.id.hitungPersegi);
        hitungSegitiga = (Button) getView().findViewById(R.id.hitungSegitiga);
        hitungLingkaran = (Button) getView().findViewById(R.id.hitungLingkaran);


        hitungPersegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatePersegi();
            }
        });

        hitungSegitiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateSegitiga();
            }
        });

        hitungLingkaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateLingkaran();
            }
        });
        }


        public void calculatePersegi() {
            Integer sisi = Integer.parseInt(sisiPersegi.getText().toString());
            Integer hasilPersegi = sisi*sisi;
            areaPersegi.setText(hasilPersegi.toString());
         }

        public void calculateSegitiga() {
            Integer alas = Integer.parseInt(alasSegitiga.getText().toString());
            Integer tinggi = Integer.parseInt(tinggiSegitiga.getText().toString());
            Integer hasilSegitiga = alas*tinggi/2;
            areaSegitiga.setText(hasilSegitiga.toString());
        }

        public void calculateLingkaran() {
            Integer ruas = Integer.parseInt(ruasLingkaran.getText().toString());
            Double hasilLingkaran = 3.14*ruas*ruas;
            areaLingkaran.setText(hasilLingkaran.toString().format("%.2f", hasilLingkaran));
        }

    private void setContentView(int fragment_area) {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_area, container, false);
    }
}