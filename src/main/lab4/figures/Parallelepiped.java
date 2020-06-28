package main.lab4.figures;

public class Parallelepiped extends Body {
    private double width;
    private double height;
    private double depth;

    public Parallelepiped(double density, double volume, double mass, double width, double height, double depth) {
        super(density, volume, mass);
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public double GetWidth() {
        width = volume / (height * depth);
        return width;
    }

    public double GetHeight() {
        height = volume / (width * depth);
        return height;
    }

    public double GetDepth() {
        depth = volume / (width * height);
        return depth;
    }

    @Override
    String GetName() {
        return "Parallelepiped ";
    }

    @Override
    String ToString() {
        return "Parallelepiped:" + "\n" +
            "Density: " + GetDensity() + "\n" +
            "Volume: " + GetVolume() + "\n" +
            "Mass: " + GetMass() + "\n" +
            "Width: " + GetWidth() + "\n" +
            "Height: " + GetHeight() + "\n" +
            "Depth: " + GetDepth() + "\n"
            ;
    }
}
