/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class Test2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Probando clase Hangar");
        Hangar hangar = new Hangar(4);
        System.out.println(hangar.getMaxElements());
        System.out.println(hangar.getShieldBoosters());
        System.out.println(hangar.getWeapons());
        Weapon armaas = new Weapon("laser", WeaponType.LASER, 8);
        Weapon arma3 = new Weapon("misil", WeaponType.MISSILE, 10);
        hangar.addWeapon(armaas);
        hangar.addWeapon(arma3);
        ShieldBooster escudoss = new ShieldBooster("prueba", 1, 1);
        hangar.addShieldBooster(escudoss);
        hangar.addShieldBooster(escudoss);
        System.out.println(hangar.getWeapons());
        System.out.println(hangar.getShieldBoosters());
        System.out.println(hangar.toString());
        hangar.removeWeapon(1);
        System.out.println(hangar.getWeapons());
        hangar.removeShieldBooster(0);
        System.out.println(hangar.getShieldBoosters());
        Hangar hangar2 = new Hangar(hangar);
        System.out.println(hangar2.toString());


        System.out.println("Probando clase Damage");
        Damage damage = new Damage(2, 2);
        System.out.println(damage.getNShields());
        System.out.println(damage.getNWeapons());
        System.out.println(damage.getWeapons());
        System.out.println(damage.toString());
        Weapon arma1 = new Weapon("laser", WeaponType.LASER, 8);
        Weapon arma2 = new Weapon("misil", WeaponType.MISSILE, 10);
        ArrayList<Weapon> armas = new ArrayList<>();
        armas.add(arma1);
        armas.add(arma2);
        ArrayList<WeaponType> arma = new ArrayList<>();
        arma.add(arma1.getType());
        arma.add(arma2.getType());
        Damage damage2 = new Damage(arma, 3);
        ShieldBooster escudo = new ShieldBooster("name", 2, 2);
        ArrayList<ShieldBooster> escudos = new ArrayList<>();
        escudos.add(escudo);
        System.out.println(damage2.getNShields());
        System.out.println(damage2.getNWeapons());
        System.out.println(damage2.getWeapons());
        Damage damage3 = new Damage(damage2);
        System.out.println(damage3.toString());
        System.out.println(damage.hasNoEffect());
        Damage damage4 = new Damage(damage2.adjust(armas, escudos));
        System.out.println("-----------");
        System.out.println(damage2.toString());
        System.out.println(damage4.toString());
        System.out.println("-----------");
        System.out.println(damage.getNWeapons());
        damage.discardWeapon(arma1);
        System.out.println(damage.getNWeapons());
        System.out.println(damage2.getWeapons());
        damage2.discardWeapon(arma1);
        System.out.println(damage2.getWeapons());
        System.out.println(damage.getNShields());
        damage.discardShieldBooster();
        System.out.println(damage.getNShields());

        
        System.out.println("Probando EnemyStarShip");
        Loot loot = new Loot(1,2,3,4,5);
        Damage damagee = new Damage(2,2);
        EnemyStarShip enemy = new EnemyStarShip("Prueba", 2.0f, 3.0f, loot, damagee);
        System.out.println(enemy.getName());
        System.out.println(enemy.getAmmoPower());
        System.out.println(enemy.getShieldPower());
        System.out.println(enemy.getLoot());
        System.out.println(enemy.getDamage());
        System.out.println(enemy.toString());
        System.out.println(enemy.protection());
        System.out.println(enemy.fire());
        System.out.println(enemy.receiveShot(2.0f));
        
        
        System.out.println("Probando SpaceStation");
        SuppliesPackage supplies = new SuppliesPackage(1, 2, 3);
        SpaceStation space = new SpaceStation("prueba", supplies);
        System.out.println(space.getName());
        System.out.println(space.getAmmoPower());
        System.out.println(space.getFuelUnits());
        System.out.println(space.getShieldPower());
        System.out.println(space.getNMedals());
        System.out.println(space.getPendingDamage());
        System.out.println(space.getWeapons());
        System.out.println(space.getShieldBoosters());
        System.out.println(space.getHangar());
        System.out.println(space.toString());
        Hangar hangar4 = new Hangar(4);
        Weapon armita = new Weapon("arma", WeaponType.LASER, 8);
        ShieldBooster escudito = new ShieldBooster("escudo", 1, 1);
        System.out.println("-----------");
        System.out.println(space.receiveWeapon(armita));
        System.out.println(space.receiveShieldBooster(escudito));
        System.out.println("-----------");
        space.receiveHangar(hangar4);
        System.out.println(space.receiveWeapon(armita));
        System.out.println(space.receiveShieldBooster(escudito));
        System.out.println(space.getHangar());
        System.out.println("-----------");
        space.mountShieldBooster(0);
        space.mountWeapon(0);
        System.out.println(space.getHangar());
        System.out.println(space.getShieldBoosters());
        System.out.println(space.getWeapons());
        space.discardHangar();
        System.out.println(space.getHangar());
        System.out.println("-----------");
        space.receiveHangar(hangar4);
        System.out.println(space.receiveWeapon(armita));
        System.out.println(space.receiveShieldBooster(escudito));
        System.out.println(space.getHangar());
        space.discardShieldBoosterInHangar(0);
        space.discardWeaponInHangar(0);
        System.out.println(space.getHangar());
        System.out.println(space.getSpeed());
        System.out.println(space.getFuelUnits());
        space.move();
        System.out.println(space.getFuelUnits());
        System.out.println("-----------");
        Weapon wp = new Weapon("arma", WeaponType.PLASMA, 0);
        System.out.println(space.receiveWeapon(wp));
        space.mountWeapon(0);
        System.out.println(space.getWeapons());
        space.cleanUpMountedItems();
        System.out.println(space.getWeapons());
        System.out.println(space.validState());
        System.out.println("-----------");
        System.out.println(space.getShieldPower());
        System.out.println(space.getWeapons());
        Damage damagito = new Damage(2,2);
        space.setPendingDamage(damagito);
        System.out.println(space.getPendingDamage());
        System.out.println(space.validState());
    }
    
}
