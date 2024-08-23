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

import com.example.testazrac.databinding.ActivityMainBinding; // Импортируем сгенерированный класс ViewBinding

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding; // Объявляем переменную binding

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Инициализация ViewBinding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Пример установки текста с использованием binding
        binding.text.setText("Hello World!");

        // Включение режима EdgeToEdge
        EdgeToEdge.enable(this);

        // Установка OnApplyWindowInsetsListener с использованием ViewBinding
        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Настраиваем слушатель нажатия для кнопки для отображения выбранного варианта
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получаем ID выбранной радиокнопки в группе
                int selectedId = binding.radioGroup.getCheckedRadioButtonId();

                if (selectedId != -1) {
                    // Находим выбранную радиокнопку по ID
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String selectedText = selectedRadioButton.getText().toString();

                    // Отображаем текст выбранного варианта с помощью Toast
                    Toast.makeText(MainActivity.this, "Вы выбрали: " + selectedText, Toast.LENGTH_SHORT).show();
                } else {
                    // Если ни один вариант не выбран, отображаем сообщение
                    Toast.makeText(MainActivity.this, "Пожалуйста, выберите вариант", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
