public abstract class Entity {

    int hp;
    int strength;
    int agility;
    int damagePoint = damage();

    public Entity(int hp, int strength, int agility){
        this.hp = hp;
        this.strength = strength;
        this.agility = agility;
    }

    //узнаем damage существ. зависимость критического урона от agility
    //зависимость ap(attack point) от силы, критического урона и вероятности критического урона
    public int damage(){
        int ap = 0;
        double criticalDamage = agility * 0.5;
        if(Math.random() < 0.15){
            ap = strength + (int)criticalDamage;
        } else {
            ap = strength;
        }
        return ap;
    }


}
