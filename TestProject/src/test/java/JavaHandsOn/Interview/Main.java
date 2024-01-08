package JavaHandsOn.Interview;

class Base {
    int length;
    int width;

    public Base(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public void area() {
        System.out.println("Area of Base: " + length * width);
    }
}

class Triangle extends Base {
    public Triangle(int length, int width) {
        super(length, width);
    }

    @Override
    public void area() {
        System.out.println("Area of Triangle: " + 0.5 * length * width);
    }
}

class Rectangle extends Base {
    public Rectangle(int length, int width) {
        super(length, width);
    }

    @Override
    public void area() {
        System.out.println("Area of Rectangle: " + length * width);
    }
}

class Driver {
    public static void findArea(Base b) {
        b.area();
    }
}

public class Main {
    public static void main(String... args) {
        Base t = new Triangle(5, 7); // upcasting
        Base r = new Rectangle(5, 5);

        Driver.findArea(t);
        Driver.findArea(r);
    }
}
