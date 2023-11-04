package ioop.lab4;

public class Healer extends Character {
    
    public Healer(String name, Coordinates location, int maxHealth, World world, Damage attack, Coordinates goal) {
        super(name, location, maxHealth, world, attack, goal);
    }

    private void heal(WorldEntity target) {
        target.setCurrentHealth(target.getMaxHealth());
    }

    // Task 3.2
    public void encounter(WorldEntity traveller) {
        if (traveller instanceof Adventurer) this.heal(traveller);
        else { 
            if (traveller instanceof Monster) world.battle(this, traveller);
            else System.out.println("In a distant land a healer waves kindly to their fellow character and invites them for a cup of herbal tea.");
        }
    }







}
