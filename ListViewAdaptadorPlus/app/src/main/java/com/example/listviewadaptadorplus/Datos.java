package com.example.listviewadaptadorplus;
/*
Archivo:Datos.java
Descripcion:Contiene el constructor de la clase y tres metodos getters

   Fecha   / Autor / Version
   24-10-22/ Martin / 1.0 Versión Inicial
   28-10-22/ Martin / 2.0 Versión Final
 */
public class Datos {
    private int imagen;
    private String titulo;
    private String texto;
    public Datos(int idImagen,String textoTitulo, String textoContenido){
        this.imagen = idImagen;
        this.titulo = textoTitulo;
        this.texto = textoContenido;
    }
    public String get_Titulo(){return  titulo;}
    public String get_textoContenido(){return texto;}
    public int get_idimagen(){return imagen;}
}
