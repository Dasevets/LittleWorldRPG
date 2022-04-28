import java.util.Scanner;

// контреллер, отвечет за все управление героя, открытие карты, инвентаря, управление боем
public class Controller {

    static Scanner scanner = new Scanner(System.in);
    static int pointHX = Move.pointHeroX();
    static int pointHY = Move.pointHeroY();

    public static void control(){

        label:
        while (true){
            String cont = scanner.nextLine();

            if((pointHX == LittleWorld.xTM) && (pointHY == LittleWorld.yTM)){ // когда заходим на клетку торговца, перемещаемся в магазин
                Tradesman.shop();
            }

            for(int i =0; i<12; i+=2) { // когда заходим на клетку артефакта, автоматичсески подбираем его, можем увидеть в инвентаре
                if ((pointHX == Artifact.coordArt.get(i)) && (pointHY == Artifact.coordArt.get(i+1))) {
                    Inventory.artefacts.add(new Item("Artifact", 0, 0, 0, 30));
                    System.out.println("You picked up an artifact!");
                }
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
                    System.out.println("/exit - Close game");
                    break;
                case "m":
                    System.out.println("'H' - Hero");
                    System.out.println("'TM' - Tradesman");
                    //System.out.println("'G' - Goblin");
                    //System.out.println("'S' - Skeleton");
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
                    break label;
                case "w":  // вперед
                    Move.moveUp();
                    break;
                case "s":  // назад
                    Move.moveDown();
                    break;
                case "a":  // влево
                    Move.moveLeft();
                    break;
                case "d":  // вправо
                    Move.moveRight();
                    break;
            }
        }
    }
}



class Move{

    // задаем изначальное место спауна героя
    public static int pointHeroX(){
        int xH = (int)((Math.random() * 5)+2); // строки
        return xH;
    }
    public static int pointHeroY(){
        int yH = (int)((Math.random() * 5)+15); // столбцы
        return yH;
    }


    // метода движения героя по полю
    public static void moveUp(){
        LittleWorld.world[Controller.pointHX][Controller.pointHY] = ".";
        Controller.pointHX -= 1;
        LittleWorld.world[Controller.pointHX][Controller.pointHY] = "H";
        Game.littleWorld.printWorld();
    }

    public static void moveDown(){
        LittleWorld.world[Controller.pointHX][Controller.pointHY] = ".";
        Controller.pointHX += 1;
        LittleWorld.world[Controller.pointHX][Controller.pointHY] = "H";
        Game.littleWorld.printWorld();
    }

    public static void moveLeft(){
        LittleWorld.world[Controller.pointHX][Controller.pointHY] = ".";
        Controller.pointHY -= 1;
        LittleWorld.world[Controller.pointHX][Controller.pointHY] = "H";
        Game.littleWorld.printWorld();
    }

    public static void moveRight(){
        LittleWorld.world[Controller.pointHX][Controller.pointHY] = ".";
        Controller.pointHY += 1;
        LittleWorld.world[Controller.pointHX][Controller.pointHY] = "H";
        Game.littleWorld.printWorld();
    }
}
