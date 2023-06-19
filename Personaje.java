/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stratego;

/**
 *
 * @author Dell
 */
public class Personaje {
    String Nombre;
    int Rango; //Bomba 11 Bandera = 12
    boolean Heroe_Villano;
    boolean Vivo;
    int ID;
    boolean Oculto=true;
    
    public Personaje(int ID, String nom, int ran, boolean HV){
        Nombre=nom;
        Rango=ran;
        Heroe_Villano=HV;
        this.ID=ID;
        Vivo=true;
    }

    
    //GETTER
    public String getNombre() {
        return Nombre;
    }

    public int getRango() {
        return Rango;
    }

    public boolean isHeroe_Villano() {
        return Heroe_Villano;
    }

    public int getID() {
        return ID;
    }

    public boolean isVivo() {
        return Vivo;
    }

    public boolean isOculto() {
        return Oculto;
    }

    
    
    
    
    //SETTER
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setRango(int Rango) {
        this.Rango = Rango;
    }

    public void setHeroe_Villano(boolean Heroe_Villano) {
        this.Heroe_Villano = Heroe_Villano;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setVivo(boolean Vivo) {
        this.Vivo = Vivo;
    }

    public void setOculto(boolean Oculto) {
        this.Oculto = Oculto;
    }
            
    
    
    
}
