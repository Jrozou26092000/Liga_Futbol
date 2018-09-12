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
import java.util.Scanner;
public class Ventas {
    private Productos[] producto;
    
    public Ventas(int n) {
        this.producto = new Productos[n];
    }
    public void IngresarProductos(){
        Scanner lectura = new Scanner(System.in);
        int c;
        String d;
        double p;
        for (int i = 1; i < this.producto.length; i++) {
            System.out.println("Producto "+i);
            System.out.println("Ingrese el codigo del producto: ");
            c = lectura.nextInt();
            System.out.println("Ingrese la decripcion del producto: ");
            d = lectura.next();
            System.out.println("Ingrese el precio por unidad: ");
            p = lectura.nextDouble();
            this.producto[i].setCodigo(c);
            this.producto[i].setDescripcion(d);
            this.producto[i].setPrecio_unidad(p);
        }
    }
}
