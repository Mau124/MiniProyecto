/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 * Clase que abstrae las propiedades de una asignatura
 * @author Mauricio Andres FLores Perez
 */
public class Subject {
    private int IDSubject;
    private String name;
    private int IDAcademy;
    
    public Subject() { }

    public Subject(int IDSubject, String name, int IDAcademy) {
        this.IDSubject = IDSubject;
        this.name = name;
        this.IDAcademy = IDAcademy;
    }

    public int getIDSubject() {
        return IDSubject;
    }

    public void setIDSubject(int IDSubject) {
        this.IDSubject = IDSubject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIDAcademy() {
        return IDAcademy;
    }

    public void setIDAcademy(int IDAcademy) {
        this.IDAcademy = IDAcademy;
    }
    
}
