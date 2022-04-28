public class Skeleton extends Entity{

    private int damagePoint = damage();
    static int sX =0;
    static int sY =0;

    public Skeleton(int hp, int strength, int agility) {
        super(hp, strength, agility);
    }

    public static void setsX(int sX) {
        Skeleton.sX = sX;
    }

    public static void setsY(int sY) {
        Skeleton.sY = sY;
    }

    @Override
    public String toString(){
        return "HP: " + hp + ", STR: " + strength + ", AGL: " + agility;
    }
}
