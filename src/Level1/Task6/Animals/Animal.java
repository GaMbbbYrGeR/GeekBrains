package Level1.Task6.Animals;

public abstract class Animal {

    static int countOfAnimals;

    final String name;
    String color;
    int age;
    int maxRun;
    int maxSwim;

    public Animal(String name, String color, int age, int maxRun, int maxSwim) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
    }

    public void run(int barLength) {
        if (barLength <= maxRun && barLength >= 0) {
            System.out.println(name + " ran " + barLength + " meters");
        } else if (barLength < 0) {
            System.out.println("Ошибка: Вы ввели отрицательное число");
        } else {
            System.out.println(name + " столько не пробежит");
        }
    }

    public void swim(int barLength) {
        if (barLength <= maxSwim && barLength >= 0) {
            System.out.println(name + " swam " + barLength + " meters");
        } else if (barLength < 0) {
            System.out.println("Ошибка: Вы ввели отрицательное число");
        } else {
            System.out.println(name + " столько не проплывет");
        }
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
