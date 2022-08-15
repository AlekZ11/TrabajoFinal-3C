/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import modelo.Ciudad;

/**
 *
 * @author Usuario iTC
 */
public class CiudadDao extends AdaptadorDao<Ciudad>{
    
    private Ciudad ciudad;
    
    public CiudadDao() {
        super(Ciudad.class);
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void guardar() throws Exception{
        super.guardar(ciudad);
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    
    
}
