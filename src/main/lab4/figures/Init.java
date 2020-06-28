package main.lab4.figures;

import java.util.List;
import java.util.Scanner;

public class Init {
    static Body init(Scanner scanner, String name, Body figure) {
        if (name.equals("cone")) {
            figure = new Cone(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(),1,1);
        }
        if (name.equals("cylinder")) {
            figure = new Cylinder(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(),1,1);
        }
        if (name.equals("sphere")) {
            figure = new Sphere(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
        }
        if (name.equals("parallelepiped")) {
            figure = new Parallelepiped(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(),1,1, 1);
        }
        return figure;
    }

    public static void initialized(Scanner scanner, List<Body> figures)
    {
        while (scanner.hasNextLine()) {
            String name = scanner.next();
            Body figure = new Body(0,0,0);
            if(name.equals("exit")) {
                break;
            }
            figure = Init.init(scanner, name, figure);
            if (name.equals("compound")) {
                System.out.println("Введите фигуры для составного тела:");
                Compound compound = new Compound(0, 0, 0);
                compound.AddChildBody(scanner, figures, compound);
                compound.density = compound.GetDensity();
                figures.add(compound);
            } else {
                figures.add(figure);
            }
        }
    }

    public static Body greatestMass(List<Body> figures) {
        double mass = 0;
        Body figureWithGreatestMass = new Body(0, 0, 0);
        for (Body figure: figures) {
            if (mass < figure.GetMass()) {
                mass = figure.GetMass();
                figureWithGreatestMass = figure;
            }
        }
        return figureWithGreatestMass;
    }

    public static Body lowestMass(List<Body> figures) {
        double mass = 0;
        Body figureWithLowestMass = new Body(0, 0, 0);
        for (Body figure: figures) {
            if (mass > figure.GetWeightInWater()) {
                mass = figure.GetWeightInWater();
                figureWithLowestMass = figure;
            }
        }
        return figureWithLowestMass;
    }
}
