package Level1.Task5;

public class Employee {
    private String fullName;
    private String post;
    private String email;
    private String phoneNumber;
    private String salary;
    private int age;

    public Employee() {

    }

    public Employee(String fullName, String post, String email, String phoneNumber, String salary, int age) {
        this.fullName = fullName;
        this.post = post;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void getInfo() {
        System.out.println("ФИО: " + this.fullName);
        System.out.println("Должность: " + this.post);
        System.out.println("Email:" + this.email);
        System.out.println("Номер телефона: " + this.phoneNumber);
        System.out.println("Зарплата: " +  this.salary);
        System.out.println("Возраст: " +   this.age);
    }

    public String getFullName() {
        return fullName;
    }

    public String getPost() {
        return post;
    }

    public int getAge() {
        return age;
    }
}
