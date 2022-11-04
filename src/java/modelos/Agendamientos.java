
package modelos;

public class Agendamientos {
    private int idagendamiento;
    private String fecha_agendamiento;
    private Empleados empleados;
    private Clientes clientes;

    public Agendamientos() {
    }

    public Agendamientos(int idagendamiento, String fecha_agendamiento, Empleados empleados, Clientes clientes) {
        this.idagendamiento = idagendamiento;
        this.fecha_agendamiento = fecha_agendamiento;
        this.empleados = empleados;
        this.clientes = clientes;
    }

    public int getIdagendamiento() {
        return idagendamiento;
    }

    public void setIdagendamiento(int idagendamiento) {
        this.idagendamiento = idagendamiento;
    }

    public String getFecha_agendamiento() {
        return fecha_agendamiento;
    }

    public void setFecha_agendamiento(String fecha_agendamiento) {
        this.fecha_agendamiento = fecha_agendamiento;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    
    
}
