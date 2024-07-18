package Level1.Task6.Animals;

public class Cat extends Animal {

    private static int countOfCats;
    private static final int MAX_RUN = 200;
    private static final int MAX_SWIM = 0;

    public Cat(String name, String color, int age) {
        super(name, color, age, MAX_RUN, MAX_SWIM);
        countOfCats++;
        countOfAnimals++;
    }

    public int getCountOfCats() {
        return countOfCats;
    }
}

