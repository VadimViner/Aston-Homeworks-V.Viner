import java.util.ArrayList;
import java.util.List;

public class Park {
    private String name;
    private List<Attraction> attractions;

    public Park(String name) {
        this.name = name;
        this.attractions = new ArrayList<>();
    }

    public void addAttraction(String name, String hours, int price) {
        attractions.add(new Attraction(name, hours, price));
    }

    public void printAttractions() {
        System.out.println("Park: " + name);
        for (Attraction attraction : attractions) {
            System.out.println("Attraction: " + attraction.name +
                    ", Hours: " + attraction.hours +
                    ", Price: " + attraction.price);
        }
    }

    private class Attraction {
        private String name;
        private String hours;
        private int price;

        public Attraction(String name, String hours, int price) {
            this.name = name;
            this.hours = hours;
            this.price = price;
        }
    }
}
