package com.mgke.lr22zad1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1_1).setOnClickListener(v ->
                openFragment(new Fragment1_1())
        );

        findViewById(R.id.button1_2).setOnClickListener(v ->
                openFragment(new Fragment1_2())
        );

        findViewById(R.id.button1_3).setOnClickListener(v ->
                openFragment(new Fragment1_3())
        );

        findViewById(R.id.button2).setOnClickListener(v ->
                openFragment(new Fragment2())
        );
    }

    private void openFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}
