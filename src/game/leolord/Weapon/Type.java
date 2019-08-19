package game.leolord.Weapon;

public class Type {
    private String name;
    private int apModifier;
    private int[] apModifiers = { 2, 4, 6, 10, 15, 25};
    private String[] types = { "Shortsword", "Broadsword", "Longsword", "Claymore", "Zweihander", "Godsword"};
    private int rarity;

    public Type(int rarity){
        this.rarity = rarity;
        name = types[rarity];
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
