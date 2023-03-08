/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;

/**
 *
 * @author antoniojrr
 */
public class TestP1 {
    
    static void main(String[] args) {
        
        // Clase Loot
        
        final int NUM_SUPPLIES = 1;
        final int NUM_WEAPONS = 2; 
        final int NUM_SHIELD = 1; 
        final int NUM_HANGARS = 2;
        final int NUM_MEDALS = 1; 
                
        Loot my_loot = new Loot(NUM_SUPPLIES, NUM_WEAPONS, NUM_SHIELD,
                       NUM_HANGARS, NUM_MEDALS);
        
        System.out.println("El número de ");
        int loot_num_supplies = my_loot.getNSupplies();
        int loot_num_weapons = my_loot.getNWeapons();
        int loot_num_shield = my_loot.getNShield();
        int loot_num_hangars = my_loot.getNHangars();
        int loot_num_medals = my_loot.getNMedals();
        
        
    }
    
}
