package inheritance.polymorphism;

abstract class shape {
    abstract double area();
}
class Circle extends shape {
    double radius;
    Circle(double radius) {
        this.radius = radius;
    }
    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}
class Rectangle extends shape {
    double length;
    Rectangle(double length) {
        this.length = length;
    }
    @Override
    double area() {
        return length * length;
    }
}

public class ShapeArea {
    public static void main(String[] args) {
        shape[] shapes = new shape[2];

        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(10);

        double Toatalarea = 0;
        for (shape a : shapes) {
            Toatalarea += a.area();
        }
        System.out.println(Toatalarea);
    }
}
