package com.hartonostudio.donasiappsmadania.Menu.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.hartonostudio.donasiappsmadania.Model.ProgramDonasi;
import com.hartonostudio.donasiappsmadania.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
        setupRecyclerView();
        setupSearch();
    }

    private void setupRecyclerView() {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        
        // Data dummy untuk testing visual modernisasi
        List<ProgramDonasi> list = new ArrayList<>();
        list.add(new ProgramDonasi("Bantu Pembangunan Masjid Madania", "", 100000000, 65000000));
        list.add(new ProgramDonasi("Sedekah Qur'an untuk Santri", "", 50000000, 20000000));
        list.add(new ProgramDonasi("Donasi Sembako Dhuafa", "", 30000000, 25000000));
        list.add(new ProgramDonasi("Wakaf Sumur Air Bersih", "", 75000000, 15000000));

        ProgramDonasiAdapter adapter = new ProgramDonasiAdapter(list);
        binding.recyclerView.setAdapter(adapter);
    }

    private void setupSearch() {
        binding.searchRecipe.setQueryHint("Cari program donasi...");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}