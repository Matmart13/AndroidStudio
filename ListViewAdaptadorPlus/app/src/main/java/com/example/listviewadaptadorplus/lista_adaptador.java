package com.example.listviewadaptadorplus;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import java.util.ArrayList;
/*
Archivo:lista_adaptador.java
Descripcion:Es una clase abstracta que extiende de ArrayAdapter con sus metodos

   Fecha   / Autor / Version
   24-10-22/ Martin / 1.0 Versión Inicial
   28-10-22/ Martin / 2.0 Versión Final
 */
public abstract class lista_adaptador extends BaseAdapter {

        private ArrayList<?> entradas;
        private int R_layout_IdView;
        private Context contexto;


public lista_adaptador (Context context, int R_layout_IdView, ArrayList<?> entradas ){
        super();
        this.entradas = entradas;
        this.contexto = context;
        this.R_layout_IdView = R_layout_IdView;

    }
        public  int getCount(){return  entradas.size();}
        public Object getItem(int position){return entradas.get(position);}
        public long getItemId(int position){return position;}
        @Override
        public  View getView(int position, View view, ViewGroup parent) {
                if (view == null) {
                        LayoutInflater mostrado = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        view = mostrado.inflate(R_layout_IdView, null);

                }
                onEntrada(entradas.get(position),view);
                return view;
                }

        protected abstract void onEntrada(Object entradas, View view);

    protected abstract void onEntrada(lista_entrada datos, View view);
}


