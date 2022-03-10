import java.sql.*;

//запускаем  терминал
//В каталоге должен быть jar               ---    sqlite-jdbc-3.27.2.1.jar
//В каталоге должна быть  DB                  ---  us.db

// переходим в каталог                   ---     /home/alex/Hardy/MySQLite/src/
//запускаем компилятор                          ---     javac Program.java
//и затем запускаем программу                   ---     java -cp sqlite-jdbc-3.27.2.1.jar:.  Program



//      !!!!!!!!!!!!!!!!!!!!!!!!!!!!
//      !!!!!!!!!!!   ВАЖНО   !!!!!!
//для того чтобы запустить Program.main()
//Необходимо подключить Библиотеку!
//Смотри MySQLliteII


//Sample (Образец)  - Лежит полная редакция урока Евгения Волосатова


public class Program {
    public static Connection conn;

    public static void main(String[] var0) {


        conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:us.db");
            System.out.println("База Подключена!");

        } catch (Exception var5) {
            System.out.println(var5.getMessage());
        }

    }


}

