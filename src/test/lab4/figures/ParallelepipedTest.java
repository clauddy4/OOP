package test.lab4.figures;

import main.lab4.figures.Parallelepiped;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParallelepipedTest {

    @Test
    public void getWidth() {
        double volume = 4;
        double height = 3;
        double depth = 3;
        double rightWidth = 0.4444444444;
        Parallelepiped parallelepiped = new Parallelepiped(0, volume,0,0,height,depth);
        double width = parallelepiped.GetWidth();
        assertEquals(rightWidth, width, 0.001);
    }

    @Test
    public void getHeight() {
        double volume = 4;
        double width = 12.56;
        double depth = 3;
        double rightHeight = 0.1061571125;
        Parallelepiped parallelepiped = new Parallelepiped(0, volume,0,width,0,depth);
        double height = parallelepiped.GetHeight();
        assertEquals(rightHeight, height, 0.001);
    }

    @Test
    public void getDepth() {
        double volume = 4;
        double width = 5.98;
        double height = 3;
        double rightDepth = 0.2229654404;
        Parallelepiped parallelepiped = new Parallelepiped(0, volume,0,width,height,0);
        double depth = parallelepiped.GetDepth();
        assertEquals(rightDepth, depth, 0.001);
    }
}
