/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.*;
import java.util.ArrayList;

import Models.Optional;

/**
 *
 * @author Andres
 */
public class OptionalDB {
    private DataBaseClass db = new DataBaseClass();
    
    public ArrayList<Optional> readAllOptional()
    {
        ArrayList<Optional> optionals = new ArrayList<Optional>();
        ResultSet result;
        
        try 
        {
            PreparedStatement stmt = db.getCon().prepareStatement("SELECT * FROM Optional");
            result = stmt.executeQuery();
            
            while (result.next())
            {
                Optional o = new Optional();
                
                o.setIDOptional(result.getInt("IDOptional"));
                o.setName(result.getString("Name"));
                o.setCredits(result.getInt("Credits"));
                o.setIDCarer(result.getInt("IDCarer"));
                
                optionals.add(o);
            }
        } catch (SQLException e)
        {
            System.out.println("Error " + e.getMessage());
            return null;
        }
        
        return optionals;
    }
    
    public boolean addOptional(Optional optional)
    {
        try 
        {
            String sql = "INSERT INTO optional( Name, Credits, IDCarer)"
                    + " VALUES(?, ?, ?)";
            
            PreparedStatement stmt = db.getCon().prepareStatement(sql);
            stmt.setString(1, optional.getName());
            stmt.setInt(2, optional.getCredits());
            stmt.setInt(3, optional.getIDCarer());
            
            stmt.executeUpdate();
        } catch (SQLException e)
        {
            System.out.println("Error " + e.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean updateOptional(int IDOptional, Optional optional)
    {
        try
        {
            String sql = "UPDATE optional SET Name = ?, Credits = ?, IDCarer = ? "
                    + "WHERE IDOptional = ?";
            
            PreparedStatement stmt = db.getCon().prepareStatement(sql);
            stmt.setString(1, optional.getName());
            stmt.setInt(2, optional.getCredits());
            stmt.setInt(3, optional.getIDCarer());
            stmt.setInt(4, IDOptional);
            
            stmt.executeUpdate();
        } catch (SQLException e)
        {
            System.out.println("Error " + e.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean deleteOptional(int IDOptional)
    {
        try 
        {
            String sql = "DELETE FROM optional WHERE IDOptional = ?";
            
            PreparedStatement stmt = db.getCon().prepareStatement(sql);
            stmt.setInt(1, IDOptional);
            
            stmt.executeUpdate();
        } catch (SQLException e)
        {
            System.out.println("Error " + e.getMessage());
            return false;
        }
        return true;
    }
}
