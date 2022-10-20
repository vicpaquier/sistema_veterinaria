/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;


public class DetallesFacturacion {

    private int iddetallefacturacion;
    private Servicios servicio;
    private Facturacion facturacion;
    private int cantidad_detallefacturacion;

    public DetallesFacturacion() {
    }

    public DetallesFacturacion(int iddetallefacturacion, Servicios servicio, Facturacion facturacion, int cantidad_detallefacturacion) {
        this.iddetallefacturacion = iddetallefacturacion;
        this.servicio = servicio;
        this.facturacion = facturacion;
        this.cantidad_detallefacturacion = cantidad_detallefacturacion;
    }

    public int getIddetallefacturacion() {
        return iddetallefacturacion;
    }

    public void setIddetallefacturacion(int iddetallefacturacion) {
        this.iddetallefacturacion = iddetallefacturacion;
    }

    public Servicios getServicio() {
        return servicio;
    }

    public void setServicio(Servicios servicio) {
        this.servicio = servicio;
    }

    public Facturacion getFacturacion() {
        return facturacion;
    }

    public void setFacturacion(Facturacion facturacion) {
        this.facturacion = facturacion;
    }

    public int getCantidad_detallefacturacion() {
        return cantidad_detallefacturacion;
    }

    public void setCantidad_detallefacturacion(int cantidad_detallefacturacion) {
        this.cantidad_detallefacturacion = cantidad_detallefacturacion;
    }
    
    
}

