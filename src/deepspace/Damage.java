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
public abstract class Damage {
    
    private int nShields;
    
    abstract DamageToUI getUIversion();
    
    public abstract Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s);
    
    public abstract void discardWeapon(Weapon w);
    
    public void discardShieldBooster(){
        if (nShields > 0)
            nShields--;
    }
    
    public abstract boolean hasNoEffect();
            
    int getNShields(){return nShields;}
    
    void setNShields(int s) { nShields=s; }
}
