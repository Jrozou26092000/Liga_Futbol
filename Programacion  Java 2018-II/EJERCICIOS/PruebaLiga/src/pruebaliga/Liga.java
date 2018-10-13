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
public class Liga {
    private String nombre;
    private ArrayList<Equipo> equipos;

    public Liga(String nombre) {
        this.nombre = nombre;
        this.equipos = new ArrayList<Equipo>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }
    
    public boolean addEquipo(Equipo e){
        return this.equipos.add(e);
    }
    
    public boolean removeEquipo(Equipo e){
        return this.equipos.remove(e);
    }
    
    public void ShowGerentes(){
        for (int i = 0; i < this.equipos.size(); i++) {
            System.out.println("-----------Equipo "+(i+1)+"------------------");
            System.out.println("Nombre: "+this.equipos.get(i).getGerente().getNombre());
            System.out.println("Cedula: "+this.equipos.get(i).getGerente().getCedula());
        }
    }
}
