package com.ucb.tree;

class Nodo {
	int valor;
	Nodo izq, der;
	
	public Nodo(int valor) {
		this.valor = valor;
		izq = null;
		der = null;
	}
}

public class ArbolBinario {
	Nodo raiz;
	
	public ArbolBinario() {
		raiz = null;
	}
	
	public void insertar(int valor) {
		raiz = insertarRec(raiz, valor);
	}
	
	public Nodo insertarRec(Nodo raiz, int valor) {
		if (raiz == null) {
			raiz = new Nodo(valor);
			return raiz;
		}
		if (valor < raiz.valor) {
			raiz.izq = insertarRec(raiz.izq, valor);
		} else if (valor > raiz.valor) {
			raiz.der = insertarRec(raiz.der, valor);
		}
		return raiz;
	}
	
	public void recorridoInOrden() {
		inOrden(raiz);
	}
	
	public void recorridoPreOrden() {
		preOrden(raiz);
	}
	
	public void recorridoPostOrden() {
		postOrden(raiz);
	}
	
	public void inOrden(Nodo raiz) {
		if (raiz != null) {
			inOrden(raiz.izq);
			System.out.print(raiz.valor + " ");
			inOrden(raiz.der);
		}
	}
	
	public void preOrden(Nodo raiz) {
		if (raiz != null) {
			System.out.print(raiz.valor + " ");
			preOrden(raiz.izq);
			preOrden(raiz.der);
		}
	}
	
	public void postOrden(Nodo raiz) {
		if (raiz != null) {			
			postOrden(raiz.izq);
			postOrden(raiz.der);
			System.out.print(raiz.valor + " ");
		}
	}
	
	public boolean buscar(int valor) {
		return buscarRec(raiz, valor);
	}
	
	public boolean buscarRec(Nodo raiz, int valor) {
		if (raiz==null) {
			return false;
		}
		if(valor == raiz.valor) {
			return true;
		}
		return valor < raiz.valor ? buscarRec(raiz.izq, valor) : buscarRec(raiz.der, valor);
	}
	
	public int altura() {
		return alturaRec(raiz);
	}
	
	public int alturaRec(Nodo raiz) {
		if (raiz == null) {
			return 0;
		}
		int altIzq = alturaRec(raiz.izq);
		int altDer = alturaRec(raiz.der);
		return Math.max(altIzq, altDer) + 1;
	}
	
	public int amplitud() {
		int altura = altura();
		int maxAmplitud = 0;
		for (int nivel = 1; nivel <= altura; nivel++) {
			int amplitudNivel = contarNodosEnNivel(raiz, nivel);
			maxAmplitud = Math.max(maxAmplitud, amplitudNivel);
		}
		return maxAmplitud;
	}
	
	private int contarNodosEnNivel(Nodo raiz, int nivel) {
		if (raiz == null) {
			return 0;
		}
		if (nivel == 1) {
			return 1;
		}
		return contarNodosEnNivel(raiz.izq, nivel - 1) 
				+ contarNodosEnNivel(raiz.der, nivel - 1);
	}
	
	public static void main(String[] args) {
		ArbolBinario ab = new ArbolBinario();
		ab.insertar(50);
		ab.insertar(30);
		ab.insertar(20);
		ab.insertar(40);
		ab.insertar(70);
		ab.insertar(60);
		ab.insertar(80);
		
		System.out.println("Recorrido in orden");
		ab.recorridoInOrden();
		System.out.println();
		System.out.println("Recorrido pre orden");
		ab.recorridoPreOrden();
		System.out.println();
		System.out.println("Recorrido post orden");
		ab.recorridoPostOrden();
		System.out.println();
		System.out.println("Busqueda 50: " + ab.buscar(50));
		System.out.println("Busqueda 71: " + ab.buscar(71));
		
		System.out.println("Altura: " + ab.altura());
		System.out.println("Amplitud: " + ab.amplitud());
	}
}
