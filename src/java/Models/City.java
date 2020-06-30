/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 * Clase que abstrae las propiedades de un municipio
 * @author Mauricio Andres FLores Perez
 */
public class City {
    private int IDCity;
    private String city;
    
    public City() { }

    public City(int IDCity) {
        this.IDCity = IDCity;
    }

    public int getIDCity() {
        return IDCity;
    }

    public void setIDCity(int IDCity) {
        this.IDCity = IDCity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
}
