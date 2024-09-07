package com.ucb.test1;
import java.util.ArrayList;
import java.util.Scanner;

class Producto {
    String nombre;
    double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre + " - Bs." + precio;
    }
}

class Carrito
{
	public ArrayList<Producto> productos;
	public Scanner scanner = new Scanner(System.in);
	
	public Carrito() {
		productos = new ArrayList<>();
	}
	
	public void menu() {
        int opcion;
        do {
            System.out.println("1. Agregar producto");
            System.out.println("2. Eliminar producto");
            System.out.println("3. Listar productos");
            System.out.println("4. Calcular total");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> agregarProducto();
                case 2 -> quitarProducto();
                case 3 -> listaProductos();
                case 4 -> totalProductos();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida");
            }
        } while (opcion != 5);
	}

	public void totalProductos() {
		double total = 0.0;
		for (Producto producto : productos) {
		    total += producto.precio;
		}
		System.out.println("Total a pagar: $" + total);
	}

	public void listaProductos() {
		System.out.println("Productos en el supermercado:");
		for (Producto producto : productos) {
		    System.out.println(producto);
		}
	}

	public void quitarProducto() {
		System.out.print("Ingrese el nombre del producto a eliminar: ");
		String nombre = scanner.nextLine();
		productos.removeIf(producto -> producto.nombre.equals(nombre));
	}

	public void agregarProducto() {
		System.out.print("Ingrese el nombre del producto: ");
		String nombre = scanner.nextLine();
		System.out.print("Ingrese el precio del producto: ");
		double precio = scanner.nextDouble();
		productos.add(new Producto(nombre, precio));
	}
}

public class Ejercicio6 {
    public static void main(String[] args) {
        Carrito c = new Carrito();
    	c.menu();
    }
}

