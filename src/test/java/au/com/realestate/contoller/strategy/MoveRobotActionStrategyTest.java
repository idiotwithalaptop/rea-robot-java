package au.com.realestate.contoller.strategy;

import au.com.realestate.bdm.Direction;
import au.com.realestate.bdm.Robot;
import au.com.realestate.controller.strategy.MoveRobotActionStrategy;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by rbrown on 17/11/2014.
 */
public class MoveRobotActionStrategyTest
{
    private MoveRobotActionStrategy target;
    private static final int MAX_X = 10;
    private static final int MAX_Y = 10;

    @Before
    public void setUp() throws Exception
    {
        target = new MoveRobotActionStrategy(MAX_X, MAX_Y);
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
        Assert.assertNull(robot.getX());
        Assert.assertNull(robot.getY());
        Assert.assertFalse(robot.isInitialised());
    }

    @Test
    public void testExecute_LargeX_MaximumUsed() throws Exception
    {
        // Arrange
        int expectedX = 5;
        int expectedY = 3;
        Direction expectedDirection = Direction.EAST;
        Robot robot = new Robot(5, 3, Direction.EAST);

        // Act
        target.execute(robot);

        // Assert
        Assert.assertEquals(expectedDirection, robot.getDirection());
        Assert.assertEquals(expectedX, robot.getX());
        Assert.assertEquals(expectedY, robot.getY());
    }

    @Test
    public void testExecute_LargeY_MaximumUsed() throws Exception
    {
        // Arrange
        int expectedX = 3;
        int expectedY = 5;
        Direction expectedDirection = Direction.NORTH;
        Robot robot = new Robot(3, 5, Direction.NORTH);

        // Act
        target.execute(robot);

        // Assert
        Assert.assertEquals(expectedDirection, robot.getDirection());
        Assert.assertEquals(expectedX, robot.getX());
        Assert.assertEquals(expectedY, robot.getY());
    }

    @Test
    public void testExecute_NegativeX_MinimumUsed() throws Exception
    {
        // Arrange
        int expectedX = 0;
        int expectedY = 3;
        Direction expectedDirection = Direction.WEST;
        Robot robot = new Robot(0, 3, Direction.WEST);

        // Act
        target.execute(robot);

        // Assert
        Assert.assertEquals(expectedDirection, robot.getDirection());
        Assert.assertEquals(expectedX, robot.getX());
        Assert.assertEquals(expectedY, robot.getY());
    }

    @Test
    public void testExecute_NegativeY_MaximumUsed() throws Exception
    {
        // Arrange
        int expectedX = 3;
        int expectedY = 0;
        Direction expectedDirection = Direction.SOUTH;
        Robot robot = new Robot(3, 0, Direction.SOUTH);

        // Act
        target.execute(robot);

        // Assert
        Assert.assertEquals(expectedDirection, robot.getDirection());
        Assert.assertEquals(expectedX, robot.getX());
        Assert.assertEquals(expectedY, robot.getY());
    }

    @Test
    public void testExecute_Valid_MovesNorth() throws Exception
    {
        // Arrange
        int expectedX = 3;
        int expectedY = 4;
        Direction expectedDirection = Direction.NORTH;
        Robot robot = new Robot(3, 3, Direction.NORTH);

        // Act
        target.execute(robot);

        // Assert
        Assert.assertEquals(expectedDirection, robot.getDirection());
        Assert.assertEquals(expectedX, robot.getX());
        Assert.assertEquals(expectedY, robot.getY());
    }

    @Test
    public void testExecute_Valid_MovesEast() throws Exception
    {
        // Arrange
        int expectedX = 5;
        int expectedY = 3;
        Direction expectedDirection = Direction.EAST;
        Robot robot = new Robot(5, 3, Direction.EAST);

        // Act
        target.execute(robot);

        // Assert
        Assert.assertEquals(expectedDirection, robot.getDirection());
        Assert.assertEquals(expectedX, robot.getX());
        Assert.assertEquals(expectedY, robot.getY());
    }

    @Test
    public void testExecute_Valid_MovesSouth() throws Exception
    {
        // Arrange
        int expectedX = 3;
        int expectedY = 0;
        Direction expectedDirection = Direction.SOUTH;
        Robot robot = new Robot(3, 0, Direction.SOUTH);

        // Act
        target.execute(robot);

        // Assert
        Assert.assertEquals(expectedDirection, robot.getDirection());
        Assert.assertEquals(expectedX, robot.getX());
        Assert.assertEquals(expectedY, robot.getY());
    }

    @Test
    public void testExecute_Valid_MovesWest() throws Exception
    {
        // Arrange
        int expectedX = 0;
        int expectedY = 3;
        Direction expectedDirection = Direction.WEST;
        Robot robot = new Robot(0, 3, Direction.WEST);

        // Act
        target.execute(robot);

        // Assert
        Assert.assertEquals(expectedDirection, robot.getDirection());
        Assert.assertEquals(expectedX, robot.getX());
        Assert.assertEquals(expectedY, robot.getY());
    }
}
