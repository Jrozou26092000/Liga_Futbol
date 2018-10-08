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
}
