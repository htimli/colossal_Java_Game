/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colossal;

/**
 *
 * @author User
 */
public class ObjectBullet extends Object {
     private final static String DEFAULT_NAME="Bullet";

    public ObjectBullet() {
        super(DEFAULT_NAME);
    }
   

    @Override
    public void info(String Name) {
        System.out.println("Nothing special aboit this bullet");
    }
    
}
