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
public class Mascotas {
    
    private int idmascota;
    private String nombre_mascota;
    private String especie_mascota;
    private String raza_mascota;
    private String colorpelo_mascota;
    private String fechanacimiento_mascota;
    

    public Mascotas() {
    }

    public Mascotas(int idmascota, String nombre_mascota, String especie_mascota, String raza_mascota, String colorpelo_mascota, String fechanacimiento_mascota) {
        
        this.idmascota = idmascota;
        this.nombre_mascota = nombre_mascota;
        this.especie_mascota = especie_mascota;
        this.raza_mascota = raza_mascota;
        this.colorpelo_mascota = colorpelo_mascota;
        this.fechanacimiento_mascota = fechanacimiento_mascota;
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
