public class Cat extends Animal {
    private static final int MAX_RUN_DISTANCE = 200;
    private static final int MAX_SWIM_DISTANCE = 0; // Кот не умеет плавать
    private static int catCount = 0; // Счетчик котов

    private boolean isFull = false; // Сытость кота

    public Cat(String name) {
        super(name);
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(getName() + " пробежал " + distance + " метров.");
        } else {
            System.out.println(getName() + " не может пробежать больше " + MAX_RUN_DISTANCE + " метров.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(getName() + " не умеет плавать.");
    }

    public void eatFromBowl(Bowl bowl) {
        if (bowl.getFoodAmount() >= 10) {
            bowl.decreaseFood(10);
            isFull = true;
            System.out.println(getName() + " поел и теперь сыт.");
        } else {
            System.out.println(getName() + " не хватает еды в миске.");
        }
    }

    public boolean isFull() {
        return isFull;
    }
}
