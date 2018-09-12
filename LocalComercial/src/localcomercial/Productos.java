/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localcomercial;

/**
 *
 * @author Juanes
 */
public class Productos {
    private int codigo;
    private String descripcion;
    private double precio_unidad;

    public Productos(int codigo, String descripcion, double precio_unidad) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio_unidad = precio_unidad;
    }
    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio_unidad() {
        return precio_unidad;
    }

    public void setPrecio_unidad(double precio_unidad) {
        this.precio_unidad = precio_unidad;
    }
    
}
