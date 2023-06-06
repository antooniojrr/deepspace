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
        super(s);
        weapons = new ArrayList<WeaponType>();
        if (wl!=null) {
            int size=wl.size();
            for(int i = 0; i < size; i++)
                weapons.add(wl.get(i));
        }
    }
    
    public SpecificDamage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s){
        
        int nShields_new=s.size();
        ArrayList<WeaponType> weapons_new = new ArrayList<>();
        ArrayList<Weapon> aux = new ArrayList<>();
        
        for( Weapon weap: w)
            aux.add(weap);
        
        if (getNShields() < nShields_new)
            nShields_new = getNShields();
        int i;
      
        for (WeaponType wt : weapons){
            i = arrayContainsType(aux, wt);
            if(i != -1) {
                weapons_new.add(wt);
                aux.remove(i);
            }
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
    
    public SpecificDamage copy() {
        int s = getNShields();
        ArrayList<WeaponType> wl = new ArrayList<>();
        for (WeaponType wt : getWeapons())
            wl.add(wt);
        return new SpecificDamage(wl,s);
    }
    
}
