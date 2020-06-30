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
            System.out.println("Error en la consulta");
            return null;
        }
        
        return students;
    }
}
