//  @ Ejercicio 2
//  @ File Name : Funcionamiento.java
//  @ Date : 27/08/2024
//  @ Author : Alejandro Manuel Jerez Melgar 24678
//

import java.util.Date;

public class Funcionamiento {
    //Atributos
    private Proyecto []proyectos=new Proyecto[5];
    private Desarrollador []desarrolladors=new Desarrollador[10];
    private int proyectoCount=0;
    private int desarrolladorCount=0;
    int contador=1;

    //Metodo para crear Proyectos
    public Proyecto crearProyecto(String nombre, String codigo, String categoria, Desarrollador dJ, Desarrollador dS, Date fecha) {
        Proyecto nuevoProyecto = new Proyecto(nombre, codigo, categoria, dJ, dS, fecha);
        return nuevoProyecto;

    }

    //Metodo para crear Desarrolladores
    public Desarrollador crearDesarrollador(String nombre, String puesto) {
        Desarrollador nuevoDesarrollador = new Desarrollador(nombre, puesto);
        return nuevoDesarrollador;
    }

    //Metodo para crear Tareas
    public Tarea crearTarea(String nombre, String tipo, Desarrollador desarrollador, float tE, float tR, String estado) {
        Tarea nuevaTarea = new Tarea(nombre, tipo, desarrollador, tE, tR, estado);
        return nuevaTarea;
    }

    //Metodo para agregar Proyectos al arreglo proyectos
    public boolean agregarProyecto(Proyecto proyecto) {
        if (proyectoCount < proyectos.length) {
            proyectos[proyectoCount] = proyecto;
            proyectoCount++;
            return true; 
        } else {
            return false;
        }
    }

    //Metodo para agregar Desarrolladroes al arreglo desarrolladoes
    public boolean agregarDesarrollador(Desarrollador desarrollador) {
        if (desarrolladorCount < desarrolladors.length) {
            desarrolladors[desarrolladorCount] = desarrollador;
            desarrolladorCount++;
            return true; 
        } else {
            return false;
        }
    }

    //Metodo para crear codigo unico para cada proyecto
    public String codigoProyecto(String fecha){
        String codigoBoleto=fecha+contador;
        contador++;
        return codigoBoleto;
    }

    //Metood para verificar si un desarrollador es Junior
    public boolean esDesarrolladorJunior(Desarrollador desarrollador) {
        return desarrollador.getPuesto().equalsIgnoreCase("Junior");
    }

    //Metood para verificar si un desarrollador es Senior
    public boolean esDesarrolladorSenior(Desarrollador desarrollador) {
        return desarrollador.getPuesto().equalsIgnoreCase("Senior");
    }

    //Metodo para editar tareas de un proyecto especifico
    public void editarTarea(Tarea tareaSeleccionada, String estado){
        tareaSeleccionada.setEstado(estado);

    }

    //Metodo para mostrar todos los proyectos junto a sus tareas
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

    /**
     * 
     * @return desarrolladors
     */
    public Desarrollador[] getDesarrolladors() {
        return desarrolladors;
    }

    /**
     * 
     * @return proyectos
     */
    public Proyecto[] getProyectos() {
        return proyectos;
    }

    /**
     * 
     * @return desarrolladorCount
     */
    public int getDesarrolladorCount() {
        return desarrolladorCount;
    }
    /**
     * 
     * @return proyectoCount
     */
    public int getProyectoCount() {
        return proyectoCount;
    }
}
