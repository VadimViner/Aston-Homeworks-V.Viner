public class Cat extends Animal {
    private static final int MAX_RUN_DISTANCE = 200;
    private static final int MAX_SWIM_DISTANCE = 0; // Кот не умеет плавать

    private boolean isFull = false; // сытость кота

    public Cat(String name, int age) {
        super(name, age, "кошка");
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            super.run(distance);
        } else {
            System.out.println(getName() + " не может пробежать больше " + MAX_RUN_DISTANCE + " метров.");
        }
    }

    @Override
    public void swim(int distance) {
        if (MAX_SWIM_DISTANCE == 0) {
            System.out.println(getName() + " не умеет плавать.");
        } else {
            super.swim(distance);
        }
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
