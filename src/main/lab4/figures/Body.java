package main.lab4.figures;

public class Body {
    double density;
    double volume;
    double mass;

    final int densityOfWater = 1000;
    final int g = 1000;

    Body(double density, double volume, double mass) {
        this.density = density;
        this.volume = volume;
        this.mass = mass;
    }

    double GetDensity() {
        return this.density;
    }

    double GetVolume() {
        return this.volume;
    }

    public double GetMass() {
        return GetDensity() * GetVolume();
    }

    public double GetWeightInWater() {
        return (GetDensity() - densityOfWater) * GetVolume() * g;
    }

    String OutFigMass() {
        return " ";
    }

    String OutFigMassInWater() {
        return " ";
    }

    String GetName() {
        return " ";
    }

    String ToString() {
        return "Density: " + GetDensity() + "\n" +
            "Volume: " + GetVolume() + "\n" +
            "Mass: " + GetMass() + "\n"
        ;
    }
}
