package game.leolord;

import game.leolord.Items.*;
import game.leolord.Weapon.Weapon;

public class Communication {
//    OUTPUT
    public static void welcomePrint(){
        System.out.println("Welcome to this dungeon crawler");
    }
    public static void startPrint(Player playerCharacter){
//        TODO story and intro. also weapon select
        System.out.printf("%n%s%n%s%n", playerCharacter.getName() + ", wielding a " + playerCharacter.getEquippedWeapon().getName(), "delves deep into a dungeon of old.");
    }
    public static void enterNamePrint(){
        System.out.print("Enter player name: ");
    }
    public static void spacerPrint(){
        System.out.printf("%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n");
    }
    public static void inputArrowPrint(){
        System.out.printf("%s", "->");
    }
    public static void statusPrint(Player playerCharacter){
        if(playerCharacter.getHp() == playerCharacter.getMaxHp()){
            System.out.printf("%n%s%n%s%n", playerCharacter.getName()+" is feeling primed up for combat!","Hp is full at "+playerCharacter.getHp()+"/"+playerCharacter.getMaxHp());
        } else if(playerCharacter.getHp() > playerCharacter.getMaxHp()/2){
            System.out.printf("%n%s%n%s%n", playerCharacter.getName()+" is bruised, but fit for fight!","Hp is at "+playerCharacter.getHp()+"/"+playerCharacter.getMaxHp());
        } else if(playerCharacter.getHp() < playerCharacter.getMaxHp()/2){
            System.out.printf("%n%s%n%s%n", playerCharacter.getName()+" is injured!","Hp is at "+playerCharacter.getHp()+"/"+playerCharacter.getMaxHp());
        }
    }
    public static void fullStatusPrint(Player playerCharacter){
        System.out.printf("%n%s%n%s%n%s%n%s%n", "Status of " + playerCharacter.getName() + ": ", "lvl " + playerCharacter.getLvl() + " - "
                        + playerCharacter.getHp()+"/"+playerCharacter.getMaxHp() + " hp - luck " + playerCharacter.getLuck(),
                 "wielding a " + playerCharacter.getEquippedWeapon().getName() + " with " + playerCharacter.getEquippedWeapon().getAp() + " ap ",
                "carrying " + playerCharacter.getInventory().size() + " " + playerCharacter.getInventory().get(0).getName() + "[s]");
    }
    public static void statusPrint(Enemy enemy){
        if(enemy.getHp() > 0){
            System.out.printf("%n%s%n%s%n", enemy.getName()+" still draws breath", "Enemy hp is at "+enemy.getHp()+"/"+enemy.getMaxHp());
        }
    }
    public static void encounterFocusPrint(Weapon affectedWeapon){
        System.out.printf("%n%s%n%s%n", "You focus intensely, increasing your weapon effectiveness", "Crit chance raised to "
                + affectedWeapon.getCritChance() + " and miss chance reduced to " + affectedWeapon.getMissChance());
    }
    public static void encounterTauntPrint(Weapon affectedWeapon){
        System.out.printf("%n%s%n%s%n", "You taunt the enemy, decreasing it's weapon effectiveness", "Crit chance decreased to "
                + affectedWeapon.getCritChance() + " and miss chance increased to "+ affectedWeapon.getMissChance());
    }
    public static void newEnemyPrint(Enemy enemy){
        System.out.printf("%n%s%n%s%n","You face " + enemy.getName() + " - lvl " + enemy.getLvl() + " - " + enemy.getHp()+"/"+enemy.getMaxHp() + " hp", "It wields a " + enemy.getEquippedWeapon().getName());
        if (enemy.getType() == 2){
            System.out.printf("%s%n", "This enemy looks strong and will be harder to defeat");
        }
    }
    public static void enemyDefeatedPrint(Enemy enemy){
        System.out.printf("%n%n%s%n", "You have defeated " + enemy.getName() + "!");
    }
    public static void playerDeathPrint(Player playerCharacter){
        System.out.printf("%n%s%n%n%n%s", playerCharacter.getName() + " falls to the ground, dead.", "Congratulations! You made it to lvl " + playerCharacter.getLvl());
    }
    public static void gameOverPrint(){
        System.out.printf("%s%n%s%n%s", "/////////////////////////", "/////// GAME OVER ///////", "/////////////////////////");
    }
    public static void encounterMenuPrint(){
        System.out.printf("%n%s%n%s%n%s%n%s%n%s%n%s", "[1] Attack", "[2] Focus", "[3] Taunt", "[4] Item", "[5] Flee", "->");
    }
    public static void encounterItemMenuPrint(Player playerCharacter){
        for(int i = 0; i < playerCharacter.getInventory().size(); i++){
            System.out.printf("%s%n","[" + (i+1) + "]" + playerCharacter.getInventory().get(i).getName());
        }
    }
    public static void healthPotionUsedPrint(Potion usedItem){
        System.out.printf("%n%s%n", "You use a " + usedItem.getName() + " and heal for " + usedItem.getHealing());
    }
    public static void encounterFleeFailedPrint(Enemy enemy){
        System.out.printf("%n%s%n", "As you try to escape " + enemy.getName() + " blocks your path");
    }
    public static void encounterFleeSuccessPrint(){
        System.out.printf("%n%s%n", "You successfully escaped");
    }
    public static void attackPrint(Player playerCharacter, int attackDamage){
//        Players attack damage done + crit/miss info
        if(playerCharacter.getEquippedWeapon().getAp() == attackDamage){
//            Normal hit for [attackDamage]
            System.out.printf("%n%s%n","You hit for " + attackDamage + "!");
        } else if(playerCharacter.getEquippedWeapon().getAp() < attackDamage){
//            Critical hit for [attackDamage]
            System.out.printf("%n%s%n","You critically hit for " + attackDamage + "!");
        } else if(attackDamage == 0){
//            Miss!
            System.out.printf("%n%s%n", "Your attack missed!");
        }

    }
    public static void attackPrint(Enemy enemy, int attackDamage){
//        Enemy attack damage done + crit/miss info
        if(enemy.getEquippedWeapon().getAp() == attackDamage){
//            Normal hit for [attackDamage]
            System.out.printf("%n%s%n", enemy.getName() + " hit you for " + attackDamage + "!");
        } else if(enemy.getEquippedWeapon().getAp() < attackDamage){
//            Critical hit for [attackDamage]
            System.out.printf("%n%s%n", enemy.getName() + " critically hit you for " + attackDamage + "!");
        } else if(attackDamage == 0){
//            Miss!
            System.out.printf("%n%s%n", enemy.getName() + "'s attack missed!");
        }
    }
    public static void dungeonMenuPrint(){
        System.out.printf("%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s", "As you delve deeper through the dark twisted corridors,", "suddenly a monster jumps out in front of you!",
                            "What do you do?", "[1] Fight", "[2] Rush to the nearest door", "[3] Return to bonfire", "[4] Character status", "->");
    }
    public static void monsterRewardPrint(Potion rewardItem){
        System.out.printf("%n%s%n","You loot a "+rewardItem.getName());
    }
    public static void weaponDropPrint(Weapon weaponDrop){
        System.out.printf("%n%s%n%s%n%s", "You find a " + weaponDrop.getName() + " on the defeated enemy", "Do you want to equip it? [Y/N]", "->");
    }
    public static void weaponEquippedPrint(Weapon weaponDrop, Weapon oldWeapon){
        System.out.printf("%n%s%n%s%n", "You equip " + weaponDrop.getName(), "and leave your " + oldWeapon.getName() + " behind");
    }
    public static void dingPrint(Player playerCharacter){
        System.out.printf("%n%s%n","Ding! " + playerCharacter.getName() + " is now lvl " + playerCharacter.getLvl());
    }
    public static void npcRewardPrint(/*name and reward info */){
        System.out.printf("%n%s%n","The "+"[NPC NAME]"+"offers you"+"[REWARD INFO]"+"as a reward");
    }
    public static void bonfirePrint(){
        System.out.printf("%n%s%n%s%n", "You make your way back to the bonfire" ,"In the warmth of the bonfire you recover your resolve");
    }
    public static void bonfireMonsterPrint(){
        System.out.printf("%n%s%n", "On your way back to the bonfire, a monster intercepts you!");
    }
    public static void bonfireNpcPrint(){
        System.out.printf("%n%s%n", "On your way back to the bonfire, you spot a friendly face");
    }
    public static void invalidPrint(){
        System.out.println("The command used was invalid, try again.");
    }

//    INPUT
    public void yesNo(String input){

    }
}
