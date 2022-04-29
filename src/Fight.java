
public class Fight {
    public static void fight(Entity entity) { // приходит монстр
        if (entity.agility >= Game.hero.agility) { // решаем кто наносит первый удар (если ловкость монстра больше ловкости героя)
            System.out.println("Opponent strikes first"); // монстр бьет первый
            punchMtoH(Game.hero, entity.damage(), entity); // отсылаем героя, урон монстра, и монстра в метод "удар монстра по герою"

        } else { //если ловкость героя больше ловкости монстра, герой бьет первый
            System.out.println("You strikes first");
            punchHtoM(Game.hero, Game.hero.damage(), entity); //отсылаем героя, урон героя и монстра в метод "удар героя по монстру"

        }
    }

    public static void punchHtoM(Entity entity, int damage, Entity monster) { //метод "удар героя по монстру"

        while (true) {
            monster.hp += (int) (Hero.armorPoint * 0.6); //вычисляем здоровье монстра
            monster.hp -= damage; //вычитаем из здоровья монстра урон героя
            System.out.println(Game.hero.toString());
            System.out.println("Monster " + monster.toString());
            if (monster.hp <= 0) { //если здоровье монстра меньше или равно 0, мы победили получаем денеьги и опыт, переходим обратно на карту
                //System.out.println("1");
                Game.hero.setMoney(20);
                System.out.println("You wins!");
                Game.hero.setExperience(50);
                Controller.control();
                break;
            } else { //если здоровье монстра больше 0, переходим к методу "удар монстра по герою"
                //System.out.println("2");
                punchMtoH(Game.hero, damage, monster);

            }
        }
    }

    public static void punchMtoH(Entity entity, int damage, Entity monster) {  //метод "удар монстра по герою"
        while (true) {
            Game.hero.hp += (int) (Hero.armorPoint * 0.6); // вычисляем здоровье героя
            Game.hero.hp -= damage; // вычитаем из здоровья героя урон от монстра

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

            if (Game.hero.hp <= 0) { //если уровень здоровья героя меньше или равен 0, мы умерли

                //System.out.println("3");
                System.out.println("YOU DIED");
                System.exit(0); // завершаем программу
                //break;

            } else {
                //System.out.println("4");
                punchHtoM(entity, damage, monster); //если не умерли, переходим к методу "удар героя по монстру"
            }
        }
    }
}
