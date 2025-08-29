public class Rutina {
    private String nombre;
    private String descripcion;

    public Rutina(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Descripción: " + descripcion;
    }
}