package main.lab3.car;

class Car {
    private boolean engineState = false;
    private EDirection direction = EDirection.STAY;
    private Transmission transmission = new Transmission();
    private int speed;

    EDirection getDirection() {
        return direction;
    }

    boolean getEngineState() {
        return engineState;
    }

    int getGear() {
        return transmission.getGear();
    }

    boolean setGear(int nextGear) {
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

    int getSpeed() {
        return speed;
    }

    private void setDirection(int nextGear) {
        if (transmission.getGear() > 0) {
            if (direction != EDirection.BACK && speed != 0) {
                direction = EDirection.FORWARD;
            }
        } else if (transmission.getGear() < 0) {
            direction = EDirection.BACK;
        } else if (speed == 0) {
            direction = EDirection.STAY;
        }
        if ((nextGear == -1 && speed == 0 && (direction == EDirection.STAY || direction == EDirection.BACK)) || (speed == 0 && nextGear == 0)) {
            direction = EDirection.STAY;
        }
    }

    boolean turnOnEngine() {
        if (engineState) {
            return false;
        }
        engineState = true;
        return true;
    }

    boolean turnOffEngine() {
        if (engineState && transmission.getGear() == 0 && direction.equals(EDirection.STAY)) {
            engineState = false;
            return true;
        }
        return false;
    }

    boolean setSpeed(int nextSpeed) {
        if (transmission.getGear() == -1 && nextSpeed != 0) {
            direction = EDirection.BACK;
        }
        if (transmission.getGear() == 0 && nextSpeed == 0) {
            direction = EDirection.STAY;
        }
        if (transmission.getGear() > 0 && nextSpeed > 0 && transmission.checkCanSetSpeed(nextSpeed, speed)) {
            direction = EDirection.FORWARD;
        }
        if (transmission.checkCanSetSpeed(nextSpeed, speed)) {
            speed = nextSpeed;
            return true;
        }
        return false;
    }
}