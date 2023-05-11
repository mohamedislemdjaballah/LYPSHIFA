package com.example.shifa.ui.description;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.shifa.Signup;
import com.example.shifa.databinding.FragmentDescriptionBinding;

import java.util.zip.Inflater;

public class DescriptionFragment extends Fragment implements View.OnClickListener{

    private FragmentDescriptionBinding binding;
    Button addTest;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DescriptionViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DescriptionViewModel.class);


        binding = FragmentDescriptionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        addTest = binding.addTest;

        addTest.setOnClickListener(this::onClick);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == addTest.getId()) {
            Toast.makeText(requireContext(), "buttonClicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this.getContext(), com.example.shifa.add_result.class);
            startActivity(intent);
        }
    }
}