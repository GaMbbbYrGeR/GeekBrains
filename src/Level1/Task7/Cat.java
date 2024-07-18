package Level1.Task7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name) {
        this.name = name;
        appetite = 10;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public void eat(Plate plate) {
        if (plate.decreaseFood(appetite)) {
            System.out.println("cat " + name + " eat...");
            satiety = true;
        } else {
            System.out.println("cat " + name + "no eat...");
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", satiety=" + satiety +
                '}';
    }
}

