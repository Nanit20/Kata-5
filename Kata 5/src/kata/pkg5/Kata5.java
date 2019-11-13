/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata.pkg5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Usuario
 */
public class Kata5 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String URL_BD_SQLite = new String ("jdbc:sqlite:C:\\Users\\Usuario\\Documents\\NetBeansProjects\\DB_SQLite");
        Connection connection = connect (URL_BD_SQLite);
        selectData_PEOPLE(connection);
    }

    private static Connection connect(String URL_BD_SQLite) {
        Connection connection = null;
        try{
            this.connection = DriverManager.getConnection(URL_BD_SQLite);
            System.out.println("Base de datos conectada...");
            return connection;
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
    }

    private static void selectData_PEOPLE(Connection connection) {
        String SQL = "SELECT * FROM PEOPLE";
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(SQL);
    }
    
}
