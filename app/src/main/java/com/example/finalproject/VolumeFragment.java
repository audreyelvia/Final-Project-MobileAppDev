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


public class VolumeFragment extends Fragment {
    EditText panjangBalok, lebarBalok, tinggiBalok, sisiPiramid, tinggiPiramid, radiusTabung, tinggiTabung;
    TextView  volumeBalok, volumePiramid, volumeTabung;
    Button hitungBalok, hitungPiramid, hitungTabung;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_volume);
        panjangBalok = (EditText) getView().findViewById(R.id.panjangBalok);
        lebarBalok = (EditText) getView().findViewById(R.id.lebarBalok);
        tinggiBalok = (EditText) getView().findViewById(R.id.tinggiBalok);
        sisiPiramid = (EditText) getView().findViewById(R.id.sisiPiramid);
        tinggiPiramid = (EditText) getView().findViewById(R.id.tinggiPiramid);
        radiusTabung = (EditText) getView().findViewById(R.id.radiusTabung);
        tinggiTabung = (EditText) getView().findViewById(R.id.tinggiTabung);
        volumeBalok = (TextView) getView().findViewById(R.id.volumeBalok);
        volumePiramid = (TextView) getView().findViewById(R.id.volumePiramid);
        volumeTabung = (TextView) getView().findViewById(R.id.volumeTabung);
        hitungBalok = (Button) getView().findViewById(R.id.hitungBalok);
        hitungPiramid= (Button) getView().findViewById(R.id.hitungPiramid);
        hitungTabung = (Button) getView().findViewById(R.id.hitungTabung);

        hitungBalok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBalok();
            }
        });

        hitungPiramid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatePiramid();
            }
        });

        hitungTabung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateTabung();
            }
        });

    }

    public void calculateBalok() {
        Integer panjang = Integer.parseInt(panjangBalok.getText().toString());
        Integer lebar = Integer.parseInt(lebarBalok.getText().toString());
        Integer tinggi = Integer.parseInt(tinggiBalok.getText().toString());
        Integer hasilBalok = panjang*lebar*tinggi;
        volumeBalok.setText(hasilBalok.toString());
    }

    public void calculatePiramid() {
        Integer sisi = Integer.parseInt(sisiPiramid.getText().toString());
        Integer tinggi = Integer.parseInt(tinggiPiramid.getText().toString());
        Double hasilPiramid = 0.33*sisi*sisi*tinggi;
        volumePiramid.setText(hasilPiramid.toString().format("%.2f", hasilPiramid));
    }

    public void calculateTabung() {
        Integer radius = Integer.parseInt(radiusTabung.getText().toString());
        Integer tinggi = Integer.parseInt(tinggiTabung.getText().toString());
        Double hasilTabung = 3.14*radius*radius*tinggi;
        volumeTabung.setText(hasilTabung.toString().format("%.2f", hasilTabung));
    }


    private void setContentView(int fragment_volume) {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_volume, container, false);
    }
}