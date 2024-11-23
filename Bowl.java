public class Bowl {
    private int foodAmount; // количество еды в миске

    public Bowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void addFood(int amount) {
        foodAmount += amount;
        System.out.println("Добавлено " + amount + " еды в миску. Всего еды: " + foodAmount);
    }

    public void decreaseFood(int amount) {
        if (foodAmount >= amount) {
            foodAmount -= amount;
            System.out.println("Убрано " + amount + " еды из миски. Осталось еды: " + foodAmount);
        } else {
            System.out.println("Недостаточно еды в миске.");
        }
    }
}
