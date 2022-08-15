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
public class TipoVehiculo {
    private String ID_TIPOVEHICULO;
    private Date created_At;

    public TipoVehiculo() {
    }

    public TipoVehiculo(String tipo) {
        this.ID_TIPOVEHICULO = tipo;
    }

    public String getID_TIPOVEHICULO() {
        return ID_TIPOVEHICULO;
    }

    public void setID_TIPOVEHICULO(String ID_TIPOVEHICULO) {
        this.ID_TIPOVEHICULO = ID_TIPOVEHICULO;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }
    
}
