/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaliga;

/**
 *
 * @author Juanes
 */
public class PruebaLiga {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Liga liga = new Liga("A");
        //----------------------------------
        Gerente g1 = new Gerente("Juan", 123);
        Equipo e1 = new Equipo("X",g1);
        e1.addJugador("Andres", 789, "Portero");
        liga.addEquipo(e1);
        //----------------------------------
        Gerente g2 = new Gerente("Jorge", 456);
        Equipo e2 = new Equipo("Y", g2);
        e2.addJugador("Camilo", 321, "Alero");
        liga.addEquipo(e2);
        liga.ShowGerentes();
    }
    
}
