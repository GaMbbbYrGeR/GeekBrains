package Level1.Task6.Animals;

public class Dog extends Animal{

    private static int countOfDogs;

    public Dog(String name, String color, int age) {
        super(name, color, age);
        countOfDogs++;
        countOfAnimals++;
    }

    @Override
    public void run(int barLength) {
        if (barLength <= 500 && barLength >= 0) {
            System.out.println(name + " ran " + barLength + " meters");
        } else if (barLength < 0) {
            System.out.println("Вы ввели отрицательное число");
        } else {
            System.out.println("Слишком много для пёсика (");
        }
    }

    @Override
    public void swim(int barLength) {
        if (barLength <= 10 && barLength >= 0) {
            System.out.println(name + " swam " + barLength + " meters");
        } else if (barLength < 0 ) {
            System.out.println("Вы ввели отрицательное число");
        } else {
            System.out.println("Слишком много для пёсика (");
        }
    }

    public int getCountOfDogs() {
        return countOfDogs;
    }
}
