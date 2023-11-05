package com.example.myshop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myshop.databinding.FragmentCheckOutBinding;


public class CheckOutFragment extends Fragment {

    private FragmentCheckOutBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCheckOutBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CheckOutFragmentArgs args = CheckOutFragmentArgs.fromBundle(getArguments());
        binding.edtAddress.setText(args.getAddress());
        binding.txtProductName.setText(args.getProductName());

        NavController navController = NavHostFragment.findNavController(this);
        LiveData<String> addressLiveData = navController.getCurrentBackStackEntry()
                .getSavedStateHandle()
                .getLiveData("address");
        addressLiveData.observe(getViewLifecycleOwner(), res -> binding.edtAddress.setText(res));
        binding.edtAddress.setOnClickListener(v -> {
            navController.navigate(CheckOutFragmentDirections.actionCheckOutFragmentToAddressFragment());
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}