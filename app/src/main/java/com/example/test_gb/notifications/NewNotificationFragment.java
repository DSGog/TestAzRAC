package com.example.test_gb.notifications;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.test_gb.R;
import com.example.test_gb.databinding.FragmentNewNotificationFragmentBinding;

public class NewNotificationFragment extends Fragment {

    private FragmentNewNotificationFragmentBinding binding;
    private ImageView imageView;

    public NewNotificationFragment() {
        // Required empty public constructor
    }

    public static NewNotificationFragment newInstance(String param1, String param2) {
        NewNotificationFragment fragment = new NewNotificationFragment();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        args.putString("param2", param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String mParam1 = getArguments().getString("param1");
            String mParam2 = getArguments().getString("param2");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNewNotificationFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = binding.imageView;

        if (imageView != null) {
            Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.simcenter_animated);
            imageView.startAnimation(animation);
        } else {
            Log.e("NewNotificationFragment", "ImageView is null. Check your layout.");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
