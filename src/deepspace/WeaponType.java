/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;

/**
 *
 * @author antoniojrr
 * @author kessler
 */


public enum WeaponType { 
        LASER((float) 2.0),
        MISSILE((float) 3.0),
        PLASMA((float) 4.0);
        
        private final float power;
        WeaponType(float power) { this.power=power; }
        float getPower() { return this.power; }
        
        public String toString(){
            if (getPower() == 2.0)
                return "Laser";
            else if (getPower() == 3.0)
                return "Missile";
            else
                return "Plasma";
        }
    }
