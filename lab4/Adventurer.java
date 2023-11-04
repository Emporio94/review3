package ioop.lab4;

public class Adventurer extends WorldEntity{

    private Damage[] attacks = new Damage[3];


    // Task 3.1
    public Adventurer(String name, Coordinates location, int maxHealth, World world, Damage attack) {
        super(name, location, maxHealth, world, attack);
        this.attacks[0] = attack;
    }

    // Task 3.1
    public void addAttack(Damage attack)
    {
        if (this.attacks[1] == null) this.attacks[1] = attack;
        else this.attacks[2] = attack; 
    }

    // Task 3.1
    public void attack(WorldEntity target)
    {
        for (int attackCycle = 0; attackCycle < 2; attackCycle++) {
            this.attack(target);
        }
    }

    public Damage[] getAttacks()
    {
        return attacks;
    }
    


}