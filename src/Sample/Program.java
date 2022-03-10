package Sample;

import java.sql.*;

//запускаем  терминал
//В каталоге должен быть jar               ---    sqlite-jdbc-3.27.2.1.jar
//В каталоге должна быть  DB                  ---  us.db

// переходим в каталог                   ---     /home/alex/Hardy/MySQLite/src/
//запускаем компилятор                          ---     javac Program.java
//и затем запускаем программу                   ---     java -cp sqlite-jdbc-3.27.2.1.jar:.  Program


public class Program {

    public static void main(String[] var0) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection co = DriverManager.getConnection("jdbc:sqlite:us.db");
            System.out.println("База Подключена!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


}

