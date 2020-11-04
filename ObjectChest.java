
package colossal;

import java.util.ArrayList;
import java.util.List;


public class ObjectChest extends Object{
    
    private List<Object> lsObjectChest;
            
    public ObjectChest(String name) {
        super(name);
        this.lsObjectChest=new ArrayList();
    }
    public void addObject(Object obj){
        this.lsObjectChest.add(obj);
    }
    public boolean haveInChest(Object obj){
        return this.lsObjectChest.contains(obj);
    }
    
    public void viderList(){
        this.lsObjectChest.clear();       
    }
    
    public List<Object> getLsObjectChest() {
        return lsObjectChest;
    }

   

    @Override
    public void info(String Name) {
        System.out.println(this.getName());
        
        System.out.println("Info ["+Name+"]");
        
        Object obj=this.lsObjectChest.stream()
                .filter(x -> x.getName().equals(Name.toUpperCase()))
                .findAny()
                .orElse(null);
 
        if(obj !=null){
            obj.info(Name);
        }else
            System.out.println("object does not exist in chest");

    }
    
   
    
    
}
