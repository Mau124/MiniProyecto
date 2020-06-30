/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 * Clase que abstrae las propiedades de una academia
 * @author Mauricio Andres FLores Perez
 */
public class Academy {
    private int IDAcademy;
    private String name;
    private int IDCarer;
    
    public Academy() { }

    public Academy(int IDAcademy, String name, int IDCarer) {
        this.IDAcademy = IDAcademy;
        this.name = name;
        this.IDCarer = IDCarer;
    }

    public int getIDAcademy() {
        return IDAcademy;
    }

    public void setIDAcademy(int IDAcademy) {
        this.IDAcademy = IDAcademy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIDCarer() {
        return IDCarer;
    }

    public void setIDCarer(int IDCarer) {
        this.IDCarer = IDCarer;
    }
    
}
