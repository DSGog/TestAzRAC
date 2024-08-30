package com.example.test_gb.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.test_gb.R;

public class NotificationsFragment extends Fragment {

    public NotificationsFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);

        // Установить слушатель нажатий на элемент BottomNavigationView или любую другую кнопку
        view.findViewById(R.id.button_open_new_notification).setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_navigation_notifications_to_new_notification_fragment);
        });

        return view;
    }
}
