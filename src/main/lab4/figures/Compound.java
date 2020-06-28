package main.lab4.figures;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Compound extends Body {
    List<Body> compoundFigures = new LinkedList<>();

    Compound(double density, double volume, double mass) {
        super(density, volume, mass);
    }

    @Override
    public double GetMass() {
        return mass;
    }

    @Override
    double GetVolume() {
        return volume;
    }

    @Override
    double GetDensity() {
        return GetMass() / GetVolume();
    }

    @Override
    String GetName() {
        return "Compound: ";
    }

    @Override
    String OutFigMass() {
        for (Body fig: compoundFigures) {
            System.out.print(fig.GetName());
            System.out.print(" mass ");
            System.out.println(fig.GetMass());
        }
        return "";
    }

    @Override
    String OutFigMassInWater() {
        for (Body fig: compoundFigures) {
            System.out.print(fig.GetName());
            System.out.print(" mass ");
            System.out.println(fig.GetWeightInWater());
        }
        return "";
    }

    boolean AddChildBody(Scanner scanner, List<Body> figures, Compound compound) {
        while (scanner.hasNextLine()) {
            String name = scanner.next();
            Body figure = new Body(0,0,0);
            figure = Init.init(scanner, name, figure);
            if(name.equals("exit")) {
                break;
            }
            if (name.equals("compound")) {
                System.out.println("Enter figures for the composite body:");
                compound.AddChildBody(scanner, figures, compound);
            } else {
                figures.add(figure);
                compoundFigures.add(figure);
                volume += figure.GetVolume();
                mass += figure.GetMass();
            }
        }
        return !compoundFigures.isEmpty();
    }

    @Override
    String ToString() {
        return "Compound:" + "\n" +
            "Density: " + density + "\n" +
            "Volume: " + volume + "\n" +
            "Mass: " + mass + "\n"
            ;
    }
}
