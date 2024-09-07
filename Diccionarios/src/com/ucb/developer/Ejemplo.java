package com.ucb.developer;

import java.util.Scanner;

public class Ejemplo {

	public static void main(String[] args) {
		// cargar datos
		Scanner sc = new Scanner(System.in);
		int a, b;
		System.out.print("Ingrese el valor de a: ");
		a = sc.nextInt();
		sc.nextLine();
		System.out.print("Ingrese el valor de b: ");
		b = sc.nextInt();
		sc.nextLine();
		int suma = a + b;
		System.out.println("La suma es: " + suma);	
	}
}
