package game.leolord;

import game.leolord.Weapon.Weapon;

import java.util.Random;

public class Character {

    public int attack(Weapon weapon){
        int result = weapon.getAp();
        Random chance = new Random();
        if(weapon.getCritChance() > chance.nextInt(100)){
            result *= 2;
        } else if(weapon.getMissChance() > chance.nextInt(100)){
            result = 0;
        }
        return result;
    }
}
