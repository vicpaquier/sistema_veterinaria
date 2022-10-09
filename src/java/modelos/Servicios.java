package modelos;

/**
 *
 * @author Administrador
 */
public class Servicios {
    private int idservicio;
    private String descripcion_servicio;
    private int precio_servicio;
    private String iva_servicio;

    public Servicios() {
    }

    public Servicios(int idservicio, String descripcion_servicio, int precio_servicio, String iva_servicio) {
        this.idservicio = idservicio;
        this.descripcion_servicio = descripcion_servicio;
        this.precio_servicio = precio_servicio;
        this.iva_servicio = iva_servicio;
    }

    public int getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(int idservicio) {
        this.idservicio = idservicio;
    }

    public String getDescripcion_servicio() {
        return descripcion_servicio;
    }

    public void setDescripcion_servicio(String descripcion_servicio) {
        this.descripcion_servicio = descripcion_servicio;
    }

    public int getPrecio_servicio() {
        return precio_servicio;
    }

    public void setPrecio_servicio(int precio_servicio) {
        this.precio_servicio = precio_servicio;
    }

    public String getIva_servicio() {
        return iva_servicio;
    }

    public void setIva_servicio(String iva_servicio) {
        this.iva_servicio = iva_servicio;
    }


}
