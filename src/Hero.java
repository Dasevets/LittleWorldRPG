public class Hero extends Entity{

    private String name; // имя героя
    private int experience = 0; // опыт героя
    private int money; // количество денег
    private int damagePoint = damage(); // очки наносимого урона
    private double critical = 0.05; // вероятность критического урона
    private int level = 1;

    static int armorPoint = Inventory.sumArmorPoint(); // очки брони, считаются в инвентаре в зависимости от надетых вещей


    public Hero(int hp, int strength, int agility) { // конструктор героя

        super(hp, strength, agility);

    }

    public void setName(String name) {
        this.name = name;
    } // устанавливаем имя

    public void setMoney(int money) { // установить кол-во денег
        this.money += money;
    }

    public int getMoney() { // получить кол-во денег
        return money;
    }

    public void setExperience(int experience) { // изменяем количество опыта
        this.experience += experience;
        if((this.experience % 100) == 0){
            level++;
            System.out.println("New level!" + level); // увеличиваем и выводи уровень, увеличиваем все показатели с каждым уровнем
            critical += 0.04;
            strength += 5;
            hp += 10;
            agility += 5;
            System.out.println(Game.hero.toString());
        }
    }


    @Override
    public String toString(){
        return name + ", HP: " + hp + ", STR: " + strength + ", AGL: " + agility + ", EXP: " + experience + ", GOLD: " + money + ", LVL: " + level;
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
