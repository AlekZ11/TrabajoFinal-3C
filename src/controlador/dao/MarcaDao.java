/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.tda.lista.ListaEnlazada;
import modelo.Marca;

/**
 *
 * @author Usuario iTC
 */
public class MarcaDao extends AdaptadorDao<Marca> {
    private Marca marca;

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public MarcaDao() {
        super(Marca.class);
    }
    
    public void guardar() throws Exception{
        super.guardar(marca);
        System.out.println("Marca Guardada");
    }
    
    public void modificar() throws Exception{
        super.modificar(marca);
    }
    
    @Override
    public Marca obtener (String id) throws Exception{
        return super.obtener(id);
    }

    public static void main(String[] args) throws Exception {
    }
}
