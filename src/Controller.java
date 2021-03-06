import java.util.Scanner;

// контреллер, отвечет за все управление героя, открытие карты, инвентаря, управление боем
public class Controller {

    static Scanner scanner = new Scanner(System.in);
    static int pointHX = Move.pointHeroX();
    static int pointHY = Move.pointHeroY();


    public static void control() {


        while (true) {
            String cont = scanner.nextLine();

            if ((pointHX == LittleWorld.xTM) && (pointHY == LittleWorld.yTM)) { // когда заходим на клетку торговца, перемещаемся в магазин
                Tradesman.shop();
            }

            for (int i = 0; i < 12; i += 2) { // когда заходим на клетку артефакта, автоматичсески подбираем его, можем увидеть в инвентаре
                if ((pointHX == Artifact.coordArt.get(i)) && (pointHY == Artifact.coordArt.get(i + 1))) {
                    Inventory.artefacts.add(new Item("Artifact", 0, 0, 0, 30));
                    System.out.println("You picked up an artifact!");
                }
            }

            if ((pointHX == Skeleton.sX) && (pointHY == Skeleton.sY)) { // бой со скелетом
                Skeleton skeleton = new Skeleton(50, 40, 25);
                System.out.println("You started the battle with the skeleton");
                System.out.print("Skeleton ");
                System.out.println(skeleton);
                System.out.println(Game.hero.toString());
                Skeleton.setsX((int) ((Math.random() * 4) + 3));
                Skeleton.setsY((int) ((Math.random() * 4) + 3));
                //Fight.fight(skeleton);
                new Fight(Game.hero, skeleton).fight();
            }
            if ((pointHX == Goblin.gX) && (pointHY == Goblin.gY)) {
                Goblin goblin = new Goblin(75, 60, 100);
                System.out.println("You started the battle with the goblin");
                System.out.print("Goblin ");
                System.out.println(goblin);
                System.out.println(Game.hero.toString());
                Goblin.setgX((int) ((Math.random() * 4) + 14));
                Goblin.setgY((int) ((Math.random() * 4) + 14));
                //Fight.fight(goblin);
                new Fight(Game.hero, goblin).fight();
            }


            switch (cont) {
                case "/help":
                    System.out.println("m - Map legend");
                    System.out.println("i - Inventory");
                    System.out.println("j - Characteristics");
                    System.out.println("w - Move UP");
                    System.out.println("s - Move DOWN");
                    System.out.println("a - Move LEFT");
                    System.out.println("d - Move RIGHT");
                    System.out.println("'h' - First aid kit");
                    System.out.println("/exit - Close game");

                    break;
                case "m":
                    System.out.println("'H' - Hero");
                    System.out.println("'TM' - Tradesman");
                    System.out.println("'G' - Goblin");
                    System.out.println("'S' - Skeleton");
                    System.out.println("'A' - Artifact");
                    break;
                case "i":
                    if (Inventory.inventory.isEmpty() && Inventory.artefacts.isEmpty()) {
                        System.out.println("Inventory is empty!");
                    } else {
                        Inventory.inventory.forEach(item -> System.out.println(item.toString()));
                        Inventory.artefacts.forEach(item -> System.out.println(item.toString()));
                    }
                    break;
                case "j":
                    System.out.println(Game.hero.toString());
                    break;
                case "/exit":
                    System.out.println("GAME OVER");
                    System.exit(0);
                    break;
                case "w":  // вперед
                    Move.move(Controller.pointHX - 1, Controller.pointHY);
                    break;
                case "s":  // назад
                    Move.move(Controller.pointHX + 1, Controller.pointHY);
                    break;
                case "a":  // влево
                    Move.move(Controller.pointHX, Controller.pointHY - 1);
                    break;
                case "d":  // вправо
                    Move.move(Controller.pointHX, Controller.pointHY + 1);
                    break;
                case "h": //применить аптечку
                    if (Game.hero.hp < Game.HP) { //проверяем героя на количество здоровья
                        for (Item item : Inventory.inventory) {
                            try {
                                if (item.heal != 0) { // проверяем наличие аптечки в инвентаре
                                    Game.hero.hp += item.heal; //увеличиваем здоровье за счет аптечки
                                    if(Game.hero.hp > Game.HP){ // если аптечка "перелечила", убираем лишнее
                                        Game.hero.hp = Game.HP;
                                    }
                                    Inventory.inventory.remove(item); //удаляем аптечку
                                    break;
                                } else {
                                    System.out.println("You have not heal!");
                                }
                            } catch (NullPointerException e) {
                                System.out.println("Inventory is empty!");
                            }
                        }
                    }else{
                        System.out.println("Full health");
                    }
                    break;
            }
        }
    }
}


class Move {

    // задаем изначальное место спауна героя
    public static int pointHeroX() {
        int xH = (int) ((Math.random() * 5) + 2); // строки
        return xH;
    }

    public static int pointHeroY() {
        int yH = (int) ((Math.random() * 5) + 15); // столбцы
        return yH;
    }


    // общий метод движения героя по полю
    public static void move(int x, int y) {
        LittleWorld.world[Controller.pointHX][Controller.pointHY] = ".";
        borderCheck(Controller.pointHX, Controller.pointHY);
        Controller.pointHX = x;
        Controller.pointHY = y;
        try {
            LittleWorld.world[Controller.pointHX][Controller.pointHY] = "H";
            Game.littleWorld.printWorld();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You fell off the edge of the world!");
            System.out.println("YOU DIED!");
            System.exit(0);
        }
    }

    public static void borderCheck(int x, int y) {
        if ((x <= 2) || (x >= 19) || (y <= 2) || (y >= 19)) {
            System.out.println("You have come too close to the edge of the world!");
            System.out.println("Leave or die!");

        }
    }
}
