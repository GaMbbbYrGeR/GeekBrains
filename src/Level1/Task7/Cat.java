package Level1.Task7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name) {
        this.name = name;
        appetite = 10;
        satiety = false;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        satiety = false;
    }

    public String getName() {
        return name;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void eat(Plate plate) {
        int eatedFood = plate.decreaseFood(appetite);
        if (eatedFood == -1) {
            System.out.println("Котик " + name + " не смог поесть, тарелка пустая");
        } else if (eatedFood == 0) {
            System.out.println("Кот " + name + " покушал и сыт");
            appetite = 0;
            satiety = true;
        } else if (eatedFood == -2) {
            System.out.println("Вы ввели отриательное число");
        } else {
            appetite -= eatedFood;
            System.out.println("Котик " + name + " доел все, но не наелся (");
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

