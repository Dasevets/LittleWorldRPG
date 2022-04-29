public class Class {

    // задаем класс героя при начале игры
    // начальные характеристики героя различаются в зависимости от класса и меняются в зависимосчти от вещей и уровня


    public static void tank(String nameHero) {
        Game.hero  = new Hero(150, 75, 25);
        Game.hero.setName(nameHero);
    }

    public static void rogue(String nameHero){
        Game.hero  = new Hero(75, 75, 100 );
        Game.hero.setName(nameHero);
    }

    public static void killer(String nameHero){
        Game.hero  = new Hero(50, 150, 50);
        Game.hero.setName(nameHero);
    }
}