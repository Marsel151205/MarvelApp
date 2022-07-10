package com.example.marvelapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.marvelapp.R;

public class CreditCardFragment extends Fragment {
    private Button btnConfirm;
    private EditText etLoginCard, etVT, etCV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_credit_card, container, false);
        //initialization
        btnConfirm = view.findViewById(R.id.btn_confirm);
        etLoginCard = view.findViewById(R.id.et_login_card);
        etVT = view.findViewById(R.id.et_vt);
        etCV = view.findViewById(R.id.et_cv);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etLoginCard.getText().length() < 16) {
                    etLoginCard.setError("Такой карты нету");
                } else if (etVT.getText().length() < 4 || etVT.getText().length() > 4) {
                    etVT.setError("Неправильный формат");
                } else if (etCV.getText().length() < 3 || etCV.getText().length() > 3) {
                    etCV.setError("CVV не действителен");
                } else {
                    Navigation.findNavController(view).navigate(R.id.successfullyBuyFragment);
                    Toast.makeText(getContext(), "Вы успешно купили Комикс\n Приятного чтения", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return view;
    }
}