package au.com.realestate.bdm;

/**
 * Represents the valid directions for the robot.
 *
 * Includes differences (deltas) to be applied to the X and Y coordinates that can be used to calculate movement.
 *
 * Created by rbrown on 17/11/2014.
 */
public enum Direction
{
    NORTH(0, 1),
    EAST(1, 0),
    SOUTH(0, -1),
    WEST(-1, 0);

    private int deltaX;
    private int deltaY;

    private Direction(int deltaX, int deltaY)
    {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public int getDeltaX()
    {
        return deltaX;
    }

    public int getDeltaY()
    {
        return deltaY;
    }
}
