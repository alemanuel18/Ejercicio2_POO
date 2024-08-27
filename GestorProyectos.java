//  @ Ejercicio 2
//  @ File Name : GestorProyectos.java
//  @ Date : 27/08/2024
//  @ Author : Alejandro Manuel Jerez Melgar 24678
//

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class GestorProyectos {

    public static void main(String[] args) {
        //se inicializan las variables

        String nombreP;
        String nombreD;
        String nombreT;
        Proyecto proyectoSeleccionado;

        Funcionamiento funcionamiento=new Funcionamiento();
       
        Date fechaActual = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("MMyyyydd");
        String fecha = formateador.format(fechaActual);

        int eleccion=menu();

        Scanner teclado=new Scanner(System.in);

        //ciclo principal, es el encargado de la navegacion
        while (eleccion!=6) {
            if (eleccion == 1) {
                if (funcionamiento.getDesarrolladorCount()<2) {
                    System.out.println("Deben existir dos o mas desarrolladores para crear un proyecto.");
                }else{
                    System.out.println("Ingrese el nombre del proyecto");
                    nombreP=teclado.nextLine();
                    funcionamiento.agregarProyecto(funcionamiento.crearProyecto(nombreP, funcionamiento.codigoProyecto(fecha), menu2(), seleccionarDesarrolladorJunior(funcionamiento), seleccionarDesarrolladorSenior(funcionamiento), fechaActual));
                    System.out.println("Se a creado el proyecto");
                }
                eleccion = menu();
            }else if (eleccion==2) {
                if (funcionamiento.getProyectoCount()<1) {
                    System.out.println("Debe exitir almenos un proyecto para asignar tareas");                    
                }else{
                    proyectoSeleccionado=seleccionarProyecto(funcionamiento);
                    System.out.println("Ingrese el nombre de la tarea");
                    nombreT = teclado.nextLine();
                    
                    if (proyectoSeleccionado.agregarTarea(funcionamiento.crearTarea(nombreT, menu4(), seleccionarDesarrolladorTareas(proyectoSeleccionado), TE(), 0, "No iniciada"))) {
                        System.out.println("Se a asignado la tarea");   
                    }else{
                        System.out.println("No se agrego la tarea ya que este proyecto ya no hacepta mas tareas");
                    }
                }
                
                eleccion=menu();
            }else if (eleccion==3) {
                System.out.println("Ingrese el nombre del desarrollador");
                nombreD=teclado.nextLine();
                funcionamiento.agregarDesarrollador(funcionamiento.crearDesarrollador(nombreD, menu3()));
                System.out.println("Se a creado a un nuevo desarrollador");
                
                eleccion=menu();
            }else if (eleccion==4) {
                if (funcionamiento.getProyectoCount()<1) {
                    System.out.println("Debe existir almenos un proyecto.");
                    
                }else{
                    proyectoSeleccionado = seleccionarProyecto(funcionamiento);
                    if (proyectoSeleccionado.tieneTareas()) {
                        funcionamiento.editarTarea(seleccionarTareaEditar(proyectoSeleccionado), menu5());
                        System.out.println("Se a actualizado la tarea.");
                    } else {
                        System.out.println("Este proyecto no tiene tareas asignadas");
                    }
                }
                eleccion=menu();
            }else if (eleccion==5) {
                System.out.println(funcionamiento.mostrarProyectos());                
                eleccion=menu();
            }
            
        }
        System.out.println("Gracias por preferirnos, hasta la proxima.");
        teclado.close();
    }

    public static int menu(){
        //Se inicializan las variables
        //Se crean los objetos

        Scanner teclado=new Scanner(System.in);
        String eleccionUsuarioS="";
        int eleccionUsuarioi=0;
        boolean verificador=false;
        

        //Menu principal
        while (verificador==false) {
            System.out.println("\nMenu\nSeleccion lo que deses realizar\n1. Crear nuevo proyecto\n2. Agregar tarea a proyecto\n3. Crear nuevo desarrollador\n4. Actualizar estado de tarea\n5. Generar reporte de progreso\n6. Salir");
            eleccionUsuarioS=teclado.nextLine();

            try { 
                //verifica que el dato ingresado sea un int
                eleccionUsuarioi=Integer.parseInt(eleccionUsuarioS);
                if(eleccionUsuarioi<1 ||eleccionUsuarioi>6){
                    System.out.println("Ingrese una de las opciones del menu");
                }else
                verificador=true;
                
            } catch (Exception e) {
                System.out.println("Ingrese un numero entero");
            } 
        }
        return eleccionUsuarioi;

    }

    public static String menu2(){
        //Se inicializan las variables
        //Se crean los objetos

        Scanner teclado=new Scanner(System.in);
        String eleccionUsuarioS="";
        int eleccionUsuarioi=0;
        boolean verificador=false;
        

        // Meni de categoria de proyecto
        while (verificador==false) {
            System.out.println("\nSeleccion la categoria del proyecto\n1. Desarrollo\n2. Mantenimiento");
            eleccionUsuarioS=teclado.nextLine();

            try { 
                eleccionUsuarioi=Integer.parseInt(eleccionUsuarioS);
                if(eleccionUsuarioi<1 ||eleccionUsuarioi>2){
                    System.out.println("Ingrese una de las opciones del menu");
                }else{
                    if (eleccionUsuarioi==1) {
                        eleccionUsuarioS="Desarrollo";
                        verificador=true;
                    }
                    else if (eleccionUsuarioi==2) {
                        eleccionUsuarioS="Mantenimiento";
                        verificador=true;
                    }
                }
                
            } catch (Exception e) {
                System.out.println("Ingrese un numero entero");
            } 
        }
        return eleccionUsuarioS;
    }

    public static String menu3(){
        //Se inicializan las variables
        //Se crean los objetos

        Scanner teclado=new Scanner(System.in);
        String eleccionUsuarioS="";
        int eleccionUsuarioi=0;
        boolean verificador=false;
        

        //Menu del puesto del desarrollador
        while (verificador==false) {
            System.out.println("\nSeleccion el puesto del desarrollador\n1. Junior\n2. Senior");
            eleccionUsuarioS=teclado.nextLine();

            try { 
                eleccionUsuarioi=Integer.parseInt(eleccionUsuarioS);
                if(eleccionUsuarioi<1 ||eleccionUsuarioi>2){
                    System.out.println("Ingrese una de las opciones del menu");
                }else{
                    if (eleccionUsuarioi==1) {
                        eleccionUsuarioS="Junior";
                        verificador=true;
                    }
                    else if (eleccionUsuarioi==2) {
                        eleccionUsuarioS="Senior";
                        verificador=true;
                    }
                }
                
            } catch (Exception e) {
                System.out.println("Ingrese un numero entero");
            } 
        }
        return eleccionUsuarioS;

    }

    public static String menu4(){
        //Se inicializan las variables
        //Se crean los objetos

        Scanner teclado=new Scanner(System.in);
        String eleccionUsuarioS="";
        int eleccionUsuarioi=0;
        boolean verificador=false;
        

        while (verificador==false) {
            //menu de tipo de tarea
            System.out.println("\nSeleccion el tipo de tarea\n1. Desarrollo\n2. Pruebas\n3. Documentacion");
            eleccionUsuarioS=teclado.nextLine();

            try { 
                eleccionUsuarioi=Integer.parseInt(eleccionUsuarioS);
                if(eleccionUsuarioi<1 ||eleccionUsuarioi>3){
                    System.out.println("Ingrese una de las opciones del menu");
                }else{
                    if (eleccionUsuarioi==1) {
                        eleccionUsuarioS="Desarrollo";
                        verificador=true;
                    }
                    else if (eleccionUsuarioi==2) {
                        eleccionUsuarioS="Pruebas";
                        verificador=true;
                    }
                    else if (eleccionUsuarioi==3) {
                        eleccionUsuarioS="Documentacion";
                        verificador=true;
                    }
                }
                
            } catch (Exception e) {
                System.out.println("Ingrese un numero entero");
            } 
        }
        return eleccionUsuarioS;
    }

    public static String menu5(){
        //Se inicializan las variables
        //Se crean los objetos

        Scanner teclado=new Scanner(System.in);
        String eleccionUsuarioS="";
        int eleccionUsuarioi=0;
        boolean verificador=false;
        

        while (verificador==false) {
            //menu de estado de la tarea 
            System.out.println("\nSeleccion el nuevo estado de la tarea\n1. Completada\n2. Proceso\n3. No iniciada");
            eleccionUsuarioS=teclado.nextLine();

            try { 
                eleccionUsuarioi=Integer.parseInt(eleccionUsuarioS);
                if(eleccionUsuarioi<1 ||eleccionUsuarioi>3){
                    System.out.println("Ingrese una de las opciones del menu");
                }else{
                    if (eleccionUsuarioi==1) {
                        eleccionUsuarioS="Completada";
                        verificador=true;
                    }
                    else if (eleccionUsuarioi==2) {
                        eleccionUsuarioS="Proceso";
                        verificador=true;
                    }
                    else if (eleccionUsuarioi==3) {
                        eleccionUsuarioS="No iniciada";
                        verificador=true;
                    }
                }
                
            } catch (Exception e) {
                System.out.println("Ingrese un numero entero");
            } 
        }
        return eleccionUsuarioS;
    }

    public static float TE(){

        Scanner teclado=new Scanner(System.in);
        String eleccionUsuarioS="";
        float eleccionUsuarioi=0;
        boolean verificador=false;
        

        while (verificador==false) {
            //verifica que se ingrese un float
            System.out.println("\nIngrese el timpo estimado para la tarea");
            eleccionUsuarioS=teclado.nextLine();

            try { 
                eleccionUsuarioi=Float.parseFloat(eleccionUsuarioS);
                verificador=true;
                
            } catch (Exception e) {
                System.out.println("Ingrese el tiempo estimado.");
            } 
        }
        return eleccionUsuarioi;

    }

    public static Desarrollador seleccionarDesarrolladorJunior(Funcionamiento funcionamiento) {
        Desarrollador[] desarrolladors = funcionamiento.getDesarrolladors();
        int desarrolladorCount=funcionamiento.getDesarrolladorCount();
        Desarrollador[] desarrolladoresJuniors = new Desarrollador[desarrolladorCount];
        int count = 0;
        boolean verificador=false;
        String eleccionUsuarioS;
        int eleccionUsuarioi=0;
        Scanner teclado=new Scanner(System.in);
        

        // Filtrar desarrolladores juniors
        for (int i = 0; i < desarrolladorCount; i++) {
            if (funcionamiento.esDesarrolladorJunior(desarrolladors[i])) {
                desarrolladoresJuniors[count] = desarrolladors[i];
                count++;
            }
        }

        // Capturar selección del usuario

        while (verificador==false) {
            System.out.println("Seleccione un desarrollador junior:");

            //muestra a los desarrolladores Junior
            for (int i = 0; i < count; i++) {
                System.out.println((i + 1) + ". " + desarrolladoresJuniors[i].getNombre() + " - " + desarrolladoresJuniors[i].getPuesto());
            }
            eleccionUsuarioS=teclado.nextLine();

            try { 
                eleccionUsuarioi=Integer.parseInt(eleccionUsuarioS);
                if(eleccionUsuarioi < 1 || eleccionUsuarioi > count){
                    System.out.println("Ingrese una de las opciones del menu");
                }else{
                    verificador=true;
                }
                
            } catch (Exception e) {
                System.out.println("Ingrese un numero entero");
            } 
        }

        return desarrolladoresJuniors[eleccionUsuarioi - 1];
    }

    public static Desarrollador seleccionarDesarrolladorSenior(Funcionamiento funcionamiento) {
        Desarrollador[] desarrolladors = funcionamiento.getDesarrolladors();
        int desarrolladorCount=funcionamiento.getDesarrolladorCount();
        Desarrollador[] desarrolladoresSenior = new Desarrollador[desarrolladorCount];
        int count = 0;
        boolean verificador=false;
        String eleccionUsuarioS;
        int eleccionUsuarioi=0;
        Scanner teclado=new Scanner(System.in);
        

        // Filtrar desarrolladores senior
        for (int i = 0; i < desarrolladorCount; i++) {
            if (funcionamiento.esDesarrolladorSenior(desarrolladors[i])) {
                desarrolladoresSenior[count] = desarrolladors[i];
                count++;
            }
        }
        // Capturar selección del usuario

        while (verificador==false) {
            System.out.println("Seleccione un desarrollador junior:");

            //Muestra a los desarrolladores senior
            for (int i = 0; i < count; i++) {
                System.out.println((i + 1) + ". " + desarrolladoresSenior[i].getNombre() + " - " + desarrolladoresSenior[i].getPuesto());
            }
            eleccionUsuarioS=teclado.nextLine();

            try { 
                eleccionUsuarioi=Integer.parseInt(eleccionUsuarioS);
                if(eleccionUsuarioi < 1 || eleccionUsuarioi > count){
                    System.out.println("Ingrese una de las opciones del menu");
                }else{
                    verificador=true;
                }
                
            } catch (Exception e) {
                System.out.println("Ingrese un numero entero");
            } 
        }

        return desarrolladoresSenior[eleccionUsuarioi - 1];
    }

    public static Proyecto seleccionarProyecto(Funcionamiento funcionamiento) {
        Proyecto []proyectos=funcionamiento.getProyectos();
        int proyectosCount=funcionamiento.getProyectoCount();

        boolean verificador=false;
        String eleccionUsuarioS;
        int eleccionUsuarioi=0;
        Scanner teclado=new Scanner(System.in);
        
        // Capturar selección del usuario

        while (verificador==false) {
            System.out.println("Seleccione proyecto para agregar tarea:");

            //Muestra todos los proyectos
            for (int i = 0; i < proyectosCount; i++) {
                System.out.println((i + 1) + ". " + proyectos[i].getNombre());
            }
            eleccionUsuarioS=teclado.nextLine();

            try { 
                eleccionUsuarioi=Integer.parseInt(eleccionUsuarioS);
                if(eleccionUsuarioi < 1 || eleccionUsuarioi > proyectosCount){
                    System.out.println("Ingrese una de las opciones del menu");
                }else{
                    verificador=true;
                }
                
            } catch (Exception e) {
                System.out.println("Ingrese un numero entero");
            } 
        }

        return proyectos[eleccionUsuarioi - 1];
    }

    public static Desarrollador seleccionarDesarrolladorTareas(Proyecto proyecto) {
        
        //Almacena a todos los desarrolladores dle proyecto
        Desarrollador[] desarrolladorsProyecto={proyecto.getdJ(), proyecto.getdS()};

        boolean verificador=false;
        String eleccionUsuarioS;
        int eleccionUsuarioi=0;
        Scanner teclado=new Scanner(System.in);
        
        // Capturar selección del usuario

        while (verificador==false) {
            System.out.println("Seleccione proyecto para agregar tarea:");

            //Muestra a todos los desarrolladores del proyecto
            for (int i = 0; i < desarrolladorsProyecto.length; i++) {
                System.out.println((i + 1) + ". " + desarrolladorsProyecto[i].getNombre() + " - " + desarrolladorsProyecto[i].getPuesto());
            }
            eleccionUsuarioS=teclado.nextLine();

            try { 
                eleccionUsuarioi=Integer.parseInt(eleccionUsuarioS);
                if(eleccionUsuarioi < 1 || eleccionUsuarioi > desarrolladorsProyecto.length){
                    System.out.println("Ingrese una de las opciones del menu");
                }else{
                    verificador=true;
                }
                
            } catch (Exception e) {
                System.out.println("Ingrese un numero entero");
            } 
        }

        return desarrolladorsProyecto[eleccionUsuarioi - 1];
    }

    public static Tarea seleccionarTareaEditar(Proyecto proyecto) {
        
        //ALmacena a todas las tareas del proyecto 
        Tarea[] tareas= proyecto.getTareas();

        boolean verificador=false;
        String eleccionUsuarioS;
        int eleccionUsuarioi=0;
        Scanner teclado=new Scanner(System.in);
        
        // Capturar selección del usuario

        while (verificador==false) {
            System.out.println("Seleccione la tarea a editar:");

            //Muestra a todas las tareas del proyecto
            for (int i = 0; i < tareas.length; i++) {
                System.out.println((i + 1) + ". " + tareas[i].getNombre() + " - " + tareas[i].getEstado());
            }

            eleccionUsuarioS=teclado.nextLine();

            try { 
                eleccionUsuarioi=Integer.parseInt(eleccionUsuarioS);
                if(eleccionUsuarioi < 1 || eleccionUsuarioi > tareas.length){
                    System.out.println("Ingrese una de las opciones del menu");
                }else{
                    verificador=true;
                }
                
            } catch (Exception e) {
                System.out.println("Ingrese un numero entero");
            } 
        }

        return tareas[eleccionUsuarioi - 1];
    }

}
