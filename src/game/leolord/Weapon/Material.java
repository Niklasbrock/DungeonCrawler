package game.leolord.Weapon;

public class Material {
    private String name;
    private int apModifier;
    private int[] apModifiers = { 2, 4, 6, 10, 15, 25};
    private String[] materials = { "Bronze", "Iron", "Steel", "Dragon-Bone", "Valerian-Steel", "God-Steel"};
    private int rarity;

    public Material(int rarity){
        this.rarity = rarity;
        name = materials[rarity];
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
