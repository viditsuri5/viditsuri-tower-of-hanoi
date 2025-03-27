import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class TowerModel {
    private final int totalDisks;
    private final List<Stack<Integer>> rods;

    public TowerModel(int totalDisks) {
        this.totalDisks = totalDisks;
        rods = new ArrayList<>();
        
        // Initialize rods
        for (int i = 0; i < 3; i++) {
            rods.add(new Stack<>());
        }

        for (int i = totalDisks; i > 0; i--) {
            rods.get(0).push(i);
            }
        }

        public void move(int fromRod, int toRod) {
        if (rods.get(fromRod).isEmpty()) {
            throw new IllegalStateException("Cannot move from an empty rod!");
        }
        if (!rods.get(toRod).isEmpty() && rods.get(fromRod).peek() > rods.get(toRod).peek()) {
            throw new IllegalStateException("Cannot place a larger disk on a smaller one!");
        }
        rods.get(toRod).push(rods.get(fromRod).pop());
    }

    public boolean isSolved() {
        return rods.get(0).isEmpty() && rods.get(1).isEmpty() && rods.get(2).size() == totalDisks;
    }

    public void print() {
        for (int i = 0; i < rods.size(); i++) {
            System.out.println("Rod " + i + ": " + rods.get(i));
        }
        System.out.println();
    }
}