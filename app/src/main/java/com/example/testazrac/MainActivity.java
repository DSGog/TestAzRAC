package com.example.testazrac;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.testazrac.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private int toastIndex = 0; // Индекс для отслеживания текущего Toast сообщения

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.text.setText("Hello World!");

        EdgeToEdge.enable(this);

        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.button2.setOnClickListener(v -> {
            int selectedId = binding.radioGroup.getCheckedRadioButtonId();

            if (selectedId != -1) {
                RadioButton selectedRadioButton = findViewById(selectedId);
                String selectedText = selectedRadioButton.getText().toString();
                Toast.makeText(MainActivity.this, "Вы выбрали: " + selectedText, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Пожалуйста, выберите вариант", Toast.LENGTH_SHORT).show();
            }
        });

        binding.button3.setOnClickListener(v -> {
            // Получаем текст из EditText
            String inputText = binding.textInputEditText.getText().toString();

            // Проверяем, если текст не пустой, то устанавливаем его в TextView
            if (!inputText.isEmpty()) {
                binding.textVisible.setText("Привет, " + inputText);
                binding.textVisible.setVisibility(View.VISIBLE);
            } else {
                // Показываем следующую Toast при каждом нажатии на кнопку
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
            // Сбросить индекс после показа всех сообщений, если нужно
            toastIndex = 0;
        }
    }
}
