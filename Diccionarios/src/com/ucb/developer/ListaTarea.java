package com.ucb.developer;

import java.util.LinkedList;
import java.util.Scanner;

class Tarea {
    private int id;
    private String nombre;
    private boolean completada;

    public Tarea(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.completada = false;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public boolean isCompletada() { return completada; }
    public void setCompletada(boolean completada) { this.completada = completada; }

    @Override
    public String toString() {
        return "Tarea [ID=" + id + ", Nombre=" + nombre + ", Completada=" + completada + "]";
    }
}

public class ListaTarea {
    private LinkedList<Tarea> tareas = new LinkedList<>();
    private int contadorId = 1;

    public void agregarTarea(String nombre) {
        Tarea nuevaTarea = new Tarea(contadorId++, nombre);
        tareas.add(nuevaTarea);
        System.out.println("Tarea agregada: " + nuevaTarea);
    }

    public void marcarTareaCompletada(int id) {
        for (Tarea tarea : tareas) {
            if (tarea.getId() == id) {
                tarea.setCompletada(true);
                System.out.println("Tarea completada: " + tarea);
                return;
            }
        }
        System.out.println("Tarea no encontrada.");
    }

    public void eliminarTarea(int id) {
        tareas.removeIf(tarea -> tarea.getId() == id);
        System.out.println("Tarea eliminada.");
    }

    public void listarTareas() {
        for (Tarea tarea : tareas) {
            System.out.println(tarea);
        }
    }

    public static void main(String[] args) {
        ListaTarea listaDeTareas = new ListaTarea();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Agregar Tarea");
            System.out.println("2. Marcar Tarea Completada");
            System.out.println("3. Eliminar Tarea");
            System.out.println("4. Listar Tareas");
            System.out.println("5. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Nombre de la tarea: ");
                    String nombre = scanner.nextLine();
                    listaDeTareas.agregarTarea(nombre);
                    break;
                case 2:
                    System.out.print("ID de la tarea a completar: ");
                    int idCompletada = scanner.nextInt();
                    listaDeTareas.marcarTareaCompletada(idCompletada);
                    break;
                case 3:
                    System.out.print("ID de la tarea a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    listaDeTareas.eliminarTarea(idEliminar);
                    break;
                case 4:
                    listaDeTareas.listarTareas();
                    break;
                case 5:
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}

