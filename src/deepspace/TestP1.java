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
        
        System.out.println("Supplies: " + my_loot.getNSupplies());
        
        // Clase SuppliesPackage        

        final float AMMO_POWER =  1.0f;
        final float FUEL_UNITS = 3.0f; 
        final float SHIELD_POWER = 2.0f;

        SuppliesPackage supplies = new SuppliesPackage(AMMO_POWER, FUEL_UNITS, 
                                   SHIELD_POWER);

        System.out.println("");

    }
}