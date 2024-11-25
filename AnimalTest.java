public class AnimalTest {
    public static void main(String[] args) {
        // Создаем объекты животных
        Dog dog1 = new Dog("Бобик");
        Dog dog2 = new Dog("Шарик");
        Cat cat1 = new Cat("Мурка");
        Cat cat2 = new Cat("Барсик");

        // Печатаем информацию о количестве животных
        System.out.println("Количество собак: " + Dog.getDogCount());
        System.out.println("Количество котов: " + Cat.getCatCount());

        // Создаем миску с едой
        Bowl bowl = new Bowl(30);

        // Попросим котов поесть
        cat1.eatFromBowl(bowl);
        cat2.eatFromBowl(bowl);

        // Печатаем информацию о сытости котов
        System.out.println(cat1.isFull() ? cat1.getName() + " сыт" : cat1.getName() + " голоден");
        System.out.println(cat2.isFull() ? cat2.getName() + " сыт" : cat2.getName() + " голоден");

        // Тестируем бег и плавание
        dog1.run(300);
        dog1.swim(5);
        cat1.run(150);
        cat1.swim(0); // кот не умеет плавать
    }
}
