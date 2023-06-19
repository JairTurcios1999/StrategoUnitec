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
public class Logs {
    String Ganador;
    String Perdedor; 
    
    String RazondeVictoria;
    
    String Fecha;
    boolean Heroe_Villano;
    
    public Logs(String ganador, String perdedor, String razon, boolean heroe_villano){
        
        Heroe_Villano=heroe_villano;
            Ganador = ganador;
     Perdedor = perdedor; 
    
     RazondeVictoria = razon;
    
    
        
        
        
        
    }
    
    public String obtenerLogCompleto(String Usuario){
     String LogCompleto ="";
        
        if(this.Ganador == Usuario || this.Perdedor == Usuario ){
             LogCompleto = this.RazondeVictoria;
        }
        
        return LogCompleto;
    }
    
    
    public String obtenerLogHeroes_Ganados(){
     String LogCompleto ="";
        
        if(this.Heroe_Villano==true){
             LogCompleto = this.Ganador+" - "+this.Perdedor+" - "+this.RazondeVictoria+" - "+this.Fecha;
        }
        
        return LogCompleto;
    }
    
    
     public String obtenerLogVillanos_Ganados(){
     String LogCompleto ="";
        
        if(this.Heroe_Villano==false){
             LogCompleto = this.Ganador+" - "+this.Perdedor+" - "+this.RazondeVictoria+" - "+this.Fecha;
        }
        
        return LogCompleto;
    }
    
    
}
