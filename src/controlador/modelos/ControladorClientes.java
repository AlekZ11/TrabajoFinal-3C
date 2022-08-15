package controlador.modelos;

import com.google.gson.Gson;
import controlador.dao.CiudadDao;
import controlador.dao.ClienteDao;
import controlador.dao.ProvinciaDao;
import controlador.dao.UbicacionDao;
import controlador.tda.lista.ListaEnlazada;
import modelo.Ciudad;
import modelo.Cliente;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import modelo.Provincia;
import modelo.Ubicacion;

public class ControladorClientes {

    private ListaEnlazada<Cliente> listaClientes;
    private ClienteDao cldao;
    private UbicacionDao udao;
    private CiudadDao cidao;
    private ProvinciaDao pdao;

    public ControladorClientes() {
        listaClientes = new ListaEnlazada<>();
        cldao = new ClienteDao();
        udao = new UbicacionDao();
        cidao = new CiudadDao();
        pdao = new ProvinciaDao();
    }

    public ClienteDao getCldao() {
        return cldao;
    }

    public UbicacionDao getUdao() {
        return udao;
    }

    public CiudadDao getCidao() {
        return cidao;
    }

    public ProvinciaDao getPdao() {
        return pdao;
    }

    public Cliente obtenerCliente(Integer id_cliente) throws Exception {
        for (int i = 0; i < listaClientes.getSize(); i++) {
            Cliente cliente = listaClientes.obtenerDato(i);
            if (cliente.getID_Cliente().equals(id_cliente)) {
                return cliente;
            }
        }
        return null;
    }

    public ListaEnlazada<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ListaEnlazada<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public Integer getSize() {
        return listaClientes.getSize();
    }

    public void cargarClientes() {
        listaClientes = cldao.listar();
    }

    public Integer existeProvincia(String provincia) throws Exception {
        ListaEnlazada<Provincia> listaProvincia = pdao.listar();
        ListaEnlazada<Provincia> resultado = listaProvincia.buscar("nombre", provincia);
        if (resultado.getSize() > 0) {
            return resultado.obtenerDato(0).getID_Provincia();
        }
        pdao.setProvincia(new Provincia(provincia));
        pdao.guardar();
        return pdao.getCurrentValue();
    }

    public Integer existeCiudad(String ciudad, String provincia) throws Exception {
        ListaEnlazada<Ciudad> listaCiudad = cidao.listar();
        ListaEnlazada<Ciudad> resultado1 = listaCiudad.buscar("nombre", ciudad);
        Integer id_provincia = existeProvincia(provincia);
        ListaEnlazada<Ciudad> resultado2 = resultado1.buscar("ID_Provincia", id_provincia);
        if (resultado2.getSize() > 0) {
            return resultado2.obtenerDato(0).getID_Ciudad();
        }
        cidao.setCiudad(new Ciudad(ciudad, id_provincia));
        cidao.guardar();
        return cidao.getCurrentValue();
    }

    public Integer existeCliente(String nombre, String apellido, String identificacion, String direccion, String ciudad, String provincia) throws Exception {
        ListaEnlazada<Cliente> listaCliente = cldao.listar();
        ListaEnlazada<Cliente> resultado = listaCliente.buscar("identificacion", identificacion);
        Integer id_Ubicacion = existeUbicacion(direccion, ciudad, provincia);
        if (resultado.getSize() > 0) {
            return resultado.obtenerDato(0).getID_Cliente();
        }
        cldao.setCliente(new Cliente(nombre, apellido, identificacion, id_Ubicacion));
        cldao.guardar();
        return cldao.getCurrentValue();
    }

    public Integer existeUbicacion(String direccion, String ciudad, String provincia) throws Exception {
        ListaEnlazada<Ubicacion> listaUbicacion = udao.listar();
        Integer id_ciudad = existeCiudad(ciudad, provincia);
        ListaEnlazada<Ubicacion> resultado = listaUbicacion.buscar("Direccion", direccion);
        ListaEnlazada<Ubicacion> resultado2 = resultado.buscar("ID_Ciudad", id_ciudad);
        if (resultado2.getSize() > 0) {
            return resultado.obtenerDato(0).getID_Ubicacion();
        }
        udao.setUbicacion(new Ubicacion(id_ciudad, direccion));
        udao.guardar();
        return udao.getCurrentValue();
    }

    public void imprimir(Integer i) throws Exception {
        System.out.println(listaClientes.obtenerDato(i).toString());
    }
}
