package main.lab4.figures;

public class Cone extends Body {
    private double height;
    private double radius;

    public Cone(double density, double volume, double mass, double height, double radius) {
        super(density, volume, mass);
        this.height = height;
        this.radius = radius;
    }

    public double GetBaseRadius() {
        radius = Math.sqrt((3 * volume) / (Math.PI * height));
        return radius;
    }

    public double GetHeight() {
        height = (3 * volume) / (Math.PI * Math.pow(radius, 2));
        return height;
    }

    @Override
    String GetName() {
        return "Cone ";
    }

    @Override
    String ToString() {
        return "Cone:" + "\n" +
            "Density: " + GetDensity() + "\n" +
            "Volume: " + GetVolume() + "\n" +
            "Mass: " + GetMass() + "\n" +
            "Radius: " + GetBaseRadius() + "\n" +
            "Height: " + GetHeight() + "\n"
            ;
    }
}
