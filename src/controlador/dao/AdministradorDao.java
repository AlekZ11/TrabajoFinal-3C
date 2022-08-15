/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.tda.lista.ListaEnlazada;
import modelo.Administrador;

/**
 *
 * @author Usuario iTC
 */
public class AdministradorDao extends AdaptadorDao<Administrador> {
    private Administrador administrador;

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador persona) {
        this.administrador = persona;
    }

    public AdministradorDao() {
        super(Administrador.class);
    }
    
    public void guardar() throws Exception{
        super.guardar(administrador);
    }
    
    public void modificar() throws Exception{
        super.modificar(administrador);
    }
    
    public ListaEnlazada<Administrador> listar(){
        return super.listar();
    }
    

    public static void main(String[] args) throws Exception {
        AdministradorDao adao = new AdministradorDao();
        adao.setAdministrador(new Administrador("joanr", "sysdba456"));
        adao.guardar();
    }
}
