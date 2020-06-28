package test.lab4.figures;

import main.lab4.figures.*;
import org.junit.Test;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import main.lab4.figures.Init;
import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testGreatestMassWorks() {
        List<Body> figures = new LinkedList<>();
        Body cone = new Cone(2, 3, 4, 1, 1);
        figures.add(cone);
        Body cylinder = new Cylinder(5, 6, 7, 1, 1);
        figures.add(cylinder);
        Body parallelepiped = new Parallelepiped(1, 2, 3, 1, 1, 1);
        figures.add(parallelepiped);
        Body sphere = new Sphere(7, 8, 9);
        figures.add(sphere);
        Body fig = Init.greatestMass(figures);
        double mass = fig.GetMass();
        double rightMass = 56;
        assertEquals(rightMass, mass, 0.001);
    }

    @Test
    public void testLowestMassWorks() {
        List<Body> figures = new LinkedList<>();
        Body cone = new Cone(2, 3, 4, 1, 1);
        figures.add(cone);
        Body cylinder = new Cylinder(5, 6, 7, 1, 1);
        figures.add(cylinder);
        Body parallelepiped = new Parallelepiped(1, 2, 3, 1, 1, 1);
        figures.add(parallelepiped);
        Body sphere = new Sphere(7, 8, 9);
        figures.add(sphere);
        Body fig = Init.lowestMass(figures);
        double mass = fig.GetWeightInWater();
        double rightMass = -79440;
        assertEquals(rightMass, mass, 0.001);
    }

    @Test
    public void testOneFigureHaveGreatestMass() {
        Scanner scanner = new Scanner("" + "\n" +
            "compound" + "\n" +
            "cylinder 1 2 3" + "\n" +
            "exit" + "\n" +
            "compound" + "\n" +
            "parallelepiped 1 2 3" + "\n" +
            "compound" + "\n" +
            "sphere 2 3 4" + "\n" +
            "exit exit exit exit");
        List<Body> figures = new LinkedList<>();
        Init.initialized(scanner, figures);
        assertEquals(5, figures.size());
        Body fig = Init.greatestMass(figures);
        fig = Init.lowestMass(figures);
        assertEquals(-49920, fig.GetWeightInWater(), 0.001);
    }

    @Test
    public void testCompoundFigureHaveGreatestMass() {
        Scanner scanner = new Scanner("cone 1 2 3" + "\n" +
            "compound" + "\n" +
            "cylinder 5000 10 30" + "\n" +
            "exit" + "\n" +
            "compound" + "\n" +
            "parallelepiped 1 2 3" + "\n" +
            "compound" + "\n" +
            "sphere 2 3 4" + "\n" +
            "exit exit exit exit");
        List<Body> figures = new LinkedList<>();
        Init.initialized(scanner, figures);
        assertEquals(6, figures.size());
        Body fig = Init.greatestMass(figures);
        assertEquals(50000, fig.GetMass(), 0.001);
        fig = Init.lowestMass(figures);
        assertEquals(-49920, fig.GetWeightInWater(), 0.001);
    }

    @Test
    public void testCompoundInCompoundFigureHaveGreatestMass() {
        Scanner scanner = new Scanner("cone 1 2 3" + "\n" +
            "compound" + "\n" +
            "cylinder 2 3 4" + "\n" +
            "exit" + "\n" +
            "compound" + "\n" +
            "parallelepiped 20 50 1" + "\n" +
            "compound" + "\n" +
            "sphere 700 30 80" + "\n" +
            "exit exit exit exit");
        List<Body> figures = new LinkedList<>();
        Init.initialized(scanner, figures);
        assertEquals(6, figures.size());
        Body fig = Init.greatestMass(figures);
        assertEquals(22000, fig.GetMass(), 0.001);
        fig = Init.lowestMass(figures);
        assertEquals(-580000, fig.GetWeightInWater(), 0.001);
    }
}
