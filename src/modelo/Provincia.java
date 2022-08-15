/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author LENOVO LEGION 5
 */
public class Provincia {
    private Integer ID_Provincia;
    private String Nombre;
    
    public Provincia(){}

    public Provincia( String Nombre) {
        this.Nombre = Nombre;
    }

    public Integer getID_Provincia() {
        return ID_Provincia;
    }

    public void setID_Provincia(Integer ID_Provincia) {
        this.ID_Provincia = ID_Provincia;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public String toString() {
        return "Provincia{" + "id=" + ID_Provincia + ", Nombre=" + Nombre + '}';
    }  
}
