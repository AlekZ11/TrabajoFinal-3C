/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author LENOVO LEGION 5
 */
public class Marca {
    private Integer ID_Marca;
    
    private String nombre;
    private Date created_At;

    public Marca(){}
    
    public Marca( String marca) {
        this.nombre = marca;
    }

    public Integer getID_Marca() {
        return ID_Marca;
    }
    
    public void setID_Marca(Integer ID_Marca){
        this.ID_Marca = ID_Marca;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }
    
    

    @Override
    public String toString() {
        return "Marca{"+"ID="+ID_Marca+", marca="+nombre+", Created_At="+created_At+"}";
    }
    
    
}
