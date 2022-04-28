import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LittleWorld {

    static Object[][] world = setWorld();
    static int xTM = (int)((Math.random() * 6)+7);
    static int yTM = (int)((Math.random() * 6)+7);

    public static Object[][] setWorld(){
        Object[][] map = new Object[22][22];

        //делаем рамку вокруг карты
        String s = "_";
        String s1 = "|";
        String s2 = ".";
        for(int i = 0; i < map.length; i++){

            map[0][i] = s;
            map[21][i] = s;
            map[i][0] = s1;
            map[i][21] = s1;

        }

        //убираем null с карты, заменяем на точки
        for(int i = 1; i < map.length -1; i++ ){
            for(int j = 1; j < map[i].length -1; j++){
                map[i][j] = s2;
            }
        }

        // задаем место спауна игрока
        map[Controller.pointHX][Controller.pointHY] = "H";

        // раскидываем артефакты по полю
        Artifact.setArtifact(); // получаем координаты при помощи math.random
        for (int i  = 0; i < 12; i = i+2) {
            map[Artifact.coordArt.get(i)][Artifact.coordArt.get(i + 1)] = "A"; // передаем координаты на карту
//            System.out.println(Artifact.coordArt.get(i) + " " + Artifact.coordArt.get(i + 1));
        }

//        for (int i  = 0; i < Artifact.coordArt.size(); i++) {
//
//            System.out.print(Artifact.coordArt.get(i) + " ");
//        }

        return map;
    }



    public void printWorld(){

        //задаем место положение торговца на карте(TM - tradesman)
        world[xTM][yTM] = "TM";

        //распечатываем карту в консоль
        for(int i = 0; i < world.length; i++ ){
            for(int j = 0; j < world[i].length; j++){
                System.out.print(world[i][j] + "\t");
            }
            System.out.println();
        }
        //System.out.println(LittleWorld.world[Controller.pointHX][Controller.pointHY].toString());
    }


}
