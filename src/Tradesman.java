import java.util.*;

public class Tradesman {

    static Map<Integer, Item> store = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void shop(){

        System.out.println("Select the desired item and enter its number");
        System.out.println("Enter to exit - /back\n");


        store.put(1, new Item("Small Heal", 15, 0, 0, 10));
        store.put(2, new Item("Large Heal", 25, 0, 0, 20));
        store.put(3, new Item("Iron Blade", 0, 10, 0, 15));
        store.put(4, new Item("Obsidian Blade", 0, 50, 0, 45));
        store.put(5, new Item("Shield", 0, 0, 25, 15));
        store.put(6, new Item("Helmet", 0, 0, 15, 15));
        store.put(7, new Item("Armor", 0, 0, 20, 25));
        store.put(8, new Item("Shoes", 0, 0, 10, 10));
        store.put(9, new Item("Good Armor", 0, 0, 30, 35));
        store.put(10, new Item("Good Helmet", 0, 0, 20, 20));

        for(int i = 1; i <= store.size(); i++) { // распечатываем все что есть в магазине
            System.out.println((i) + store.get(i).toString());
        }

        while (true){ // запускаем контроллер магазина
            String shopControl = scanner.nextLine();

            if(shopControl.equals("/back")){
                Move.moveUp();
                Controller.control();
                break;
            }else {
                try {
                    int index = Integer.parseInt(shopControl);
                    int gold = Game.hero.getMoney();
                    if(gold > store.get(index).price) {
                        Inventory.inventory.add(store.get(index));
                    }else {
                        System.out.println("Not enough money");
                        shop();
                    }

                }catch (NumberFormatException e){
                    System.out.println("Incorrect command!");
                }

            }
        }
    }
}
