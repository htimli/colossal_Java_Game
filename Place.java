/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colossal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collector;

/**
 *
 * @author okohen
 */
public class Place {
    private static int  cpt=0;
    private final int ID_PLACE;
    private  final String DESCRIPTION;
    private List<Object> lsObjectsPlace;
    private List <PersonBot> lsBotsPlace ;
    private final Map<String,Exit> MAP_EXITS_PLACE;

    public Place(String description, List<Object> lsObject , List <PersonBot> lsBots) {
        this.ID_PLACE = cpt;
        this.DESCRIPTION = description;
        this.lsObjectsPlace = lsObject;
        this.MAP_EXITS_PLACE = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        this.lsBotsPlace=lsBots;
        cpt++;
    }
    
    public List<Object> getLsObjectsPlace() {
        return lsObjectsPlace;
    }

    public List<PersonBot> getLsBotsPlace(){
        return lsBotsPlace;
    }
    
    public void addObjectPlace(Object object){
        //if(this.lsBotsPlace==null)
          // this.lsObjectsPlace=new ArrayList<>();// prevoir une exception
        this.lsObjectsPlace.add(object);    //le cas ou lsobjplace est non instancié
    } 
    
    public void addBotPlace(PersonBot bot){
       // if(this.lsBotsPlace==null)
        //  this.lsBotsPlace=new ArrayList<>();
        this.lsBotsPlace.add(bot);//la aussi
        bot.setPosActuel(this);
    }
    
    
    public void addExitPlace(String direction, Exit ex ){
        this.MAP_EXITS_PLACE.put(direction, ex);
        ex.AddVoisin(this);      
    }

    public boolean isDirection(String Direction){
        return MAP_EXITS_PLACE.containsKey(Direction);
    }
    
//    public Object getObject(){
//        if(lsObjectsPlace.size()>0){
//            Object obj = lsObjectsPlace.get(0);
//            lsObjectsPlace.remove(0);
//            return obj;
//        }else{
//            System.out.println("0 Object to recover");
//            return null;
//        }
//    }
    
    
    
    public Exit getExit(String Direction){
        return MAP_EXITS_PLACE.get(Direction);
    }
    
    public Place getNextPlace(String Direction) {
        for(int i=0;i<2;i++) // a refaire
            if(this.ID_PLACE!=MAP_EXITS_PLACE.get(Direction).getLsPlaceVoisin().get(i).ID_PLACE)
                  return MAP_EXITS_PLACE.get(Direction).getLsPlaceVoisin().get(i);
        return null;
    }
          
    
    public void AfficherExitdisp(){
        System.out.println(MAP_EXITS_PLACE);
    }

    public String getDescription() {
        return DESCRIPTION;
    }

    
     public void affichePlace(){
        System.out.println(this.DESCRIPTION);
        System.out.println("les objects qui sont dispo dans cette salle : ");
        System.out.println(this.lsObjectsPlace);
        System.out.println("les exits dispo :");
        System.out.println(this.MAP_EXITS_PLACE.keySet().toString().toUpperCase());
        System.out.println("les bots dispo:");
        System.out.println(this.getLsBotsPlace());
    }

    public void getinfo(String Name){
        
        System.out.println("Info ["+Name+"]");
        
        Object obj=this.lsObjectsPlace.stream()
                .filter(x -> x.getName().equalsIgnoreCase(Name))
                .findAny()
                .orElse(null);
 
        if(obj !=null){
            obj.info(Name);
        }else
            System.out.println("object does not exist in chest");
    }
    
    
    

    
    
    
}
