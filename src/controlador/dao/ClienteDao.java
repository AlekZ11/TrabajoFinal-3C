/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import modelo.Cliente;

/**
 *
 * @author Usuario iTC
 */
public class ClienteDao extends AdaptadorDao<Cliente>{
    private Cliente cliente;

    public ClienteDao() {
        super(Cliente.class);
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    public void guardar() throws Exception{
        super.guardar(cliente);
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
}
