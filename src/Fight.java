
public class Fight {
    public static void fight(Entity entity) {
        if (entity.agility >= Game.hero.agility) { // решаем кто наносит первый удар
            System.out.println("Opponent strikes first");
            punchMtoH(Game.hero, entity.damage(), entity);

        } else {
            System.out.println("You strikes first");
            punchHtoM(entity, Game.hero.damage(), entity);

        }
    }

    public static void punchHtoM(Entity entity, int damage, Entity monster) {

        while (true) {
            monster.hp += (int) (Hero.armorPoint * 0.6);
            monster.hp -= damage;
            System.out.println(Game.hero.toString());
            System.out.println("Monster " + monster.toString());
            if (monster.hp <= 0) {
                //System.out.println("1");
                Game.hero.setMoney(20);
                System.out.println("You wins!");
                Game.hero.setExperience(50);
                Controller.control();
                break;
            } else {
                //System.out.println("2");
                punchMtoH(Game.hero, damage, monster);

            }
        }
    }

    public static void punchMtoH(Entity entity, int damage, Entity monster) {
        while (true) {
            Game.hero.hp += (int) (Hero.armorPoint * 0.6);
            Game.hero.hp -= damage;

            if(Game.hero.hp <= 10){
                for (Item item: Inventory.inventory) {
                    try {
                        if (item.heal != 0) {
                            Game.hero.hp += item.heal;
                        } else {
                            System.out.println("You have not heal!");
                        }
                    }catch (NullPointerException e) {
                        System.out.println("Inventory is empty!");
                    }
                }
            }

            if (Game.hero.hp <= 0) {

                //System.out.println("3");
                System.out.println("YOU DIED");
                System.exit(0);
                //break;

            } else {
                //System.out.println("4");
                punchHtoM(entity, damage, monster);
            }
        }
    }
}
