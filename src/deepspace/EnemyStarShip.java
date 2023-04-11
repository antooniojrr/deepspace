/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;

/**
 *
 * @author david
 */
public class EnemyStarShip {
    private float ammoPower;
    private String name; 
    private float shieldPower;
    private Loot loot;
    private Damage damage;
    
    EnemyStarShip(String n, float a, float s, Loot l, Damage d){
        name = n; 
        ammoPower = a; 
        shieldPower = s;
        loot = l; 
        damage = d;
    }
    
    EnemyStarShip(EnemyStarShip e){
        name = e.getName();
        ammoPower = e.getAmmoPower();
        shieldPower = e.getShieldPower();
        loot = e.getLoot();
        damage = e.getDamage();
    }
    
    EnemyToUI getUIversion(){return new EnemyToUI(this);}
    
    public float fire(){
        return getAmmoPower();
    }
    
    public float protection(){
        return getShieldPower();
    }
    
    public ShotResult receiveShot(float shot){
        if (shot > protection())
            return ShotResult.DONOTRESIST;
        else 
            return ShotResult.RESIST;
    }
    
    
    public float getAmmoPower(){return ammoPower;}
    public float getShieldPower(){return shieldPower;}
    public String getName(){return name;}
    public Loot getLoot(){return loot;}
    public Damage getDamage(){return damage;}
    
}
