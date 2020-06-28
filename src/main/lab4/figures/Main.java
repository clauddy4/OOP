package main.lab4.figures;

import java.util.*;

public class Main {
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

    public static void main(String[] argc) {
        List<Body> figures = new LinkedList<>();

        System.out.println("Введите фигуры(cone, cylinder, sphere, parallelepiped and compound) и их плотность, объём и массу");
        Scanner scanner = new Scanner(System.in);
        Main.initialized(scanner, figures);

        for (Body figure: figures) {
            String out = figure.ToString();
            System.out.println(out);
        }

        System.out.println("Максимальная масса: ");
        Body fig = Main.greatestMass(figures);
        System.out.print(fig.GetName());
        System.out.print("масса ");
        System.out.println(fig.GetMass());
        fig.OutFigMass();
        System.out.println("Минимальная масса фигуры, погружённой в воду: ");
        fig = Main.lowestMass(figures);
        System.out.print(fig.GetName());
        System.out.print("вес фигуры, погружённой в воду ");
        System.out.println(fig.GetWeightInWater());
        fig.OutFigMassInWater();
    }
}
