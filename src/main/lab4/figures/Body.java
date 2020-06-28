package main.lab4.figures;

public class Body {
    double density;
    double volume;
    double mass;

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
        return (GetDensity() - 1000) * GetVolume() * 10;
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
