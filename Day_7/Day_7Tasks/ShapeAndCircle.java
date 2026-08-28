abstract class Shape {
    private String color;

    public Shape(String color) {
        this.color = color;
    }

    public abstract double getArea();

    @Override
    public String toString() {
        return "Shape color: " + color;
    }

    public String getColor() {
        return color;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle [Color: " + getColor()
                + ", Radius: " + radius
                + ", Area: " + String.format("%.2f", getArea()) + "]";
    }
}

class ShapeAndCircle {
    public static void main(String[] args) {
        Circle circle = new Circle("Red", 5.0);
        System.out.println(circle);
    }
}