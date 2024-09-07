package com.ucb.test1;
import java.util.ArrayList;
import java.util.Scanner;

class SerieC {
	ArrayList<Integer> coeficiente;
	int fila;
	
	public SerieC(int filas)
	{
		this.fila = filas;
		this.coeficiente = new ArrayList<>();
		this.coeficiente.add(1); // Primer coeficiente siempre es 1
        for (int i = 1; i <= filas; i++) {
        	this.coeficiente.add((this.coeficiente.get(i - 1) * (filas - i + 1)) / i);
        }
	}
	public void imprimir()
	{
		System.out.println("Coeficientes de la expansión de (a + b)^" + this.fila + ": " + this.coeficiente);
	}
}

public class Ejercicio3 {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        System.out.println("Binomio de Newton: Ingrese limite superior: ");
        int n = sc.nextInt();
        SerieC s = new SerieC(n);
        s.imprimir();
    }
}