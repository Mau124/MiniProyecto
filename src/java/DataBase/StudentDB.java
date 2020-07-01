/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.*;
import java.util.ArrayList;

import Models.Student;

/**
 * Clase que contiene los metodos para realizar un CRUD a la tabla estudiantes
 * @author Mauricio Andres FLores Perez
 */
public  class StudentDB {
    private  DataBaseClass db = new DataBaseClass();
    
    public ArrayList<Student> readAllStudents()
    {
        ArrayList<Student> students = new ArrayList<Student>();
        ResultSet result;
        
        try 
        {
            PreparedStatement stmt = db.getCon().prepareStatement("SELECT * FROM Student");
            result = stmt.executeQuery();
            
            while (result.next())
            {
                Student s = new Student();
                s.setRegister(result.getString("Register"));
                s.setName(result.getString("Name"));
                s.setLastName(result.getString("LastName"));
                s.setIDCity(result.getInt("IDCity"));
                s.setIDCarer(result.getInt("IDCarer"));
                
                students.add(s);
            }
        } catch (SQLException e)
        {
            System.out.println("Error " + e.getMessage());
            return null;
        }
        
        return students;
    }
    
    public boolean addStudent(Student student)
    {
        try 
        {
            String sql = "INSERT INTO student(Register, Name, LastName, IDCity, IDCarer)"
                    + " VALUES(?, ?, ?, ?, ?)";
            
            PreparedStatement stmt = db.getCon().prepareStatement(sql);
            stmt.setString(1, student.getRegister());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getLastName());
            stmt.setInt(4, student.getIDCity());
            stmt.setInt(5, student.getIDCarer());
            
            stmt.executeUpdate();
        } catch (SQLException e)
        {
            System.out.println("Error " + e.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean updateStudent(String register, Student student)
    {
        try
        {
            String sql = "UPDATE student SET Name = ?, LastName = ?, IDCity = ?, "
                    + "IDCarer = ? WHERE Register = ?";
            
            PreparedStatement stmt = db.getCon().prepareStatement(sql);
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getLastName());
            stmt.setInt(3, student.getIDCity());
            stmt.setInt(4, student.getIDCarer());
            stmt.setString(5, register);
            
            stmt.executeUpdate();
        } catch (SQLException e)
        {
            System.out.println("Error " + e.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean deleteStudent(String register)
    {
        try 
        {
            String sql = "DELETE FROM student WHERE register = ?";
            
            PreparedStatement stmt = db.getCon().prepareStatement(sql);
            stmt.setString(1, register);
            
            stmt.executeUpdate();
        } catch (SQLException e)
        {
            System.out.println("Error " + e.getMessage());
            return false;
        }
        return true;
    }
}
