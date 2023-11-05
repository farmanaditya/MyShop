package com.example.myshop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.myshop.databinding.FragmentHomeBinding;

public class HomeFragment  extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnBuy.setOnClickListener(v -> {
            HomeFragmentDirections.ActionHomeFragmentToCheckOutFragment action = HomeFragmentDirections.actionHomeFragmentToCheckOutFragment("Samsung M22", null);
            Navigation.findNavController(v).navigate(action);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}