public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Абстрактные методы для реализации в наследниках
    public abstract void run(int distance);
    public abstract void swim(int distance);
}
