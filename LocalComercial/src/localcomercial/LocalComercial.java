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
public class LocalComercial {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        System.out.println("Ingrese el numero de productos del local: ");
        int n = lectura.nextInt();
        Ventas venta = new Ventas(n);
        venta.IngresarProductos();
    }
    
}
