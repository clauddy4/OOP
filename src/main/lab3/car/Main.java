package main.lab3.car;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean driving = true;
        final Car car = new Car();
        while (driving) {
            final Scanner scanner = new Scanner(System.in);
            final String command = scanner.next();
            switch (command) {
                case "Info":
                    System.out.print("engine state: ");
                    if (car.getEngineState()) {
                        System.out.println("on");
                    } else {
                        System.out.println("off");
                    }
                    System.out.println("direction: " + car.getDirection());
                    System.out.println("speed: " + car.getSpeed());
                    System.out.println("gear: " + car.getGear());
                    break;
                case "EngineOn":
                    boolean engine = car.turnOnEngine();
                    if (!engine) {
                        System.out.println("Engine cannot be turned on");
                    }
                    break;
                case "EngineOff":
                    engine = car.turnOffEngine();
                    if (!engine) {
                        System.out.println("Engine cannot be turned off");
                    }
                    break;
                case "SetGear":
                    final int gear = scanner.nextInt();
                    car.setGear(gear);
                    break;
                case "SetSpeed":
                    final int speed = scanner.nextInt();
                    car.setSpeed(speed);
                    break;
                case "Stop":
                    driving = false;
                    break;
                default:
                    System.out.println("Please enter one of the options: Info, EngineOn, EngineOff, SetGear, SetSpeed, Stop");
                    break;
            }
        }
    }
}