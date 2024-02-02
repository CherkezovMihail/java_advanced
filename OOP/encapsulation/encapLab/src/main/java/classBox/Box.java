package classBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void validateValues(double value, String msgPrefix) {
        if (value < 0) {
            throw new IllegalStateException(msgPrefix + " cannot be zero or negative.");
        }
    }

    private void setHeight(double height) {
        validateValues(height, "Height");
        this.height = height;
    }

    private void setWidth(double width) {
        validateValues(width, "Width");
        this.width = width;
    }

    private void setLength(double length) {
        validateValues(length, "Length");
        this.length = length;
    }

    public double calculateSurfaceArea() {
        return (2*(length * width)) + (2*(length * height)) + (2*(width * height));
    }

    public double calculateLateralSurfaceArea() {
        return (2*(length * height)) + (2*(width * height));
    }

    public double calculateVolume() {
        return length * width * height;
    }
}
