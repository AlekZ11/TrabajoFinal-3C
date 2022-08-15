/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.tda.lista.ListaEnlazada;
import modelo.TipoVehiculo;

/**
 *
 * @author Usuario iTC
 */
public class TipoVehiculoDao extends AdaptadorDao<TipoVehiculo> {
    private TipoVehiculo tipoVehiculo;

    /**
     * @return the tipoVehiculo
     */
    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    /**
     * @param tipoVehiculo the tipoVehiculo to set
     */
    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public TipoVehiculoDao() {
        super(TipoVehiculo.class);
    }
    
    public void guardar() throws Exception{
        super.guardar(tipoVehiculo);
    }
    
    public void modificar() throws Exception{
        super.modificar(tipoVehiculo);
    }
    
    @Override
    public ListaEnlazada<TipoVehiculo> listar(){
        return super.listar();
    }
    
    @Override
    public TipoVehiculo obtener (String id) throws Exception{
        return super.obtener(id);
    }

    public static void main(String[] args) throws Exception {
    }
    
    
}
