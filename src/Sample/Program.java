package Sample;

import java.sql.*;

//запускаем  терминал
//В каталоге должен быть jar               ---    sqlite-jdbc-3.27.2.1.jar
//В каталоге должна быть  DB                  ---  us.db

// переходим в каталог                   ---     /home/alex/Hardy/MySQLite/src/
//запускаем компилятор                          ---     javac Program.java
//и затем запускаем программу                   ---     java -cp sqlite-jdbc-3.27.2.1.jar:.  Program


public class Program {
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    public Program() {
    }

    public static void main(String[] var0) throws ClassNotFoundException, SQLException {
        String[] var1 = var0;
        int var2 = var0.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            String var10000 = var1[var3];
            System.out.println(" args ---- " + var0[0]);
        }

        conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:./us.db");
            System.out.println("База Подключена!");
            CreateDB();
            WriteDB();
            ReadDB();
            CloseDB();
        } catch (Exception var5) {
            System.out.println(var5.getMessage());
        }

    }

    public static void CreateDB() throws ClassNotFoundException, SQLException {
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'phone' INT);");
        System.out.println("Таблица создана или уже существует.");
    }

    public static void WriteDB() throws SQLException {
        statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Petya', 125453); ");
        statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Vasya', 321789); ");
        statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Masha', 456123); ");
        System.out.println("Таблица заполнена");
    }

    public static void ReadDB() throws ClassNotFoundException, SQLException {
        resSet = statmt.executeQuery("SELECT * FROM users");

        while(resSet.next()) {
            int var0 = resSet.getInt("id");
            String var1 = resSet.getString("name");
            String var2 = resSet.getString("phone");
            System.out.println("ID = " + var0);
            System.out.println("name = " + var1);
            System.out.println("phone = " + var2);
            System.out.println();
        }

        System.out.println("Таблица выведена");
    }

    public static void CloseDB() throws ClassNotFoundException, SQLException {
        conn.close();
        statmt.close();
        resSet.close();
        System.out.println("Соединения закрыты");
    }
}

