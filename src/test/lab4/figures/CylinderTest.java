package test.lab4.figures;

import main.lab4.figures.Cylinder;
import org.junit.Test;

import static org.junit.Assert.*;

public class CylinderTest {
    @Test
    public void testGetBaseRadiusWorks() {
        double volume = 3;
        double height = 4;
        double rightRadius = 0.48860251190292;
        Cylinder cylinder = new Cylinder(0, volume, 0, 0, height);
        double radius = cylinder.GetBaseRadius();
        assertEquals(rightRadius, radius, 0.001);

        volume = 12.56;
        height = 5.98;
        rightRadius = 0.81765348353803;
        Cylinder cylinder1 = new Cylinder(0, volume, 0, 0, height);
        radius = cylinder1.GetBaseRadius();
        assertEquals(rightRadius, radius, 0.001);
    }

    @Test
    public void testGetHeightWorks() {
        double volume = 4;
        double radius = 3;
        double rightHeight =  0.1414710605261292;
        Cylinder cylinder = new Cylinder(0, volume, 0, radius, 0);
        double height = cylinder.GetHeight();
        assertEquals(rightHeight, height, 0.001);

        volume = 12.56;
        radius = 5.98;
        rightHeight =  0.11179886607723657;
        Cylinder cylinder1 = new Cylinder(0, volume, 0, radius, 0);
        height = cylinder1.GetHeight();
        assertEquals(rightHeight, height, 0.001);
    }
}
