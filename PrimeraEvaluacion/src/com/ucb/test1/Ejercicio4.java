package com.ucb.test1;

import java.util.ArrayList;
import java.util.Scanner;

class Supermercado {
	public ArrayList<String> productos;
	public static Scanner scanner = new Scanner(System.in);
	
	public Supermercado() {
		productos = new ArrayList<>();
	}
	
	public void listarProducto() {
		System.out.println("Productos en el supermercado:");
		for (String prod : productos) {
		    System.out.println(prod);
		}
	}

	public void quitarProducto() {
		System.out.print("Ingrese el nombre del producto a eliminar: ");
		String producto = scanner.nextLine();
		productos.remove(producto);
	}

	public void agregarProducto() {
		System.out.print("Ingrese el nombre del producto: ");
		String producto = scanner.nextLine();
		productos.add(producto);
	}
	
	public void menu() {
		int opcion;
		do {
            System.out.println("1. Agregar producto");
            System.out.println("2. Eliminar producto");
            System.out.println("3. Listar productos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> agregarProducto();
                case 2 -> quitarProducto();
                case 3 -> listarProducto();
                case 4 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida");
            }
        } while (opcion != 4);
	}
}

public class Ejercicio4 {
	public static void main(String[] args) {
		Supermercado sup = new Supermercado();
        sup.menu();
    }
}
