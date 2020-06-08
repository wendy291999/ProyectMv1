
package com.mycompany.proyectmv1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.Serializable;


public class Conection implements Serializable{
    private static Conection connectionbd;
    private transient  Connection connection;
    
    private Conection() throws SQLException {       
        try {
             connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/crudgabriel",
                    "postgres", "wendy123");
            Logger.getLogger(Conection.class.getName()).log(Level.INFO, "Conectado");
        } catch (SQLException ex) {
            Logger.getLogger(Conection.class.getName()).log(Level.SEVERE,"Error", ex);
        }finally{
            connection.close();
        }            
    }
    
    public static Conection getInstance() throws SQLException{
        if(connectionbd == null)
            connectionbd = new Conection();
        return connectionbd;
    }
}
