package main.lab4.figures;

import java.util.*;

public class Main {
    public static void main(String[] argc) {
        List<Body> figures = new LinkedList<>();

        System.out.println("Введите фигуры(cone, cylinder, sphere, parallelepiped and compound) и их плотность, объём и массу");
        Scanner scanner = new Scanner(System.in);
        Init.initialized(scanner, figures);

        for (Body figure: figures) {
            String out = figure.ToString();
            System.out.println(out);
        }

        System.out.println("Максимальная масса: ");
        Body fig = Init.greatestMass(figures);
        System.out.print(fig.GetName());
        System.out.print(" масса ");
        System.out.println(fig.GetMass());
        fig.OutFigMass();
        System.out.println("Минимальная масса фигуры, погружённой в воду: ");
        fig = Init.lowestMass(figures);
        System.out.print(fig.GetName());
        System.out.print(" вес фигуры, погружённой в воду ");
        System.out.println(fig.GetWeightInWater());
        fig.OutFigMassInWater();
    }
}
