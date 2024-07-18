package Level1.Task7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public boolean decreaseFood(int amount) {
        if (amount < 0 || amount > food) {
            return false;
        }
        food -= amount;
        return true;
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