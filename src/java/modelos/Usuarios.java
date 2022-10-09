
package modelos;

public class Usuarios {
    private int idusuario;
    private String tipo_usuario;
    private String contra_usuario;
    private String login_usuario;
    private Empleados empleados;

    public Usuarios() {
    }

    public Usuarios(int idusuario, String tipo_usuario, String contra_usuario, String login_usuario, Empleados empleados) {
        this.idusuario = idusuario;
        this.tipo_usuario = tipo_usuario;
        this.contra_usuario = contra_usuario;
        this.login_usuario = login_usuario;
        this.empleados = empleados;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getContra_usuario() {
        return contra_usuario;
    }

    public void setContra_usuario(String contra_usuario) {
        this.contra_usuario = contra_usuario;
    }

    public String getLogin_usuario() {
        return login_usuario;
    }

    public void setLogin_usuario(String login_usuario) {
        this.login_usuario = login_usuario;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }
    
    
    
}
