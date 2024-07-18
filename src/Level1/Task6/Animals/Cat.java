package Level1.Task6.Animals;

public class Cat extends Animal {

    private static int countOfCats;

    public Cat(String name, String color, int age) {
        super(name, color, age);
        countOfCats++;
        countOfAnimals++;
    }

    @Override
    public void run(int barLength) {
        if (barLength <= 200 && barLength >= 0) {
            System.out.println(name + " ran " + barLength + " meters");
        } else if (barLength < 0) {
            System.out.println("Вы ввели отрицательное число");
        } else {
            System.out.println("Слишком много для котика (");
        }
    }

    @Override
    public void swim(int barLength) {
        System.out.println("Котики не плавают (");
    }

    public int getCountOfCats() {
        return countOfCats;
    }
}

