package com.ucb.test1;
import java.util.ArrayList;
import java.util.Scanner;

// Serie 1, 4, 9, 61, 52, 63, 94...
class SerieE{
	private ArrayList<Integer> serie;
	
	public SerieE(int n)
	{
		serie = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
        	int potencia = i * i;
            serie.add(invertirNumero(potencia));
        }
	}
	
	public int invertirNumero(int n) {
		int nuevo = 0;
		while (n>0) {
			int digito = n % 10;
			nuevo = nuevo * 10 + digito;
			n = n / 10;
		}
		return nuevo;
	}
	
	public void imprimir()
	{
		System.out.println("Serie generada: " + serie);
	}
}

public class Ejercicio5 {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("SERIE: Ingrese limite de la serie: ");
        int n = sc.nextInt();
        SerieE s = new SerieE(n);
        s.imprimir();
    }
}
