/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaliga;

import java.util.ArrayList;

/**
 *
 * @author Juanes
 */
public class Equipo {
    private String nombre;
    private Gerente gerente;
    private ArrayList<Jugador> jugadores;

    public Equipo(String nombre, Gerente gerente) {
        this.nombre = nombre;
        this.gerente = gerente;
        this.jugadores = new ArrayList<Jugador>();
    }

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }
     public boolean addJugador(String nombre, int cedula,String posicion){
        return this.jugadores.add(new Jugador(nombre,cedula,posicion));
    }
}
