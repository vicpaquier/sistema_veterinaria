
package modelos;

//import java.sql.Date;

public class Facturacion {

    private int id_facturacion;
    private String fecha_facturacion;
    private String estado_facturacion;
    private String numero_facturacion;;
    private String condicion_facturacion;
    private Clientes cliente;
    private Usuarios usuario;

    public Facturacion() {
    }

    public Facturacion(int id_facturacion, String fecha_facturacion, String estado_facturacion, String numero_facturacion, String condicion_facturacion, Clientes cliente, Usuarios usuario) {
        this.id_facturacion = id_facturacion;
        this.fecha_facturacion = fecha_facturacion;
        this.estado_facturacion = estado_facturacion;
        this.numero_facturacion = numero_facturacion;
        this.condicion_facturacion = condicion_facturacion;
        this.cliente = cliente;
        this.usuario = usuario;
    }

    public int getId_facturacion() {
        return id_facturacion;
    }

    public void setId_facturacion(int id_facturacion) {
        this.id_facturacion = id_facturacion;
    }

    public String getFecha_facturacion() {
        return fecha_facturacion;
    }

    public void setFecha_facturacion(String fecha_facturacion) {
        this.fecha_facturacion = fecha_facturacion;
    }

    public String getEstado_facturacion() {
        return estado_facturacion;
    }

    public void setEstado_facturacion(String estado_facturacion) {
        this.estado_facturacion = estado_facturacion;
    }

    public String getNumero_facturacion() {
        return numero_facturacion;
    }

    public void setNumero_facturacion(String numero_facturacion) {
        this.numero_facturacion = numero_facturacion;
    }

    public String getCondicion_facturacion() {
        return condicion_facturacion;
    }

    public void setCondicion_facturacion(String condicion_facturacion) {
        this.condicion_facturacion = condicion_facturacion;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    
}
