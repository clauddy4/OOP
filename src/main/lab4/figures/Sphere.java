package main.lab4.figures;

public class Sphere extends Body {
    public Sphere(double density, double volume, double mass) {
        super(density, volume, mass);
    }

    public double GetRadius() {
        double number = (3 * volume) / (4 * Math.PI);
        return Math.pow(number, 1.0 / 3);
    }

    @Override
    String GetName() {
        return "Sphere ";
    }

    @Override
    String ToString() {
        return "Sphere:" + "\n" +
            "Density: " + GetDensity() + "\n" +
            "Volume: " + GetVolume() + "\n" +
            "Mass: " + GetMass() + "\n" +
            "Radius: " + GetRadius() + "\n"
            ;
    }
}
