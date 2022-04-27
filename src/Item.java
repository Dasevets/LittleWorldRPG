public class Item {
    String itemName;
    int heal;
    int damage;
    int defence;
    int price;

    // задаем предмет и его характеристики
    public Item(String itemName, int heal, int attack, int defence, int price) {
        this.itemName = itemName;
        this.heal = heal;
        this.damage = attack;
        this.defence = defence;
        this.price = price;
    }

    @Override
    public String toString(){

        return "'" + itemName + "'" + " heal: " + heal + ", attack: " + damage + ", defence: " + defence + ", price: " + price;
    }


}
