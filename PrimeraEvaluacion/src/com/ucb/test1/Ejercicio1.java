package com.ucb.test1;
import java.util.ArrayList;
import java.util.Scanner;

class SerieA{
	private ArrayList<Integer> serie;
	
	public SerieA(int n)
	{
		serie = new ArrayList<>();
		serie.add(1);
		serie.add(1);
		int siguiente = 0;
        for (int i = 2; i < n; i++) {
        	if(serie.get(i - 1) % 2 != 0)
        		siguiente = serie.get(i - 1) + serie.get(i - 2);
        	else
        		siguiente = serie.get(i - 1) + serie.get(i - 2) + serie.get(i - 3);
            serie.add(siguiente);
        }
	}
	// 1, 1, 2, 4, 7, 11, 18, 36, 65,...
	public void imprimir()
	{
		System.out.println("Serie generada: " + serie);
	}
}

public class Ejercicio1 {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("SERIE: Ingrese limite de la serie: ");
        int n = sc.nextInt();
        SerieA s = new SerieA(n);
        s.imprimir();
    }
}
