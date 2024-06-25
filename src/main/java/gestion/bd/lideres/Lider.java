package gestion.bd.lideres;

/**
 *
 * @author camilaMartin14
 */
public class Lider {

    private int id;
    private String nombre;
    private String apellido;
    private String fechaContratacion;

    public Lider() {
    }

    public Lider(int id, String nombre, String apellido, String fechaContratacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaContratacion = fechaContratacion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }
}
