
package colossal;


public class ObjectFood extends Object{
    
    private final int GAIN ;
    private static final int DEFAULT_GAIN =10;
   
    public ObjectFood(String name){
        super(name);
        this.GAIN=DEFAULT_GAIN;
    }
    public ObjectFood(int gain, String name){
        super(name);
        this.GAIN = gain;
    }

    public int getGAIN() {
        return this.GAIN;
    }

    @Override
    public void info(String Name) {
        System.out.println("Nothing special aboit this food");
    }

    
    
    
    
    
    
}
