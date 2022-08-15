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
public class Ciudad {
    private Integer ID_Ciudad;
    private String Nombre;
    private Integer ID_Provincia;
    private Date Created_At;
    
    public Ciudad(){}

    public Ciudad(String Nombre, Integer ID_Provincia) {
        this.Nombre = Nombre;
        this.ID_Provincia = ID_Provincia;
    }

    public Integer getID_Ciudad() {
        return ID_Ciudad;
    }

    public void setID_Ciudad(Integer ID) {
        this.ID_Ciudad = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Integer getID_Provincia() {
        return ID_Provincia;
    }

    public void setID_Provincia(Integer ID_Provincia) {
        this.ID_Provincia = ID_Provincia;
    }

    public Date getCreated_At() {
        return Created_At;
    }

    public void setCreated_At(Date Created_At) {
        this.Created_At = Created_At;
    }

    @Override
    public String toString() {
        return "Ciudad{" + "id=" + ID_Ciudad + ", Nombre=" + Nombre + ", ID_Provincia=" + ID_Provincia + ", Created_At=" + Created_At + '}';
    }
    
}
