package ioop.lab4;

public class Blob extends Monster{
    public Blob(String name, Coordinates location, int maxHealth, World world, Damage attack, int speed) {
        super(name, location, maxHealth, world, attack, speed);
    }

    public void encounter(WorldEntity traveller)
    {
        if (traveller instanceof Blob) {
            //absorb
            this.maxHealth += traveller.getMaxHealth();
            this.currentHealth += traveller.getCurrentHealth();
            Blob copy = (Blob) traveller;
            this.xp += copy.getXp();
            traveller.setCurrentHealth(0);
        } else world.battle(this, traveller);

    }


}
