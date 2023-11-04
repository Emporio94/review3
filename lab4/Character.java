package ioop.lab4;

public class Character extends TravellingWorldEntity {
    protected Coordinates goal;
    // Task 3.2
    public Character(String name, Coordinates location, int maxHealth, World world, Damage attack, Coordinates goal) {
        super(name, location, maxHealth, world, attack);
        this.goal = goal;
    }

    // Task 3.2
    public void takeTurn()
    {
        move(this.location.getNextStepTo(this.goal));
    }





}
