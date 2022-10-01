/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private String direccion_empleado;
    private String ruc_empleado;
    private int idmascota;
    private String nombre_mascota;
    private String especie_mascota;
    private String raza_mascota;
    private String colorpelo_mascota;
    private String fechanacimiento_mascota;
    

    public Empleados() {
    }

    public Empleados(int idempleado, String nombre_empleado, String apellido_empleado, String celular_empleado, String direccion_empleado, String ruc_empleado, int idmascota, String nombre_mascota, String especie_mascota, String raza_mascota, String colorpelo_mascota, String fechanacimiento_mascota) {
        this.idempleado = idempleado;
        this.nombre_empleado = nombre_empleado;
        this.apellido_empleado = apellido_empleado;
        this.celular_empleado = celular_empleado;
        this.direccion_empleado = direccion_empleado;
        this.ruc_empleado = ruc_empleado;
        this.idmascota = idmascota;
        this.nombre_mascota = nombre_mascota;
        this.especie_mascota = especie_mascota;
        this.raza_mascota = raza_mascota;
        this.colorpelo_mascota = colorpelo_mascota;
        this.fechanacimiento_mascota = fechanacimiento_mascota;
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

    public String getDireccion_empleado() {
        return direccion_empleado;
    }

    public void setDireccion_empleado(String direccion_empleado) {
        this.direccion_empleado = direccion_empleado;
    }

    public String getRuc_empleado() {
        return ruc_empleado;
    }

    public void setRuc_empleado(String ruc_empleado) {
        this.ruc_empleado = ruc_empleado;
    }

    public int getIdmascota() {
        return idmascota;
    }

    public void setIdmascota(int idmascota) {
        this.idmascota = idmascota;
    }

    public String getNombre_mascota() {
        return nombre_mascota;
    }

    public void setNombre_mascota(String nombre_mascota) {
        this.nombre_mascota = nombre_mascota;
    }

    public String getEspecie_mascota() {
        return especie_mascota;
    }

    public void setEspecie_mascota(String especie_mascota) {
        this.especie_mascota = especie_mascota;
    }

    public String getRaza_mascota() {
        return raza_mascota;
    }

    public void setRaza_mascota(String raza_mascota) {
        this.raza_mascota = raza_mascota;
    }

    public String getColorpelo_mascota() {
        return colorpelo_mascota;
    }

    public void setColorpelo_mascota(String colorpelo_mascota) {
        this.colorpelo_mascota = colorpelo_mascota;
    }

    public String getFechanacimiento_mascota() {
        return fechanacimiento_mascota;
    }

    public void setFechanacimiento_mascota(String fechanacimiento_mascota) {
        this.fechanacimiento_mascota = fechanacimiento_mascota;
    }
}
