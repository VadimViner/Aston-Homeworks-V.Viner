public interface GeometricFigure {
    String getFillColor();
    String getBorderColor();
    double calculatePerimeter();
    double calculateArea();

    default void printCharacteristics() {
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Площадь: " + calculateArea());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
    }
}
