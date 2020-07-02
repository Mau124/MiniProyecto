/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 * Clase que abstrae las propiedades de una asignatura optativa
 * @author Mauricio Andres Flores Perez
 */
public class Optional {
    private int IDOptional;
    private String name;
    private int credits;
    private int IDCarer;
    
    public Optional() { }

    public Optional(int IDOptional, String name, int credits, int IDCarer) {
        this.IDOptional = IDOptional;
        this.name = name;
        this.credits = credits;
        this.IDCarer = IDCarer;
    }
    
    public Optional(String name, int credits, int IDCarer) {
        this.name = name;
        this.credits = credits;
        this.IDCarer = IDCarer;
    }

    public int getIDOptional() {
        return IDOptional;
    }

    public void setIDOptional(int IDOptional) {
        this.IDOptional = IDOptional;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getIDCarer() {
        return IDCarer;
    }

    public void setIDCarer(int IDCarer) {
        this.IDCarer = IDCarer;
    }
    
}
