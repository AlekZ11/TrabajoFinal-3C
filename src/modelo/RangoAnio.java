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
public class RangoAnio {
    private Integer ID_RangoAnio;
    private Integer anioMin;
    private Integer anioMax;
    private Date created_At;
    private Date updated_At;

    public RangoAnio( Integer anioMin, Integer anioMax) {
        this.anioMin = anioMin;
        this.anioMax = anioMax;
    }

    public RangoAnio() {    }

    public Integer getID_RangoAnio() {
        return ID_RangoAnio;
    }

    public void setID_RangoAnio(Integer ID_RangoAnio) {
        this.ID_RangoAnio = ID_RangoAnio;
    }

    public Integer getAnioMin() {
        return anioMin;
    }

    public void setAnioMin(Integer anioMin) {
        this.anioMin = anioMin;
    }

    public Integer getAnioMax() {
        return anioMax;
    }

    public void setAnioMax(Integer anioMax) {
        this.anioMax = anioMax;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

    public Date getUpdated_At() {
        return updated_At;
    }

    public void setUpdated_At(Date updated_At) {
        this.updated_At = updated_At;
    }
    
    
}
