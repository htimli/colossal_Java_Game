
package colossal;

public class ObjectWeapon extends Object {
    
    private final int DAMAGE_PTS;
    private static final int DEFAULT_DAMAGE_PTS=5;
    
    public ObjectWeapon(String name){
        super(name);
        this.DAMAGE_PTS=DEFAULT_DAMAGE_PTS;
    }

    public ObjectWeapon(int DAMAGE_PTS,String name) {
        super(name);
        this.DAMAGE_PTS = DAMAGE_PTS;
    }

    public int getDAMAGE_PTS() {
        return DAMAGE_PTS;
    }

    @Override
    public void info(String Name) {
       System.out.println("Nothing special aboit this Weapon");
    }
    
    
    
}
