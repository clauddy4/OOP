package main.lab4.figures;

import java.util.*;

public class Main {
    public static void main(String[] argc) {
        List<Body> figures = new LinkedList<>();

        System.out.println("Enter figures: ");
        Scanner scanner = new Scanner(System.in);
        Init.initialized(scanner, figures);

        for (Body figure: figures) {
            String out = figure.ToString();
            System.out.println(out);
        }

        System.out.println("Max mass: ");
        Body fig = Init.greatestMass(figures);
        System.out.print(fig.GetName());
        System.out.print("=> mass = ");
        System.out.println(fig.GetMass());
        fig.OutFigMass();
        System.out.println("Min mass in water: ");
        fig = Init.lowestMass(figures);
        System.out.print(fig.GetName());
        fig.OutFigMassInWater();
    }
}
