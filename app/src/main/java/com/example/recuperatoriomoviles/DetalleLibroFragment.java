package com.example.recuperatoriomoviles;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.recuperatoriomoviles.ui.Biblioteca.Modelo.Libro;

public class DetalleLibroFragment extends Fragment {

    private TextView tvTitulo, tvAutor, tvEditorial, tvAnio;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalle_libro, container, false);

        tvTitulo = view.findViewById(R.id.tvTituloD);
        tvAutor = view.findViewById(R.id.tvAutorD);
        tvEditorial = view.findViewById(R.id.tvEditorialD);
        tvAnio = view.findViewById(R.id.tvAnioD);
        Bundle bundle = getArguments();
        if (bundle != null) {
            Libro libro = (Libro) bundle.getSerializable("libro");
            if (libro != null) {
                tvTitulo.setText(libro.getTitulo());
                tvAutor.setText(libro.getAutor());
                tvEditorial.setText(libro.getEditorial());
                tvAnio.setText(String.valueOf(libro.getAnio()));
            }
        }

        return view;
    }
}