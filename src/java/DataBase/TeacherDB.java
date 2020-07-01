/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Models.Teacher;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que contiene todos los metodos CRUD del Maestro
 * @author Angel Manuel
 */
public class TeacherDB {
    private DataBaseClass db = new DataBaseClass();
    //Insertar Maestro
    public boolean Insertar(Teacher Maestro) throws SQLException{
        try{
            PreparedStatement stmt = db.getCon().prepareStatement("INSERT INTO Teacher (IDTeacher,Name,LastName,IDAcademy) VALUES (?,?,?,?)");
            stmt.setInt(1, Maestro.getIDTeacher());
            stmt.setString(2, Maestro.getName());
            stmt.setString(3, Maestro.getLastName());
            stmt.setInt(4, Maestro.getIDAcademy());
            boolean rowInserted = stmt.executeUpdate()>0;
            stmt.close();
            db.getCon().close();
            return rowInserted;
        }catch(SQLException e){
            System.out.println("Error en la consulta");
            return false;
        }
    }
    //Listar todos los maestros
    
    public List<Teacher> ListarMaestros() throws SQLException{
        List<Teacher> listaMaestros = new ArrayList<Teacher>();
        ResultSet result;
        try{
            PreparedStatement stmt = db.getCon().prepareStatement("SELECT * FROM Teacher");
            result = stmt.executeQuery();
            while(result.next()){
            Teacher Maestro = new Teacher();
            Maestro.setIDAcademy(result.getInt("IDTeacher"));
            Maestro.setName(result.getString("Name"));
            Maestro.setLastName(result.getString("LastName"));
            Maestro.setIDAcademy(result.getInt("IDAcademy"));
            listaMaestros.add(Maestro);
            }
            db.getCon().close();
            return listaMaestros;
        }catch(SQLException e){
            System.out.println("Error en la consulta");
                    return null;
        }
    }
    //Actualizar
    public boolean Actualizar(Teacher Maestro) throws SQLException{
        boolean rowActualizar = false;
        try{
        PreparedStatement stmt = db.getCon().prepareStatement("UPDATE Teacher SET IDTeacher=?,Name=?,LastName=?,IDAcademy=?");
        stmt.setInt(1, Maestro.getIDTeacher());
        stmt.setString(2,Maestro.getName());
        stmt.setString(3, Maestro.getLastName());
        stmt.setInt(4, Maestro.getIDAcademy());
        rowActualizar = stmt.executeUpdate()>0;
        stmt.close();
        db.getCon().close();
        return rowActualizar;
        }catch(SQLException e){
            System.out.println("Error en la consulta");
            return rowActualizar;
        }
    }
    //Eliminar
    /*public boolean Eliminar(Teacher Maestro) throws SQLException{
        
    }*/
}
