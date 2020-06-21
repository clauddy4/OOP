package main.lab3.car;

public class Car {
    private boolean engineState = false;
    private Direction direction = Direction.STAY;
    private final Transmission transmission = new Transmission();
    private int speed;

    public Direction getDirection() {
        return direction;
    }

    public boolean getEngineState() {
        return engineState;
    }

    public int getGear() {
        return transmission.getGear();
    }

    public boolean setGear(int nextGear) {
        setDirection(nextGear);
        if (!engineState) {
            if (nextGear == 0) {
                return transmission.setGear(nextGear, speed, direction);
            }
        } else {
            return transmission.setGear(nextGear, speed, direction);
        }
        return false;
    }

    public int getSpeed() {
        return speed;
    }

    private void setDirection(int nextGear) {
        if (transmission.getGear() > 0) {
            if (direction != Direction.BACK && speed != 0) {
                direction = Direction.FORWARD;
            }
        } else if (transmission.getGear() < 0) {
            direction = Direction.BACK;
        } else if (speed == 0) {
            direction = Direction.STAY;
        }
        if ((nextGear == -1 && speed == 0 && (direction == Direction.STAY || direction == Direction.BACK)) || (speed == 0 && nextGear == 0)) {
            direction = Direction.STAY;
        }
    }

    public boolean turnOnEngine() {
        if (engineState) {
            return false;
        }
        engineState = true;
        return true;
    }

    public boolean turnOffEngine() {
        if (engineState && transmission.getGear() == 0 && direction.equals(Direction.STAY)) {
            engineState = false;
            return true;
        }
        return false;
    }

    public boolean setSpeed(int nextSpeed) {
        if (transmission.getGear() == -1 && nextSpeed != 0) {
            direction = Direction.BACK;
        }
        if (transmission.getGear() == 0 && nextSpeed == 0) {
            direction = Direction.STAY;
        }
        if (transmission.getGear() > 0 && nextSpeed > 0 && transmission.checkCanSetSpeed(nextSpeed, speed)) {
            direction = Direction.FORWARD;
        }
        if (transmission.checkCanSetSpeed(nextSpeed, speed)) {
            speed = nextSpeed;
            return true;
        }
        return false;
    }
}