package entity;

public class Employee {
    private String name;
    private Long salary;
    private int id;

    public String getName() {
        return this.name;
    }

    public long getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name=" + name +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }

    public int getId() {
        return this.id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public Employee(String name_items, long cost_items, int id) {
        this.name = name_items;
        this.salary = cost_items;
        this.id = id;

    }
}
