package com.example.listviewadaptadorplus;
/*
Archivo: lista_entrada.java
Descripcion: Tiene el constructor y tres metodos getters de la lista de entrada

   Fecha   / Autor / Version
   24-10-22/ Martin / 1.0 Versión Inicial
   28-10-22/ Martin / 2.0 Version Inicial
 */
public class lista_entrada {
    private int imagen;
    private String titulo;
    private String texto;

    public lista_entrada(int IdImagen, String textoTitulo, String textoContenido){
        this.imagen  = IdImagen;
        this.titulo = textoTitulo;
        this.texto = textoContenido;
    }
    public String get_textoTitulo(){return titulo;}
    public String get_textoContenido(){return texto;}
    public int get_idImagen(){return imagen;}
}
