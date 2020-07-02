/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Models.City;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Andres
 */
public class CityDB {
    private  DataBaseClass db = new DataBaseClass();
    
    public ArrayList<City> readAllCities()
    {
        ArrayList<City> cities = new ArrayList<City>();
        ResultSet result;
        
        try 
        {
            PreparedStatement stmt = db.getCon().prepareStatement("SELECT * FROM City");
            result = stmt.executeQuery();
            
            while (result.next())
            {
                City c = new City();
                c.setIDCity(result.getInt("IDCity"));
                c.setCity(result.getString("City"));
                
                cities.add(c);
            }
        } catch (SQLException e)
        {
            System.out.println("Error " + e.getMessage());
            return null;
        }
        
        return cities;
    }
    
    public boolean addCity(City city)
    {
        try 
        {
            String sql = "INSERT INTO city(Name)"
                    + " VALUES(?)";
            
            PreparedStatement stmt = db.getCon().prepareStatement(sql);
            stmt.setString(1, city.getCity());
            
            stmt.executeUpdate();
        } catch (SQLException e)
        {
            System.out.println("Error " + e.getMessage());
            return false;
        }
        return true;
    }
}
