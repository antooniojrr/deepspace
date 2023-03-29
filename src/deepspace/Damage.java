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
    private ArrayList <WeaponType> weapons;
    
    Damage (int w, int s){
        nWeapons = w; 
        nShields = s;
        weapons = null;
    }
    
    Damage(ArrayList <WeaponType> wl, int s){
        weapons = wl; 
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
    /*
    public Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s){
        
        if (w.size() < nWeapons || s.size() < nShields){
            
        }
        else{
            
        }
    } Ha dicho que esta clase es la más interesante de toda la práctica,
       incluso de todo el juego. Cuidado con las implementaciones. adjust no tengo
       ni idea de cómo implementarlo. w y s son los valores del jugador. Si tenemos
       un daño de 25 pero nuestro jugador solo tiene 3, solo le quitamos 3. Tenemos que
       idear nosotros un algoritmo que tenga sentido. */
    
    public void discardWeapon(Weapon w){
        if (w)
    }
}
