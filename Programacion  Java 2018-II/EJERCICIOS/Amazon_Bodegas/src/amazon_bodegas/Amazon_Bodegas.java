/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amazon_bodegas;
import java.util.Scanner;

/**
 *
 * @author Juanes
 */
public class Amazon_Bodegas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Se crea la bodega 
        Bodega bodega = new Bodega("X");
        //se crean los estantes a traves del siguiente metodo
        bodega.RegistroEstantes();
        //se crean los robots a traves del siguiente metodo
        bodega.RegistroRobot();
        Scanner leer = new Scanner(System.in);
        int c;
        do{
            System.out.println("---------------------------------------------------------");
            System.out.println("1- Registrar productos");
            System.out.println("2- Realizar pedido");
            System.out.println("3- Salir");
            c = leer.nextInt();
            switch(c){
                case 1:
                    int numEstante;
                    do{
                        System.out.println("Numero de estante: ");
                        numEstante = leer.nextInt()-1;
                    }while(numEstante+1 > 20 || numEstante+1 <0);                    
                    //Se desea conocer la cantidad TOTAL de productos que se quieren almacenar 
                    //para tener en cuenta el limite de productos que se pueden alamacenar
                    //y con ello tenrer certeza de que solo ingresara la cantidad predeterminada
                    int cantidad;
                    
                    do {
                        //Se creo el metodo con el fin de que el empleado tenga
                        //presente cuantos productos puede guardar en el estante
                        System.out.println("Cantidad de productos que desea alamacenar en el estante (max. 21 por estante): ");
                        cantidad = leer.nextInt();
                    } while (cantidad > 21);
                    for (int i = cantidad; 0 < i; i--) {
                        System.out.println("Dsiponibilidad en el estante: "+bodega.Dsiponibilidad(numEstante)+" espacios");
                        System.out.println("--------------------------------------------------------");
                        int unidad;
                        do{
                            System.out.println("Unidades de un mismo producto a resgistrar: ");
                            unidad = leer.nextInt();
                        }while(cantidad < unidad);
                        cantidad-=unidad;
                        System.out.println("Nombre del producto: ");
                        String nombre = leer.next();
                        System.out.println("Codigo del producto: ");
                        int codigo = leer.nextInt();
                        System.out.println("Precio del producto: ");
                        double precio = leer.nextDouble();
                        for (int j = unidad; 0 < j; j--) {
                            Producto p = new Producto(nombre, codigo,precio);
                            //Con esta varible se sabe que no hay mas espacio en el estante para almacenar
                            //productos y con ello terminar el ciclo con i = 0 y j = 0 ,para no volver a repetirlo
                            //sabiendo que no hay espacios deisponibles
                            boolean espacioEstante = bodega.LlenarEstante(p,numEstante);
                            if(espacioEstante == false){
                                System.out.println("------No hay suficiente espacio en este estante---------");
                                j=0;
                                i=0;
                            }
                        }
                        i-=unidad;
                    }
                    break;
                case 2:
                    int numEstante_2;
                    int decision;
                    int id;
                    String nombre;
                    System.out.println("Numero con el que desea registrar el pedido: ");
                    int codigo = leer.nextInt();
                    do{
                        System.out.println("Nombre del producto que desea retirar: ");
                        nombre = leer.next();
                        System.out.println("Identificador del producto que desea retirar: ");
                        id = leer.nextInt();
                        System.out.println("Estantes con el producto disponible: ");
                        bodega.ProductoEstanteDisponible(nombre, id);
                        System.out.println("De cual de los estantes desea retirar los productos: ");
                        numEstante_2 = leer.nextInt()-1;                        
                        System.out.println("Cuantas unidades disponibles desea retirar: ");
                        int unidad_2 = leer.nextInt();
                        //generar la factura
                        boolean exito = bodega.RetirarProductos(numEstante_2, unidad_2, nombre, id, codigo);
                        if(exito == true){
                            System.out.println("Los productos fueron retirados con exito");
                        }else{
                            System.out.println("Los productos no fueron retirados con exito");
                        }
                        System.out.println("Desea seguir retirando productos");
                        System.out.println("1- Si");
                        System.out.println("2- No");
                        decision = leer.nextInt();
                        if(decision == 2){
                            bodega.Factura(unidad_2, codigo);
                        }
                    }while(decision == 1);
            }
        }while(c != 3); 
    }
    
}
