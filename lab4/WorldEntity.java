package ioop.lab4;

public class WorldEntity {
    private String name;
    protected Coordinates location;
    protected int maxHealth;
    protected int currentHealth;
    protected Damage attack;
    protected World world;
    public boolean conscious;

    public WorldEntity(String name, Coordinates location, int maxHealth,  World world, Damage attack) {
        this.name = name;
        this.location = location;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.world = world;
        this.attack = attack;
    }

    //Task 2.1
    public void takeDamage(Damage damage) {
        if (damage.getAmount() > this.currentHealth) {
            this.currentHealth = 0;
            this.conscious = false;
        } else this.currentHealth -= damage.getAmount();
        

    }

    // Task 2.1
    public void attack(WorldEntity target) {
        target.takeDamage(attack);
    }

    // Task 2.1
    public void encounter(WorldEntity traveller) {
        System.out.println(this.world);
    }

    public String getName() {
        return name;
    }

    public Coordinates getLocation() {
        return location;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public Damage getAttack() {
        return attack;
    }

    public World getWorld() {
        return world;
    }

    public boolean isConscious() {
        return conscious;
    }

    public void setCurrentHealth(int health) {
        currentHealth=health;
    }
}
