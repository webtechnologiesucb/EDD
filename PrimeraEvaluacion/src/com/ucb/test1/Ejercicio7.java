package com.ucb.test1;
import java.util.ArrayList;
import java.util.Scanner;

// 1, 11, 21, 1211, 111221, 312211...
class SerieG{
	private ArrayList<String> serie;
	
	public SerieG(int n)
	{
		serie = new ArrayList<>();
		serie.add("1");
        for (int i = 1; i < n; i++) {
        	String terminoPrevio = serie.get(i-1);
        	String siguienteTermino = generarSiguiente(terminoPrevio);
        	serie.add(siguienteTermino);
        }
	}
	
	public String generarSiguiente(String valor) {
		StringBuilder sig = new StringBuilder();
		int cont = 1;
		
		for (int i = 1; i < valor.length(); i++) {
			if (valor.charAt(i) == valor.charAt(i - 1)) {
				cont++;
            } else {
            	sig.append(cont).append(valor.charAt(i - 1));
                cont = 1;
            }
		}

        sig.append(cont).append(valor.charAt(valor.length() - 1));
        return sig.toString();
	}
	
	public void imprimir()
	{
		System.out.println("Serie generada: " + serie);
	}
}

public class Ejercicio7 {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("SERIE: Ingrese limite de la serie: ");
        int n = sc.nextInt();
        SerieG s = new SerieG(n);
        s.imprimir();
    }
}
