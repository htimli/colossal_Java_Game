
package colossal;


public abstract class Person {
    private final String NAME;
    private int nbLife; 
    private Place posActuel;

    public Person(String NAME, Place place, int life) {
        this.NAME = NAME;
        this.posActuel=place;
        this.nbLife=life;
    }

    public Place getPosActuel() {
        return posActuel;
    }

    public int getNbLife() {
        return this.nbLife;
    }

    public String getNAME() {
        return NAME;
    }
    
    public void setPosActuel(Place posActuel) {
        this.posActuel = posActuel;
    }

    public void setNbLife(int nbLife) {
        if(this.nbLife>0)
            this.nbLife = nbLife;
        else {
            this.nbLife=0;
            this.posActuel=null;
            
            System.out.println(this.NAME+": § GAME OVER  §");
        }  
    }

    @Override
    public String toString() {
        return "{" + "NAME=" + NAME + ", nbLife=" + nbLife + ", posActuel=" + posActuel + '}';
    }
    
    
            
            
            
            
            
}

