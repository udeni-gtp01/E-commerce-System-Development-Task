package com.udeni.e_commerce_system_development_task;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Fragment fragment_1 = new ViewOrderListFragment();
        Fragment fragment_2 = new ViewOrderFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment, fragment_1).commit();

        Button btn_fragment = findViewById(R.id.btn_fragment);
        btn_fragment.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment, fragment_2).addToBackStack(null).commit();
        });
    }
}