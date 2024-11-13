import java.util.ArrayList;
import java.util.List;

// Суперкласс HomeworkFour
public class HomeworkFour {}

// Класс Employee
class Employee {
    private String lastName;
    private String firstName;
    private String middleName;
    private String email;
    private long phoneNumber;
    private int salary;
    private int age;

    public Employee(String lastName, String firstName, String middleName, String email, long phoneNumber, int salary, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void getEmployee() {
        System.out.println("Employee: " + lastName + " " + firstName + " " + middleName +
                ", Position: unknown, Email: " + email + ", Phone: " + phoneNumber +
                ", Salary: " + salary + ", Age: " + age);
    }
}

// Класс Person
class Person {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Person(String fullName, String position, String email, String phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void getPersonInfo() {
        System.out.println("Person: " + fullName + ", Position: " + position + ", Email: " + email +
                ", Phone: " + phone + ", Salary: " + salary + ", Age: " + age);
    }
}

// Класс Park с внутренним классом Attraction
class Park {
    private String name;
    private List<Attraction> attractions;

    public Park(String name) {
        this.name = name;
        this.attractions = new ArrayList<>();
    }

    public void addAttraction(String name, String hours, int price) {
        Attraction attraction = new Attraction(name, hours, price);
        attractions.add(attraction);
    }

    public void showAttractions() {
        System.out.println("Park: " + name);
        for (Attraction attraction : attractions) {
            System.out.println("Attraction: " + attraction.name + ", Hours: " + attraction.hours +
                    ", Price: " + attraction.price);
        }
    }

    class Attraction {
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

// Класс Main
class Main {
    public static void main(String[] args) {
        Employee freshEmployee = new Employee("Салова", "Марина", "Борисовна", "salova@gmail.com", 879818514951L, 200000, 25);
        freshEmployee.getEmployee();

        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@gmail.com", "89877656543", 30000, 30);
        persArray[1] = new Person("Petrov Pyotr", "Driver", "pepyotr@gmail.com", "89877656545", 30000, 31);
        persArray[2] = new Person("Sidorov Viktor", "Writer", "siviktor@gmail.com", "89877656546", 31000, 32);
        persArray[3] = new Person("Ivanova Nina", "Engineer", "ivnina@gmail.com", "89877656547", 32000, 33);
        persArray[4] = new Person("Dow Jones", "Cook", "drdow@gmail.com", "89877656540", 34000, 35);

        for (Person person : persArray) {
            person.getPersonInfo();
        }

        Park park = new Park("Парк Гулливер");
        park.addAttraction("Карусель", "09:00 - 21:00", 5);
        park.addAttraction("Комната страха", "17:00 - 01:00", 10);
        park.addAttraction("Американские горки", "09:00 - 21:00", 15);
        park.showAttractions();
    }
}
