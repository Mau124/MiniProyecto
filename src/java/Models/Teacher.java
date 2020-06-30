/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 * Clase que abstrae las propiedades de una maestro
 * @author  Mauricio Andres FLores Perez
 */
public class Teacher {
    private int IDTeacher;
    private String name, lastName;
    private int IDAcademy;
    
    public Teacher() { }

    public Teacher(int IDTeacher, String name, String lastName, int IDAcademy) {
        this.IDTeacher = IDTeacher;
        this.name = name;
        this.lastName = lastName;
        this.IDAcademy = IDAcademy;
    }

    public int getIDTeacher() {
        return IDTeacher;
    }

    public void setIDTeacher(int IDTeacher) {
        this.IDTeacher = IDTeacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getIDAcademy() {
        return IDAcademy;
    }

    public void setIDAcademy(int IDAcademy) {
        this.IDAcademy = IDAcademy;
    }
    
}
