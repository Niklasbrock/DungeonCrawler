package game.leolord.Generators;

import game.leolord.Weapon.Weapon;

public class WeaponGenerator {

    private static String[] condition = { "Broken", "Dull", "Rusty", "Worn", "Sharp"};
    private static String[] material = { "Bronze", "Iron", "Steel", "Enchanted Steel", "Dragon-bone"};
    private static String[] type = { "Shortsword", "Broadsword", "Longsword", "Claymore", "Zweihander"};

    public static Weapon generateWeapon(int luckModifier){
        return new Weapon(luckModifier);
    }

}
