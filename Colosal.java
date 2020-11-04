/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colossal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author okohen
 */
public class Colosal {

    /**
     * @param args the command line arguments
     */
    
    public final static void clearConsole()
{
//        System.out.print("\033[H\033[2J");  
//        System.out.flush();  
    try
    {
        final String os = System.getProperty("os.name");

        if (os.contains("Windows"))
        {
            Runtime.getRuntime().exec("cls");
        }
        else
        {
            Runtime.getRuntime().exec("clear");
        }
    }
    catch (final Exception e)
    {
        //  Handle any exceptions.
    }
}
    public static void byby(){
        System.out.println("====================================================================");
        System.out.println("==============          SEE YOU LATER              =================");
        System.out.println("====================================================================");
    }
    
    
    
    public static void main(String[] args) {
    /*   
       Object obj1= new ObjectKey();
       Object obj2 = new ObjectCode();
             
       List<Object> malistep1 = new ArrayList<>();
       malistep1.add(obj1);
       malistep1.add(obj2);
       
       List<Object> malistep2 = new ArrayList<>();
       malistep2.addAll(malistep1);
       
       Place p1 = new Place("Salle 1",malistep1);//k c
       Place p2 = new Place("Salle 2",malistep2);//k c
       Place p3 = new Place("Salle 3",malistep1);//k c
       
       ExitWithKey e1= new ExitWithKey();  ///  P1 ----   P2
       e1.AddVoisin(p1);
       e1.AddVoisin(p2);
       
       ExitWithCode e2= new ExitWithCode();
       e2.AddVoisin(p1);
       e2.AddVoisin(p3);
     
       p1.addExitPlace("Haut".toUpperCase(), e1);
       p1.addExitPlace("Droit".toUpperCase(),e2);
       
       p2.addExitPlace("Bas".toUpperCase(), e1);
       
       p3.addExitPlace("Gauche".toUpperCase(), e2);
    
       ObjectChest objchest= new ObjectChest("C1");
       objchest.addObject(obj1);
       objchest.addObject(obj2);
       p1.addObjectPlace(objchest);
       
       PersonPlayer omar = new PersonPlayer("Omar", p1);
       

       Scanner scan = new Scanner(System.in);
       String commande;
       String[] words;
       Command com = null ;
       do{
           System.out.print("> ");
            commande= scan.nextLine();
            words=commande.split(" ");
            try {
             
            System.out.println("===============================================================================================");
            omar.getPosActuel().affichePlace();
            System.out.println("===============================================================================================");
                
            com = Command.valueOf(words[0].toUpperCase());
            switch(com){
                
                case GO: omar.ChangerPos(words[1].toUpperCase()); break;
                case TAKE:
                             for(int i =1; i<words.length ;i++)
                                omar.takeobject(words[i].toUpperCase());
                             break;
                case LOOK:  
                            for(int i =1; i<words.length ;i++)
                                omar.getPosActuel().getinfo(words[i].toUpperCase());
                             break;
                            
                case HELP: break;
                case USE: break;              
                case QUIT : byby(); break;
                default : System.out.println("Not in Commande");
             }
             
            }catch(Exception ex){
                
                 System.out.println("Please retry");
             
            }
           
            clearConsole();

        }while(com!=Command.QUIT);
 
       
    
      */
    
    Building b = new Building();
    b.initBuilding();
        
       
        
       
    
    }
    
}
