public class TowerSolver {
    private final TowerModel tower;

    public TowerSolver(TowerModel tower) {
        this.tower = tower;
    }

    public void solve(int disks, int startRod, int endRod, int spareRod) {
        if (disks == 0) return;

        solve(disks - 1, startRod, spareRod, endRod);

        tower.move(startRod, endRod);

        solve(disks - 1, spareRod, endRod, startRod);
    }
}
