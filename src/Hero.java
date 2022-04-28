public class Hero extends Entity{

    private String name; // имя героя
    private int experience = 0; // опыт героя
    private int money; // количество денег
    private int damagePoint = damage(); // очки наносимого урона
    private double critical = 0.05; // вероятность критического урона

    static int armorPoint = Inventory.sumArmorPoint(); // очки брони, считаются в инвентаре в зависимости от надетых вещей


    public Hero(int hp, int strength, int agility) {

        super(hp, strength, agility);

    }

    public void setName(String name) {
        this.name = name;
    } // устанавливаем имя

    public void setMoney(int money) { // установить кол-во денег
        this.money = money;
    }

    public int getMoney() { // получить кол-во денег
        return money;
    }

    @Override
    public String toString(){
        return name + ", HP: " + hp + ", STR: " + strength + ", AGL: " + agility + ", EXP: " + experience + ", GOLD: " + money;
    }

    //переопределяем назначение наносимого урона.
    //вероятность критического урона может меняться в зависимости от уровня героя переменная critical
    @Override
    public int damage(){
        int ap = 0; // attack point
        double criticalDamage = agility * 0.5;
        if(Math.random() < critical){
            ap = strength + (int)criticalDamage;
        } else {
            ap = strength;
        }
        //наносимый урон так же зависит от оружия главного героя
        if (Inventory.weapon != null){
            ap += Inventory.weapon.damage;
        }
        return ap;
    }
}
