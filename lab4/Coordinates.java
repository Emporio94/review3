package ioop.lab4;

public class Coordinates {
    public final static Coordinates NORTH_VECTOR = new Coordinates(1, 0);
    public final static Coordinates SOUTH_VECTOR = new Coordinates(-1, 0);
    public final static Coordinates EAST_VECTOR = new Coordinates(0, 1);
    public final static Coordinates WEST_VECTOR = new Coordinates(0, -1);
    public final static Coordinates STATIONARY = new Coordinates(0, 0);

    private int x;
    private int y;

    // Task 1.1
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Task 1.1
    public void addCoordinates(Coordinates vector) {
        this.x += vector.getX();
        this.y += vector.getY();
    }

    // Task 1.1
    public Coordinates findSafeMove(World world) {
        //If outside world return self
        if (this.x < -1) return this;
        if (this.y < -1) return this;
        if (this.x > world.getxDimension() + 1) return this;
        if (this.y > world.getxDimension() + 1) return this;
       
        //Check N, S, E, W
        if (this.x < world.getxDimension() -1) return NORTH_VECTOR;
        if (this.x > 0) return SOUTH_VECTOR;
        if (this.y < world.getxDimension() - 1) return EAST_VECTOR;
        if (this.y > 0) return WEST_VECTOR;
        
        return this;
    }

    // Task 1.2
    public Coordinates getNextStepTo(Coordinates destination) {

        if (destination.getX() == this.x && destination.getY() == this.y) return new Coordinates(0, 0);

        //step value created to streamline negative steps
        int xStepValue = 1;
        int yStepValue = 1;
       
        //Obtain absolute differences in x and y for comparison and set relevant step values
        int xDiff = destination.getX() - this.x;
        int absXDiff = Math.abs(xDiff);
        if (xDiff < 0) xStepValue = -1;

        int yDiff = destination.getY() - this.y;
        int absYDiff = Math.abs(yDiff);
        if (yDiff < 0) xStepValue = -1;

        if (absXDiff >= absYDiff) return new Coordinates(xStepValue, 0);
        else return new Coordinates(0, yStepValue);
    }

    // Task 1.3
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        try { //Use try in case of type cast exception.

            Coordinates check = (Coordinates) obj; 
            if (check.getX() == this.x && check.getY() == this.y) return true;
            return false;

        } catch (Exception ex) {
            return false;
        }
        
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
