package au.com.realestate.controller.strategy;

import au.com.realestate.bdm.Direction;
import au.com.realestate.bdm.Robot;
import org.apache.log4j.Logger;

/**
 * Robot Action utilised using a strategy pattern.  This implementation places the robot on the defined co-ordinates
 * provided.  It's key responsibilties is to parse and validate the inputs and place the robot.
 * <p/>
 * Created by rbrown on 17/11/2014.
 */
public class PlaceRobotActionStrategy implements IRobotActionStrategy
{
    private static Logger LOG = Logger.getLogger(PlaceRobotActionStrategy.class);
    private static final int MIN_COORDINATE_VALUE = 0;

    public static final int EXPECTED_NO_OF_ARGS = 3;

    private int maximumXValue;
    private int maximumYValue;

    /**
     * Constructor.  Accepts maximum values for the X and Y coordinates of the current robot context.
     *
     * @param maximumXValue The maximum X coordinate
     * @param maximumYValue The maximum Y coordinate.
     */
    public PlaceRobotActionStrategy(int maximumXValue, int maximumYValue)
    {
        this.maximumXValue = maximumXValue;
        this.maximumYValue = maximumYValue;
    }

    /**
     * Parses and validates the inputs and places the robot on the defined co-ordinates.
     *
     * @param robot The robot to place
     * @param args  The arguments.  Expected to have 3 values: X Coordinate, Y Coordinate, Direction.
     */
    @Override
    public void execute(Robot robot, String... args)
    {
        // Validate arguments
        if (robot == null)
        {
            LOG.error("Provided Robot is null");
            return;
        }
        if (args == null)
        {
            LOG.error("Provided arguments are null");
            return;
        }
        if (args.length < EXPECTED_NO_OF_ARGS)
        {
            LOG.error("Provided arguments are null");
            return;
        }

        // Parse X
        int x;
        try
        {
            x = Integer.parseInt(args[0]);
        }
        catch (NumberFormatException e)
        {
            // X a invalid integer.  Log error and ignore.
            LOG.error("Error parsing x value", e);
            return;
        }
        if (x > maximumXValue)
        {
            LOG.debug(String.format("X value, %d, greater than allowed maximum %d.  Setting to maximum", x, maximumXValue));
            x = maximumXValue;
        }
        if (x < MIN_COORDINATE_VALUE)
        {
            LOG.debug(String.format("X value, %d, less than allowed minimum %d.  Setting to minimum", x, MIN_COORDINATE_VALUE));
            x = MIN_COORDINATE_VALUE;
        }

        // Parse Y
        int y;
        try
        {
            y = Integer.parseInt(args[1]);
        }
        catch (NumberFormatException e)
        {
            // Y a invalid integer.  Log error and ignore.
            LOG.error("Error parsing y value", e);
            return;
        }
        if (y > maximumYValue)
        {
            LOG.error(String.format("Y value, %d, greater than allowed maximum %d.  Setting to maximum.", y, maximumYValue));
            y = maximumYValue;
        }
        if (y < MIN_COORDINATE_VALUE)
        {
            LOG.debug(String.format("Y value, %d, less than allowed minimum %d.  Setting to minimum", y, MIN_COORDINATE_VALUE));
            y = MIN_COORDINATE_VALUE;
        }

        // Parse Direction
        Direction direction = null;
        try
        {
            direction = Direction.valueOf(args[2]);
        }
        catch (IllegalArgumentException e)
        {
            // Direction is not a valid or supported direction.  Log error and ignore.
            LOG.error("Invalid direction specified", e);
            return;
        }

        // Place robot
        robot.setX(x);
        robot.setY(y);
        robot.setDirection(direction);
    }

}
