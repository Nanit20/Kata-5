/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata.pkg5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
        connect (URL_BD_SQLite);
        selectData_PEOPLE();
    }

    private static void connect(String URL_BD_SQLite) {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL_BD_SQLite);
            System.out.println("Base de datos conectada...");
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
    
}
