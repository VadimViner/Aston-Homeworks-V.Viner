public class Employee {
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

    public String getFullName() {
        return lastName + " " + firstName + " " + middleName;
    }

    public void printInfo() {
        System.out.println("Employee: " + getFullName() +
                ", Email: " + email + ", Phone: " + phoneNumber +
                ", Salary: " + salary + ", Age: " + age);
    }
}
