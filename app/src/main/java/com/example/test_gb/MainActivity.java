package com.example.test_gb;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.test_gb.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private int toastIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Инициализация привязки к макету
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Инициализация Toolbar и установка его в качестве ActionBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Настройка BottomNavigationView и NavController
        BottomNavigationView navView = findViewById(R.id.bottomNavigationView);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.new_notification_fragment)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController);

        // Установка текста в TextView
        binding.text.setText("Hello World!");

        // Обработка отступов для системных панелей (например, вырезов и закругленных углов)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Обработка нажатия на кнопку button2
        binding.button2.setOnClickListener(v -> {
            int selectedId = binding.radioGroup.getCheckedRadioButtonId();

            if (selectedId != -1) {
                RadioButton selectedRadioButton = binding.getRoot().findViewById(selectedId);
                String selectedText = selectedRadioButton.getText().toString();
                Toast.makeText(MainActivity.this, "Вы выбрали: " + selectedText, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Пожалуйста, выберите вариант", Toast.LENGTH_SHORT).show();
            }
        });

        // Обработка нажатия на кнопку button3
        binding.button3.setOnClickListener(v -> {
            String inputText = binding.textInputEditText.getText().toString();

            if (!inputText.isEmpty()) {
                binding.textVisible.setText("Привет, " + inputText);
                binding.textVisible.setVisibility(View.VISIBLE);
            } else {
                showNextToast();
            }
        });
    }

    // Метод для показа следующего Toast сообщения
    private void showNextToast() {
        String[] messages = {
                "Я же попросил",
                "ПоЖаЛУйсТА, введите текст",
                "Вы не ввели текст",
                "Перестаньте",
                "Лаааадно, играйся"
        };

        if (toastIndex < messages.length) {
            Toast.makeText(MainActivity.this, messages[toastIndex], Toast.LENGTH_SHORT).show();
            toastIndex++;
        } else {
            toastIndex = 0;
        }
    }
}
