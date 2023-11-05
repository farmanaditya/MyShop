package com.example.myshop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.myshop.databinding.FragmentAddressBinding;

public class AddressFragment extends Fragment {

    private FragmentAddressBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAddressBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] provinces = getResources().getStringArray(R.array.provinces);
        ArrayAdapter<String> adapterProvinces = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, provinces);
        adapterProvinces.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerProvinces.setAdapter(adapterProvinces);

        binding.btnDone.setOnClickListener(v -> {
            Navigation.findNavController(v).getPreviousBackStackEntry()
                    .getSavedStateHandle().set("address", binding.spinnerProvinces.getSelectedItem().toString());
            Navigation.findNavController(v).navigateUp();
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}