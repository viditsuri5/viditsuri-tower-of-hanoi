public class TowerSolver {
    public void solve(TowerModel model) {
        moveDisks(model.getHeight(), 0, 2, 1, model);
    }

    private void moveDisks(int n, int from, int to, int aux, TowerModel model) {
        if (n == 0) {
            return;
        }

        moveDisks(n - 1, from, aux, to, model);
        model.move(from, to);
        moveDisks(n - 1, aux, to, from, model);
    }
}
