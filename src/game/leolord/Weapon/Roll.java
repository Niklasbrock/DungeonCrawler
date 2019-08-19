package game.leolord.Weapon;

import java.util.Random;

public class Roll {

    public Roll(){}

    public static int affixRoll(int luckModifier){
        Random random = new Random();
        int rarity = 0;
        for (int i = 0; i < luckModifier; i++){
            int roll = random.nextInt(100);
            if (roll > 50 && roll < 70 && rarity < 1){ /* 18% */
                rarity = 1;
            } else if (roll > 70 && roll < 84 && rarity < 2){ /* 12% */
                rarity = 2;
            } else if (roll > 84 && roll < 93 && rarity < 3){ /* 7% */
                rarity = 3;
            } else if (roll > 93 && roll < 98 && rarity < 4){ /* 3% */
                rarity = 4;
            } else if (roll > 98){ /* 1% */
                rarity = 5;
                break;
            }
        }
        return rarity;
    }
}
