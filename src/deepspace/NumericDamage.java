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
public class NumericDamage extends Damage {
    
    private int nWeapons;
    
    NumericDamageToUI getUIversion() {
        return new NumericDamageToUI(this);
    }
    
    NumericDamage (int w, int s){
        nWeapons = w; 
        setNShields(s);
    }
    
    public NumericDamage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s){
        
        int sh = 0;
        int nShields_new, nWeapons_new;
        
        for (int i = 0; i < s.size(); i++){
            sh += s.get(i).getUses();
        }
        
        if (getNShields() > sh)
            nShields_new = sh;
        else
            nShields_new = getNShields();
        
        if (nWeapons > w.size())
            nWeapons_new = w.size();
        else 
            nWeapons_new = nWeapons;

        return new NumericDamage(nWeapons_new, nShields_new);
    }
    
    public void discardWeapon(Weapon w) {
        if(nWeapons > 0)
            nWeapons--;
    }
    
    public boolean hasNoEffect(){
        return (getNShields() == 0 && nWeapons == 0);
    }
    
    int getNWeapons(){return nWeapons;}
    
}
