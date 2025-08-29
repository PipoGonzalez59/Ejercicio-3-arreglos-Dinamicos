import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Gimnasio {
    private ArrayList<Miembro> miembros;
    private ArrayList<Entrenador> entrenadores;
    private ArrayList<Rutina> rutinas;

    public Gimnasio() {
        this.miembros = new ArrayList<>();
        this.entrenadores = new ArrayList<>();
        this.rutinas = new ArrayList<>();
    }
    
    public void agregarMiembro(Miembro miembro) {
        this.miembros.add(miembro);
    }
    
    public void agregarEntrenador(Entrenador entrenador) {
        this.entrenadores.add(entrenador);
    }
    
    public void agregarRutina(Rutina rutina) {
        this.rutinas.add(rutina);
    }

    public Miembro buscarMiembroPorId(String id) {
        for (Miembro miembro : miembros) {
            if (miembro.getId().equalsIgnoreCase(id)) {
                return miembro;
            }
        }
        return null;
    }

    public Entrenador buscarEntrenadorPorId(String id) {
        for (Entrenador entrenador : entrenadores) {
            if (entrenador.getId().equalsIgnoreCase(id)) {
                return entrenador;
            }
        }
        return null;
    }
    
    public Rutina buscarRutinaPorNombre(String nombre) {
        for (Rutina rutina : rutinas) {
            if (rutina.getNombre().equalsIgnoreCase(nombre)) {
                return rutina;
            }
        }
        return null;
    }

    public ArrayList<Miembro> getMiembros() {
        return miembros;
    }

    public ArrayList<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public ArrayList<Rutina> getRutinas() {
        return rutinas;
    }
    
    public String getReporteRutinaMasPopular() {
        if (miembros.isEmpty()) {
            return "No hay miembros para generar el reporte.";
        }

        Map<Rutina, Integer> conteoRutinas = new HashMap<>();
        for (Miembro miembro : miembros) {
            if (miembro.getRutina() != null) {
                Rutina r = miembro.getRutina();
                conteoRutinas.put(r, conteoRutinas.getOrDefault(r, 0) + 1);
            }
        }

        if (conteoRutinas.isEmpty()) {
            return "Ningún miembro tiene una rutina asignada.";
        }

        Rutina rutinaMasPopular = null;
        int maxMiembros = 0;
        for (Map.Entry<Rutina, Integer> entry : conteoRutinas.entrySet()) {
            if (entry.getValue() > maxMiembros) {
                maxMiembros = entry.getValue();
                rutinaMasPopular = entry.getKey();
            }
        }

        return "La rutina más popular es '" + rutinaMasPopular.getNombre() + "' con " + maxMiembros + " practicantes.";
    }

    public String getReporteTotalRutinasActivas() {
        HashSet<Rutina> rutinasActivas = new HashSet<>();
        for (Miembro miembro : miembros) {
            if (miembro.getRutina() != null) {
                rutinasActivas.add(miembro.getRutina());
            }
        }
        return "Hay un total de " + rutinasActivas.size() + " rutinas activas en el gimnasio.";
    }

    public String getReporteEntrenadorConMasMiembros() {
        if (miembros.isEmpty()) {
            return "No hay miembros para generar el reporte.";
        }
        
        Map<Entrenador, Integer> conteoMiembros = new HashMap<>();
        for (Miembro miembro : miembros) {
            if (miembro.getEntrenador() != null) {
                Entrenador e = miembro.getEntrenador();
                conteoMiembros.put(e, conteoMiembros.getOrDefault(e, 0) + 1);
            }
        }

        if (conteoMiembros.isEmpty()) {
            return "Ningún miembro tiene un entrenador asignado.";
        }
        
        Entrenador entrenadorTop = null;
        int maxMiembros = 0;
        for (Map.Entry<Entrenador, Integer> entry : conteoMiembros.entrySet()) {
            if (entry.getValue() > maxMiembros) {
                maxMiembros = entry.getValue();
                entrenadorTop = entry.getKey();
            }
        }

        return "El entrenador con más miembros es '" + entrenadorTop.getNombre() + "' con " + maxMiembros + " alumnos.";
    }
}