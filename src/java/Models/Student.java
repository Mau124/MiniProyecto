/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 * Clase que abstrae las propiedades de un estudiante
 * @author Mauricio Andres Flores Pérez
 */
public class Student {
    private String register;
    private String name, lastName;
    private int IDCity;
    private int IDCarer;
    
    public Student() { }

    public Student(String register, String name, String lastName, int IDCity, int IDCarer) {
        this.register = register;
        this.name = name;
        this.lastName = lastName;
        this.IDCity = IDCity;
        this.IDCarer = IDCarer;
    }
    
    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
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

    public int getIDCity() {
        return IDCity;
    }

    public void setIDCity(int IDCity) {
        this.IDCity = IDCity;
    }

    public int getIDCarer() {
        return IDCarer;
    }

    public void setIDCarer(int IDCarer) {
        this.IDCarer = IDCarer;
    }
    
}
