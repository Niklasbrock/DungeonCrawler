package game.leolord.Weapon;

public class Condition {
    private String name;
    private int apModifier;
    private int[] apModifiers = {-10, 1, 3, 5, 10, 15};
    private String[] conditions = {"Broken", "Dull", "Rusty", "Worn", "Sharp", "Razorsharp"};
    private int rarity;

    public Condition(int rarity){
        this.rarity = rarity;
        name = conditions[rarity];
        apModifier = apModifiers[rarity];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getApModifier() {
        return apModifier;
    }

    public void setApModifier(int apModifier) {
        this.apModifier = apModifier;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }
}
