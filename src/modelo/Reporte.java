package modelo;

import java.util.Date;

public class Reporte {
    private Integer ID_Reporte;
    private Integer ID_Vehiculo;
    private boolean estado;
    private Date fecha;
    private String observacion;

    public Reporte(){   }

    public Reporte(Integer id, Integer id_vehiculo, boolean estado, String observacion){
        this.ID_Reporte = id;
        this.ID_Vehiculo = id_vehiculo;
        this.estado = estado;
        //Asignar la fecha actual
        this.fecha = new Date();
        this.observacion = observacion;
    }

    public Integer getID_Reporte() {
        return ID_Reporte;
    }

    public void setID_Reporte(Integer ID_Reporte) {
        this.ID_Reporte = ID_Reporte;
    }

    public Integer getID_Vehiculo() {
        return ID_Vehiculo;
    }

    public void setID_Vehiculo(Integer ID_Vehiculo) {
        this.ID_Vehiculo = ID_Vehiculo;
    }

    public String getEstado() {
        return (estado)?"Aprovado":"Reprobado";
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public String toString(){
        return "Reporte: " + this.ID_Reporte
                + "\n - Cliente: " + 1/*ControladorCliente.getCliente(ControladorVehiculo.getVehiculo(ID_Vehiculo).getCliente).getNombre()*/
                + "\n - Vehiculo: " + this.ID_Vehiculo
                + "\n - Estado: " + this.estado
                + "\n - Fecha: " + this.fecha
                + "\n - Observacion: " + this.observacion;
    }
}
