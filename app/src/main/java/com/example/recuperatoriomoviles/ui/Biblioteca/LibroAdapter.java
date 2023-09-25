package com.example.recuperatoriomoviles.ui.Biblioteca;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recuperatoriomoviles.R;
import com.example.recuperatoriomoviles.ui.Biblioteca.Modelo.Libro;

import java.util.List;

public class LibroAdapter extends RecyclerView.Adapter<LibroAdapter.ViewHolder> {
    private List<Libro> lista;
    private Context context;
    private LayoutInflater inflater;
    public LibroAdapter(List<Libro> lista, Context context, LayoutInflater inflater) {
        this.lista = lista;
        this.context = context;
        this.inflater = inflater;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_libro,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Titulo.setText(lista.get(position).getTitulo());
        holder.Autor.setText(lista.get(position).getAutor());
    }


    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView Titulo;
        private TextView Autor;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Titulo = itemView.findViewById(R.id.tvTituloD);
            Autor = itemView.findViewById(R.id.tvAutorD);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Libro libroSeleccionado = lista.get(position);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("libro", libroSeleccionado);
                        NavController navController = Navigation.findNavController(v);
                        navController.navigate(R.id.action_nav_Biblioteca_to_nav_Detalles, bundle);
                    }
                }
            });
        }
    }

}
