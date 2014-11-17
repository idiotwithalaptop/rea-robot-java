package au.com.realestate;

import au.com.realestate.controller.RobotController;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Entry point, Main class for the REA Robot simulator.
 *
 * Main responsibility is to accept input from the Standard Input and forward it to the Controller.
 */
public class App
{
    private static final Logger LOG = Logger.getLogger(App.class);

    public static void main(String[] args)
    {
        try
        {
            RobotController controller = new RobotController(5, 5, System.out);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input;
            while ((input = br.readLine()) != null)
            {
                controller.processCommands(input);
            }
        }
        catch (Exception e)
        {
            LOG.fatal("Unexpected error occurred, quitting Robot simulator.  Please check robot.log for more details.");
        }
    }
}
