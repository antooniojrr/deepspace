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
public class Damage {
    private int nShields; 
    private int nWeapons;
    private ArrayList <WeaponType> weapons = new ArrayList();
    
    Damage (int w, int s){
        nWeapons = w; 
        nShields = s;
        weapons = null;
    }
    
    Damage(ArrayList <WeaponType> wl, int s){
        weapons = new ArrayList<WeaponType>();
        if (wl!=null) {
            int size=wl.size();
            for(int i = 0; i < size; i++)
                weapons.add(wl.get(i));
        }
        nShields = s;
        nWeapons = -1; // constante
    }
    
    Damage(Damage d){
        nShields = d.getNShields();
        nWeapons = d.getNWeapons();
        weapons = d.getWeapons();
    }
    
    DamageToUI getUIversion(){return new DamageToUI(this);}
    
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
    
    public Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s){
        
        int sh = 0;
        int nShields_new, nWeapons_new;
        ArrayList<WeaponType> weapons_new = null;
        
        for (int i = 0; i < s.size(); i++){
            sh += s.get(i).getUses();
        }
        
        if (nShields > sh)
            nShields_new = sh;
        else
            nShields_new = nShields;
        
        if (nWeapons != -1){
            if (nWeapons > w.size())
                nWeapons_new = w.size();
            else 
                nWeapons_new = nWeapons;
            
            return new Damage(nWeapons_new, nShields_new);
        }
        else{
            for (int i = 0; i < weapons.size(); i++){
                if(arrayContainsType(w, weapons.get(i)) != -1)
                    weapons_new.add(weapons.get(i));
            }
            
            return (new Damage(weapons_new, nShields_new));
        }
    } 
    
    public void discardWeapon(Weapon w){
        if (nWeapons != -1) {
            if (nWeapons > 0)
                nWeapons--;
        }
        else
            weapons.remove(w.getType());              
    }
    
    public void discardShieldBooster(){
        if (nShields > 0)
            nShields--;
    }
    
    public boolean hasNoEffect(){
        if (nWeapons != -1)
            return (nShields == 0 && nWeapons == 0);
        else
            return (nShields == 0 && weapons.isEmpty());
    }
    
    int getNShields(){return nShields;}
    int getNWeapons(){return nWeapons;}
    ArrayList <WeaponType> getWeapons(){return weapons;}
}
