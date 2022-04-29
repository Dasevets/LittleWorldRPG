import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LittleWorld {

    static Object[][] world = setWorld();
    static int xTM = (int) ((Math.random() * 6) + 7);
    static int yTM = (int) ((Math.random() * 6) + 7);
    int count = 0;


    public static Object[][] setWorld() {
        Object[][] map = new Object[22][22];

        //делаем рамку вокруг карты
        String s = "_";
        String s1 = "|";
        String s2 = ".";
        for (int i = 0; i < map.length; i++) {

            map[0][i] = s;
            map[21][i] = s;
            map[i][0] = s1;
            map[i][21] = s1;

        }

        //убираем null с карты, заменяем на точки
        for (int i = 1; i < map.length - 1; i++) {
            for (int j = 1; j < map[i].length - 1; j++) {
                map[i][j] = s2;
            }
        }

        // задаем место спауна игрока
        map[Controller.pointHX][Controller.pointHY] = "H";


        // задаем место спауна мобов
        // создаем скелет
        //Skeleton skeleton = new Skeleton(25, 15,5);
        Skeleton.setsX((int) ((Math.random() * 4) + 3));
        Skeleton.setsY((int) ((Math.random() * 4) + 3));
        map[Skeleton.sX][(Skeleton.sY)] = "S"; // назначаем точку спауна


        // создаем гоблина
        //Goblin goblin = new Goblin(50, 15, 25);
        Goblin.setgX((int) ((Math.random() * 4) + 14));
        Goblin.setgY((int) ((Math.random() * 4) + 14));
        map[Goblin.gX][Goblin.gY] = "G"; // назначаем точку спауна


        // раскидываем артефакты по полю
        Artifact.setArtifact(); // получаем координаты при помощи math.random
        for (int i = 0; i < 12; i = i + 2) {
            map[Artifact.coordArt.get(i)][Artifact.coordArt.get(i + 1)] = "A"; // передаем координаты на карту
        }

        return map;
    }


    public void printWorld() {


        //задаем место положение торговца на карте(TM - tradesman)
        world[xTM][yTM] = "TM";

        //распечатываем карту в консоль
        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[i].length; j++) {
                System.out.print(world[i][j] + "\t");
            }
            System.out.println();
        }
        count++;
        if ((count % 5) == 0) {
            for (int i = 0; i < world.length; i++) {
                for (int j = 0; j < world[i].length; j++) {
                    if(world[i][j].equals("S")){
                        world[i][j] = ".";
                    }
                    if(world[i][j].equals("G")){
                        world[i][j] = ".";
                    }
                }
            }

            // перемещаем мобов
            LittleWorld.mobs();
        }
        //System.out.println(LittleWorld.world[Controller.pointHX][Controller.pointHY].toString());
    }

    public static void mobs() {
        // двигаем мобов
        // создаем скелет
        //Skeleton skeleton = new Skeleton(25, 15,5);
        Skeleton.setsX((int) ((Math.random() * 4) + 3));
        Skeleton.setsY((int) ((Math.random() * 4) + 3));
        world[Skeleton.sX][(Skeleton.sY)] = "S"; // назначаем точку спауна


        // создаем гоблина
        //Goblin goblin = new Goblin(50, 15, 25);
        Goblin.setgX((int) ((Math.random() * 4) + 14));
        Goblin.setgY((int) ((Math.random() * 4) + 14));
        world[Goblin.gX][Goblin.gY] = "G"; // назначаем точку спауна
    }


}
