 package com.ucb.test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class SerieI {
	Set<Integer> serie;
	ArrayList<Integer> listaSerie;
	int limite;
	// 1,2,4,5,8,9,10,13,16,17,18,...

	public SerieI(int n) {
		this.limite = n;
		serie = new HashSet<>();
		//Generar los términos de la serie
		for (int i = 0; i < n; i++) {   
			for (int j = 0; j <= i; j++) {
				int suma = i * i + j * j;
				if (suma != 0) {
					serie.add(suma);
				}
			}
		}
		
		// Convertir el conjunto a una lista, ordenar y eliminar duplicados
		listaSerie = new ArrayList<>(serie);
		Collections.sort(listaSerie);
	}

	
	public void imprimir() {
		System.out.println();
		System.out.println("Los primeros " + limite + " términos de la serie son:");
        for (int i = 0; i < Math.min(limite, listaSerie.size()); i++) {
            System.out.print(listaSerie.get(i) + " ");
        }
	}
}

public class Ejercicio9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("SERIE: Ingrese limite de la serie: ");
		int n = sc.nextInt();
		SerieI s = new SerieI(n);
		s.imprimir();
	}
}
