package test.lab4.figures;

import main.lab4.figures.Sphere;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SphereTest {
    private double volume;
    private double expected;

    public SphereTest(double volume, double expected) {
        this.volume = volume;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {312, 4.207479366835002},
            {4.8473, 1.0498737969177},
            {84738, 27.247701111379},
            {13, 1.4586516277964},
            {290, 4.1061656241732},
        });
    }

    @Test
    public void testGetRadiusWorks() {
        Sphere sphere = new Sphere(0, volume, 0);
        double actual = sphere.GetRadius();
        assertEquals(expected, actual, 0.001);
    }

}
