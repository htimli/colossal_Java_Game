/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colossal;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author okohen
 */
public class PersonPlayer extends Person {
    private static final int DEFAULT_LIFE_PL =100;
    private List<Object> lsObjectPlayer;
    private ObjectWeapon currentWeapon;
    
    
    
    public PersonPlayer(String NAME, Place place) {
        super(NAME, place,DEFAULT_LIFE_PL);
        this.lsObjectPlayer = new ArrayList<>();
        this.currentWeapon=new ObjectWeapon("hands");
    }
        public List<Object> getLsObjectPlayer() {
        return lsObjectPlayer;
    }

    
    public void declencherAttack(){
        if(!this.getPosActuel().getLsBotsPlace().isEmpty()){// si bot exist on attack  
            System.out.println("Bot just Attacked YOu");
            PersonBot bot = this.getPosActuel().getLsBotsPlace().get(0);// prevoir plusieur bot  
            if (bot !=null)
               bot.attack(this); //bot attack joueur
        }
    }
    
    public void ChangerPos(String Direction){
        
        System.out.println("From : " + this.getPosActuel().getDescription());
        
        if(this.getPosActuel().isDirection(Direction)){
            
            if(openExit(this.getPosActuel().getExit(Direction))){
                 this.setPosActuel(this.getPosActuel().getNextPlace(Direction)); 
                 
               //  this.declencherAttack();          // si je recois une attack je cherche et j'attaque 
         
            }else{
                
                int lastChar = this.getPosActuel().getExit(Direction).getClass().getSimpleName().length();
                System.out.println("****        §§§§§§§§§§§§§§§§§§§§§§§§§§§                           *********");
                System.out.println("You don't have :" + this.getPosActuel().getExit(Direction).getClass().getSimpleName().substring(8,lastChar));
                System.out.println("****        §§§§§§§§§§§§§§§§§§§§§§§§§§§                           *********");
            }
        }else{
            System.out.println("You can't go  '"+Direction+"' !");
        }
        
        System.out.println("TO :" + this.getPosActuel().getDescription());
        
       
    }
    
//    public void getObject(Object obj){
//        if(obj!=null){
//            this.lsObjectPlayer.add(obj);
//            System.out.println("Object recoverd  " + obj.toString());
//        }
//        
//    }
    
    
    public boolean openExit(Exit ex){
       if(ex instanceof ExitAlwaysOpen)
            return true;
       
       if(ex.isLocked()){
         int lastchar=ex.getClass().getSimpleName().length();
         String name= ex.getClass().getSimpleName().substring(8,lastchar);
                
         Object obj = this.lsObjectPlayer.stream()
                                  .filter(code -> name.equalsIgnoreCase(code.getName()))
                                  .findAny()
                                  .orElse(null);

         if(obj!=null){
             ex.unlock();
             System.out.println("colossal.PersonPlayer.openExit() remove "+this.lsObjectPlayer.remove(obj));
             System.out.println("colossal.PersonPlayer.openExit() state "+ex.isLocked());
             return !ex.isLocked();
         }
         
         return false;
       }
       return true;
        
    }    
    
    
    public void chat(String nameb){
        int choice ;
        System.out.println("In communication with : "+nameb);
        PersonBot bot =(PersonBot) this.getPosActuel().getLsBotsPlace().stream()
                                                                       .filter(x -> x.getNAME().equals(nameb))
                                                                       .findAny()
                                                                       .orElse(null);
        if(bot!=null){
         do{    
            do{
                System.out.println("ask him : ");
                System.out.println("1: his name \n2: his Power \n3:his points of life\n4:to end the discussion\n>");
                Scanner scan = new Scanner(System.in);
                choice = (int)scan.nextInt();
              }while(choice<1 && choice >4);
            bot.chat(choice);
          }while(choice!=4);   
       }else 
            System.out.println("no Bot with this name ");

        }

    
     public void addObjectPersonne(Object obj ){
         System.out.println("{PersonPlayer}:addObjectPersonne");
        if(obj instanceof ObjectChest){
            if(!((ObjectChest)obj).getLsObjectChest().isEmpty()){
                this.lsObjectPlayer.addAll(((ObjectChest) obj).getLsObjectChest()); 
                ((ObjectChest) obj).viderList();
                System.out.println("Chest Bien Vider !");
            }else
                System.out.println("Chest Vide !");
        }
        else {
           this.lsObjectPlayer.add(obj);
           this.getPosActuel().getLsObjectsPlace().remove(obj);
            System.out.println("Object Bien Recuperer");
        }    
    }
     
    public void takeobject(String name){
        Object obj = null;
        obj=this.getPosActuel().getLsObjectsPlace().stream()
                                                   .filter(x -> x.getName().equalsIgnoreCase(name)) 
                                                   .findAny()
                                                   .orElse(null);
        if(obj!=null)
            this.addObjectPersonne(obj);
        else
            System.out.println("Impossible de recuperer ["+name+"]");
        
//      for(Object obj : this.getPosActuel().getLsObjectsPlace()){
//            if(obj.getName().equals(name)) {   
//                this.addObjectPersonne(obj);
//                System.out.println("Object recoverd  " + obj.toString());
//                return;
//            }     
//        }  
    }
    
    
    
    
     public void eat(String name){
        //for(Object obj : this.lsObjectPlayer){
          //  if(obj.getName().equalsIgnoreCase(name) && obj instanceof ObjectFood ) {
          Object f=this.lsObjectPlayer.stream()
                                      .filter(x->x.getName().equalsIgnoreCase(name))
                                      .findAny()
                                      .orElse(null);
          if(f != null && f instanceof ObjectFood ){
                setNbLife(getNbLife()+((ObjectFood)f).getGAIN());
                System.out.println("nblife +"+((ObjectFood)f).getGAIN());
                this.lsObjectPlayer.remove(f);
            } 
         else  
                System.out.println("imppossible de manger ["+name+"]");
    }
    //        for(Object obj : this.lsObjectPlayer){
//            if(obj.getName().equals(nameW) && obj instanceof ObjectWeapon )
//                w=(ObjectWeapon)obj; 
//        }
    public void use(String nameW){
         ObjectWeapon w=(ObjectWeapon) this.lsObjectPlayer.stream()  
                                        .filter(x -> x.getName().equalsIgnoreCase(nameW))
                                        .findAny()
                                        .orElse(null);
         if(w != null){
              this.lsObjectPlayer.remove(w);
              this.currentWeapon = w;
              System.out.println("==>your current Weapon is :"+w.getName());
         }
         else System.out.println("you can't use this Weapon");
    }
    
    //frdi inclus lsbulltet ( chaqueobj bullet  =1 qtasa)
    
    //changement de princie bullte || Bullet= 10 qrtassa
    //==> frdi inclus 1 Bulltets 
    //==> Players (lsobjecptlayer) inlus plusieurs (bullets(nbr=10))
    
    
    public void use2(String nameW){
        ObjectWeaponGun w;
        if(!this.currentWeapon.getName().equals(nameW)){
            this.use(nameW);
        }    
            if(this.currentWeapon instanceof ObjectWeaponGun){
               ObjectBullet b=(ObjectBullet) this.lsObjectPlayer.stream()  
                                        .filter(x -> x instanceof ObjectBullet)
                                        .findAny()
                                        .orElse(null);
               if(b!=null){
                    w=(ObjectWeaponGun)this.currentWeapon;
                    w.load();
                    this.lsObjectPlayer.remove(b);
               }
               else 
                    System.out.println("No bullet in this place");
            }  
            else 
                System.out.println("your current Weapon is not a gun to load it ");
        
        
        
        
    }
     
     
    public void attack(String nameB){
        if(this.getNbLife()>0){
            /*
            Scanner scan = new Scanner(System.in);
            System.out.println("Choose your arme : >");
            String nameW= scan.nextLine();
*/
            PersonBot bot =null;
          //  try{
          /*
                ObjectWeapon w=(ObjectWeapon) this.lsObjectPlayer.stream()  
                                        .filter(x -> x.getName().equalsIgnoreCase(nameW))
                                        .findAny()
                                        .orElse(null);
           */                                 
                        // if(w != null){
                              bot= (PersonBot) this.getPosActuel().getLsBotsPlace().stream()
                                                                                   .filter(x -> x.getNAME().equals(nameB))
                                                                                   .findAny()
                                                                                   .orElse(null);
                            if(bot!=null){
                                System.out.println("botLife - "+this.currentWeapon.getDAMAGE_PTS());
                                bot=bot.setNbLifeAttack(bot.getNbLife() - this.currentWeapon.getDAMAGE_PTS());
                                if(this.currentWeapon instanceof ObjectWeaponGun){
                                      ObjectWeaponGun w=(ObjectWeaponGun)this.currentWeapon;
                                      w.use();
                                      if(w.isEmpty()){
                                          System.out.println("End of bullet ");
                                          this.currentWeapon=new ObjectWeapon("hands");
                                      }        
                                }
                                bot.attack(this);
                            } 
                            else
                                 System.out.println("ce bot n'est pas dans cette place");
                        }else
                            this.attack(nameB);//name bot
                
          //      }catch(Exception ex){
           //         System.out.println("Impossible d'attaquer avec cet objet ");
             //       this.attack(nameB);
                
        }
    //}
    
    
    public void affichePersonne(){
        System.out.println(this.getPosActuel().getDescription());
        if(!this.getPosActuel().getLsObjectsPlace().isEmpty())
              System.out.println(this.getLsObjectPlayer().toString());        
    }
    
    
}
