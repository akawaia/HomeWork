package Interfaces;

public class Human implements Capabilities {
    private int maxDistance;
    private int maxHeightJump;
    private String name;

    public Human(String name, int maxDistance, int maxHeightJump) {
        this.maxDistance = maxDistance;
        this.maxHeightJump = maxHeightJump;
        this.name = name;
    }

    @Override
    public boolean run(int length) {
        if (maxDistance < length) return false;
        else System.out.printf("Human %s run on %d distance\n", name, length);
        return true;
    }

    @Override
    public boolean jump(int height) {
        if (maxHeightJump < height) return false;
        else System.out.printf("Human %s jumped over %d height\n", name, height);
        return true;
    }


}
