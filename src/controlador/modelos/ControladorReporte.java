/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.modelos;

import controlador.dao.AutomovilDao;
import controlador.dao.CiudadDao;
import controlador.dao.ClienteDao;
import controlador.dao.MarcaDao;
import controlador.dao.ProvinciaDao;
import controlador.dao.TipoCombustibleDao;
import controlador.dao.TipoVehiculoDao;
import controlador.dao.UbicacionDao;
import controlador.dao.VehiculoDao;
import controlador.tda.lista.ListaEnlazada;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Automovil;
import modelo.Ciudad;
import modelo.Cliente;
import modelo.Marca;
import modelo.Provincia;
import modelo.Reporte;
import modelo.TipoCombustible;
import modelo.TipoVehiculo;
import modelo.Ubicacion;
import modelo.Vehiculo;

/**
 *
 * @author LENOVO LEGION 5
 */
public class ControladorReporte {

    private Cliente c;
    private Automovil a;
    private Vehiculo v;
    private Marca m;
    private Ubicacion l;
    private Ciudad cd;
    private Provincia p;
    private TipoVehiculo t_v;
    private TipoCombustible t_c;
    private String estado;
    private ListaEnlazada<String> resultados;
    
    ListaEnlazada<Reporte> reporte;

    public ControladorReporte(Cliente c, Automovil a, ListaEnlazada<String> resultados) throws Exception {
        this.c = c;
        this.a = a;
        this.v = ObtenerVehiculo();
        this.m = ObtenerMarca();
        this.l = ObtenerUbicacion();
        this.cd = ObtenerCiudad();
        this.p = ObtenerProvincia();
        //this.t_c = obtenerTipocombustible();
        //this.t_v = obtenerTipoVehiculo();

        this.resultados = resultados;
    }
    
    public ControladorReporte(Boolean estado, String Placa, ListaEnlazada<String> resultados) throws Exception {
        
        this.a = ObtenerAutomovil(Placa);
        this.c = ObtenerCliente();
        this.v = ObtenerVehiculo();
        this.m = ObtenerMarca();
        this.l = ObtenerUbicacion();
        this.cd = ObtenerCiudad();
        this.p = ObtenerProvincia();
        this.t_c = ObtenerTipocombustible();
        this.t_v = ObtenerTipoVehiculo();
        this.estado = obtenerEstado(estado);

        this.resultados = resultados;
    }

    public ControladorReporte() {

    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    

    /**
     * @return the c
     */
    public Cliente getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(Cliente c) {
        this.c = c;
    }

    /**
     * @return the a
     */
    public Automovil getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(Automovil a) {
        this.a = a;
    }

    /**
     * @return the v
     */
    public Vehiculo getV() {
        return v;
    }

    /**
     * @param v the v to set
     */
    public void setV(Vehiculo v) {
        this.v = v;
    }

    /**
     * @return the resultados
     */
    public ListaEnlazada<String> getResultados() {
        return resultados;
    }

    /**
     * @param resultados the resultados to set
     */
    public void setResultados(ListaEnlazada<String> resultados) {
        this.resultados = resultados;
    }

    /**
     * @return the m
     */
    public Marca getM() {
        return m;
    }

    /**
     * @param m the m to set
     */
    public void setM(Marca m) {
        this.m = m;
    }

    /**
     * @return the l
     */
    public Ubicacion getL() {
        return l;
    }

    /**
     * @param l the l to set
     */
    public void setL(Ubicacion l) {
        this.l = l;
    }

    /**
     * @return the cd
     */
    public Ciudad getCd() {
        return cd;
    }

    /**
     * @param cd the cd to set
     */
    public void setCd(Ciudad cd) {
        this.cd = cd;
    }

    /**
     * @return the p
     */
    public Provincia getP() {
        return p;
    }

    /**
     * @param p the p to set
     */
    public void setP(Provincia p) {
        this.p = p;
    }

    /**
     * @return the t_v
     */
    public TipoVehiculo getT_v() {
        return t_v;
    }

    /**
     * @param t_v the t_v to set
     */
    public void setT_v(TipoVehiculo t_v) {
        this.t_v = t_v;
    }

    /**
     * @return the t_c
     */
    public TipoCombustible getT_c() {
        return t_c;
    }

    /**
     * @param t_c the t_c to set
     */
    public void setT_c(TipoCombustible t_c) {
        this.t_c = t_c;
    }
    
    
    private Vehiculo ObtenerVehiculo() throws Exception {
        VehiculoDao vehiculo = new VehiculoDao();
        //ListaEnlazada<Vehiculo> vehiculos = vehiculo.listar();
        //vehiculos = vehiculos.buscar("ID_Vehiculo", a.getID_Vehiculo());
        System.out.println("\nVehiculo " + vehiculo.obtener(a.getID_Vehiculo() + "").getModelo() + "\n");
        
        return vehiculo.obtener(a.getID_Vehiculo() + "");
        
        //return vehiculos.obtenerDato(0);
    }

    private Marca ObtenerMarca() throws Exception {
        MarcaDao marca = new MarcaDao();
        //ListaEnlazada<Marca> marcas = marca.listar();
        //marcas = marcas.buscar("ID_Marca", v.getID_Marca());
        System.out.println("\nMarca " + marca.obtener(v.getID_Marca() + "").getNombre() + "\n");
        
        return marca.obtener(v.getID_Marca() + "");
        
        //return marcas.obtenerDato(0);
    }

    private Ubicacion ObtenerUbicacion() throws Exception {
        UbicacionDao ubicacion = new UbicacionDao();
        //ListaEnlazada<Ubicacion> ubicaciones = ubicacion.listar();
        //ubicaciones = ubicaciones.buscar("ID_Ubicacion", c.getID_Ubicacion());
        System.out.println("\nUbicacion " + ubicacion.obtener(c.getID_Ubicacion() + "").getDireccion() + "\n");
        
        return ubicacion.obtener(c.getID_Ubicacion() + "");
        
        //return ubicaciones.obtenerDato(0);
    }

    private Ciudad ObtenerCiudad() throws Exception {
        CiudadDao ciudad = new CiudadDao();
        //ListaEnlazada<Ciudad> ciudades = ciudad.listar();
        //ciudades = ciudades.buscar("ID_Ciudad", l.getID_Ciudad());
        System.out.println("\nCiudad " + ciudad.obtener(l.getID_Ciudad() + "").getNombre() + "\n");
        
        return ciudad.obtener(l.getID_Ciudad() + "");
        
        //return ciudades.obtenerDato(0);
    }

    private Provincia ObtenerProvincia() throws Exception {
        ProvinciaDao provincia = new ProvinciaDao();
        //ListaEnlazada<Provincia> provincias = provincia.listar();
        //provincias = provincias.buscar("ID_Provincia", cd.getID_Provincia());
        System.out.println("\nProvincia " + provincia.obtener(cd.getID_Provincia() + "").getNombre() + "\n");
        
        return provincia.obtener(cd.getID_Provincia() + "");
        
        //return provincias.obtenerDato(0);
    }
    
    private TipoCombustible ObtenerTipocombustible() throws Exception{
        TipoCombustibleDao tipocombustible = new TipoCombustibleDao();
        //System.out.println("\nCombustible " + tipocombustible.obtener(v.getID_TipoCombustible()).getTipo() + "\n");
        System.out.println("\nCombustible " + tipocombustible.obtener("Gasolina").getID_TIPOCOMBUSTIBLE() + "\n");
        
        //return tipocombustible.obtener("Gasolina");
        return tipocombustible.obtener(v.getID_TipoCombustible());
    }
    
    private TipoVehiculo ObtenerTipoVehiculo() throws Exception{
        TipoVehiculoDao tipovehiculo = new TipoVehiculoDao();
        //System.out.println("\nTipo Vehiculo " + tipovehiculo.obtener(v.getID_TipoVehiculo()).getTipo() + "\n");
        System.out.println("\nTipo Vehiculo " + tipovehiculo.obtener("Coupe").getID_TIPOVEHICULO() + "\n");
        
        //return tipovehiculo.obtener("Coupe");
        return tipovehiculo.obtener(v.getID_TipoVehiculo());
    }
    
    private Automovil ObtenerAutomovil(String Placa) throws Exception{
        AutomovilDao auto = new AutomovilDao();
        System.out.println("AUTO" + auto.obtener("GLS1960").getAnio());
        System.out.println("\nAUTO " + auto.obtener("GLS1960").getPlaca() + "\n");
        return auto.obtener(Placa);
    }
    
    private Cliente ObtenerCliente() throws Exception{
        ClienteDao cliente = new ClienteDao();
        System.out.println("\nCliente " + cliente.obtener(a.getID_Cliente() + "").getNombre() + "\n");
        
        return cliente.obtener(a.getID_Cliente() + "");
    }
    
    public static String obtenerEstado(Boolean estado){
        if (estado) {
            return "APROBADO";
        } else{
            return "REPROBADO";
        }
    }
}
