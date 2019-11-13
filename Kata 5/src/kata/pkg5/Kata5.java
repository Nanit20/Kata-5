package kata.pkg5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5 {
    public static Connection connection;
    public static void main(String[] args) {
        String URL_BD_SQLite = new String ("jdbc:sqlite:C:\\Users\\Usuario\\Documents\\NetBeansProjects\\DB_SQLite\\miErcoles.db");
        Connection connection = connect (URL_BD_SQLite);
        
    }

    private static Connection connect(String URL_BD_SQLite) {
        // Connection connection = null;
        try{
            Kata5.connection = DriverManager.getConnection(URL_BD_SQLite);
            System.out.println("Base de datos conectada...");
            selectData_PEOPLE(connection);
        }
        catch(SQLException exception) {
            System.out.println("ERROR(SQLException)" + exception.getMessage());
        }
        finally{
            try{
                if(connection != null){
                    connection.close();
                }
            }
            catch(SQLException exception) {
                System.out.println("ERROR(SQLException)" + exception.getMessage());
            }
        }
        return connection;
    }

    private static void selectData_PEOPLE(Connection connection) {
        String SQL = "SELECT * FROM PEOPLE";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(SQL);
            System.out.println("ID \t Name \t Apellidos \t Departamento");
            while (resultset.next()){
                System.out.println(resultset.getInt("ID") + "\t " +
                                   resultset.getString("Name") + "\t " +
                                   resultset.getString("Apellidos") + "\t " + 
                                   resultset.getString("Departamento") + "\t ");
            }
        }
        catch(SQLException exception) {
            System.out.println("ERROR(Salida)" + exception.getMessage());
        }
    }

        
    
}
