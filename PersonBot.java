
package colossal;

public class PersonBot extends Person {
    
    private final static int DEF_LIFE_B =20;
    private final static int POWER_B=2;
    
    public PersonBot(String NAME, Place place) {
        super(NAME, place, DEF_LIFE_B);
        //place.addBotPlace(this);
    }
    
    @Override
    public void setNbLife(int nbLife) {};
    
    public PersonBot setNbLifeAttack(int nbLife) {
        if(nbLife <= 0){
            System.out.println("GAME OVER for : "+this.getNAME());
            this.getPosActuel().getLsBotsPlace().remove(this);
            return null;
        }
        super.setNbLife(nbLife); 
        return this;
        
    }
    public void attack(PersonPlayer p){
        
        p.setNbLife(p.getNbLife()-POWER_B);// check err
        System.out.println("bot attacked you ==> nbLife - "+POWER_B + " : "+p.getNbLife() );
        p.attack(this.getNAME());
        
    }  

    public static int getPOWER_B() {
        return POWER_B;
    }
    
    public void chat(int choice){
      switch(choice){
          case 1 : 
              System.out.println("my name is "+this.getNAME());
              break ;
          case 2 :    
              System.out.println("I have "+getPOWER_B()+" of power");
              break ;
          case 3 :    
              System.out.println("I still have "+this.getNbLife()+" points of life");
              break ;
          case 4 :
              System.out.println("good bye !");
              break ;
          default : 
              System.out.println(" I didn't understand,what do you want ? ");
                break;          
      }  
    }
    
    
    
}
