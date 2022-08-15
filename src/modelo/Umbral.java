package modelo;

import java.util.Date;


public class Umbral {
    private Integer ID_Umbral;
    private String descripcion;
    private String categoria;
    private Integer ID_RangoAnio;
    private String tipo;
    private Double valorMin;
    private Double valorMax;
    private Integer clave_Umbral;
    private Date Created_At;
    private Date Updated_At;

    public Umbral(){   }

    public Umbral(Integer ID_Umbral, String descripcion, String categoria, Integer ID_RangoAnio, String tipo, Double valorMin, Double valorMax, Integer clave_Umbral) {
        this.ID_Umbral = ID_Umbral;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.ID_RangoAnio = ID_RangoAnio;
        this.tipo = tipo;
        this.valorMin = valorMin;
        this.valorMax = valorMax;
        this.clave_Umbral = clave_Umbral;
    }

    public Integer getID_Umbral() {
        return ID_Umbral;
    }

    public void setID_Umbral(Integer ID_Umbral) {
        this.ID_Umbral = ID_Umbral;
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getID_RangoAnio() {
        return ID_RangoAnio;
    }

    public void setID_RangoAnio(Integer ID_RangoAnio) {
        this.ID_RangoAnio = ID_RangoAnio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValorMin() {
        return valorMin;
    }

    public void setValorMin(Double valorMin) {
        this.valorMin = valorMin;
    }

    public Double getValorMax() {
        return valorMax;
    }

    public void setValorMax(Double valorMax) {
        this.valorMax = valorMax;
    }

    public Integer getClave_Umbral() {
        return clave_Umbral;
    }

    public void setClave_Umbral(Integer clave_Umbral) {
        this.clave_Umbral = clave_Umbral;
    }

    public Date getCreated_At() {
        return Created_At;
    }

    public void setCreated_At(Date Created_At) {
        this.Created_At = Created_At;
    }

    public Date getUpdated_At() {
        return Updated_At;
    }

    public void setUpdated_At(Date Updated_At) {
        this.Updated_At = Updated_At;
    }
    
    

    
}
