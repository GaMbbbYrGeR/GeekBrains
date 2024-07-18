package Level1.Task7;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Murzik"),
                new Cat("Murzik2"),
                new Cat("Murzik3"),
                new Cat("Murzik4"),
                new Cat("Murzik5"),
        };
        Plate plate = new Plate(35);
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
        }

        for (int i = 0; i < cats.length; i++) {
            System.out.println(cats[i]);
        }
        plate.info();

    }

    public static void printValue(Integer a) {
        System.out.println("value= " + a);
    }

    public static void printInt(int i) {
        System.out.println("value= " + i);
    }
}

