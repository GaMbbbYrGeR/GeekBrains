package Level1.Task6.Animals;

public class Dog extends Animal{

    private static int countOfDogs;
    private static final int MAX_RUN = 500;
    private static final int MAX_SWIM = 10;

    public Dog(String name, String color, int age) {
        super(name, color, age, MAX_RUN, MAX_SWIM);
        countOfDogs++;
        countOfAnimals++;
    }

    public int getCountOfDogs() {
        return countOfDogs;
    }
}
