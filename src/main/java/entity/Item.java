package entity;

public class Item {
    private String name_items;
    private Long cost_items;
    private int id;

    public String getName_items() {
        return this.name_items;
    }

    public long getCost_items() {
        return this.cost_items;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name_items=" + name_items +
                ", cost_items=" + cost_items +
                ", id=" + id +
                '}';
    }

    public int getId() {
        return this.id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public Item(String name_items, long cost_items, int id) {
        this.name_items = name_items;
        this.cost_items = cost_items;
        this.id = id;
    }
}
