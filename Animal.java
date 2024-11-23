public class Animal {
    private String name;
    private int age;
    private String species;

    public static int animalCount = 0;
    public static int dogCount = 0;
    public static int catCount = 0;

    public Animal(String name, int age, String species) {
        this.name = name;
        this.age = age;
        this.species = species;
        animalCount++;

        if (species.equals("собака")) {
            dogCount++;
        } else if (species.equals("кошка")) {
            catCount++;
        }
    }

    // Геттеры для name и других полей
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSpecies() {
        return species;
    }

    public void run(int distance) {
        System.out.println(name + " пробежал(а) " + distance + " метров.");
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл(а) " + distance + " метров.");
    }

    public static void printCounts() {
        System.out.println("Общее количество животных: " + animalCount);
        System.out.println("Количество собак: " + dogCount);
        System.out.println("Количество котов: " + catCount);
    }
}
