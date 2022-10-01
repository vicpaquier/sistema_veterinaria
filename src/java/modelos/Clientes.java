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
public class Clientes {
    private int idcliente;
    private String nombre_cliente;
    private String apellido_cliente;
    private String celular_cliente;
    private String direccion_cliente;
    private String ruc_cliente;
    private int idmascota;
    private String nombre_mascota;
    private String especie_mascota;
    private String raza_mascota;
    private String colorpelo_mascota;
    private String fechanacimiento_mascota;
    

    public Clientes() {
    }

    public Clientes(int idcliente, String nombre_cliente, String apellido_cliente, String celular_cliente, String direccion_cliente, String ruc_cliente, int idmascota, String nombre_mascota, String especie_mascota, String raza_mascota, String colorpelo_mascota, String fechanacimiento_mascota) {
        this.idcliente = idcliente;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.celular_cliente = celular_cliente;
        this.direccion_cliente = direccion_cliente;
        this.ruc_cliente = ruc_cliente;
        this.idmascota = idmascota;
        this.nombre_mascota = nombre_mascota;
        this.especie_mascota = especie_mascota;
        this.raza_mascota = raza_mascota;
        this.colorpelo_mascota = colorpelo_mascota;
        this.fechanacimiento_mascota = fechanacimiento_mascota;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getApellido_cliente() {
        return apellido_cliente;
    }

    public void setApellido_cliente(String apellido_cliente) {
        this.apellido_cliente = apellido_cliente;
    }

    public String getCelular_cliente() {
        return celular_cliente;
    }

    public void setCelular_cliente(String celular_cliente) {
        this.celular_cliente = celular_cliente;
    }

    public String getDireccion_cliente() {
        return direccion_cliente;
    }

    public void setDireccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }

    public String getRuc_cliente() {
        return ruc_cliente;
    }

    public void setRuc_cliente(String ruc_cliente) {
        this.ruc_cliente = ruc_cliente;
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
