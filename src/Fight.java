import java.util.Scanner;

public class Fight {
    public static void fight(Entity entity){
        if(entity.agility >= Game.hero.agility){
            punch(Game.hero, entity.damage());
            System.out.println("Opponent strikes first");
        }else{
            punch(entity, Game.hero.damage());
            System.out.println("You strikes first");
        }
    }

    public static void punch(Entity entity, int damage){
        while(true) {
            entity.hp += (int) (Hero.armorPoint * 0.6);
            entity.hp -= damage;
            if (entity.hp <= 0) {
                if (entity.equals(Game.hero)) {
                    System.out.println("YOU DIED");
                    break;
                } else {
                    System.out.println("You wins!");
                    Controller.control();
                }
            }
        }
    }
}
