public class Goblin extends Entity{

    private int damagePoint = damage();
    static int gX =0;
    static int gY =0;

    public Goblin(int hp, int strength, int agility) {
        super(hp, strength, agility);
    }

    public static void setgX(int gX) {
        Goblin.gX = gX;
    }

    public static void setgY(int gY) {
        Goblin.gY = gY;
    }

    @Override
    public String toString(){
        return "HP: " + hp + ", STR: " + strength + ", AGL: " + agility;
    }
}
