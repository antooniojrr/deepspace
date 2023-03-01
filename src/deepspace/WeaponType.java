/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;

/**
 *
 * @author antoniojrr
 */


public enum WeaponType { 
        LASER(2.0),
        MISSILE(3.0),
        PLASMA(4.0);
        
        private final float power;
        WeaponType(float power) { this.power=power; }
        public float getPower() { return this.power; }
        
    }
