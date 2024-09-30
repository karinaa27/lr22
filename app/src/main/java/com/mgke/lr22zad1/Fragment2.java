package com.mgke.lr22zad1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {

    private ToggleButton temperatureToggle;
    private CheckBox checkBoxMilk, checkBoxCream, checkBoxSugar, checkBoxSyrup;
    private Spinner deliverySpinner;
    private ImageView temperatureIndicator;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);

        temperatureToggle = view.findViewById(R.id.temperatureToggle);
        checkBoxMilk = view.findViewById(R.id.checkBoxMilk);
        checkBoxCream = view.findViewById(R.id.checkBoxCream);
        checkBoxSugar = view.findViewById(R.id.checkBoxSugar);
        checkBoxSyrup = view.findViewById(R.id.checkBoxSyrup);
        deliverySpinner = view.findViewById(R.id.deliverySpinner);
        Button submitOrderButton = view.findViewById(R.id.submitOrderButton);
        temperatureIndicator = view.findViewById(R.id.temperatureIndicator);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.delivery_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        deliverySpinner.setAdapter(adapter);

        temperatureToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                temperatureIndicator.setImageResource(R.drawable.circle);
            } else {
                temperatureIndicator.setImageResource(R.drawable.circle_blue);
            }
        });
        submitOrderButton.setOnClickListener(v -> {
            String temperature = temperatureToggle.isChecked() ? "Горячий" : "Холодный";
            StringBuilder ingredients = new StringBuilder();
            if (checkBoxMilk.isChecked()) ingredients.append("Молоко, ");
            if (checkBoxCream.isChecked()) ingredients.append("Сливки, ");
            if (checkBoxSugar.isChecked()) ingredients.append("Сахар, ");
            if (checkBoxSyrup.isChecked()) ingredients.append("Сироп, ");
            String deliveryMethod = deliverySpinner.getSelectedItem().toString();
            String orderSummary = "Вы заказали: " + temperature + " кофе\n" +
                    "Добавки: " + (ingredients.length() > 0 ? ingredients.substring(0, ingredients.length() - 2) : "Нет") + "\n" +
                    "Способ доставки: " + deliveryMethod;
            Intent intent = new Intent(getActivity(), OrderSummaryActivity.class);
            intent.putExtra("ORDER_SUMMARY", orderSummary);
            startActivity(intent);
            Toast.makeText(getActivity(), "Заказ выполнен. Маркина", Toast.LENGTH_LONG).show();
        });
        return view;
    }
}