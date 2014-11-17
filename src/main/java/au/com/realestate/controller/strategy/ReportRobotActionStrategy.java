package au.com.realestate.controller.strategy;

import au.com.realestate.bdm.Robot;
import org.apache.log4j.Logger;

import java.io.PrintStream;

/**
 * Robot Action utilised using a strategy pattern.  This implementation reports the robot's status to the
 * provided print stream.
 *
 * Created by rbrown on 18/11/2014.
 */
public class ReportRobotActionStrategy implements IRobotActionStrategy
{
    private static final Logger LOG = Logger.getLogger(ReportRobotActionStrategy.class);

    private PrintStream streamOut;

    /**
     * Constructor, requires a print stream to be provided to print the robot's status to.
     * @param streamOut
     */
    public ReportRobotActionStrategy(PrintStream streamOut)
    {
        this.streamOut = streamOut;
    }

    /**
     * Reports the robot's status to the provided print stream.
     * @param robot The robot to execute the strategy on.
     * @param args The arguments for the strategy.
     */
    @Override
    public void execute(Robot robot, String... args)
    {
        // Validate inputs
        if(robot == null)
        {
            LOG.error("Provided Robot is null");
            return;
        }

        // Validate robot is initialised.
        if(!robot.isInitialised())
        {
            LOG.error("Provided robot has not been initialised.  Ignoring.");
            return;
        }

        // Print the report string to the print stream
        streamOut.println(robot.toString());
    }
}
