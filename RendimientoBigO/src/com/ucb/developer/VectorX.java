package com.ucb.developer;

import java.util.Random;

public class VectorX {

	public void verRendimiento() {
		// Diferentes tamaños de entrada
		int[] totales = { 1000, 2000, 4000, 8000, 16000, 32000 };
		Random random = new Random();

		for (int total : totales) {
			int[] vector = new int[total];
			for (int i = 0; i < total; i++) {
				// Llenar el array con números aleatorios
				vector[i] = random.nextInt(1000000);
			}
			// Número a buscar
			int objetivo = random.nextInt(1000000);

			long inicio = System.nanoTime();
			buscarLineal(vector, objetivo);
			long fin = System.nanoTime();
			long duracion = (fin - inicio) / 1000; // Tiempo en microsegundos

			System.out.println("Tamaño del array: " + total + 
					", Tiempo de búsqueda: " + duracion + " microsegundos");
		}
	}

	public int buscarLineal(int[] vec, int obj) {
		for (int i = 0; i < vec.length; i++) {
			if (vec[i] == obj) {
				return i; // Elemento encontrado
			}
		}
		return -1; // Elemento no encontrado
	}
}
