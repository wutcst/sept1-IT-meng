package cn.edu.whut.sept.zuul;

/**
 * 房间中的物品类
 */
public class Item {
    private String description;//物品的描述信息
    private int weight;//物品的重量
    private int number;//物品的数量

    public Item(String description, int weight, int number) {
        this.description = description;
        this.weight = weight;
        this.number = number;
    }

    public Item() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", weight=" + weight +
                ", number=" + number +
                '}';
    }
}
