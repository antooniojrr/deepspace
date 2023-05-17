/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;
import java.util.ArrayList;

/**
 *
 * @author david
 */
public class Hangar {
    private int maxElements;
    private ArrayList<Weapon> weapons = new ArrayList();
    private ArrayList<ShieldBooster> shieldBoosters= new ArrayList();
    
    Hangar(int capacity){maxElements = capacity;}
    Hangar(Hangar h){
        this.maxElements = h.getMaxElements();
        for (Weapon w : h.weapons)
            addWeapon(w);
        for (ShieldBooster s : h.shieldBoosters)
            addShieldBooster(s);
    }
    
    HangarToUI getUIversion(){return new HangarToUI(this);}
    
    public int getMaxElements(){return maxElements;}
    
    public ArrayList<ShieldBooster> getShieldBoosters(){return shieldBoosters;}
    
    public ArrayList<Weapon> getWeapons(){return weapons;}
    
    
    private boolean spaceAvailable(){
        return(weapons.size() + shieldBoosters.size() < getMaxElements());
    }
    
    boolean addWeapon(Weapon w){
        boolean possible = spaceAvailable(); 
        if (possible){
            weapons.add(w);
        }
        return possible;        
    }
    
    boolean addShieldBooster(ShieldBooster s){
        boolean possible = spaceAvailable(); 
        if (possible){
            shieldBoosters.add(s);
        }
        return possible;        
    }
    
    Weapon removeWeapon(int i){
        if (i >= 0 && i < weapons.size()){
            Weapon w = weapons.get(i);
            weapons.remove(i);
            return w;
        }
        else return null; 
    }
    
    ShieldBooster removeShieldBooster(int i){
        if (i >= 0 && i < shieldBoosters.size()){
            ShieldBooster s = shieldBoosters.get(i);
            shieldBoosters.remove(s);
            return s;
        }
        else return null;
    }
    
    public String toString() {
        String out = "Max Elements: " + maxElements + ", Weapons: ";
        out += weapons.toString() + ", Shields: ";
        out += shieldBoosters.toString();
        return out;
        
    }
    
}
