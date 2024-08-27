//  @ Ejercicio 2
//  @ File Name : Proyecto.java
//  @ Date : 27/08/2024
//  @ Author : Alejandro Manuel Jerez Melgar 24678
//
import java.util.Date;

public class Proyecto {
    //Atributos
    private String nombre;
    private String codigo;
    private String categoria;
    private Desarrollador dJ;
    private Desarrollador dS;
    private Date fecha;
    private Tarea []tareas=new Tarea[3];
    int tareaCount=0;

    //Constructor
    /**
     * 
     * @param nombre String
     * @param codigo String
     * @param categoria String
     * @param dJ Desarrollador
     * @param dS Desarrolladro
     * @param fecha Date
     */
    public Proyecto(String nombre, String codigo, String categoria, Desarrollador dJ, Desarrollador dS, Date fecha){
        this.nombre=nombre;
        this.codigo=codigo;
        this.categoria=categoria;
        this.dJ=dJ;
        this.dS=dS;
        this.fecha=fecha;
    }

    //Cosntructor vacio
    public Proyecto(){
        
    }

    /**
     * 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * 
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * 
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    /**
     * 
     * @return codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * 
     * @param categoria
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    /**
     * 
     * @return categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * 
     * @param dJ
     */
    public void setdJ(Desarrollador dJ) {
        this.dJ = dJ;
    }
    /**
     * 
     * @return dJ
     */
    public Desarrollador getdJ() {
        return dJ;
    }

    /**
     * 
     * @param dS
     */
    public void setdS(Desarrollador dS) {
        this.dS = dS;
    }
    /**
     * 
     * @return dS
     */
    public Desarrollador getdS() {
        return dS;
    }

    /**
     * 
     * @param fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    /**
     * 
     * @return fecha
     */
    public Date getFecha() {
        return fecha;
    }

    // Metodo para agregar una tarea al arreglo
    public boolean agregarTarea(Tarea tarea) {
        if (tareaCount < tareas.length) {
            tareas[tareaCount] = tarea;
            tareaCount++;
            return true;  // Tarea agregada exitosamente
        } else {
            return false;  // No hay espacio disponible
        }
    }

    //Metodo para verificar si el arreglo tarea esta vacio
    public boolean tieneTareas(){
        return tareaCount>0;
    }

    /**
     * 
     * @return tareas
     */
    public Tarea[] getTareas() {
        return tareas;
    }

}
