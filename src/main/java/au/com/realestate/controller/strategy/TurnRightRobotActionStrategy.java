package au.com.realestate.controller.strategy;

import au.com.realestate.bdm.Direction;
import au.com.realestate.bdm.Robot;
import org.apache.log4j.Logger;

/**
 * Robot Action utilised using a strategy pattern.  This implementation turns the robot right or clockwise.
 * It's key responsibilties is to validate the robot is initialised and update the robot's direction.
 *
 * Created by rbrown on 17/11/2014.
 */
public class TurnRightRobotActionStrategy implements IRobotActionStrategy
{
    private static Logger LOG = Logger.getLogger(TurnRightRobotActionStrategy.class);

    /**
     * Validates the robot is initialised and update the robot's direction to the next position to the right or
     * clockwise.
     *
     * @param robot The robot to execute the strategy on.
     * @param args  The arguments for the strategy.
     */
    @Override
    public void execute(Robot robot, String... args)
    {
        // Validate inputs
        if (robot == null)
        {
            LOG.error("Provided Robot is null");
            return;
        }

        // Validate robot is initialised.
        if (!robot.isInitialised())
        {
            LOG.error("Provided robot has not been initialised.  Ignoring.");
            return;
        }

        // Determines the next direction clockwise.
        Direction direction = robot.getDirection();
        Direction newDirection = null;
        switch (direction)
        {
            case NORTH:
                newDirection = Direction.EAST;
                break;
            case EAST:
                newDirection = Direction.SOUTH;
                break;
            case SOUTH:
                newDirection = Direction.WEST;
                break;
            case WEST:
                newDirection = Direction.NORTH;
                break;
        }

        // Sets the new direction.
        robot.setDirection(newDirection);
    }
}
