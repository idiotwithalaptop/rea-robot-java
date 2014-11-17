package au.com.realestate.controller.strategy;

import au.com.realestate.bdm.Direction;
import au.com.realestate.bdm.Robot;
import org.apache.log4j.Logger;

/**
 * Robot Action utilised using a strategy pattern.  This implementation moves the robot in the direction is is facing.
 * It's key responsibilties is to validate the movement to ensure the robot won't fall off the table and updates the
 * robot's position.
 *
 * Created by rbrown on 17/11/2014.
 */
public class MoveRobotActionStrategy implements IRobotActionStrategy
{
    private static Logger LOG = Logger.getLogger(MoveRobotActionStrategy.class);
    private static final int MIN_COORDINATE_VALUE = 0;

    private int maximumXValue;
    private int maximumYValue;

    /**
     * Constructor.  Accepts maximum values for the X and Y coordinates of the current robot context.
     * @param maximumXValue The maximum X coordinate
     * @param maximumYValue The maximum Y coordinate.
     */
    public MoveRobotActionStrategy(int maximumXValue, int maximumYValue)
    {
        this.maximumXValue = maximumXValue;
        this.maximumYValue = maximumYValue;
    }

    /**
     * Validates the movement, ensuring the robot will not fall off it's table, and then updates
     * the robot's position.
     * @param robot The robot to execute the strategy on.
     * @param args The arguments for the strategy.
     */
    @Override
    public void execute(Robot robot, String... args)
    {
        if(robot == null)
        {
            LOG.error("Provided Robot is null");
            return;
        }

        if(!robot.isInitialised())
        {
            LOG.error("Provided robot has not been initialised.  Ignoring.");
            return;
        }

        Direction direction = robot.getDirection();
        int x = robot.getX() + direction.getDeltaX();
        if(x > maximumXValue)
        {
            LOG.debug("Robot almost fell off table, setting to maximum");
            x = maximumXValue;
        }
        if(x < MIN_COORDINATE_VALUE)
        {
            LOG.debug("Robot almost fell off table, setting to minimum");
            x = MIN_COORDINATE_VALUE;
        }

        int y = robot.getY() + direction.getDeltaY();
        if(y > maximumXValue)
        {
            LOG.debug("Robot almost fell off table, setting to maximum");
            y = maximumYValue;
        }
        if(y < MIN_COORDINATE_VALUE)
        {
            LOG.debug("Robot almost fell off table, setting to minimum");
            y = MIN_COORDINATE_VALUE;
        }

        robot.setX(x);
        robot.setY(y);
    }
}
