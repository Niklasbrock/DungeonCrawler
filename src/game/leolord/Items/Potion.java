package game.leolord.Items;

import game.leolord.Player;

import static game.leolord.Communication.*;

public class Potion{
    private String name;
    private String desc;
    private int healing;

    public void use(Player playerCharacter){
        playerCharacter.setHp(playerCharacter.getHp() + healing);
        if (playerCharacter.getHp() > playerCharacter.getMaxHp()){
            playerCharacter.setHp(playerCharacter.getMaxHp());
        }
        healthPotionUsedPrint(this);
    }


    public Potion(String name, int healing){
        this.name = name;
        this.healing = healing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getHealing() {
        return healing;
    }

    public void setHealing(int healing) {
        this.healing = healing;
    }
}
