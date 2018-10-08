/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amazon_bodegas;

/**
 *
 * @author Juanes
 */
public class Estante {
    //Cada estante tiene 3 cajas
    private int id;
    private int fila;
    private int columna;
    private Producto[] productos;

    public Estante(int id, int fila, int columna) {
        this.id = id;
        this.fila = fila;
        this.columna = columna;
        this.productos = new Producto[21];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void setProductos(Producto[] productos) {
        this.productos = productos;
    }  
}
