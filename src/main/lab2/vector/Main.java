package main.lab2.vector;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static String[] read(Scanner in) throws IOException {
        String input = in.nextLine();
        if (input == null) {
            throw new IOException("Empty input");
        }
        return input.split(" ");
    }

    public static Vector<Float> program(String[] arrayOfNumber) {
        Vector<Float> vector = new Vector<>();
        for (String st : arrayOfNumber) {
            vector.add(Float.valueOf(st));
        }

        Collections.sort(vector);

        int size = vector.size();

        float min = vector.get(0);
        float max = vector.get(size - 1);


        float multiplier = max / min;

        for (int i = 0; i < vector.size(); i++) {
            float x = vector.get(i);
            float y = x * multiplier;
            vector.set(i, y);
        }
        return vector;
    }

    public static Vector<String> formatConversion(Vector<Float> vector) {
        DecimalFormat df = new DecimalFormat("#.###");
        Vector<String> out = new Vector<>();

        for (float vec : vector) {
            if (vec == -0) {
                vec = 0;
            }
            String inFormat = df.format(vec);
            out.add(inFormat);
        }
        return out;
    }

    public static void outputResult(Vector<String> vectorInFormat) {
        int size = vectorInFormat.size();
        int i = 1;
        for (var vec : vectorInFormat) {
            System.out.print(vec);
            if (i == size) {
                continue;
            }
            System.out.print(" ");
            i++;
        }
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter an array of numbers, separated by spaces:");
            String[] arrayOfNumber = Main.read(in);
            Vector<Float> vector = Main.program(arrayOfNumber);
            Collections.sort(vector);
            Vector<String> vectorInFormat = Main.formatConversion(vector);
            Main.outputResult(vectorInFormat);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}