package au.com.realestate.bdm;

/**
 * Represents the robot to be moved.
 * This class is simply a Java Bean that tracks the robot's X and Y coordinates and the direction that
 * it is current pointing.
 *
 * Created by rbrown on 17/11/2014.
 */
public class Robot
{
    private int x;
    private int y;
    private Direction direction;

    /**
     * Default constructor
     */
    public Robot()
    {
    }

    /**
     * Constructor that provides default values for the coordinates and direction.
     * @param x The X Coordinate to begin at.
     * @param y The Y Coordinate to begin at.
     * @param direction The direction to begin pointing in.
     */
    public Robot(int x, int y, Direction direction)
    {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    /**
     * Getter method for the X Coordinate
     * @return The X Coordinate
     */
    public int getX()
    {
        return x;
    }

    /**
     * Setter method that sets the X Coordinate.
     * @param x The new X Coordinate
     */
    public void setX(int x)
    {
        this.x = x;
    }

    /**
     * Getter method for the Y Coordinate
     * @return The Y Coordinate
     */
    public int getY()
    {
        return y;
    }

    /**
     * Setter method that sets the Y Coordinate.
     * @param y The new Y Coordinate
     */
    public void setY(int y)
    {
        this.y = y;
    }

    /**
     * Getter method for the robot's current direction
     * @return The robot's current direction
     */
    public Direction getDirection()
    {
        return direction;
    }

    /**
     * Setter method that sets the robot's current direction
     * @param direction The robot's new direction.
     */
    public void setDirection(Direction direction)
    {
        this.direction = direction;
    }

    /**
     * Returns true if the robot has been initialised (ie: X & Y coordinates and Direction are set.)
     * @return
     */
    public boolean isInitialised()
    {
        return x >= 0 && y >= 0 && direction != null;
    }
}
