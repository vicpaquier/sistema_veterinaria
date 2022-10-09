package modelos;

/**
 *
 * @author Administrador
 */
public class Empleados {
    private int idempleado;
    private String nombre_empleado;
    private String apellido_empleado;
    private String celular_empleado;
    private String ruc_empleado;

    public Empleados() {
    }

    public Empleados(int idempleado, String nombre_empleado, String apellido_empleado, String celular_empleado, String ruc_empleado) {
        this.idempleado = idempleado;
        this.nombre_empleado = nombre_empleado;
        this.apellido_empleado = apellido_empleado;
        this.celular_empleado = celular_empleado;
        this.ruc_empleado = ruc_empleado;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getApellido_empleado() {
        return apellido_empleado;
    }

    public void setApellido_empleado(String apellido_empleado) {
        this.apellido_empleado = apellido_empleado;
    }

    public String getCelular_empleado() {
        return celular_empleado;
    }

    public void setCelular_empleado(String celular_empleado) {
        this.celular_empleado = celular_empleado;
    }

    public String getRuc_empleado() {
        return ruc_empleado;
    }

    public void setRuc_empleado(String ruc_empleado) {
        this.ruc_empleado = ruc_empleado;
    }
}
