package entity;

public class Item {
    private String nameItems;
    private Long costItems;
    private int id;

    public String getNameItems() {
        return this.nameItems;
    }

    public long getCostItems() {
        return this.costItems;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name_items=" + nameItems +
                ", cost_items=" + costItems +
                ", id=" + id +
                '}';
    }

    public int getId() {
        return this.id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public Item(String nameItems, long costItems, int id) {
        this.nameItems = nameItems;
        this.costItems = costItems;
        this.id = id;
    }
}
