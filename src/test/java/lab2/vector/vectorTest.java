package test.java.lab2.vector;

import main.lab2.vector.Main;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Vector;
import static org.junit.jupiter.api.Assertions.*;

public class vectorTest {
    @Test
    public void testReadWorks() throws IOException {
        String inputString = "1 4.5674 -1745.7";
        Scanner numbers = new Scanner(inputString);
        Scanner arrIn = new Scanner(inputString);
        String arr = arrIn.nextLine();
        String[] rightArray = arr.split(" ");
        String[] array = Main.read(numbers);
        assertArrayEquals(rightArray, array);
    }

    @Test
    public void testFormatConversion() throws IOException {
        Scanner input = new Scanner("-5 2 3.5 10");
        String[] inputString = Main.read(input);
        Vector<Float> vector = Main.program(inputString);
        Scanner inputRight = new Scanner("10 -4 -7 -20");
        String[] inputStringRight = Main.read(inputRight);
        Vector<Float> rightVector = new Vector<>();
        for (String st : inputStringRight) {
            rightVector.add(Float.valueOf(st));
        }
        assertEquals(vector, rightVector);
    }

    @Test
    public void testFormatConversion2() throws IOException {
        Scanner input = new Scanner("-5 2 3.5555555 10");
        String[] inputString = Main.read(input);
        Vector<Float> vector = Main.program(inputString);
        Vector<String> vectorInFormat = Main.formatConversion(vector);
        Vector<String> rightVector = new Vector<>();
        rightVector.add("10");
        rightVector.add("-4");
        rightVector.add("-7,111");
        rightVector.add("-20");
        assertEquals(vectorInFormat, rightVector);
    }
}