package com.mgke.lr22zad1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1_1 extends Fragment {

    private EditText editTextName, editTextMessage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_1, container, false);

        editTextName = view.findViewById(R.id.editTextName);
        editTextMessage = view.findViewById(R.id.editTextMessage);
        Button buttonSend = view.findViewById(R.id.buttonSend);

        buttonSend.setOnClickListener(v -> {
            String name = editTextName.getText().toString();
            String message = editTextMessage.getText().toString();
            Toast.makeText(getActivity(), "Name: " + name + "\nMessage: " + message, Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}

