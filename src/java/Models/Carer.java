/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 * Clase que abstrae las propiedades de una carrera
 * @author Mauricio Andres Flores Perez
 */
public class Carer {
    private int IDCarer;
    private String name;

    public Carer() { }
    
    public Carer(int IDCarer, String name) {
        this.IDCarer = IDCarer;
        this.name = name;
    }

    public int getIDCarer() {
        return IDCarer;
    }

    public void setIDCarer(int IDCarer) {
        this.IDCarer = IDCarer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
       
}
