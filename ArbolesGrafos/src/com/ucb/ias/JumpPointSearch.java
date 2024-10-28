package com.ucb.ias;

import java.util.*;

class GrillaNodo {
    int x, y;
    double gPeso;
    double hPeso;
    double fPeso;
    GrillaNodo padre;

    public GrillaNodo(int x, int y, double hPeso) {
        this.x = x;
        this.y = y;
        this.hPeso = hPeso;
        this.gPeso = Double.POSITIVE_INFINITY;
        this.fPeso = Double.POSITIVE_INFINITY;
        this.padre = null;
    }

    public boolean equals(Object o) {
        if (this == o) 
        	return true;
        if (o == null || getClass() != o.getClass()) 
        	return false;
        GrillaNodo nodo = (GrillaNodo) o;
        return x == nodo.x && y == nodo.y;
    }

    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class JumpPointSearch {
    private static final int[][] DIRECCIONES = 
    	{{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    private GrillaNodo[][] grilla;
    private GrillaNodo inicio, meta;

    public JumpPointSearch(GrillaNodo[][] grilla, GrillaNodo inicio, GrillaNodo meta) {
        this.grilla = grilla;
        this.inicio = inicio;
        this.meta = meta;
    }

    public List<GrillaNodo> buscar() {
        PriorityQueue<GrillaNodo> conjuntoAbierto = 
        		new PriorityQueue<>(Comparator.comparingDouble(n -> n.fPeso));
        Set<GrillaNodo> conjuntoCerrado = new HashSet<>();
        inicio.gPeso = 0;
        inicio.fPeso = heuristico(inicio, meta);
        conjuntoAbierto.add(inicio);

        while (!conjuntoAbierto.isEmpty()) {
            GrillaNodo actual = conjuntoAbierto.poll();
            if (actual.equals(meta)) {
                return rutaReconstruida(actual);
            }
            conjuntoCerrado.add(actual);

            for (int[] direccion : DIRECCIONES) {
                GrillaNodo saltoNodo = saltar(actual, direccion[0], direccion[1]);
                if (saltoNodo != null && !conjuntoCerrado.contains(saltoNodo)) {
                    double gPesoTentativo = actual.gPeso + distancia(actual, saltoNodo);
                    if (gPesoTentativo < saltoNodo.gPeso) {
                        saltoNodo.padre = actual;
                        saltoNodo.gPeso = gPesoTentativo;
                        saltoNodo.fPeso = gPesoTentativo + heuristico(saltoNodo, meta);
                        if (!conjuntoAbierto.contains(saltoNodo)) {
                            conjuntoAbierto.add(saltoNodo);
                        }
                    }
                }
            }
        }
        return Collections.emptyList(); // No hay camino
    }

    private GrillaNodo saltar(GrillaNodo actual, int dx, int dy) {
        int x = actual.x + dx;
        int y = actual.y + dy;
        if (!enLimites(x, y) || esBloqueo(x, y)) 
        	return null;
        GrillaNodo sig = grilla[x][y];

        if (sig.equals(meta)) 
        	return sig;
        if ((dx != 0 && dy != 0) && 
        		(esBloqueo(x - dx, y) || esBloqueo(x, y - dy))) 
        	return sig;
        if ((dx != 0 && saltar(sig, dx, 0) != null) || 
        		(dy != 0 && saltar(sig, 0, dy) != null)) 
        	return sig;
        return saltar(sig, dx, dy);
    }

    private boolean enLimites(int x, int y) {
        return x >= 0 && y >= 0 && x < grilla.length && y < grilla[0].length;
    }

    private boolean esBloqueo(int x, int y) {
        return grilla[x][y] == null; // Si es null, está bloqueado
    }

    private double distancia(GrillaNodo a, GrillaNodo b) {
        return Math.hypot(a.x - b.x, a.y - b.y);
    }

    private double heuristico(GrillaNodo a, GrillaNodo b) {
        return Math.hypot(a.x - b.x, a.y - b.y);
    }

    private List<GrillaNodo> rutaReconstruida(GrillaNodo actual) {
        List<GrillaNodo> ruta = new ArrayList<>();
        while (actual != null) {
            ruta.add(actual);
            actual = actual.padre;
        }
        Collections.reverse(ruta);
        return ruta;
    }
    
    public static void main(String[] args) {
        int filas = 5;
        int columnas = 5;

        // Crear la cuadrícula
        GrillaNodo[][] grilla = new GrillaNodo[filas][columnas];
        for (int x = 0; x < filas; x++) {
            for (int y = 0; y < columnas; y++) {
                grilla[x][y] = new GrillaNodo(x, y, 0); // Inicializar cada nodo sin heurística
            }
        }

        // Definir inicio y fin
        GrillaNodo inicio = grilla[0][0];
        GrillaNodo meta = grilla[4][4];
        inicio.hPeso = 0;
        meta.hPeso = 0;

        // Establecer obstáculos
        grilla[1][1] = null; // Nodo bloqueado
        grilla[1][2] = null;
        grilla[2][1] = null;
        grilla[3][3] = null;

        // Crear instancia del algoritmo JPS
        JumpPointSearch jps = new JumpPointSearch(grilla, inicio, meta);

        // Ejecutar búsqueda
        List<GrillaNodo> ruta = jps.buscar();

        // Imprimir el resultado
        if (ruta.isEmpty()) {
            System.out.println("No se encontró un camino.");
        } else {
            System.out.print("Camino encontrado: ");
            for (GrillaNodo nodo : ruta) {
                System.out.print("[" + nodo.x + ", " + nodo.y + "] ");
            }
            System.out.println();
        }
    }
}


