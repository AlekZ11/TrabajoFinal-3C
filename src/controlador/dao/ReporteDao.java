/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import modelo.Reporte;

/**
 *
 * @author Usuario iTC
 */
public class ReporteDao extends AdaptadorDao<Reporte> {

    private Reporte reporte;
    
    public ReporteDao() {
        super(Reporte.class);
    }

    /**
     * @return the reporte
     */
    public Reporte getReporte() {
        return reporte;
    }

    /**
     * @param reporte the reporte to set
     */
    public void setReporte(Reporte reporte) {
        this.reporte = reporte;
    }

}
