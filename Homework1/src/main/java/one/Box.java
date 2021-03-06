package one;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits;

    public float getWeight() {
        float sum = 0;
        for (T fruit : fruits) {
            sum += fruit.getWeight();
        }
        return sum;
    }

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public boolean compare(Box<Orange> box) {
        return this.getWeight() == box.getWeight();
    }

    public void intersperseIn(Box<Apple> box){
        for (T fruit : fruits) {
            box.add((Apple) fruit);
        }
        fruits = new ArrayList<>();
    }
}
