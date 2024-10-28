package com.ucb.ias;
import java.util.*;

class GrafoNodo {
    int id;
    double gPeso;       // Costo desde el nodo inicial hasta el nodo actual
    double hPeso;       // Heurística (estimación del costo hasta el objetivo)
    double fPeso;       // fPeso = gPeso + hPeso
    List<GrafoEnlace> vecinos;
    GrafoNodo padre;
    
    public GrafoNodo(int id, double hPeso) {
        this.id = id;
        this.hPeso = hPeso;
        this.gPeso = Double.POSITIVE_INFINITY;
        this.fPeso = Double.POSITIVE_INFINITY;
        this.vecinos = new ArrayList<>();
        this.padre = null;
    }
}

class GrafoEnlace {
    GrafoNodo destino;
    double costo;
    
    public GrafoEnlace(GrafoNodo destino, double costo) {
        this.destino = destino;
        this.costo = costo;
    }
}

public class AStar {
    public List<GrafoNodo> busqueda(GrafoNodo inicio, GrafoNodo meta) {
        PriorityQueue<GrafoNodo> conjuntoAbierto = new PriorityQueue<>(Comparator.comparingDouble(n -> n.fPeso));
        Set<GrafoNodo> conjuntoCerrado = new HashSet<>();
        inicio.gPeso = 0;
        inicio.fPeso = inicio.hPeso;
        conjuntoAbierto.add(inicio);

        while (!conjuntoAbierto.isEmpty()) {
            GrafoNodo actual = conjuntoAbierto.poll();
            if (actual.equals(meta)) {
                return reconstruirRuta(actual);
            }
            conjuntoCerrado.add(actual);

            for (GrafoEnlace vertice : actual.vecinos) {
                GrafoNodo vecino = vertice.destino;
                if (conjuntoCerrado.contains(vecino)) continue;

                double tentativoGCosto = actual.gPeso + vertice.costo;
                if (tentativoGCosto < vecino.gPeso) {
                    vecino.padre = actual;
                    vecino.gPeso = tentativoGCosto;
                    vecino.fPeso = tentativoGCosto + vecino.hPeso;
                    if (!conjuntoAbierto.contains(vecino)) {
                        conjuntoAbierto.add(vecino);
                    }
                }
            }
        }
        return Collections.emptyList(); // No hay camino
    }

    private List<GrafoNodo> reconstruirRuta(GrafoNodo actual) {
        List<GrafoNodo> ruta = new ArrayList<>();
        while (actual != null) {
            ruta.add(actual);
            actual = actual.padre;
        }
        Collections.reverse(ruta);
        return ruta;
    }
    
    public static void main(String[] args) {
        // Crear nodos con heurística inicial (ejemplo arbitrario)
    	GrafoNodo inicio = new GrafoNodo(1, 10);
    	GrafoNodo nodo2 = new GrafoNodo(2, 8);
    	GrafoNodo nodo3 = new GrafoNodo(3, 5);
    	GrafoNodo meta = new GrafoNodo(4, 0);  // Heurística de 0 para el nodo objetivo

        // Conectar nodos con aristas (coste arbitrario)
        inicio.vecinos.add(new GrafoEnlace(nodo2, 1.5));
        inicio.vecinos.add(new GrafoEnlace(nodo3, 2.0));
        nodo2.vecinos.add(new GrafoEnlace(meta, 3.0));
        nodo3.vecinos.add(new GrafoEnlace(meta, 1.0));
        nodo2.vecinos.add(new GrafoEnlace(nodo3, 0.5)); // Camino adicional entre nodos

        // Crear instancia del algoritmo A*
        AStar a = new AStar();
        // Ejecutar búsqueda desde start a goal
        List<GrafoNodo> ruta = a.busqueda(inicio, meta);

        // Imprimir el resultado
        if (ruta.isEmpty()) {
            System.out.println("No se encontró un camino.");
        } else {
            System.out.print("Camino encontrado: ");
            for (GrafoNodo nodo : ruta) {
                System.out.print(nodo.id + " ");
            }
            System.out.println();
        }
    }
}
