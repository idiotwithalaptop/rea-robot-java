package au.com.realestate.contoller.strategy;

import au.com.realestate.bdm.Direction;
import au.com.realestate.bdm.Robot;
import au.com.realestate.controller.strategy.PlaceRobotActionStrategy;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by rbrown on 17/11/2014.
 */
public class PlaceRobotActionStrategyTest
{
    private PlaceRobotActionStrategy target;
    private static final int MAX_X = 10;
    private static final int MAX_Y = 10;

    @Before
    public void setup()
    {
        target = new PlaceRobotActionStrategy(MAX_X, MAX_Y);
    }

    @Test
    public void testExecute_NullRobot_Ignored() throws Exception
    {
        // Arrange
        Robot robot = null;
        String[] args = new String[] {"1", "1", "NORTH"};

        // Act
        target.execute(robot, args);

        // Assert
        // No errors, assumed correct
    }

    @Test
    public void testExecute_InvalidArguments_Ignored() throws Exception
    {
        // Arrange
        int expectedX = 1;
        int expectedY = 2;
        Direction expectedDirection = Direction.EAST;
        Robot robot = new Robot(expectedX, expectedY, expectedDirection);

        String[] args = new String[5];

        // Act
        target.execute(robot, args);

        // Assert
        Assert.assertEquals(expectedX, robot.getX());
        Assert.assertEquals(expectedY, robot.getY());
        Assert.assertEquals(expectedDirection, robot.getDirection());
    }

    @Test
    public void testExecute_InvalidXArgument_Ignored() throws Exception
    {
        // Arrange
        int expectedX = 1;
        int expectedY = 2;
        Direction expectedDirection = Direction.EAST;
        Robot robot = new Robot(expectedX, expectedY, expectedDirection);

        String[] args = new String[]{"W", "1", "EAST"};

        // Act
        target.execute(robot, args);

        // Assert
        Assert.assertEquals(expectedX, robot.getX());
        Assert.assertEquals(expectedY, robot.getY());
        Assert.assertEquals(expectedDirection, robot.getDirection());
    }

    @Test
    public void testExecute_InvalidYArgument_Ignored() throws Exception
    {
        // Arrange
        int expectedX = 1;
        int expectedY = 2;
        Direction expectedDirection = Direction.EAST;
        Robot robot = new Robot(expectedX, expectedY, expectedDirection);

        String[] args = new String[]{"4", "A", "EAST"};

        // Act
        target.execute(robot, args);

        // Assert
        Assert.assertEquals(expectedX, robot.getX());
        Assert.assertEquals(expectedY, robot.getY());
        Assert.assertEquals(expectedDirection, robot.getDirection());
    }

    @Test
    public void testExecute_InvalidDirectionArgument_Ignored() throws Exception
    {
        // Arrange
        int expectedX = 1;
        int expectedY = 2;
        Direction expectedDirection = Direction.EAST;
        Robot robot = new Robot(expectedX, expectedY, expectedDirection);

        String[] args = new String[]{"3", "5", "NORTHEAST"};

        // Act
        target.execute(robot, args);

        // Assert
        Assert.assertEquals(expectedX, robot.getX());
        Assert.assertEquals(expectedY, robot.getY());
        Assert.assertEquals(expectedDirection, robot.getDirection());
    }

    @Test
    public void testExecute_LargeXValue_Ignored() throws Exception
    {
        // Arrange
        int expectedX = MAX_X;
        int expectedY = 5;
        Direction expectedDirection = Direction.WEST;
        Robot robot = new Robot();

        String[] args = new String[]{String.valueOf(MAX_X + 1), "5", "WEST"};

        // Act
        target.execute(robot, args);

        // Assert
        Assert.assertEquals(expectedX, robot.getX());
        Assert.assertEquals(expectedY, robot.getY());
        Assert.assertEquals(expectedDirection, robot.getDirection());
    }

    @Test
    public void testExecute_LargeYValue_Ignored() throws Exception
    {
        // Arrange
        int expectedX = 1;
        int expectedY = MAX_Y;
        Direction expectedDirection = Direction.SOUTH;
        Robot robot = new Robot();

        String[] args = new String[]{"1", String.valueOf(MAX_Y + 1), "SOUTH"};

        // Act
        target.execute(robot, args);

        // Assert
        Assert.assertEquals(expectedX, robot.getX());
        Assert.assertEquals(expectedY, robot.getY());
        Assert.assertEquals(expectedDirection, robot.getDirection());
    }

    @Test
    public void testExecute_NegativeXValue_Ignored() throws Exception
    {
        // Arrange
        int expectedX = 0;
        int expectedY = 5;
        Direction expectedDirection = Direction.WEST;
        Robot robot = new Robot();

        String[] args = new String[]{"-1", "5", "WEST"};

        // Act
        target.execute(robot, args);

        // Assert
        Assert.assertEquals(expectedX, robot.getX());
        Assert.assertEquals(expectedY, robot.getY());
        Assert.assertEquals(expectedDirection, robot.getDirection());
    }

    @Test
    public void testExecute_NegativeYValue_Ignored() throws Exception
    {
        // Arrange
        int expectedX = 1;
        int expectedY = MAX_Y;
        Direction expectedDirection = Direction.SOUTH;
        Robot robot = new Robot();

        String[] args = new String[]{"1", "-1", "SOUTH"};

        // Act
        target.execute(robot, args);

        // Assert
        Assert.assertEquals(expectedX, robot.getX());
        Assert.assertEquals(expectedY, robot.getY());
        Assert.assertEquals(expectedDirection, robot.getDirection());
    }

    @Test
    public void testExecute_validArguments_updatesRobotAccordingly() throws Exception
    {
        // Arrange
        int expectedX = 1;
        int expectedY = 2;
        Direction expectedDirection = Direction.EAST;
        Robot robot = new Robot(0, 0, Direction.NORTH);

        String[] args = new String[]{"1", "2", "EAST"};

        // Act
        target.execute(robot, args);

        // Assert
        Assert.assertEquals(expectedX, robot.getX());
        Assert.assertEquals(expectedY, robot.getY());
        Assert.assertEquals(expectedDirection, robot.getDirection());
    }
}
