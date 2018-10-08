/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amazon_bodegas;

import java.util.ArrayList;

/**
 *
 * @author Juanes
 */
public class Pedido {
    private int id;
    private ArrayList<Producto> producto;
    private Cliente cliente;

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.producto = new ArrayList<Producto>();
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Producto> getProducto() {
        return producto;
    }
    
    public void setProducto(ArrayList<Producto> producto) {
        this.producto = producto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    public boolean addProducto(Producto p){
        return this.producto.add(p);
    }
    
    public boolean removeProducto(Producto p){
        return this.producto.remove(p);
    }
}
