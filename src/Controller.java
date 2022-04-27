import java.util.Scanner;

// контреллер, отвечет за все управление героя, открытие карты, инвентаря, управление боем
public class Controller {

    static Scanner scanner = new Scanner(System.in);
    static int pointHX = Move.pointHeroX();
    static int pointHY = Move.pointHeroY();

    public static void control(){

        while (true){
            String cont = scanner.nextLine();

            if((pointHX == LittleWorld.xTM) && (pointHY == LittleWorld.yTM)){ // когда заходим на клетку торговца, перемещаемся в магазин
                Tradesman.shop();
            }

            if(cont.equals("/help")){
                System.out.println("m - Map");
                System.out.println("i - Inventory");
                System.out.println("j - Characteristics");
                System.out.println("w - Move UP");
                System.out.println("s - Move DOWN");
                System.out.println("a - Move LEFT");
                System.out.println("d - Move RIGHT");
                System.out.println("/exit - Close game");
            }else if(cont.equals("m")){
                Game.littleWorld.printWorld();
                System.out.println("Map is closed.");
            }else if(cont.equals("i")){
                if(Inventory.inventory.isEmpty()){
                    System.out.println("Inventory is empty!");
                }else {
                    Inventory.inventory.forEach(item -> System.out.println(item.toString()));
                }
            }else if(cont.equals("j")){
                System.out.println(Game.hero.toString());
            }else if(cont.equals("/exit")){
                System.out.println("GAME OVER");
                break;
            }else if(cont.equals("w")){ // вперед
                Move.moveUp();
            }else if(cont.equals("s")){ // назад
                Move.moveDown();
            }else if(cont.equals("a")){ // влево
                Move.moveLeft();
            }else if(cont.equals("d")){ // вправо
                Move.moveRight();
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
