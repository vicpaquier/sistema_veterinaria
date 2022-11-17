
package modelos;

/**
 *
 * @author LENOVO
 */
public class Cobros {
    private int idcobro;
    private Usuarios usuarios;
    private String fecha_cobro;

    public Cobros() {
    }

    public Cobros(int idcobro, Usuarios usuarios, String fecha_cobro) {
        this.idcobro = idcobro;
        this.usuarios = usuarios;
        this.fecha_cobro = fecha_cobro;
    }

    public int getIdcobro() {
        return idcobro;
    }

    public void setIdcobro(int idcobro) {
        this.idcobro = idcobro;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public String getFecha_cobro() {
        return fecha_cobro;
    }

    public void setFecha_cobro(String fecha_cobro) {
        this.fecha_cobro = fecha_cobro;
    }

    
    
}
