package Level1.Task7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public int decreaseFood(int amount) {
        if (food == 0) {
            return -1;
        }
        if (amount < 0) {
            return -2;
        }
        if (amount > food) {
            int t = food;
            food = 0;
            return t;
        }
        food -= amount;
        return 0;
    }

    public void info() {
        System.out.println("Food: " + food);
    }

    public void addFood(int amount) {
        if (amount < 0) {
            return;
        }
        food += amount;
    }
}