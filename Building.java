
package colossal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Building {
    private final List <Place> LS_PLACE_B ;    //composition
    private PersonPlayer playerB ;    //agregation  

    public Building() {
        
        this.LS_PLACE_B = new ArrayList<>();
    }
    
    public void addPlace(Place place){
        this.LS_PLACE_B.add(place);
    }
    
    public PersonPlayer initPlayer(String name , Place place){
        return new PersonPlayer(name, place);
    }
    
    public void initBuilding(){
        Place p1,p2,p3,p4,p5,p6,p7,p8,p9;
        //instatation des places
        
        p1=new Place("ROOM 1 ",new ArrayList<>(),new ArrayList<>());
        p2=new Place("ROOM 2 ",new ArrayList<>(),new ArrayList<>());
        p3=new Place("ROOM 3 ",new ArrayList<>(),new ArrayList<>());
        p4=new Place("ROOM 4 ",new ArrayList<>(),new ArrayList<>());
        p5=new Place("ROOM 5 ",new ArrayList<>(),new ArrayList<>());
        p6=new Place("ROOM 6 ",new ArrayList<>(),new ArrayList<>());
        p7=new Place("ROOM 7 ",new ArrayList<>(),new ArrayList<>());
        p8=new Place("ROOM 8 ",new ArrayList<>(),new ArrayList<>());
        p9=new Place("ROOM 9 ",new ArrayList<>(),new ArrayList<>());
        //instantation des portes
        ExitWithCode e12 =new ExitWithCode();
        ExitWithCode e36 =new ExitWithCode();
        ExitWithCode e45 =new ExitWithCode();
        ExitWithCode e89 =new ExitWithCode();
        
        ExitWithKey e23 =new ExitWithKey();
        ExitWithKey e47 =new ExitWithKey();
        ExitWithKey e58 =new ExitWithKey();
        ExitWithKey e69 =new ExitWithKey();
        
        ExitAlwaysOpen e14=new ExitAlwaysOpen();
        ExitAlwaysOpen e25=new ExitAlwaysOpen();
        ExitAlwaysOpen e56=new ExitAlwaysOpen();
        ExitAlwaysOpen e78=new ExitAlwaysOpen();
        //ajout des portes au places
        p1.addExitPlace("RIGHT",e12);
        p1.addExitPlace("DOWN",e14);
        
        p2.addExitPlace("LEFT",e12);
        p2.addExitPlace("DOWN",e25);
        p2.addExitPlace("RIGHT",e23);
        
        p3.addExitPlace("DOWN",e36);
        p3.addExitPlace("LEFT",e23);
        
        p4.addExitPlace("UP",e14);
        p4.addExitPlace("RIGHT",e45);
        p4.addExitPlace("DOWN",e47);
        
        p5.addExitPlace("UP",e25);
        p5.addExitPlace("RIGHT",e56); //// ajout addvoisin f add exit place pour omar <-----
        p5.addExitPlace("LEFT",e45);
        p5.addExitPlace("DOWN",e58);
        
        p6.addExitPlace("UP",e36);
        p6.addExitPlace("LEFT",e56);
        p6.addExitPlace("DOWN",e69);
        
        p7.addExitPlace("UP",e47);
        p7.addExitPlace("RIGHT",e78);
        
        p8.addExitPlace("UP",e58);
        p8.addExitPlace("RIGHT",e89);
        p8.addExitPlace("LEFT",e78);
        
        
        p9.addExitPlace("UP",e69);
        p9.addExitPlace("LEFT",e89);
        
        //ajout des botes pour les places 
        
        p2.addBotPlace(new PersonBot ("bot1", p2));
        p3.addBotPlace(new PersonBot ("bot2", p3));
        p5.addBotPlace(new PersonBot ("bot3", p5));
        p5.addBotPlace(new PersonBot ("bot4", p5));
        p6.addBotPlace(new PersonBot ("bot5", p6));
        p7.addBotPlace(new PersonBot ("bot6", p7));
        p8.addBotPlace(new PersonBot ("bot7", p8));
        
        //ajout des objet pour les places 
       
       //p1.initbotsPlace();
        p1.addObjectPlace(new ObjectWeapon(10,"sword"));
        p1.addObjectPlace(new ObjectCode());
        p1.addObjectPlace(new ObjectWeaponGun(7,"GUN"));
        p1.addObjectPlace(new ObjectBullet());
        //p1.addObjectPlace(new ObjectWeapon(10,"sword"));
        
        p2.addObjectPlace(new ObjectKey());
        p2.addObjectPlace(new ObjectCode());
        p2.addObjectPlace(new ObjectFood("cake"));
        
        ObjectChest c1=new ObjectChest("chest1");
        c1.addObject(new ObjectWeapon(20,"gun"));
        c1.addObject(new ObjectKey());
        p3.addObjectPlace(c1);
        
        
        p4.addObjectPlace(new ObjectCode());
        p4.addObjectPlace(new ObjectKey());
        
        
        p5.addObjectPlace(new ObjectFood(10,"sandwich"));
        p5.addObjectPlace(new ObjectKey());
        
        ObjectChest c2=new ObjectChest("chest2");
        c2.addObject(new ObjectCode());
        p6.addObjectPlace(c2);
        
        p7.addObjectPlace(new ObjectFood(2,"apple"));
        
        
        /*
        ObjectWeapon w =new ObjectWeapon("fusil".toUpperCase());
        ObjectChest c=new ObjectChest("coffre");
        c.addObject(w);
        List<Object> lsObject1= new ArrayList<>();
        lsObject1.add(new ObjectWeapon("sword"));//
        lsObject1.add(new ObjectKey());          //     room1 : key , code , sword 
        lsObject1.add(new ObjectCode());        //
        List<Object> lsObject2= new ArrayList<>();   //============Exit with code 1->2  HAUT 
        lsObject2.add(c);                       //*
        lsObject2.add(new ObjectCode());        //*     room2 : code ,cake , chest 
        lsObject2.add(new ObjectFood("cake"));  //*
        
        p1=new Place("ROOM 1 ",lsObject1);
        p2=new Place("ROOM 2 ",lsObject2);
        
        p2.addBotPlace(new PersonBot ("bot1", p2));//*  room2 :    bot1
        this.addPlace(p1);
        this.addPlace(p2);
        ExitWithCode e12 =new ExitWithCode();
        e12.AddVoisin(p2);
        p1.addExitPlace("HAUT",e12);
        p2.addExitPlace("BAS", e12);
        
        */
        PersonPlayer omar= initPlayer("Hassan", p1);
  
        
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
                
                case GO: omar.ChangerPos(words[1]); break;
                case TAKE:
                             for(int i =1; i<words.length ;i++)
                                omar.takeobject(words[i]);
                            break;
                case LOOK:  
                            for(int i =1; i<words.length ;i++)
                                omar.getPosActuel().getinfo(words[i]);
                            break;
                            
                case HELP: 
                            System.out.println("Available orders :");
                            for(Command c:Command.values())
                                System.out.println(c);
                            break;
                case TALK_WITH :
                            omar.chat(words[1]);
                            break;
                case ATTACK :
                            omar.attack(words[1]);
                            break;
                case EAT :
                            for(int i =1; i<words.length ;i++)
                                omar.eat(words[i]);
                            break;
                case USE: 
                           if(words.length > 2 ){
                               if("bullet".equalsIgnoreCase(words[2]))
                                omar.use2(words[1]); 
                            }
                           else
                                omar.use(words[1]); 
                           break;              
                case QUIT : byby(); break;
                default : System.out.println("Not in Commande");
             }
             
            }catch(Exception ex){
                
                 System.out.println("Please retry");
             
            }
           
            

        }while(com!=Command.QUIT);
 
       
    }
    
    
     public static void byby(){
        System.out.println("====================================================================");
        System.out.println("==============          SEE YOU LATER              =================");
        System.out.println("====================================================================");
    }
    
  
    
}
