package display;

import controler.ControlerMySQL;
import controler.ControlerSQL;
import controler.ControlerServerSQL;
import entity.Item;
import entity.ItemSql;
import entity.Users;
import manager.ConectionManagerMySQL;
import repository.Repository;
import service.ServiceMySSQL;
import sqlManager.SqlMyManager;

import java.sql.SQLException;
import java.util.Scanner;

public class Display {
    private ControlerServerSQL controlerServerSQL;
    private ControlerMySQL controlerMySQL;
    private ControlerSQL controlerSQL;

    public Display(ControlerMySQL controlerMySQL, ControlerServerSQL controlerServerSQL,ControlerSQL controlerSQL) {
        this.controlerServerSQL = controlerServerSQL;
        this.controlerMySQL = controlerMySQL;
        this.controlerSQL = controlerSQL;
    }

    public void start() throws SQLException {
        Item item;
        ItemSql itemSql;
        String name_item;
        long cost_item;
        Users users;
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
                case 1:
                    controlerMySQL.findAll().forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("Введите название пердмета");
                    name_item = scanner.nextLine();
                    System.out.println("Введите стоимость предмета");
                    cost_item = scanner.nextLong();
                    item = new Item(name_item, cost_item, 22);
                    System.out.println(item);
                    controlerMySQL.insert(item);
                    break;
                case 3:
                    System.out.println("Введите id предмета который нужно удалить");
                    int deleteId = scanner.nextInt();
                    controlerMySQL.deleteById(deleteId);
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
                    controlerMySQL.update(item);
                    break;
                case 5:
                    controlerServerSQL.findAll().forEach(System.out::println);
                    break;
                case 6:
                    System.out.println("Введите имя новго пользователя");
                    users_names = scanner.nextLine();
                    users = new Users(users_names, 11);
                    System.out.println(users);
                    controlerServerSQL.insert(users);
                    break;
                case 7:
                    System.out.println("Введите id пользователя которого хотите удалить");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    controlerServerSQL.deleteById(id);
                    break;
                case 8:
                    System.out.println("Введите id пользователя которого хотите изменить");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Введите новое имя пользователя");
                    users_names = scanner.nextLine();
                    users = new Users(users_names, id);
                    controlerServerSQL.update(users);
                    break;
                case 9:
                    controlerSQL.findAll().forEach(System.out::println);
                    break;
                case 10:
                    System.out.println("Введите название нового предмета");
                    name_item = scanner.nextLine();
                    System.out.println("Введите стоимость предмета");
                    price_item = scanner.nextLong();
                    scanner.nextLine();
                    itemSql = new ItemSql(name_item,price_item,34);
                    System.out.println(itemSql);
                    controlerSQL.insert(itemSql);
                    break;
                case 11:
                    System.out.println("Введите id предмета который хотите удалить");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    controlerSQL.deleteById(id);
                    break;
                case 12:
                    System.out.println("Введите id предмета который хотите изменить");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Введите новое название предмета");
                    name_item = scanner.nextLine();
                    System.out.println("Введите новую стоимость предмета");
                    price_item = scanner.nextLong();
                    scanner.nextLine();
                    itemSql = new ItemSql(name_item,price_item,id);
                    controlerSQL.update(itemSql);
                    break;


            }

        }
    }
}