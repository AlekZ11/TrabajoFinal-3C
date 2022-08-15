/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador.dao;

import controlador.tda.lista.ListaEnlazada;

/**
 *
 * @author LENOVO LEGION 5
 */
public interface InterfazDao <T> {
    public void guardar(T dato) throws Exception;
    public void modificar(T dato) throws Exception;
    public ListaEnlazada<T> listar() throws Exception;
    public T obtener(String id) throws Exception;
}
