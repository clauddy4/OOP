package main.lab3.car;

class Transmission {
    private int[] gears = {-1, 0, 1, 2, 3, 4, 5};
    private int gear = 0;

    int getGear() {
        return gear;
    }

    boolean setGear(int nextGear, int speed, EDirection direction) {
        boolean canSetReverseGear = nextGear == gears[0] && speed == 0 && (direction == EDirection.STAY || direction == EDirection.BACK);
        boolean canSetNeutralGear = nextGear == gears[1] && 0 <= speed && speed <= 150;
        boolean canSetFirstGear = nextGear == gears[2] && 0 <= speed && speed <= 30 && (direction == EDirection.FORWARD || direction == EDirection.STAY);
        boolean canSetSecondGear = nextGear == gears[3] && 20 <= speed && speed <= 50 && direction == EDirection.FORWARD;
        boolean canSetThirdGear = nextGear == gears[4] && 30 <= speed && speed <= 60 && direction == EDirection.FORWARD;
        boolean canSetFourthGear = nextGear == gears[5] && 40 <= speed && speed <= 90 && direction == EDirection.FORWARD;
        boolean canSetFifthGear = nextGear == gears[6] && 50 <= speed && speed <= 150 && direction == EDirection.FORWARD;
        if (canSetReverseGear) {
            return setReverseGear();
        } else if (canSetNeutralGear) {
            return setNeutralGear();
        } else if (canSetFirstGear) {
            boolean isCarStay = gear == gears[0] && speed == 0;
            boolean isReverseGear = gear == gears[0];
            if (isCarStay|| !isReverseGear) {
                return setFirstGear();
            }
        } else if (canSetSecondGear) {
            return setSecondGear();
        } else if (canSetThirdGear) {
            return setThirdGear();
        } else if (canSetFourthGear) {
            return setFourthGear();
        } else if (canSetFifthGear) {
            return setFifthGear();
        }
        return false;
    }

    boolean checkCanSetSpeed(int nextSpeed, int speed) {
        boolean canSetReverseSpeed = nextSpeed >= 0 && nextSpeed <= 20 && gear == gears[0];
        boolean canSetNeutralSpeed = nextSpeed >= 0 && nextSpeed <= 150 && gear == gears[1] && nextSpeed <= speed;
        boolean canSetFirstSpeed = nextSpeed >= 0 && nextSpeed <= 30 && gear == gears[2];
        boolean canSetSecondSpeed = nextSpeed >= 20 && nextSpeed <= 50 && gear == gears[3];
        boolean canSetThirdSpeed = nextSpeed >= 30 && nextSpeed <= 60 && gear == gears[4];
        boolean canSetFourthSpeed = nextSpeed >= 40 && nextSpeed <= 90 && gear == gears[5];
        boolean canSetFifthSpeed = nextSpeed >= 50 && nextSpeed <= 150 && gear == gears[6];

        return  canSetReverseSpeed ||
                canSetNeutralSpeed ||
                canSetFirstSpeed ||
                canSetSecondSpeed ||
                canSetThirdSpeed ||
                canSetFourthSpeed ||
                canSetFifthSpeed;
    }

    private boolean setReverseGear() {
        gear = gears[0];
        return true;
    }
    private boolean setNeutralGear() {
        gear = gears[1];
        return true;
    }
    private boolean setFirstGear() {
        gear = gears[2];
        return true;
    }
    private boolean setSecondGear() {
        gear = gears[3];
        return true;
    }
    private boolean setThirdGear() {
        gear = gears[4];
        return true;
    }
    private boolean setFourthGear() {
        gear = gears[5];
        return true;
    }
    private boolean setFifthGear() {
        gear = gears[6];
        return true;
    }
}
