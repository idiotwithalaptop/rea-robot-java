package au.com.realestate.contoller.strategy;

import au.com.realestate.bdm.Direction;
import au.com.realestate.bdm.Robot;
import au.com.realestate.controller.strategy.TurnRightRobotActionStrategy;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by rbrown on 17/11/2014.
 */
public class TurnRightRobotActionStrategyTest
{
    private TurnRightRobotActionStrategy target;

    @Before
    public void setUp() throws Exception
    {
        target = new TurnRightRobotActionStrategy();
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
    public void testExecute_FacingNorth_MovesEast() throws Exception
    {
        // Arrange
        Direction expectedDirection = Direction.EAST;
        Robot robot = new Robot(3, 3, Direction.NORTH);

        // Act
        target.execute(robot);

        // Assert
        Assert.assertEquals(expectedDirection, robot.getDirection());
    }

    @Test
    public void testExecute_FacingWest_MovesNorth() throws Exception
    {
        // Arrange
        Direction expectedDirection = Direction.NORTH;
        Robot robot = new Robot(3, 3, Direction.WEST);

        // Act
        target.execute(robot);

        // Assert
        Assert.assertEquals(expectedDirection, robot.getDirection());
    }

    @Test
    public void testExecute_FacingSouth_MovesWest() throws Exception
    {
        // Arrange
        Direction expectedDirection = Direction.WEST;
        Robot robot = new Robot(3, 3, Direction.SOUTH);

        // Act
        target.execute(robot);

        // Assert
        Assert.assertEquals(expectedDirection, robot.getDirection());
    }

    @Test
    public void testExecute_FacingEast_MovesSouth() throws Exception
    {
        // Arrange
        Direction expectedDirection = Direction.SOUTH;
        Robot robot = new Robot(3, 3, Direction.EAST);

        // Act
        target.execute(robot);

        // Assert
        Assert.assertEquals(expectedDirection, robot.getDirection());
    }
}
