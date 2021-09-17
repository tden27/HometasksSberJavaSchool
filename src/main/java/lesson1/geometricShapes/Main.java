package lesson1.geometricShapes;

public class Main {
    public static void main(String[] args) {
        GeometricShapes circle = new Circle(15);
        GeometricShapes rect = new Rect(15, 12);
        GeometricShapes triangle = new Triangle(15, 12, 7);
        GeometricShapes square = new Square(15);

        System.out.println("Периметр круга равен " + circle.getPerimetr());
        System.out.println("Площадь круга равна " + circle.getArea());

        System.out.println("Периметр прямоугольника равен " + rect.getPerimetr());
        System.out.println("Площадь прямойгольника равна " + rect.getArea());

        System.out.println("Периметр триугольника равен " + triangle.getPerimetr());
        System.out.println("Площадь триугольника равна " + triangle.getArea());

        System.out.println("Периметр квадрата равен " + square.getPerimetr());
        System.out.println("Площадь квадрата равна " + square.getArea());
    }
}
