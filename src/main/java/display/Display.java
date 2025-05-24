package display;

import controler.ItemController;
import controler.EmployeeController;
import controler.UserController;
import entity.Item;
import entity.Employee;
import entity.User;

import java.sql.SQLException;
import java.util.Scanner;

public class Display {
    private UserController userController;
    private ItemController itemController;
    private EmployeeController employeeController;

    public Display(ItemController itemController, UserController userController, EmployeeController employeeController) {
        this.userController = userController;
        this.itemController = itemController;
        this.employeeController = employeeController;
    }

    public void start() throws SQLException {
        Item item;
        Employee employee;
        String name_item;
        long cost_item;
        User user;
        String users_names;
        String user_item;
        long price_item;
        int user_id;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String menu = """
                    Меню: |1.Посмотреть предметы
                          |2.Добавить предметы
                          |3.Удалить предметы
                          |4.Обновить значения предметов
                          |5.Посмотреть пользователей
                          |6.Добавить пользователей
                          |7.Удалить пользователя
                          |8.Обновить значения пользователя
                          |9.Посмотреть все предметы
                          |10.Добавить предмет
                          |11.Удалить предмет
                          |12.Обновить предмет
                    """;
            System.out.println(menu);
            int hz = scanner.nextInt();
            scanner.nextLine();
            switch (hz) {
                case  1:
                    itemController.findAll().forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("Введите название пердмета");
                    name_item = scanner.nextLine();
                    System.out.println("Введите стоимость предмета");
                    cost_item = scanner.nextLong();
                    item = new Item(name_item, cost_item, 22);
                    System.out.println(item);
                    itemController.insert(item);
                    break;
                case 3:
                    System.out.println("Введите id предмета который нужно удалить");
                    int deleteId = scanner.nextInt();
                    itemController.deleteById(deleteId);
                    break;
                case 4:
                    System.out.println("Введите id предмета который хотите изменить");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Введите название предмета");
                    name_item = scanner.nextLine();
                    System.out.println("Введите стоимость предмета");
                    cost_item = scanner.nextLong();
                    item = new Item(name_item, cost_item, id);
                    itemController.update(item);
                    break;
                case 5:
                    userController.findAll().forEach(System.out::println);
                    break;
                case 6:
                    System.out.println("Введите имя новго пользователя");
                    users_names = scanner.nextLine();
                    user = new User(users_names, 11);
                    System.out.println(user);
                    userController.insert(user);
                    break;
                case 7:
                    System.out.println("Введите id пользователя которого хотите удалить");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    userController.deleteById(id);
                    break;
                case 8:
                    System.out.println("Введите id пользователя которого хотите изменить");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Введите новое имя пользователя");
                    users_names = scanner.nextLine();
                    user = new User(users_names, id);
                    userController.update(user);
                    break;
                case 9:
                    employeeController.findAll().forEach(System.out::println);
                    break;
                case 10:
                    System.out.println("Введите имя новго сотрудника");
                    name_item = scanner.nextLine();
                    System.out.println("Введите зп нового сотрудника");
                    price_item = scanner.nextLong();
                    scanner.nextLine();
                    employee = new Employee(name_item,price_item,34);
                    System.out.println(employee);
                    employeeController.insert(employee);
                    break;
                case 11:
                    System.out.println("Введите id сотрудника который хотите удалить");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    employeeController.deleteById(id);
                    break;
                case 12:
                    System.out.println("Введите id сотрудника который хотите изменить");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Введите новое имя сотрудника");
                    name_item = scanner.nextLine();
                    System.out.println("Введите новую зарплату сотрудника");
                    price_item = scanner.nextLong();
                    scanner.nextLine();
                    employee = new Employee(name_item,price_item,id);
                    employeeController.update(employee);
                    break;


            }

        }
    }
}