package modelo;

import java.sql.Date;


public class Automovil {
    private String placa;
    
    private Integer anio;
    private Integer ID_Vehiculo;
    private Integer ID_Cliente;
    private Date created_At;
    private Date updated_At;

    public Automovil(){   }

    public Automovil(String placa, Integer anio, Integer ID_Vehiculo, Integer Id_cliente) {
        this.placa = placa;
        this.anio = anio;
        this.ID_Vehiculo = ID_Vehiculo;
        this.ID_Cliente = Id_cliente;
    }
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getID_Vehiculo() {
        return ID_Vehiculo;
    }

    public void setID_Vehiculo(Integer ID_Vehiculo) {
        this.ID_Vehiculo = ID_Vehiculo;
    }

    public Integer getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(Integer ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
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
