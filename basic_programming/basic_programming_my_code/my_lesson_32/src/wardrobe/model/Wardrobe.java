package wardrobe.model;

public class Wardrobe implements Comparable<Wardrobe> {
    private double height;
    private double width;
    private double depth;

    public Wardrobe(double height, double width, double depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getDepth() {
        return depth;
    }

    public double getArea() {
        return depth * width;
    }

    public double getVolume() {
        return getArea() * height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wardrobe wardrobe = (Wardrobe) o;

        if (Double.compare(wardrobe.height, height) != 0) return false;
        if (Double.compare(wardrobe.width, width) != 0) return false;
        return Double.compare(wardrobe.depth, depth) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(height);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(depth);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Wardrobe{" + "height=" + height +
                ", width=" + width +
                ", depth=" + depth +
                ", area=" + getArea() +
                ", volume=" + getVolume() +
                '}';
    }

    @Override
    public int compareTo(Wardrobe o) {
        return Double.compare(height, o.getHeight());
    }
}