import java.util.Date;

public class Funcionamiento {
    Proyecto []proyectos=new Proyecto[5];
    Desarrollador []desarrolladors=new Desarrollador[10];
    private int proyectoCount=0;
    private int desarrolladorCount=0;
    int contador=1;

    public Proyecto crearProyecto(String nombre, String codigo, String categoria, Desarrollador dJ, Desarrollador dS, Date fecha) {
        Proyecto nuevoProyecto = new Proyecto(nombre, codigo, categoria, dJ, dS, fecha);
        return nuevoProyecto;

    }

    public Desarrollador crearDesarrollador(String nombre, String puesto) {
        Desarrollador nuevoDesarrollador = new Desarrollador(nombre, puesto);
        return nuevoDesarrollador;
    }

    public Tarea crearTarea(String nombre, String tipo, Desarrollador desarrollador, float tE, float tR, String estado) {
        Tarea nuevaTarea = new Tarea(nombre, tipo, desarrollador, tE, tR, estado);
        return nuevaTarea;
    }

    public boolean agregarProyecto(Proyecto proyecto) {
        if (proyectoCount < proyectos.length) {
            proyectos[proyectoCount] = proyecto;
            proyectoCount++;
            return true; 
        } else {
            return false;
        }
    }

    public boolean agregarDesarrollador(Desarrollador desarrollador) {
        if (desarrolladorCount < desarrolladors.length) {
            desarrolladors[desarrolladorCount] = desarrollador;
            desarrolladorCount++;
            return true; 
        } else {
            return false;
        }
    }

    public String codigoProyecto(String fecha){
        String codigoBoleto=fecha+contador;
        contador++;
        return codigoBoleto;
    }

    public boolean esDesarrolladorJunior(Desarrollador desarrollador) {
        return desarrollador.getPuesto().equalsIgnoreCase("Junior");
    }

    public boolean esDesarrolladorSenior(Desarrollador desarrollador) {
        return desarrollador.getPuesto().equalsIgnoreCase("Senior");
    }

    public void editarTarea(Tarea tareaSeleccionada, String estado){
        tareaSeleccionada.setEstado(estado);

    }

    public String mostrarProyectos() {
        StringBuilder finalString = new StringBuilder();
    
        for (int i = 0; i < proyectoCount; i++) {
            Proyecto proyecto = proyectos[i];
            StringBuilder proyectoString = new StringBuilder();
            proyectoString.append("\n---------------------------------------\n")
                           .append("Nombre del Proyecto: ").append(proyecto.getNombre()).append("\n")
                           .append("Código: ").append(proyecto.getCodigo()).append("\n")
                           .append("Tareas Asignadas:\n");
            
            Tarea[] tareas = proyecto.getTareas();
            for (int j = 0; j < tareas.length; j++) {
                if (tareas[j] != null) { 
                    Tarea tarea = tareas[j];
                    proyectoString.append("\n").append(j + 1).append(". Nombre: ").append(tarea.getNombre())
                                  .append(" Tipo: ").append(tarea.getTipo())
                                  .append(" Estado: ").append(tarea.getEstado())
                                  .append(" Asignado a: ").append(tarea.getDesarrollador().getNombre())
                                  .append("\n---------------------------------------");
                }
            }
            finalString.append(proyectoString).append("\n");
        }
    
        return finalString.toString();
    }

    public Desarrollador[] getDesarrolladors() {
        return desarrolladors;
    }

    // Método para obtener la lista de tareas
    public Proyecto[] getProyectos() {
        return proyectos;
    }

    public int getDesarrolladorCount() {
        return desarrolladorCount;
    }
    public int getProyectoCount() {
        return proyectoCount;
    }
}
