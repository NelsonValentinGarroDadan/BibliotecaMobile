package com.example.recuperatoriomoviles.ui.Biblioteca;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.recuperatoriomoviles.ui.Biblioteca.Modelo.Libro;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaViewModel extends AndroidViewModel {

    private MutableLiveData<List<Libro>> ListaM;
    private Context context;


    public BibliotecaViewModel(@NonNull Application application) {
        super(application);
        context = application;
    }
    public LiveData getMutable(){
        if(ListaM==null){
            ListaM = new MutableLiveData<>();
        }
        return ListaM;
    }
    public void CargarLista(){
        List<Libro> lista = new ArrayList<>();
        lista.add(new Libro("El señor de los Anillos","Luis Mercado","ULP",2000));
        lista.add(new Libro("Harry Potter Vol 1","Benjamin Devechi","Rosari",2015));
        lista.add(new Libro("Senicienta","Mariela Dadan","Palacions INC",2022));
        lista.add(new Libro("JavaScript Avanzado","Valentin Garro","Mundo de Tete",2008));
        lista.add(new Libro("Manual de Conduccion","Nicolas Rojas","Semisa",2020));
        ListaM.setValue(lista);
    }
}