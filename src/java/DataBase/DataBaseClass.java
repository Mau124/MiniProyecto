/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.*;
import java.util.ArrayList;

/**
 * Clase que contiene los metodos y propiedades para manejar la base de datos
 * @author Mauricio Andres FLores Perez
 */
public class DataBaseClass {
    private Connection con;
    
    public DataBaseClass()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://PC;databaseName=MiniProyecto;user=sql_user;password=123");
        } catch (ClassNotFoundException | SQLException e)
        {
            System.out.println("Error al cargar el driver " + e.getMessage());
        }
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
}
