package game.leolord;

import game.leolord.Items.*;
import game.leolord.Weapon.Weapon;

import java.util.Random;
import java.util.Scanner;

import static game.leolord.Communication.*;

public class Event {
    private Enemy enemy;
    private NPC npc;
    private Weapon weaponReward;
    private Weapon playerWeapon;
    private Weapon enemyWeapon;
    private Player playerCharacter;
    private Random random;
    private int chance;
    private String choice;
    private Scanner input;
    private Scanner inputChoice;
    private boolean fighting;
    private int gainedLuckModifier;
    private int gainedXp;


    public Event(Player playerCharacter, int dungeonChoice){
        input = new Scanner(System.in);
        inputChoice = new Scanner(System.in);
        this.playerCharacter = playerCharacter;
        random = new Random();
        while (dungeonChoice == 4){
            fullStatusPrint(playerCharacter);
            inputArrowPrint();
            dungeonChoice = input.nextInt();
        }
            switch (dungeonChoice){
                case 1:
//                monster choice
                    monsterEncounter(1); /* normal */
                    break;
                case 2:
//                door choice
                    chance = random.nextInt(100);
                    if(chance > 50){
                        monsterEncounter(1); /* normal */
                    } else if(chance < 50 && chance > 20){
                        monsterEncounter(2); /* elite */
                    } else if(chance < 20){
                        npcEncounter();
                    }
                    break;
                case 3:
//                  bonfire choice
                    chance = random.nextInt(100);
                    if(chance > 90){
                        bonfireMonsterPrint();
                        monsterEncounter(1); /* normal */
                    } else if(chance < 90 && chance > 80){
                        bonfireNpcPrint();
                        npcEncounter();
                    } else if(chance < 80){
                        bonfire();
                    }
                    break;
                default: invalidPrint();
            }
    }
    public void monsterEncounter(int type){
        enemy = new Enemy(playerCharacter, type);
        this.enemyWeapon = enemy.getEquippedWeapon();
        this.playerWeapon = playerCharacter.getEquippedWeapon();
        newEnemyPrint(enemy);
        fighting = true;
        while(fighting){
            encounterMenu();
            monsterTurn();
        }
        if (enemy.getHp() <= 0){
            enemyDefeatedPrint(enemy);
            encounterPotionReward(playerCharacter);
            encounterWeaponDropRoll(playerCharacter, type);
            gainedLuckModifier += type;
            playerCharacter.setLuckModifier(playerCharacter.getLuckModifier() + gainedLuckModifier);
            gainedXp += 50;
            playerCharacter.setXp(playerCharacter.getXp() + gainedXp);
            playerCharacter.dingCheck();
        }
    }

    public void npcEncounter(){

    }
    public void bonfire(){
        playerCharacter.setHp(playerCharacter.getMaxHp());
        playerCharacter.setLuckModifier(0);
        bonfirePrint();
        fullStatusPrint(playerCharacter);
    }
    public void encounterMenu(){
        encounterMenuPrint();
        int encounterChoice = input.nextInt();
        switch(encounterChoice){
            case 1:
                encounterAttack();
                break;
            case 2:
                encounterFocus(playerWeapon);
                break;
            case 3:
                encounterTaunt(enemyWeapon);
                break;
            case 4:
                encounterItem();
                break;
            case 5:
                encounterFlee();
                break;
            default:
                invalidPrint();
        }
    }
    public void encounterAttack(){
        enemy.defend(playerCharacter.attack(playerWeapon));
        statusPrint(enemy);
        if(enemy.getHp() <= 0){
            fighting = false;
        }
    }
    public void encounterFocus(Weapon affectedWeapon){
//        increases crit by 10% and decrease miss by 5%, this event only
        affectedWeapon.setCritChance(affectedWeapon.getCritChance() + 10);
        affectedWeapon.setMissChance(affectedWeapon.getMissChance() - 5);
        encounterFocusPrint(affectedWeapon);
    }
    public void encounterTaunt(Weapon affectedWeapon){
//        reverse focus, decreases enemy crit by 10% and increases miss by 5%
        affectedWeapon.setCritChance(affectedWeapon.getCritChance() - 10);
        affectedWeapon.setMissChance(affectedWeapon.getMissChance() + 5);
        encounterTauntPrint(affectedWeapon);
    }
    public void encounterItem(){
        encounterItemMenuPrint(playerCharacter);
        int itemChoice = input.nextInt();
        playerCharacter.getInventory().get(itemChoice-1).use(playerCharacter);
        playerCharacter.getInventory().remove(itemChoice-1);

    }
    public void encounterFlee(){
//        If enemy hp is above half: 75% chance to flee. If below: 25%
        if (enemy.getHp() > enemy.getMaxHp()/2){
            chance = random.nextInt(100);
            if (chance < 75){
                fighting = false;
                encounterFleeSuccessPrint();
            } else{
                encounterFleeFailedPrint(enemy);
            }
        } else if (enemy.getHp() < enemy.getMaxHp()/2){
            if (chance < 25){
                fighting = false;
                encounterFleeSuccessPrint();
            } else{
                encounterFleeFailedPrint(enemy);
            }
        }
    }
    public void encounterPotionReward(Player playerCharacter){
        Potion rewardPotion = new Potion("Health Potion", 50);
        playerCharacter.getInventory().add(rewardPotion);
        monsterRewardPrint(rewardPotion);
    }
    public void encounterWeaponDropRoll(Player playerCharacter, int type){
//TODO      if rares are too hard to get, add a grace mechanic to garantee drop after X tries.
        switch (type){
            case 1: /* normal monster */
                chance = random.nextInt(100);
                if (chance < 15){
                    weaponReward = new Weapon(playerCharacter.getLuck());
                    weaponDropPrint(weaponReward);
                    equipWeaponRewardYN();
                }
                break;
            case 2: /* elite monster */
                chance = random.nextInt(100);
                if (chance < 25){
                    weaponReward = new Weapon(playerCharacter.getLuck());
                    weaponDropPrint(weaponReward);
                    equipWeaponRewardYN();
                }
                break;
        }

    }
    public void equipWeaponRewardYN(){
        choice = inputChoice.nextLine();
        if (choice.equalsIgnoreCase("Y")){
            weaponEquippedPrint(weaponReward, playerWeapon);
            playerCharacter.setEquippedWeapon(weaponReward);
        }
    }
    public void monsterTurn(){
        if(fighting){
            playerCharacter.defend(enemy.attack(enemyWeapon));
            statusPrint(playerCharacter);
            if(playerCharacter.getHp() <= 0){
                playerDeathPrint(playerCharacter);
                playerCharacter.setDead(true);
                fighting = false;
            }
        }
    }
}
