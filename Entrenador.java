public class Entrenador {
    private String nombre;
    private String id;

    public Entrenador(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre;
    }
}