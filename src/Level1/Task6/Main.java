package Level1.Task6;

import Level1.Task6.Animals.*;

public class Main {
    public static void main(String[] args) {
        Cat catTucha = new Cat("Tucha", "White", 4);
        Cat catMeow = new Cat("Meow","Black", 2);
        Dog dogGav = new Dog("Gav", "Gray", 10);
        Dog dogBobik = new Dog("Bobik", "Red", 6);

        catTucha.run(147);
        dogGav.run(470);
        catMeow.run(240);
        dogBobik.run(730);

        catTucha.swim(23);
        dogGav.swim(9);
        dogBobik.swim(20);

        System.out.println(catMeow.getCountOfCats());
        System.out.println(dogGav.getCountOfDogs());
        System.out.println(catTucha.getCountOfAnimals());
    }
}
