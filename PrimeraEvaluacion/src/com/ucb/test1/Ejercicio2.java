package com.ucb.test1;
import java.util.ArrayList;
import java.util.Scanner;

class SerieB {
	ArrayList<ArrayList<Integer>> pascal;
	
	public SerieB(int filas)
	{
		pascal = new ArrayList<>();
		for (int i = 0; i < filas; i++) {
            ArrayList<Integer> fila = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                	fila.add(1);
                } else {
                    int value = pascal.get(i - 1).get(j - 1) + pascal.get(i - 1).get(j);
                    fila.add(value);
                }
            }
            pascal.add(fila);
        }
	}
	public void imprimir()
	{
		System.out.println("Triángulo de Pascal:");
        for (ArrayList<Integer> row : pascal) {
            System.out.println(row);
        }
	}
}

public class Ejercicio2 {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        System.out.println("Triangulo Pascal: Ingrese limite de filas: ");
        int n = sc.nextInt();
        SerieB s = new SerieB(n);
        s.imprimir();
    }
}
