package com.ucb.developer;

import java.util.LinkedList;

public class ListaEnlazadaSimpleMenu {
	private LinkedList<Integer> lista;

	public ListaEnlazadaSimpleMenu() {
		lista = new LinkedList<>();
		lista.add(5);
		lista.add(15);
		lista.add(25);
		lista.add(35);
	}

	public void agregarInicio(int valor) {
		lista.addFirst(valor);
	}

	public void agregarFinal(int valor) {
		lista.addLast(valor);
	}

	public void agregarPosicion(int posicion, int valor) {
		if (posicion >= 0 && posicion <= lista.size()) {
			lista.add(posicion, valor);
		} else {
			System.out.println("Posición inválida");
		}
	}

	public void eliminar(int posicion) {
		if (posicion >= 0 && posicion < lista.size()) {
			lista.remove(posicion);
		} else {
			System.out.println("Posición inválida");
		}
	}

	public void mostrar() {
		System.out.println(lista);
	}

	public int tamano() {
		return lista.size();
	}

	public static void main(String[] args) {
		ListaEnlazadaSimpleMenu menu = new ListaEnlazadaSimpleMenu();

		if (args.length > 0) {
			String operacion = args[0];

			switch (operacion) {
			case "agregar_inicio":
				if (args.length == 2) {
					int valor = Integer.parseInt(args[1]);
					menu.agregarInicio(valor);
				} else {
					System.out.println("Uso: java ListaEnlazadaSimpleMenu agregar_inicio <valor>");
				}
				break;
			case "agregar_final":
				if (args.length == 2) {
					int valor = Integer.parseInt(args[1]);
					menu.agregarFinal(valor);
				} else {
					System.out.println("Uso: java ListaEnlazadaSimpleMenu agregar_final <valor>");
				}
				break;
			case "agregar_posicion":
				if (args.length == 3) {
					int posicion = Integer.parseInt(args[1]);
					int valor = Integer.parseInt(args[2]);
					menu.agregarPosicion(posicion, valor);
				} else {
					System.out.println("Uso: java ListaEnlazadaSimpleMenu agregar_posicion <posicion> <valor>");
				}
				break;
			case "eliminar":
				if (args.length == 2) {
					int posicion = Integer.parseInt(args[1]);
					menu.eliminar(posicion);
				} else {
					System.out.println("Uso: java ListaEnlazadaSimpleMenu eliminar <posicion>");
				}
				break;
			case "mostrar":
				menu.mostrar();
				break;
			case "tamano":
				System.out.println("Tamaño de la lista: " + menu.tamano());
				break;
			default:
				System.out.println("Operación no reconocida");
				break;
			}
		} else {
			System.out.println("Uso: java ListaEnlazadaSimpleMenu <operacion> [<parametros>]");
		}
	}
}
