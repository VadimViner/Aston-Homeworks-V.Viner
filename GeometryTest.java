public class GeometryTest {
    public static void main(String[] args) {
        GeometricFigure circle = new Circle(5, "Синий", "Чёрный");
        GeometricFigure rectangle = new Rectangle(4, 7, "Красный", "Серый");
        GeometricFigure triangle = new Triangle(3, 4, 5, "Зелёный", "Коричневый");

        System.out.println("Характеристики круга:");
        circle.printCharacteristics();

        System.out.println("\nХарактеристики прямоугольника:");
        rectangle.printCharacteristics();

        System.out.println("\nХарактеристики треугольника:");
        triangle.printCharacteristics();
    }
}
