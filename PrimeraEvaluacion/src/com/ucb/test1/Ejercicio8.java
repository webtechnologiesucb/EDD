package com.ucb.test1;

import java.util.ArrayList;

class Venta {
	ArrayList<String> productos;
	ArrayList<ArrayList<String>> combinaciones;

	public Venta() {
		productos = new ArrayList<>();
		combinaciones = new ArrayList<>();
		productos.add("Leche");
		productos.add("Pan");
		productos.add("Huevos");
		productos.add("Queso");
	}
	
	public void combinaciones()
	{
		generarCombinaciones(productos, 0, new ArrayList<>());
	}

	public void generarCombinaciones(ArrayList<String> prods, int indice, ArrayList<String> actual) 
	{
		if (indice == prods.size()) {
			if (!actual.isEmpty()) {
				combinaciones.add(new ArrayList<>(actual));
			}
			return;
		}
		actual.add(prods.get(indice));
		generarCombinaciones(prods, indice + 1, actual);
		actual.remove(actual.size() - 1);
		generarCombinaciones(prods, indice + 1, actual);
	}
	
	public void imprimir()
	{
		System.out.println("Todas las combinaciones posibles:");
		for (ArrayList<String> comb : combinaciones) {
			System.out.println(comb);
		}
	}
}

public class Ejercicio8 {
	public static void main(String[] args) {
		Venta v = new Venta();
		v.combinaciones();
		v.imprimir();
	}
}