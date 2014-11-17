package au.com.realestate.contoller;

import au.com.realestate.bdm.Direction;
import au.com.realestate.controller.RobotController;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by rbrown on 18/11/2014.
 */
public class RobotControllerTest
{
    private static final int MAX_X = 5;
    private static final int MAX_Y = 5;
    private RobotController target;
    private ByteArrayOutputStream testStream;

    @Before
    public void setUp() throws Exception
    {
        testStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(testStream);
        target = new RobotController(MAX_X, MAX_Y, ps);
    }

    @Test
    public void testProcessCommands_NullCommands_Ignored() throws Exception
    {
        // Arrange
        String commands = null;

        // Act
        target.processCommands(commands);

        // Assert
    }

    @Test
    public void testProcessCommands_InvalidCommands_Ignored() throws Exception
    {
        // Arrange
        String commands = "A WHOLE LOT,OF INVALID COMMANDS";

        // Act
        target.processCommands(commands);

        // Assert
        Assert.assertFalse(target.getRobot().isInitialised());
    }

    @Test
    public void testProcessCommands_ValidCommands_ReportsExpected() throws Exception
    {

        // Arrange
        String commands = "PLACE 1,2,EAST MOVE MOVE LEFT MOVE REPORT";

        // Act
        target.processCommands(commands);

        // Assert
        Assert.assertTrue(target.getRobot().isInitialised());
        Assert.assertEquals(3, target.getRobot().getX());
        Assert.assertEquals(3, target.getRobot().getY());
        Assert.assertEquals(Direction.NORTH, target.getRobot().getDirection());
        String output = testStream.toString("UTF8");
        Assert.assertEquals("3,3,NORTH" + System.lineSeparator(), output);
    }
}
