package Level1.Task6.Animals;

public abstract class Animal {

    static int countOfAnimals;

    final String name;
    String color;
    int age;

    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public void run(int barLength) {
        System.out.println(name + " ran " + barLength + " meters");
    }

    public void swim(int barLength) {
        System.out.println(name + " swam " + barLength + " meters");
    }

    public void info() {
        System.out.println(name + " " + color + " " + age);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }

    public int getCountOfAnimals() {
        return countOfAnimals;
    }
}
