package ioop.lab4;

public class Wizard extends Character{

    public Wizard(String name, Coordinates location, int maxHealth, World world, Damage attack, Coordinates goal) {
        super(name, location, maxHealth, world, attack, goal);
    }

    // Task 3.2
    public void encounter(WorldEntity traveller) {
        if(traveller instanceof Monster) world.battle(this, traveller);
        else { 
            if(traveller instanceof Adventurer) {
               Damage attack = new Damage(10, DamageType.FIRE);
                ((Adventurer)traveller).addAttack(attack);
            }
            
            System.out.println("In a distant land a healer waves kindly to their fellow character and invites them for a cup of herbal tea.");
        }
    }
}
