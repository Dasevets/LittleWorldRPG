import java.util.Scanner;

public class Game {

    public static  Hero hero;
    public static LittleWorld littleWorld = new LittleWorld();
    static int HP;

    public static void game(){

        String nameHero;
        int gameClass;

        Scanner scanner = new Scanner(System.in);
        StringBuilder salute = new StringBuilder("   Welcome to Little World!");
        salute.append("\n This world with a monster and hero.");
        salute.append("\n With adventures and bloody battles.");
        salute.append("\n And you, the new hero of this world! \n");
        System.out.println(salute);


        System.out.println("What's you name, wanderer?");
        nameHero = scanner.nextLine();
        System.out.println("Choose you game class: ");
        System.out.println("1. Tank (HP 150, STR 75, AGL 25)");
        System.out.println("2. Rogue (HP 75, STR 75, AGL 100)");
        System.out.println("3. Killer (HP 50, STR 150, AGL 50)");
        gameClass = Integer.parseInt(scanner.nextLine());
        switch (gameClass) {
            case 1 -> Class.tank(nameHero);
            case 2 -> Class.rogue(nameHero);
            case 3 -> Class.killer(nameHero);
        }
        System.out.println(hero.toString());
        HP = Game.hero.hp;
        System.out.println("/help for to view commands.");
        System.out.println("'H' - this is you, Hero!");
        System.out.println("To start trading / fighting, stand on the corresponding sign and press enter");
        System.out.println("Good game, wanderer!");
        littleWorld.printWorld();
        Controller.control();
    }
}
