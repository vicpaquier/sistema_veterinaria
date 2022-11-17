
package modelos;

/**
 *
 * @author LENOVO
 */
public class DetallesCobros {
    private int iddetalle_cobro;
    private int total_factura;
    private String metodo_pago;
    private Cobros cobro;
    private DetallesFacturacion detallesfacturacion;
    private Facturacion facturacion;

    public DetallesCobros() {
    }

    public DetallesCobros(int iddetalle_cobro, int total_factura, String metodo_pago, Cobros cobro, DetallesFacturacion detallesfacturacion, Facturacion facturacion) {
        this.iddetalle_cobro = iddetalle_cobro;
        this.total_factura = total_factura;
        this.metodo_pago = metodo_pago;
        this.cobro = cobro;
        this.detallesfacturacion = detallesfacturacion;
        this.facturacion = facturacion;
    }

    public int getIddetalle_cobro() {
        return iddetalle_cobro;
    }

    public void setIddetalle_cobro(int iddetalle_cobro) {
        this.iddetalle_cobro = iddetalle_cobro;
    }

    public int getTotal_factura() {
        return total_factura;
    }

    public void setTotal_factura(int total_factura) {
        this.total_factura = total_factura;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public Cobros getCobro() {
        return cobro;
    }

    public void setCobro(Cobros cobro) {
        this.cobro = cobro;
    }

    public DetallesFacturacion getDetallesfacturacion() {
        return detallesfacturacion;
    }

    public void setDetallesfacturacion(DetallesFacturacion detallesfacturacion) {
        this.detallesfacturacion = detallesfacturacion;
    }

    public Facturacion getFacturacion() {
        return facturacion;
    }

    public void setFacturacion(Facturacion facturacion) {
        this.facturacion = facturacion;
    }

    

 
}
