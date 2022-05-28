package com.example.finalproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class CounterFragment extends Fragment {
    private TextView counterText;
    private Button minusButton;
    private Button resetButton;
    private Button plusButton;
    int counter;

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch(view.getId()) {
                case R.id.minusButton:
                    minusCounter();
                    break;

                case R.id.resetButton:
                    initCounter();
                    break;

                case R.id.plusButton:
                    plusCounter();
                    break;
            }
        }
    };


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_counter);
        counterText = (TextView) getView().findViewById(R.id.counterText);
        minusButton = (Button) getView().findViewById(R.id.minusButton);
        minusButton.setOnClickListener(clickListener);
        resetButton = (Button) getView().findViewById(R.id.resetButton);
        resetButton.setOnClickListener(clickListener);
        plusButton = (Button) getView().findViewById(R.id.plusButton);
        plusButton.setOnClickListener(clickListener);

        initCounter();
    }


    private void initCounter() {
        counter = 0;
        counterText.setText(counter + "");
    }

    private void plusCounter(){
        counter++;
        counterText.setText(counter + "");
    }

    private void minusCounter(){
        counter--;
        counterText.setText(counter + "");
    }


    private void setContentView(int fragment_counter) {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_counter, container, false);
    }
}