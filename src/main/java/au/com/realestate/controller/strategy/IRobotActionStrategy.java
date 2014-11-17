package au.com.realestate.controller.strategy;

import au.com.realestate.bdm.Robot;

/**
 * Robot Action utilised using a strategy pattern.  This interface provides the methods to be utilised in
 * integrating with the REA Robot.
 *
 * Created by rbrown on 17/11/2014.
 */
public interface IRobotActionStrategy
{

    /**
     * Executes the strategy on the robot with the given, optional, arguments
     * @param robot The robot to execute the strategy on.
     * @param args The arguments for the strategy.
     */
    void execute(Robot robot, String... args);
}
