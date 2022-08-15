/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import modelo.Provincia;

/**
 *
 * @author Usuario iTC
 */
public class ProvinciaDao extends AdaptadorDao<Provincia>{
    
    private Provincia provincia;
    
    public ProvinciaDao() {
        super(Provincia.class);
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void guardar() throws Exception{
        super.guardar(provincia);
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
    
}
