package com.ucb.developer;

import java.util.LinkedList;
import java.util.Scanner;

class Cliente {
    private int id;
    private String nombre;

    public Cliente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }

    @Override
    public String toString() {
        return "Cliente [ID=" + id + ", Nombre=" + nombre + "]";
    }
}

public class FilaCliente {
    private LinkedList<Cliente> cola = new LinkedList<>();
    private int contadorId = 1;

    public void agregarCliente(String nombre) {
        Cliente nuevoCliente = new Cliente(contadorId++, nombre);
        cola.add(nuevoCliente);
        System.out.println("Cliente agregado: " + nuevoCliente);
    }

    public void atenderCliente() {
        if (!cola.isEmpty()) {
            Cliente clienteAtendido = cola.removeFirst();
            System.out.println("Cliente atendido: " + clienteAtendido);
        } else {
            System.out.println("No hay clientes en la cola.");
        }
    }

    public void listarClientes() {
        for (Cliente cliente : cola) {
            System.out.println(cliente);
        }
    }

    public static void main(String[] args) {
    	FilaCliente colaDeClientes = new FilaCliente();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Atender Cliente");
            System.out.println("3. Listar Clientes");
            System.out.println("4. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    colaDeClientes.agregarCliente(nombre);
                    break;
                case 2:
                    colaDeClientes.atenderCliente();
                    break;
                case 3:
                    colaDeClientes.listarClientes();
                    break;
                case 4:
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}

