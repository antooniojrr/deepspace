/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;

import java.util.ArrayList;

/**
 *
 * @author antoniojrr
 */
public class SpecificDamage extends Damage {
    
    private ArrayList <WeaponType> weapons = new ArrayList();
    
    private int arrayContainsType(ArrayList<Weapon> w, WeaponType t){
        int index = -1;
        boolean found = false; 
        for (int i = 0; i < w.size() && !found; i++){
            if (w.get(i).getType() == t){
                found = true;
                index = i;
            }
        }
        
        return index;    
    }
    
    SpecificDamageToUI getUIversion() {
        return new SpecificDamageToUI(this);
    }
    
    SpecificDamage(ArrayList <WeaponType> wl, int s){
        weapons = new ArrayList<WeaponType>();
        if (wl!=null) {
            int size=wl.size();
            for(int i = 0; i < size; i++)
                weapons.add(wl.get(i));
        }
        setNShields(s);
    }
    
    public SpecificDamage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s){
        
        int sh = 0;
        int nShields_new, nWeapons_new;
        ArrayList<WeaponType> weapons_new = new ArrayList<>();
        
        for (int i = 0; i < s.size(); i++){
            sh += s.get(i).getUses();
        }
        
        if (getNShields() > sh)
            nShields_new = sh;
        else
            nShields_new = getNShields();
      
        for (int i = 0; i < weapons.size(); i++){
            if(arrayContainsType(w, weapons.get(i)) != -1)
                weapons_new.add(weapons.get(i));
        }

        return (new SpecificDamage(weapons_new, nShields_new));

    }
    
    public void discardWeapon(Weapon w) {
        weapons.remove(w.getType());
    }
    
    public boolean hasNoEffect(){
        return(getNShields() == 0 && weapons.isEmpty());
    }
    
    ArrayList <WeaponType> getWeapons(){return weapons;}
    
}
