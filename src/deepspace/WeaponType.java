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
        private WeaponType(float power) { this.power=power; }
        public float getPower() { return this.power; }
        
    }
