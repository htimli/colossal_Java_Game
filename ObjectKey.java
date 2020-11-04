/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colossal;

/**
 *
 * @author okohen
 */
public class ObjectKey extends Object {
    
    private static final String DEFAULT_NAME="KEY";
    
    public ObjectKey() {
        super(DEFAULT_NAME);
    }

    @Override
    public void info(String Name) {
        System.out.println("Nothing special aboit this Key");
    }
    
}
