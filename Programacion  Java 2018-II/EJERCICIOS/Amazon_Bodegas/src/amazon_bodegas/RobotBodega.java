/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amazon_bodegas;

import becker.robots.*;

/**
 *
 * @author Juanes
 */
public class RobotBodega extends Robot{
    
    private int id;
    private Robot robot;
    public RobotBodega(int id, City city, int i, int i1, Direction drctn) {
        super(city, i, i1, drctn);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    /*public void RecorridoIda(int fila, int columna){
        this.robot.move();
        if(this.robot.getAvenue() == 1){
            this.robot.turnLeft();
            this.robot.move();
            for (int i = 0; i < 3; i++) {
                this.robot.turnLeft();
            }
            while(this.robot.getStreet() != columna){
                this.robot.move();
            }
            if(fila == 0){
                for (int i = 0; i < 3; i++) {
                    this.robot.turnLeft();
                }
                this.robot.move();
                this.robot.pickThing();
                for (int i = 0; i < 3; i++) {
                    this.robot.turnLeft();
                }
            }else{
                
            }
        }
    }
    public void RecorridoVuleta(int fila, int columna){
        
    }*/
}
