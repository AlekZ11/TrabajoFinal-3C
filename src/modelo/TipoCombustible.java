package modelo;

import java.sql.Date;

public class TipoCombustible {
    private String ID_TIPOCOMBUSTIBLE;
    private Date created_At;

    public TipoCombustible() {
    }

    public TipoCombustible( String tipo) {
        this.ID_TIPOCOMBUSTIBLE = tipo;
    }

    public String getID_TIPOCOMBUSTIBLE() {
        return ID_TIPOCOMBUSTIBLE;
    }

    public void setID_TIPOCOMBUSTIBLE(String ID_TIPOCOMBUSTIBLE) {
        this.ID_TIPOCOMBUSTIBLE = ID_TIPOCOMBUSTIBLE;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }
    
    
    
}
