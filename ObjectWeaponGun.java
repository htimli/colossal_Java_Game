/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colossal;

import java.util.ArrayList;
import java.util.List;


public class ObjectWeaponGun extends ObjectWeapon{
    private List<ObjectBullet> lsBullet;
    
    //private int maxBullet; 
    
    public ObjectWeaponGun(String name) {
        super(name);
        this.lsBullet=new ArrayList<>();
        for(int i=0;i<5;i++)
            this.lsBullet.add(new ObjectBullet());
    }

    public ObjectWeaponGun(int DAMAGE_PTS, String name) {
        super(DAMAGE_PTS, name);
        this.lsBullet=new ArrayList<>();
        for(int i=0;i<5;i++)
            this.lsBullet.add(new ObjectBullet());
    }
    
    public void use(){
        this.lsBullet.remove(0);
    }
    public boolean isEmpty(){
        return this.lsBullet.isEmpty();
    }
    public void load(){
            this.lsBullet.add(new ObjectBullet());
            System.out.println("GUN :loaded ++");
    }
    
    
}
