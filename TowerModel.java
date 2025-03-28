public class TowerModel {
    private int height;
    private IntegerStack[] towers;

    public TowerModel(int height) {
        this.height = height;
        towers = new IntegerStack[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new IntegerStack(height);
        }
        for (int i = height; i > 0; i--) {
            towers[0].push(i);
        }
    }

    public int getHeight() {
        return height;
    }

    public IntegerStack[] getTowers() {
        return towers;
    }

    public boolean move(int from, int to) {
        if (from < 0 || from > 2 || to < 0 || to > 2) {
            return false;
        }

        if (towers[from].peek() == 0) {
            return false;
        }

        int topFrom = towers[from].peek();
        int topTo = towers[to].peek();

        if (topTo != 0 && topFrom > topTo) {
            return false;
        }

        towers[to].push(towers[from].pop());
        return true;
    }
}

