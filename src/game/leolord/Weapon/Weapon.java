package game.leolord.Weapon;
import static game.leolord.Weapon.Roll.*;

public class Weapon {
    private String name;
    private int ap;
    private int critChance;
    private int missChance;
    private Condition condition;
    private Material material;
    private Type type;

    public Weapon(int luck){
        condition = new Condition(affixRoll(luck));
        material = new Material(affixRoll(luck));
        type = new Type(affixRoll(luck));
        name = condition.getName() + " " + material.getName() + " " + type.getName();
        ap += condition.getApModifier() + material.getApModifier() + type.getApModifier();
        if (ap < 0){
            ap = 4;
        }
        critChance = 20;
        missChance = 15;
    }

    public Weapon(int conditionRarity, int materialRarity, int typeRarity){
        condition = new Condition(conditionRarity);
        material = new Material(materialRarity);
        type = new Type(typeRarity);
        name = condition.getName() + " " + material.getName() + " " + type.getName();
        ap += condition.getApModifier() + material.getApModifier() + type.getApModifier();
        if (ap < 0){
            ap = 4;
        }
        critChance = 20;
        missChance = 15;
    }

    public Weapon(String name, int ap, int critChance, int missChance) {
        this.name = name;
        this.ap = ap;
        this.critChance = critChance;
        this.missChance = missChance;
    }

    public Weapon() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAp() {
        return ap;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public int getCritChance() {
        return critChance;
    }

    public void setCritChance(int critChance) {
        this.critChance = critChance;
    }

    public int getMissChance() {
        return missChance;
    }

    public void setMissChance(int missChance) {
        this.missChance = missChance;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
