// Интерфейс для геометрических фигур
interface GeometricFigure {
    String getFillColor();
    String getBorderColor();
    double calculatePerimeter();
    double calculateArea();

    // Метод для вывода всех характеристик фигуры
    default void printCharacteristics() {
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Площадь: " + calculateArea());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
    }
}

// Класс для круга
class Circle implements GeometricFigure {
    private double radius;
    private String fillColor;
    private String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

// Класс для прямоугольника
class Rectangle implements GeometricFigure {
    private double length;
    private double width;
    private String fillColor;
    private String borderColor;

    public Rectangle(double length, double width, String fillColor, String borderColor) {
        this.length = length;
        this.width = width;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

// Класс для треугольника
class Triangle implements GeometricFigure {
    private double sideA;
    private double sideB;
    private double sideC;
    private String fillColor;
    private String borderColor;

    public Triangle(double sideA, double sideB, double sideC, String fillColor, String borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double calculateArea() {
        double s = calculatePerimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

// Основной класс для тестирования фигур
class GeometryTest { // Изменено с Main на GeometryTest
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
