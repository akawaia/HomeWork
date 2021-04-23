package HomeWork1;

public class Robot implements Capabilities {
    private int maxDistance;
    private int maxHeightJump;
    private String name;

    public Robot (String name, int maxDistance, int maxHeightJump) {
        this.maxDistance = maxDistance;
        this.maxHeightJump = maxHeightJump;
        this.name = name;
    }

    @Override
    public boolean run(int length) {
        if (maxDistance < length) return false;
        else System.out.printf("Robot %s run on %d distance\n", name, length);
        return true;
    }

    @Override
    public boolean jump(int height) {
        if (maxHeightJump < height) return false;
        else System.out.printf("Robot %s jumped over %d height\n", name, height);
        return true;
    }


}
