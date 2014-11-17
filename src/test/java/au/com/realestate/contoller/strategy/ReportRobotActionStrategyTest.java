package au.com.realestate.contoller.strategy;

import au.com.realestate.bdm.Direction;
import au.com.realestate.bdm.Robot;
import au.com.realestate.controller.strategy.ReportRobotActionStrategy;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by rbrown on 18/11/2014.
 */
public class ReportRobotActionStrategyTest
{
    private ReportRobotActionStrategy target;
    private ByteArrayOutputStream testStream;

    @Before
    public void setUp() throws Exception
    {
        testStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(testStream);
        target = new ReportRobotActionStrategy(ps);
    }

    @Test
    public void testExecute_NullRobot_Ignored() throws Exception
    {
        // Arrange
        Robot robot = null;

        // Act
        target.execute(robot);

        // Assert
        // No errors assumes it ignored.
    }

    @Test
    public void testExecute_UninitialisedRobot_Ignored() throws Exception
    {
        // Arrange
        Robot robot = new Robot();

        // Act
        target.execute(robot);

        // Assert
        Assert.assertNull(robot.getDirection());
        Assert.assertFalse(robot.isInitialised());
    }

    @Test
    public void testExecute_ReportsCorrectly() throws Exception
    {
        // Arrange
        Robot robot = new Robot(1, 2, Direction.NORTH);

        // Act
        target.execute(robot);

        // Assert
        String output = testStream.toString("UTF8");
        Assert.assertEquals("1,2,NORTH" + System.lineSeparator(), output);
    }

}
