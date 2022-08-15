/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.tda.lista.ListaEnlazada;
import modelo.Automovil;

/**
 *
 * @author Usuario iTC
 */
public class AutomovilDao extends AdaptadorDao<Automovil> {
    private Automovil automovil;

    public Automovil getAutomovil() {
        return automovil;
    }

    public void setAutomovil(Automovil automovil) {
        this.automovil = automovil;
    }

    public AutomovilDao() {
        super(Automovil.class);
    }
    
    public void guardar() throws Exception{
        super.guardar(automovil);
    }
    
    public void modificar() throws Exception{
        super.modificar(automovil);
    }
    
    public ListaEnlazada<Automovil> listar(){
        return super.listar();
    }
    
    public Automovil obtener (String id) throws Exception{
        return super.obtener(id);
    }

    public static void main(String[] args) throws Exception {
    }
}
