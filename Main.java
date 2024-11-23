public class Main {
    public static void main(String[] args) {
        // Работа с Employee
        Employee employee = new Employee("Салова", "Марина", "Борисовна",
                "salova@gmail.com", 879818514951L,
                200000, 25);
        employee.printInfo();

        // Работа с Person
        Person[] persons = {
                new Person("Ivanov Ivan", "Engineer", "ivivan@gmail.com", "89877656543", 30000, 30),
                new Person("Petrov Pyotr", "Driver", "pepyotr@gmail.com", "89877656545", 30000, 31),
                new Person("Sidorov Viktor", "Writer", "siviktor@gmail.com", "89877656546", 31000, 32),
                new Person("Ivanova Nina", "Engineer", "ivnina@gmail.com", "89877656547", 32000, 33),
                new Person("Dow Jones", "Cook", "drdow@gmail.com", "89877656540", 34000, 35)
        };

        for (Person person : persons) {
            person.printInfo();
        }

        // Работа с Park
        Park park = new Park("Парк Гулливер");
        park.addAttraction("Карусель", "09:00 - 21:00", 5);
        park.addAttraction("Комната страха", "17:00 - 01:00", 10);
        park.addAttraction("Американские горки", "09:00 - 21:00", 15);
        park.printAttractions();
    }
}
