package com.ucb.ias;

import java.util.*;

class NodoGrafo {
    int id;
    double gPeso;       // Costo desde el nodo inicial hasta el nodo actual
    double hPeso;       // Heurística (estimación del costo hasta el objetivo)
    double fPeso;       // fPeso = gPeso + hPeso
    List<EnlaceGrafo> vecinos;
    NodoGrafo padre;

    public NodoGrafo(int id, double hPeso) {
        this.id = id;
        this.hPeso = hPeso;
        this.gPeso = Double.POSITIVE_INFINITY;
        this.fPeso = Double.POSITIVE_INFINITY;
        this.vecinos = new ArrayList<>();
        this.padre = null;
    }
}

class EnlaceGrafo {
    NodoGrafo destino;
    double costo;

    public EnlaceGrafo(NodoGrafo destino, double costo) {
        this.destino = destino;
        this.costo = costo;
    }
}

public class ThetaStar {
    public List<NodoGrafo> buscar(NodoGrafo inicio, NodoGrafo meta) {
        PriorityQueue<NodoGrafo> conjuntoAbierto = 
        		new PriorityQueue<>(Comparator.comparingDouble(n -> n.fPeso));
        Set<NodoGrafo> conjuntoCerrado = new HashSet<>();
        inicio.gPeso = 0;
        inicio.fPeso = inicio.hPeso;
        conjuntoAbierto.add(inicio);

        while (!conjuntoAbierto.isEmpty()) {
            NodoGrafo actual = conjuntoAbierto.poll();
            if (actual.equals(meta)) {
                return reconstruirRuta(actual);
            }
            conjuntoCerrado.add(actual);
            for (EnlaceGrafo enlace : actual.vecinos) {
                NodoGrafo vecino = enlace.destino;
                if (conjuntoCerrado.contains(vecino)) 
                	continue;
                double costoGTentativo;
                if (actual.padre != null && lineaVista(actual.padre, vecino)) {
                    costoGTentativo = actual.padre.gPeso + distancia(actual.padre, vecino);
                    vecino.padre = actual.padre;
                } else {
                    costoGTentativo = actual.gPeso + enlace.costo;
                    vecino.padre = actual;
                }
                if (costoGTentativo < vecino.gPeso) {
                    vecino.gPeso = costoGTentativo;
                    vecino.fPeso = costoGTentativo + vecino.hPeso;

                    if (!conjuntoAbierto.contains(vecino)) {
                        conjuntoAbierto.add(vecino);
                    }
                }
            }
        }
        return Collections.emptyList(); // No hay camino
    }

    private boolean lineaVista(NodoGrafo inicio, NodoGrafo fin) {
        // Aquí debería implementarse la verificación de línea de visión
        // Por simplicidad, asumimos que no hay obstáculos entre nodos
        return true;
    }

    private double distancia(NodoGrafo a, NodoGrafo b) {
        return Math.hypot(a.id - b.id, a.id - b.id); // Distancia euclidiana
    }

    private List<NodoGrafo> reconstruirRuta(NodoGrafo actual) {
        List<NodoGrafo> ruta = new ArrayList<>();
        while (actual != null) {
            ruta.add(actual);
            actual = actual.padre;
        }
        Collections.reverse(ruta);
        return ruta;
    }
    
    public static void main(String[] args) {
        // Crear nodos con heurística inicial (ejemplo arbitrario)
        NodoGrafo inicio = new NodoGrafo(1, 10);
        NodoGrafo nodo2 = new NodoGrafo(2, 8);
        NodoGrafo nodo3 = new NodoGrafo(3, 5);
        NodoGrafo meta = new NodoGrafo(4, 0);  // Heurística de 0 para el nodo objetivo

        // Conectar nodos con aristas (coste arbitrario)
        inicio.vecinos.add(new EnlaceGrafo(nodo2, 1.5));
        inicio.vecinos.add(new EnlaceGrafo(nodo3, 2.0));
        nodo2.vecinos.add(new EnlaceGrafo(meta, 3.0));
        nodo3.vecinos.add(new EnlaceGrafo(meta, 1.0));
        nodo2.vecinos.add(new EnlaceGrafo(nodo3, 0.5)); // Camino adicional entre nodos

        // Crear instancia del algoritmo Theta*
        ThetaStar t = new ThetaStar();
        // Ejecutar búsqueda desde start a goal
        List<NodoGrafo> ruta = t.buscar(inicio, meta);
        // Imprimir el resultado
        if (ruta.isEmpty()) {
            System.out.println("No se encontró un camino.");
        } else {
            System.out.print("Camino encontrado: ");
            for (NodoGrafo node : ruta) {
                System.out.print(node.id + " ");
            }
            System.out.println();
        }
    }
}
