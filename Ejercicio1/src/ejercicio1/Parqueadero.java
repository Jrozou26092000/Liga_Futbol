/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

/**
 *
 * @author Juanes
 */
import becker.robots.*; 
import java.util.Scanner;
public class Parqueadero {
    private Seccion[][] seccion;
    private Temporal[] temporal;
    private Robot robot;
    private City ciudad;
    
    public Parqueadero() {
       this.seccion = new Seccion[5][3];
       this.temporal = new Temporal[4];
       this.ciudad = new City();
       this.robot = new Robot(ciudad, 6, 7, Direction.WEST);
        for (int i = 1; i <= 3; i++) {
            Wall pared = new Wall(ciudad, 1, i, Direction.NORTH);
        }
        for (int i = 1; i <=5; i++) {
            for (int j = 1; j <= 3; j++) {
                Wall pared= new Wall(ciudad, i, j, Direction.WEST);
            }
        }
        for (int i = 1; i <=5; i++) {
            for (int j = 1; j <= 3; j++) {
                Wall pared= new Wall(ciudad, i, j, Direction.EAST);
            }
        }
        for (int i = 4; i <= 7; i++) {
            Wall pared = new Wall(ciudad, 5, i, Direction.NORTH);
        }
        Wall pared = new Wall(ciudad, 5, 7, Direction.EAST);
        Thing thing = new Thing(ciudad, 6, 7);
        Thing thing1 = new Thing(ciudad, 3, 2);
        Thing thing2 = new Thing(ciudad, 1, 3);
        Thing thing3 = new Thing(ciudad, 3, 3);
        Thing thing4 = new Thing(ciudad, 4, 2);
        Thing thing5 = new Thing(ciudad, 1, 1);
        Thing thing6 = new Thing(ciudad, 4, 3);
        Thing thing7 = new Thing(ciudad, 4, 2);
        Thing thing8 = new Thing(ciudad, 5, 1);
        Thing thing9 = new Thing(ciudad, 2, 2);
    }
    
    public void IngresarVehiculo() {
        Recorrer();
        if(this.robot.canPickThing()==true){
            this.robot.pickThing();
        }
        int vacio = MasVacio();
        for (int i = 0; i < 5 ; i++) {
                if(this.seccion[i][vacio] == null){
                    LlevarCarro(i,vacio);
                    i=6;
                }
        }
    }
    public void Recorrer(){
        Scanner leer = new Scanner(System.in);
        for(int i =0; i<4; i++){
            this.robot.move();
        }
        for (int i = 0; i < 3; i++) {
            this.robot.turnLeft();
        }
        for (int i = 0; i < 3; i++) {
            while(this.robot.frontIsClear()==true){
                this.robot.move();
            }
            for (int j = 0; j < 2; j++) {
            this.robot.turnLeft();
            }
            for (int j = 0; j < 5; j++) {
                if(this.robot.canPickThing()==false){
                    this.seccion[j][i] = null;
                }else{
                    Vehiculo vehiculo  = new Vehiculo(000);
                    this.seccion[j][i] = new Seccion(vehiculo);
                }
                this.robot.move();
            }
            for (int j = 0; j < 3; j++) {
                this.robot.turnLeft();
            }
            this.robot.move();
            for (int j = 0; j < 3; j++) {
                this.robot.turnLeft();
            }
        }
        for (int i = 0; i < 3; i++) {
            this.robot.turnLeft();
        }
        for (int i = 0; i < 7; i++) {
            this.robot.move();
        }
        for (int i = 0; i < 2; i++) {
            this.robot.turnLeft();
        }
    }
    public void LlevarCarro(int i, int j){
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese las placas del vehiculo: ");
        int placa = leer.nextInt();
        /*System.out.println("Hora de ingreso: ");
        System.out.println("Hora: ");
        int hora = leer.nextInt();
        System.out.println("Minutos: ");
        int minutos = leer.nextInt();
        Hora ingreso = new Hora(hora, minutos);*/
        Vehiculo vehiculo = new Vehiculo(placa);
        //vehiculo.VehiculoIngreso(placa, ingreso);
        //this.seccion[i][j] = new Seccion(vehiculo);
        for (int k = 4+j; 0 < k; k--) {
            this.robot.move();
        }
        for (int k = 0; k < 3; k++) {
            this.robot.turnLeft();
        }
        for (int k = 4-i; 0 <= k; k--) {
            this.robot.move();
        }
        this.robot.putThing();
        int a = this.robot.getAvenue();
        int b = this.robot.getStreet();
        if (a == 1) {
            a = 2;
        } else if(a == 2){
            a = 1;
        }else{
            a = 0;
        }
        b-=1;
        this.seccion[b][a] = new Seccion(vehiculo);
        for (int k = 0; k < 2; k++) {
            this.robot.turnLeft();
        }
        for (int k = 4-i; 0 <= k; k--) {
            this.robot.move();
        }
        this.robot.turnLeft();
        for (int k = 4+j; 0 < k; k--) {
            this.robot.move();
        }
        for (int k = 0; k < 2; k++) {
            this.robot.turnLeft();
        }
    }
    public int MasVacio(){
        int a=0;
        for (int i = 0; i < 5; i++) {
            if (this.seccion[i][0] == null) {
                a++;
            }
        }
        int b=0;
        for (int i = 0; i < 5; i++) {
            if (this.seccion[i][1] == null) {
                b++;
            }
        }
        int c=0;
        for (int i = 0; i < 5; i++) {
            if (this.seccion[i][2] == null) {
                c++;
            }
        }
        if(a==b && a==c && a == 5){
            System.out.println("El parqueadero se encuentra lleno en este momento...");
        }
        if (b<=a && c<=a) {
            return 0;
        }else if(a<=b && c<=b){
            return 1;
        }else if(b<=c && a<=c){
            return 2;
        }
        return 0;
    }
    public void SacarVehiculo(){
        Scanner leer = new Scanner(System.in);
        System.out.println("En que seccion se encuentra el vehiculo?");
        int numsec = leer.nextInt();
        numsec-=1;
        System.out.println("Placa del vehiculo?");
        int numplaca = leer.nextInt();
        for (int i = 4+numsec; 0 < i; i--) {
            this.robot.move();
        }
        for (int i = 0; i < 3; i++) {
            this.robot.turnLeft();
        }
        this.robot.move();
        int a = 0;
        for (int i = 4; 0 <= 4; i--) {
            if(this.robot.canPickThing()==false){
                this.robot.move();
                a++;
            }else if( this.seccion[i][numsec].getVehiculo().getPlacas() == numplaca){     
                    this.robot.pickThing();
                    this.robot.turnLeft();
                    this.robot.turnLeft();
                    for (int j = a; 0 <= j; j--) {
                        this.robot.move();
                    }
                    this.robot.turnLeft();
                    for (int j = 4+numsec; 0 < j; j--) {
                        this.robot.move();
                    }
                    for (int j = 0; j < 2; j++) {
                        this.robot.turnLeft();
                    }
                    this.robot.putThing();
                    i= -1;
                }else{
                    a+=1;
                    this.robot.pickThing();
                    this.robot.turnLeft();
                    this.robot.turnLeft();
                    for (int j = a; 0 < j; j--) {
                        this.robot.move();
                    }
                    this.robot.turnLeft();
                    for (int j = 4+numsec; 0 < j; j--) {
                        this.robot.move();
                    }
                    this.robot.turnLeft();
                    LLevarZonaTemporal(numsec,i);
            }
        }
    }
    public void LLevarZonaTemporal(int numsec, int numfila){
        this.robot.move();
        this.robot.turnLeft();
            for (int i = 0; i < 4; i++) {
                if(this.robot.canPickThing()==true){
                    this.robot.move();
                }else{
                    this.robot.putThing();
                    this.robot.turnLeft();
                    this.robot.turnLeft();
                    for (int j = i; 0 < j; j--) {
                        this.robot.move();
                    }
                    for (int j = 0; j < 3; j++) {
                        this.robot.turnLeft();
                    }
                    this.robot.move();
                    for (int k = 0; k < 3; k++) {
                        this.robot.turnLeft();
                    }
                    //----------------------
                    for (int k = 4+numsec; 0 < k; k--) {
                        this.robot.move();
                    }
                    for (int k = 0; k < 3; k++) {
                        this.robot.turnLeft();
                    }
                    //Aqui quede el robot sigue mas casillas y se mata, analizar numfila que se manda desde el otro metodo
                    for (int k = 5-numfila; 0 <= k; k--) {
                        this.robot.move();
                    }
                    i=5;
                }
            }
    }
}
