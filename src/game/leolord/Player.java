package game.leolord;

import game.leolord.Items.Potion;
import game.leolord.Weapon.Condition;
import game.leolord.Weapon.Weapon;

import java.util.ArrayList;

import static game.leolord.Communication.*;

public class Player extends Character{
//      Fields included in save file
    private String name;
    private Weapon equippedWeapon;
    private int maxHp;
    private int hp;
    private int lvl;
    private int xp;
    private int luck;
    private int luckModifier;
    private ArrayList<Potion> inventory;
//      Fields not included in save file
    private boolean dead;
    private Enemy currentEnemy;

    public void defend(int attack){
        hp -= attack;
        attackPrint(currentEnemy, attack);
    }
    public void dingCheck(){
//        checks if the player has leveled up, increasing maxhp and luck
        if (xp >= (100*lvl)){
            lvl += 1;
            maxHp += 50;
            hp = 0;
            hp += maxHp;
            xp = 0;
            dingPrint(this);
        }
    }
    public Player(String selectedName){
        name = selectedName;
        dead = false;
        lvl = 1;
        maxHp = 100;
        hp += maxHp;
        luck += lvl + luckModifier;
        equippedWeapon = new Weapon(luck);
        if (equippedWeapon.getCondition().getName().equals("Broken")){
            equippedWeapon = new Weapon(1, equippedWeapon.getMaterial().getRarity(), equippedWeapon.getType().getRarity());
        }
        inventory = new ArrayList<>();
        inventory.add(new Potion("Health Potion", 50));
    }
    public Player(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
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

    public int getLuck() {
        luck = lvl + luckModifier;
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public Enemy getCurrentEnemy() {
        return currentEnemy;
    }

    public void setCurrentEnemy(Enemy currentEnemy) {
        this.currentEnemy = currentEnemy;
    }

    public ArrayList<Potion> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Potion> inventory) {
        this.inventory = inventory;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getLuckModifier() {
        return luckModifier;
    }

    public void setLuckModifier(int luckModifier) {
        this.luckModifier = luckModifier;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
}
