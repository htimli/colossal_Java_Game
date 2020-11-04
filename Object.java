/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colossal;

import java.util.Objects;

/**
 *
 * @author okohen
 */
public abstract class Object {
    private final String NAME;
    
    public String getName() {
        return NAME;
    }
    
    public Object(String nom) {
        this.NAME = nom;
    }

    
    
    @Override
    public String toString() {
        return NAME; 
    }
    
    @Override
    public boolean equals(java.lang.Object obj) {
        return ((Object)obj).getName()==this.getName();
    }
    
    
    public abstract void info(String Name);
}
