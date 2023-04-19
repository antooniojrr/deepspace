

package deepspace;

import java.util.ArrayList;
/**
 *
 * @author antoniojrr
 */
public class asistencia2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        final int NUM_PLASMA=7;
        final int NUM_LASER=2;
        final int NUM_MISSILE=1;
        ArrayList<WeaponType> armas = new ArrayList();
        
        for (int i = 0; i < NUM_LASER; i++)
            armas.add(WeaponType.LASER);
        
        for(int i = 0; i < 7; i++)
            armas.add(WeaponType.PLASMA);
        
        for (int i = 0; i < NUM_MISSILE; i++)
            armas.add(WeaponType.MISSILE);
        
        final int ESCUDOS=8;
        
        Damage dam = new Damage(armas,ESCUDOS);
        
        if (!dam.hasNoEffect())
            System.out.println("Este daño tiene efecto");
        
        for (int i = 0; i < ESCUDOS; i++) 
            dam.discardShieldBooster();
        
        Weapon laser = new Weapon("",WeaponType.LASER,1);
        Weapon plasma = new Weapon("",WeaponType.PLASMA,1);
        Weapon misil = new Weapon("",WeaponType.MISSILE,1);
        
        for (int i = 0; i < NUM_LASER; i++)
            dam.discardWeapon(laser);
        
        for (int i = 0; i < NUM_PLASMA; i++)
            dam.discardWeapon(plasma);
        
        for (int i = 0; i < NUM_MISSILE; i++)
            dam.discardWeapon(misil);
        
        System.out.println("Discards hechos");
        if (dam.hasNoEffect())
            System.out.println("Este daño ya no tiene efecto");
    }
    
}
