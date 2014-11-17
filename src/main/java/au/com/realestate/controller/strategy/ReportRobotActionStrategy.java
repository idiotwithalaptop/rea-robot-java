package au.com.realestate.controller.strategy;

import au.com.realestate.bdm.Robot;
import org.apache.log4j.Logger;

import java.io.PrintStream;

/**
 * Created by rbrown on 18/11/2014.
 */
public class ReportRobotActionStrategy implements IRobotActionStrategy
{
    private static final Logger LOG = Logger.getLogger(ReportRobotActionStrategy.class);

    private PrintStream streamOut;

    public ReportRobotActionStrategy(PrintStream streamOut)
    {
        this.streamOut = streamOut;
    }

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

        streamOut.println(robot.toString());
    }
}
