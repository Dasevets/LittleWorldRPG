import java.util.ArrayList;
import java.util.List;


// инвентарь отвечает за хранение и просмотр вещей которые есть у героя
public class Inventory {

    static List<Item> inventory = new ArrayList<>();
    static List<Item> artefacts = new ArrayList<>();
    static int armorPoint;
    static Item helmet = null; //шлем
    static Item armor = null;  // броня
    static Item shoes = null;  // обувь

    static Item shield = null;  // щит
    static Item weapon = null;  // оружие

    public static void sumArmorPoint(){
        armorPoint = helmet.defence + armor.defence + shoes.defence + shield.defence;
    }


}
