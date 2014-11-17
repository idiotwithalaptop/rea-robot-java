package au.com.realestate.controller;

import au.com.realestate.bdm.Robot;
import au.com.realestate.controller.strategy.*;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Controller class for this application.  It's core responsibility is to parse the user's input and
 * utilises a strategy pattern, see gang of four's Design Patterns book, to identify the relevant commands.
 *
 * Created by rbrown on 18/11/2014.
 */
public class RobotController
{
    private static final Pattern COMMAND_REGEX = Pattern.compile("(\\S+)( (\\S+,)\\S+)?");
    private Robot robot;
    private Map<String, IRobotActionStrategy> actionStrategies;

    /**
     * Contstructor.  Allows for the maximum X and Y values to be set as well as the stream to write any reporting to.
     * @param maximumXValue The maximum X value for the robot, before it falls off the table.
     * @param maximumYValue The maximum Y value for the robot, before it falls off the table.
     * @param streamOut The stream to write the reporting to.
     */
    public RobotController(int maximumXValue, int maximumYValue, PrintStream streamOut)
    {
        robot = new Robot();
        actionStrategies = new HashMap<String, IRobotActionStrategy>();
        actionStrategies.put("PLACE", new PlaceRobotActionStrategy(maximumXValue, maximumYValue));
        actionStrategies.put("MOVE", new MoveRobotActionStrategy(maximumXValue, maximumYValue));
        actionStrategies.put("LEFT", new TurnLeftRobotActionStrategy());
        actionStrategies.put("RIGHT", new TurnRightRobotActionStrategy());
        actionStrategies.put("REPORT", new ReportRobotActionStrategy(streamOut));
    }

    /**
     * Returns the robot currently being used in this controller.
     * @return The robot currently being used in this controller.
     */
    public Robot getRobot()
    {
        return robot;
    }

    /**
     * Processes all the commands in the provided string.  The String is expected to be comprised of a mixture of:
     * PLACE X,Y,D
     * MOVE
     * LEFT
     * RIGHT
     * REPORT
     *
     * All other values are ignored.  PLACE must be called first in order to subsequent commands to be interpreted.
     *
     * @param commands The commands to process and execute
     */
    public void processCommands(String commands)
    {
        if(commands != null)
        {
            Matcher matcher = COMMAND_REGEX.matcher(commands);
            // For each detected command
            while (matcher.find())
            {
                // Extract command.  Should be PLACE, REPORT, LEFT, RIGHT or MOVE
                String command = matcher.group(1);
                // Get related strategy for this command.
                IRobotActionStrategy strategy = actionStrategies.get(command);
                if (strategy != null)
                {
                    // Extract arguments if they exist and execute
                    String args = matcher.group(2);
                    if (args == null)
                    {
                        strategy.execute(robot);
                    }
                    else
                    {
                        strategy.execute(robot, args.trim().split(","));
                    }

                }
            }
        }
    }
}
