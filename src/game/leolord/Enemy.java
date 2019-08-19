package game.leolord;


import game.leolord.Generators.NameGenerator;
import game.leolord.Weapon.Weapon;

import static game.leolord.Communication.*;

public class Enemy extends Character{
    private String name;
    private int type; /* type 1 = normal, type 2 = elite */
    private int maxHp;
    private int hp;
    private int lvl;
    private int luck;
    private int luckModifier;
    private Weapon equippedWeapon;
    private Player playerCharacter;

    public Enemy(Player playerCharacter, int type){
        this.playerCharacter = playerCharacter;
        playerCharacter.setCurrentEnemy(this);
        this.type = type;
        if (type == 2){
            name = "Elite " + NameGenerator.generateName();
        } else{
            name = NameGenerator.generateName();
        }
        lvl = playerCharacter.getLvl();
        maxHp = (playerCharacter.getMaxHp()/100)*(50*type);
        hp = maxHp;
        luck += lvl + luckModifier;
        equippedWeapon = new Weapon(luck);
    }


    public void defend(int attack){
        hp -= attack;
        attackPrint(playerCharacter, attack);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
