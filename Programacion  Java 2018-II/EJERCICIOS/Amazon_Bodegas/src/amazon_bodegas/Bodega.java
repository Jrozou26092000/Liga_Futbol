/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amazon_bodegas;
import becker.robots.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Juanes
 */
public class Bodega {
    private String nombre;
    //La Bodega cuenta con un arreglo de 20 estantes representados por un thing
    private Estante[] estante;
    //Actualmente la Bodega cuenta con 10 robots para realizar trabajos de preparacion de pedidos 
    private RobotBodega[] robot;
    private City ciudad;
    //La Bodega puede realizar varios pedidos
    private ArrayList<Pedido> pedidos;
   
    public Bodega(String nombre){
        this.nombre = nombre;
        this.estante = new Estante[20];
        this.robot = new RobotBodega[10];
        this.ciudad = new City();
        this.pedidos = new ArrayList<Pedido>();
        
        for (int i = 0; i < 4; i++) {
            Wall wall = new Wall(ciudad, i, 0, Direction.WEST);
        }
        for (int i = 0; i < 10; i++) {
            Wall wall = new Wall(ciudad, 0, i, Direction.NORTH);
        }
        for (int i = 0; i < 10; i++) {
            Wall wall = new Wall(ciudad, 3, i, Direction.SOUTH);
        }
        Wall wall_1 = new Wall(ciudad, 3, 9, Direction.EAST);
        Wall wall_2 = new Wall(ciudad, 0, 9, Direction.EAST);
        for (int i = 0; i < 10; i++) {
            Wall wall = new Wall(ciudad, i, 14, Direction.EAST);
        }
        Wall wall_3 = new Wall(ciudad, 0, 14, Direction.NORTH);
        Wall wall_4 = new Wall(ciudad, 9, 14, Direction.SOUTH);
        for (int i = 1; i < 10; i+=2) {
            Wall wall = new Wall(ciudad, 10, i, Direction.SOUTH);
        }
        for (int i = 1; i < 10; i++) {
            Wall wall = new Wall(ciudad, 10, i, Direction.NORTH);
        }
        for (int i = 2; i < 10; i+=2) {
            Thing thing = new Thing(ciudad, 11, i);
            thing.setColor(Color.red);
        }
    }
    
    public boolean addPedido(Pedido p){
        return this.pedidos.add(p);
    }
    public boolean removePedido(Pedido p){
        return this.pedidos.remove(p);
    }
    public void RegistroEstantes(){
        //Se hace el registro de cada estante con su identificador, su fila y
        //columna. Ademas se crea el thing por el cual está representado.
        for (int i = 0; i < 20; i++) {
            if(i<10){
                Thing thing = new Thing(ciudad, 0, i);
                this.estante[i]= new Estante((i+1),0,i);
            }else{
                Thing thing = new Thing(ciudad, 3, i-10);
                this.estante[i]= new Estante((i+1),3,i-10);
            } 
        }
    }
    public void RegistroRobot(){
        //Se crea cada robot de la fabrica con su respectivo identificador
        for (int i = 0; i < 10; i++) {
            this.robot[i] = new RobotBodega((i+1),ciudad, i, 14, Direction.WEST);
        }
    }
    
    public int Dsiponibilidad(int numEstante){
        //Se retornara la cantidad de espacios vacios para guardar productos
        Producto[] productos = this.estante[numEstante].getProductos();
        int c =0;
        for (int i = 0; i < 21; i++) {
            if(productos[i] == null){
                c++;
            }
        }
        return c;
    }
    public boolean LlenarEstante(Producto p, int numEstante){
        //Se crea un arreglo de productos que corresponde al arreglo que almacena
        // el esatante con el fin de poder determinar que espacio hay o no disponibles
        Producto[] productos = this.estante[numEstante].getProductos();
        //Se creo la varible c con el fin de determinar si hay o no espacios disponibles
        //de tal manera que si todos los espacios son nulos c = 21 se da por terminado el metodo
        int c = 0;
        for (int i = 0; i < 21; i++) {
            if(productos[i] != null){
                c++;
            }
        }
        if(c == 21){
            return false;
        }
        //Si hay espacios disponibles entonces se le asignara el producto que se 
        //recibio como parametro a una posicion del nuevo arreglo de productos
        for (int i = 0; i < 21; i++) {
            if( productos[i] == null){
                productos[i] = p;
                //Se modifican los productos del estante con el procedimiento anteriormente hecho
                //y se retorna verdadero para agregar el producto que se recibio como parametro
                //y acabar el ciclo
                this.estante[numEstante].setProductos(productos);
                return true;
            }
        }
        return true;
    }
    //-------------------------------------------------------------------------
    public void ProductosEstante(int numEstante){
        Producto[] productos = this.estante[numEstante].getProductos();
        for (int i = 0; i < 21; i++) {
            if(productos[i] == null){
                System.out.println((i+1)+"- : vacio");
            }else{
                System.out.println((i+1)+"- Nombre: "+productos[i].getNombre());
                System.out.println("Codigo: "+productos[i].getCodigo());
            }
        }
    }
    //-------------------------------------------------------------------------
    public void CantidadProductosEstante(int numEstante,String nombre, int id){
        Producto[] productos = this.estante[numEstante].getProductos();
        int c = 0;
        for (int i = 0; i < 21; i++) {
            if(productos[i] != null ){
                if((productos[i].getNombre().equals(nombre))&&(productos[i].getCodigo()==id)){
                    c++;
                }
            }
        }
        System.out.println("Cantidad de productos disponibles en el estante: "+c);
    }
    public boolean RetirarProductos(int numEstante, int unidades, String nombre, int id, int codigo, Cliente cliente){
        Producto[] productos = this.estante[numEstante].getProductos();
        Pedido pedido = null;
        boolean pedidoExistente = true;
        if(!this.pedidos.isEmpty()){
            for (int i = 0; i < this.pedidos.size(); i++) {
                if(this.pedidos.get(i).getId() == codigo){
                    pedido = this.pedidos.get(i);
                }
            }
        }else{
            pedidoExistente = false;
            pedido = new Pedido(codigo,cliente);
        }
        
        for (int i = 0; i < 21; i++) {
            if(productos[i] != null){
                if((productos[i].getNombre().equals(nombre)) && (productos[i].getCodigo() == id)){
                    pedido.addProducto(productos[i]);
                    unidades-=1;
                    productos[i] = null;
                }
            }
            if((unidades == 0) && (pedidoExistente== false)){
                this.estante[numEstante].setProductos(productos);
                this.pedidos.add(pedido);
                ProductosEstante(numEstante);
                return true;
            }else if(unidades == 0){
                this.estante[numEstante].setProductos(productos);
                ProductosEstante(numEstante);
                return true;
            }
        }
        return false;
    }
    public void ProductoEstanteDisponible(String nombre, int id){
        for (int i = 0; i < 20; i++) {
            Producto[] productos = this.estante[i].getProductos();
            for (int j = 0; j < 21; j++) {
                if(productos[j] != null ){
                    if((productos[j].getNombre().equals(nombre))&&(productos[j].getCodigo()==id)){
                        System.out.println("Producto disponible en estante: "+(i+1));
                        CantidadProductosEstante(i,nombre,id);
                        j=21;
                    }
                }
            }
        }
    }
    public boolean Factura(int unidades, int codigo, int cedula){
        System.out.println("------------------------Factura----------------------");
        ArrayList<Producto> p = null;
        for (int i = 0; i < this.pedidos.size(); i++) {
           if((this.pedidos.get(i).getId() == codigo)&&(this.pedidos.get(i).getCliente().getCedula()== cedula)){
               Cliente cliente = this.pedidos.get(i).getCliente();
               System.out.println("                 Cliente             ");
               System.out.println("Nombre: "+cliente.getNombre());
               System.out.println("Cedula: "+cliente.getCedula());
               p = this.pedidos.get(i).getProducto();
           }
        }
        double costo = 0;
        for (int i = 0; i < p.size(); i++) {
            System.out.println("Producto: "+ "      Costo(unidad): ");
            System.out.println(p.get(i).getNombre()+"                "+p.get(i).getPrecio());
            costo = costo +p.get(i).getPrecio();
        }
        System.out.println("TOTAL: "+ costo);
        System.out.println("-----------------------------------------------------");
        return false;
    }
    public void Recorridos(int numEstante,int opcion){
        int robotDisponible = 0;
        int fila = this.estante[numEstante].getFila();
        int columna = this.estante[numEstante].getColumna();
        if(opcion == 0){
        for (int i = 0; i < 10; i++) {
            if(this.robot[i].getStreet()== 14){
                robotDisponible = i;
            }
        }
        this.robot[robotDisponible].RecorridoIda(fila,columna);
        }else if(opcion == 1){
            this.robot[0].RecorridoVuleta(fila, columna);
        }
    }
}
    