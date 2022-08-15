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
public class TipoAutoDao extends AdaptadorDao<TipoVehiculo> {
    private TipoVehiculo tipoVehiculo;

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo persona) {
        this.tipoVehiculo = persona;
    }

    public TipoAutoDao() {
        super(TipoVehiculo.class);
    }
    
    public void guardar() throws Exception{
        super.guardar(tipoVehiculo);
    }
    
    public void modificar() throws Exception{
        super.modificar(tipoVehiculo);
    }
    
    public ListaEnlazada<TipoVehiculo> listar(){
        return super.listar();
    }
    
    public TipoVehiculo obtener (String id) throws Exception{
        return super.obtener(id);
    }

    public static void main(String[] args) throws Exception {
    }
}
