
public class Fight {

    Entity entity;
    Entity entity1;
    public Fight(Entity entity, Entity entity1) {

        this.entity = entity;
        this.entity1 = entity1;

    }

    public void fight() { // приходит монстр
        if (entity1.agility >= entity.agility) { // решаем кто наносит первый удар (если ловкость монстра больше ловкости героя)
            System.out.println("Opponent strikes first"); // монстр бьет первый
            punchHtoM(entity, entity1.damage(), entity1); // отсылаем героя, урон монстра, и монстра в метод "удар монстра по герою"

        } else { //если ловкость героя больше ловкости монстра, герой бьет первый
            System.out.println("You strikes first");
            punchHtoM(entity1, entity.damage(), entity); //отсылаем героя, урон героя и монстра в метод "удар героя по монстру"

        }
    }

    public static void punchHtoM(Entity entity1, int damage, Entity entity2) { //метод "удар героя по монстру"

        while (true) {
            entity1.hp += (int) (Hero.armorPoint * 0.6); //вычисляем здоровье монстра
            entity1.hp -= damage; //вычитаем из здоровья монстра урон героя

//            entity1.hp += (int) (Hero.armorPoint * 0.6); // вычисляем здоровье героя
//            entity1.hp -= damage; // вычитаем из здоровья героя урон от монстра

            if(Game.hero.hp <= 10){ // если уровень здоровья героя меньше 10, применяется аптечка
                for (Item item: Inventory.inventory) {
                    try {
                        if (item.heal != 0) { // проверяем наличие аптечки в инвентаре
                            Game.hero.hp += item.heal; //увеличиваем здоровье за счет аптечки
                            Inventory.inventory.remove(item); //удаляем аптечку
                        } else {
                            System.out.println("You have not heal!");
                        }
                    }catch (NullPointerException e) {
                        System.out.println("Inventory is empty!");
                    }
                }
            }

            System.out.println(entity1.toString());
            System.out.println("Monster " + entity2.toString());
            if (entity2.hp <= 0) { //если здоровье монстра меньше или равно 0, мы победили получаем денеьги и опыт, переходим обратно на карту
                //System.out.println("1");
                if((entity2.getClass().equals(Skeleton.class)) || (entity2.getClass().equals(Goblin.class))){
                    Game.hero.setMoney(20);
                System.out.println("You wins!");
                Game.hero.setExperience(50);
                Controller.control();
                break;
                }

            } else { //если здоровье монстра больше 0, переходим к методу "удар монстра по герою"
                //System.out.println("2");
                punchHtoM(entity2, damage, entity1);

            }

            if (entity1.hp <= 0) { //если уровень здоровья героя меньше или равен 0, мы умерли

                //System.out.println("3");
                System.out.println("YOU DIED");
                System.exit(0); // завершаем программу
                //break;

            } else {
                //System.out.println("4");
                punchHtoM(entity1, damage, entity2); //если не умерли, переходим к методу "удар героя по монстру"
            }
        }
    }

//    public static void punchMtoH(Entity entity, int damage, Entity monster) {  //метод "удар монстра по герою"
//        while (true) {
//            Game.hero.hp += (int) (Hero.armorPoint * 0.6); // вычисляем здоровье героя
//            Game.hero.hp -= damage; // вычитаем из здоровья героя урон от монстра
//
//            if(Game.hero.hp <= 10){ // если уровень здоровья героя меньше 10, применяется аптечка
//                for (Item item: Inventory.inventory) {
//                    try {
//                        if (item.heal != 0) { // проверяем наличие аптечки в инвентаре
//                            Game.hero.hp += item.heal; //увеличиваем здоровье за счет аптечки
//                            Inventory.inventory.remove(item); //удаляем аптечку
//                        } else {
//                            System.out.println("You have not heal!");
//                        }
//                    }catch (NullPointerException e) {
//                        System.out.println("Inventory is empty!");
//                    }
//                }
//            }
//
//            if (Game.hero.hp <= 0) { //если уровень здоровья героя меньше или равен 0, мы умерли
//
//                //System.out.println("3");
//                System.out.println("YOU DIED");
//                System.exit(0); // завершаем программу
//                //break;
//
//            } else {
//                //System.out.println("4");
//                punchHtoM(entity, damage, monster); //если не умерли, переходим к методу "удар героя по монстру"
//            }
//        }
//    }
}
