public class Miembro {
    private String nombre;
    private String id;
    private String tipoMembresia;
    private Entrenador entrenador;
    private Rutina rutina;

    public Miembro(String nombre, String id, String tipoMembresia) {
        this.nombre = nombre;
        this.id = id;
        this.tipoMembresia = tipoMembresia;
        this.entrenador = null;
        this.rutina = null;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public Rutina getRutina() {
        return rutina;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public void setRutina(Rutina rutina) {
        this.rutina = rutina;
    }

    @Override
    public String toString() {
        String infoEntrenador = (entrenador != null) ? entrenador.getNombre() : "No asignado";
        String infoRutina = (rutina != null) ? rutina.getNombre() : "No asignada";

        return "ID: " + id + ", Nombre: " + nombre + ", Membresía: " + tipoMembresia +
               " | Entrenador: " + infoEntrenador + ", Rutina: " + infoRutina;
    }
}