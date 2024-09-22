package com.ucb.developer;

import java.util.LinkedList;

public class ListaVectorial {
	static LinkedList<Integer> lista = new LinkedList<>();
	
	public static LinkedList<Integer> multiplicarEscalar(int k) {
		LinkedList<Integer> result = new LinkedList<Integer>();
        for (int component : lista) {
            result.add(component * k);
        }
        return result;
	}
	
	public static LinkedList<Integer> sumar(LinkedList<Integer> lista1, LinkedList<Integer> lista2) {
		LinkedList<Integer> result = new LinkedList<Integer>();
		if(lista1.size() == lista2.size()) {
			for (int i = 0; i < lista1.size(); i++) {
	            result.add(lista1.get(i) + lista2.get(i));
	        }
		}
        return result;
    }

	public static int multiplicar(LinkedList<Integer> lista1, LinkedList<Integer> lista2) {
		int res = 0;
		if(lista1.size() == lista2.size()) {
			for (int i = 0; i < lista1.size(); i++) {
	            res += lista1.get(i) * lista2.get(i);
	        }
		}
        return res;
    }
	
    public static void main(String[] args) {
        lista.add(5);
        lista.add(9);
        lista.add(14);
        lista.add(22);
        int k = 8;
        System.out.println("Lista Original:");
        for(int valor : lista)
        {
        	System.out.print(valor + "->");
        }
        System.out.println("NULL");
        System.out.println("Lista Original * escalar " + k + ":");
        for(int valor : multiplicarEscalar(k))
        {
        	System.out.print(valor + "->");
        }
        System.out.println("NULL");
        LinkedList<Integer> lista1 = new LinkedList<>();
        lista1.add(1);
        lista1.add(2);
        lista1.add(3);

        LinkedList<Integer> lista2 = new LinkedList<>();
        lista2.add(4);
        lista2.add(5);
        lista2.add(6);

        System.out.println("Lista 1:");
        for(int valor : lista1)
        {
        	System.out.print(valor + "->");
        }
        System.out.println("NULL");
        System.out.println("Lista 2:");
        for(int valor : lista2)
        {
        	System.out.print(valor + "->");
        }
        System.out.println("NULL");

        LinkedList<Integer> resultado = sumar(lista1, lista2);
        System.out.println("Resultado de la suma:");
        for(int valor : resultado)
        {
        	System.out.print(valor + "->");
        }
        System.out.println("NULL");
        
        int respuesta = multiplicar(lista1, lista2);
        System.out.println("Resultado de la multiplicacion: " + respuesta);
    }
}
