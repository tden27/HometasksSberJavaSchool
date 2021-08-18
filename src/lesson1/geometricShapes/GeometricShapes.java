package lesson1.geometricShapes;

public abstract class GeometricShapes {
    int perimetr;
    double area;

    public abstract double getPerimetr();

    public abstract  double getArea();

}

class Circle extends GeometricShapes{
    int radius;

    public Circle(int radius){
        this.radius = radius;
    }

    @Override
    public double getPerimetr() {
        return 2*radius*Math.PI;
    }

    @Override
    public double getArea() {
        return Math.PI*Math.pow(radius, 2.0D);
    }
}

class Rect extends GeometricShapes{
    int a;
    int b;

    public Rect(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public double getPerimetr() {
        return (a+b)*2;
    }

    @Override
    public double getArea() {
        return a*b;
    }
}

class Triangle extends GeometricShapes{
    int a;
    int b;
    int c;

    public Triangle(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getPerimetr() {
        return a+b+c;
    }

    @Override
    public double getArea() {
        double p = (a+b+c)/2.0;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}

class Square extends GeometricShapes{
    int a;

    public Square(int a){
        this.a = a;
    }

    @Override
    public double getPerimetr() {
        return 4*a;
    }

    @Override
    public double getArea() {
        return a*a;
    }
}
