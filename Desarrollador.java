//  @ Ejercicio 2
//  @ File Name : Desarrollador.java
//  @ Date : 27/08/2024
//  @ Author : Alejandro Manuel Jerez Melgar 24678
//

public class Desarrollador{
    //Atributos
    private String nombre;
    private String puesto;

    //Constructor
    /**
     * 
     * @param nombre String
     * @param puesto String
     */
    public Desarrollador(String nombre, String puesto){
        this.nombre=nombre;
        this.puesto=puesto;
    }

    //COnstructor vacio
    /**
     * 
     */
    public Desarrollador(){

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
     * @param puesto
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    /**
     * 
     * @return puesto
     */
    public String getPuesto() {
        return puesto;
    }

}