/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colossal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author okohen
 */
public abstract class Exit {
    //des portes toujours ouvertes, des portes qui nécessitentune clé ou un code secret.
    private final List<Place> lsPlaceVoisin;   
    private boolean locked;

    public List<Place> getLsPlaceVoisin() {
        return lsPlaceVoisin;
    }

    public Exit() {
        this.lsPlaceVoisin=new ArrayList<>();
        this.locked=true;
    }
    
    public void unlock(){
        this.locked=false;
    }
    
    public boolean isLocked(){
        return this.locked;
    }
    
    public void AddVoisin(Place P){
        if(lsPlaceVoisin.size()<=4 && !lsPlaceVoisin.contains(P))
            this.lsPlaceVoisin.add(P);
        else 
            System.out.println("Erreur Exit Contiens deja 4 place");
    }
    
    
}
