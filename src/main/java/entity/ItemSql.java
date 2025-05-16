package entity;

public class ItemSql {
    private String name_item;
    private Long price_item;
    private int id;

    public String getName_item() {
        return this.name_item;
    }

    public long getPrice_item() {
        return this.price_item;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name_items=" + name_item +
                ", cost_items=" + price_item +
                ", id=" + id +
                '}';
    }

    public int getId() {
        return this.id;
    }

    public void setName_items(String name_items) {
        this.name_item = name_items;
    }

    public void setCost_items(long cost_items) {
        this.price_item = cost_items;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ItemSql(String name_items, long cost_items, int id) {
        this.name_item = name_items;
        this.price_item = cost_items;
        this.id = id;

    }
}
