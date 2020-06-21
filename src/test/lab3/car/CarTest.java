package test.lab3.car;

import main.lab3.car.Car;
import main.lab3.car.Direction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {
    private Car car = new Car();
    private final Direction BACK = Direction.BACK;
    private final Direction STAY = Direction.STAY;
    private final Direction FORWARD = Direction.FORWARD;

    @Before
    public void setUp() {
        car = new Car();
    }

    @Test
    public void turnOnEngineTest() {
        car.turnOnEngine();
        assertTrue(car.getEngineState());
        assertEquals(0, car.getGear());
        assertEquals(STAY, car.getDirection());
    }

    @Test
    public void turnOffEngineTest() {
        car.turnOnEngine();
        car.turnOffEngine();
        assertFalse(car.getEngineState());
        assertEquals(0, car.getSpeed());
        assertEquals(0, car.getGear());
    }

    @Test
    public void setGearTest() {
        assertTrue(car.setGear(0));
        assertFalse(car.setGear(2));
        car.turnOnEngine();
        assertTrue(car.setGear(1));
        car.setSpeed(25);
        car.setGear(2);
        assertEquals(2, car.getGear());
        car.setSpeed(35);
        car.setGear(3);
        assertEquals(3, car.getGear());
        car.setSpeed(45);
        car.setGear(4);
        assertEquals(4, car.getGear());
        car.setSpeed(55);
        car.setGear(5);
        assertEquals(5, car.getGear());

    }

    @Test
    public void setSpeedTest() {
        car.turnOnEngine();
        car.setGear(1);
        assertTrue(car.setSpeed(10));
        assertFalse(car.setSpeed(50));
        car.setSpeed(25);
        car.setGear(2);
        assertTrue(car.setSpeed(30));
        assertFalse(car.setSpeed(60));
        car.setSpeed(40);
        car.setGear(3);
        assertTrue(car.setSpeed(50));
        assertFalse(car.setSpeed(70));
        car.setSpeed(55);
        car.setGear(4);
        assertTrue(car.setSpeed(70));
        assertFalse(car.setSpeed(100));
        car.setSpeed(70);
        car.setGear(5);
        assertTrue(car.setSpeed(120));
        assertFalse(car.setSpeed(160));
    }

    @Test
    public void neutralGearTest() {
        car.turnOnEngine();
        car.setGear(1);
        assertEquals(1, car.getGear());
        car.setSpeed(25);
        car.setGear(2);
        car.setSpeed(40);
        car.setGear(0);
        assertEquals(0, car.getGear());
        assertTrue(car.setSpeed(35));
        assertFalse(car.setSpeed(45));
    }

    @Test
    public void reverseGearTest() {
        car.turnOnEngine();
        car.setGear(-1);
        assertEquals(STAY, car.getDirection());
        car.setSpeed(10);
        car.setGear(0);
        assertFalse(car.setGear(1));
        assertFalse(car.setGear(2));
        assertFalse(car.setGear(3));
        assertFalse(car.setGear(4));
        assertFalse(car.setGear(5));
        car.setSpeed(0);
        assertTrue(car.setGear(1));
    }

    @Test
    public void cantOffTheEngineWhileNonNeutral() {
        car.turnOnEngine();
        car.setGear(-1);
        assertFalse(car.turnOffEngine());
        car.setGear(0);
        car.setGear(1);
        assertFalse(car.turnOffEngine());
    }

    @Test
    public void cantChooseNonNeutralWhileEngineIsOff() {
        assertFalse(car.setGear(1));
        assertFalse(car.setGear(5));
    }

    @Test
    public void cantTurnEngineOffWhileMoving() {
        car.turnOnEngine();
        car.setGear(1);
        car.setSpeed(10);
        assertFalse(car.turnOffEngine());
    }
}