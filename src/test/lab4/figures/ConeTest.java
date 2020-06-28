package test.lab4.figures;

import main.lab4.figures.Cone;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConeTest {

    @Test
    public void getBaseRadius() {
        double volume = 4;
        double height = 3;
        double rightRadius = 1.1283791671;
        Cone cone = new Cone(0, volume, 0, height, 0);
        double radius = cone.GetBaseRadius();
        assertEquals(rightRadius, radius, 0.001);

        volume = 12.56;
        height = 5.98;
        rightRadius = 1.4162173765;
        Cone cone1 = new Cone(0, volume, 0, height, 0);
        radius = cone1.GetBaseRadius();
        assertEquals(rightRadius, radius, 0.001);
    }

    @Test
    public void getHeight() {
        double volume = 4;
        double radius = 3;
        double rightHeight = 0.4244131816;
        Cone cone = new Cone(0, volume, 0, 0, radius);
        double height = cone.GetHeight();
        assertEquals(rightHeight, height, 0.001);

        volume = 12.56;
        radius = 5.98;
        rightHeight = 0.3353965982;
        Cone cone1 = new Cone(0, volume, 0, 0, radius);
        height = cone1.GetHeight();
        assertEquals(rightHeight, height, 0.001);
    }
}
