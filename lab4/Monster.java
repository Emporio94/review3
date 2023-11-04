package ioop.lab4;

public class Monster extends TravellingWorldEntity{
    
    private int speed;
    private int stepTimer=0;
    protected int xp=0;
    protected int level=1;
    protected int nextLevel=2;
    protected Boolean awake = false;
    
    //Task2.2
    public Monster(String name, Coordinates location, int maxHealth, World world, Damage attack, int speed) {
        super(name, location, maxHealth, world, attack);
        this.speed=speed;
    }

    // Task 2.2
    public void takeTurn()
    {
        if (!this.isAwake()) return;
        ++stepTimer;
        if (stepTimer == speed) {
            Coordinates destination = this.getWorld().getAdventurer().getLocation();
            move(this.location.getNextStepTo(destination));
        }
        
    }
    
    //Task 2.2
    public void gainXP(int amount)
    {
        this.xp+=amount;
        while (this.xp >= this.nextLevel) {
                this.xp -= this.nextLevel;
                ++this.level;
                this.maxHealth += 10;
                this.currentHealth = this.maxHealth;
                this.nextLevel = this.nextLevel * 2;
            }

        
    }
    
    //Task 2.2 - this code is incomplete but note how the monster instance passes itself as a parameter to the battle method!
    public void encounter(WorldEntity traveller)
    {
        if(this.isAwake()) world.battle(this,traveller);
        this.setAwake(true);
    }

    public int getSpeed() {
        return speed;
    }

    public int getStepTimer() {
        return stepTimer;
    }

    public boolean isAwake() {

        return this.awake;
    }

    public int getXp() {
        return xp;
    }

    public int getLevel() {
        return level;
    }

    public int getNextLevel() {
        return nextLevel;
    }

    public void setAwake(boolean awake)
    {
        this.awake=awake;
    }

    
}
