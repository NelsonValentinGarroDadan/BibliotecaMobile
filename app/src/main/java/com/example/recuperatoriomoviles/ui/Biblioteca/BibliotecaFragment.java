package com.example.recuperatoriomoviles.ui.Biblioteca;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recuperatoriomoviles.R;
import com.example.recuperatoriomoviles.databinding.FragmentBibliotecaBinding;
import com.example.recuperatoriomoviles.ui.Biblioteca.Modelo.Libro;

import java.util.List;


public class BibliotecaFragment extends Fragment {

    private FragmentBibliotecaBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        BibliotecaViewModel bibliotecaViewModel =
                new ViewModelProvider(this).get(BibliotecaViewModel.class);

        binding = FragmentBibliotecaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        bibliotecaViewModel.getMutable().observe(getViewLifecycleOwner(), new Observer<List<Libro>>() {
            @Override
            public void onChanged(List<Libro> lista) {
                RecyclerView rv = root.findViewById(R.id.recyclerView); ;
                LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false);
                rv.setLayoutManager(layoutManager);
                LibroAdapter adapter = new LibroAdapter(lista,requireContext(),getLayoutInflater());
                rv.setAdapter(adapter);
            }
        });
        bibliotecaViewModel.CargarLista();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}