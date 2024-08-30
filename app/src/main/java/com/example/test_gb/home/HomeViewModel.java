package com.example.test_gb.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(""); // Изначально пустой текст
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void resetText() {
        mText.setValue(""); // Метод для сброса текста
    }
}
