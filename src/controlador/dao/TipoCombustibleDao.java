/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.tda.lista.ListaEnlazada;
import modelo.TipoCombustible;

/**
 *
 * @author Usuario iTC
 */
public class TipoCombustibleDao extends AdaptadorDao<TipoCombustible> {
    private TipoCombustible tipoCombustible;

    public TipoCombustible getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(TipoCombustible persona) {
        this.tipoCombustible = persona;
    }

    public TipoCombustibleDao() {
        super(TipoCombustible.class);
    }
    
    public void guardar() throws Exception{
        super.guardar(tipoCombustible);
    }
    
    public void modificar() throws Exception{
        super.modificar(tipoCombustible);
    }
    
    public ListaEnlazada<TipoCombustible> listar(){
        return super.listar();
    }
    
    public TipoCombustible obtener (String id) throws Exception{
        return super.obtener(id);
    }

    public static void main(String[] args) throws Exception {
    }
}
