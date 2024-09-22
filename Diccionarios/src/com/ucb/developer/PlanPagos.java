package com.ucb.developer;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Scanner;

public class PlanPagos {
    static class Cuota {
        int nNumero;
        LocalDateTime dFecha;
        double nCapital;
        double nInteres;

        public Cuota(int nro, LocalDateTime fecha, double capital, double interes) {
            this.nNumero = nro;
            this.dFecha = fecha;
            this.nCapital = capital;
            this.nInteres = interes;
        }

        @Override
        public String toString() {
            return nNumero + "\t" + dFecha.toLocalDate() + "\t" + nCapital + "\t" + nInteres;
        }
    }

    static class ListaPagos {
        private LinkedList<Cuota> oLista;

        public ListaPagos() {
            oLista = new LinkedList<>();
        }

        public void agregarNodo(int cuota, LocalDateTime fecha, double capital, double interes) {
            Cuota oCuota = new Cuota(cuota, fecha, capital, interes);
            oLista.add(oCuota);
        }

        public void mostrarLista() {
            if (oLista.isEmpty()) {
                System.out.println("La lista está vacía.");
                return;
            }

            for (Cuota item : oLista) {
                System.out.println(item);
            }
        }
    }

    public static void main(String[] args) {
        ListaPagos lista = new ListaPagos();
        double capInicial = 200;
        double intInicial = 800;
        double capital = capInicial;
        double interes = intInicial;
        LocalDateTime fecha = LocalDateTime.now();
        int cuota = 1;
        while (capital <= intInicial && interes >= capInicial) {
            lista.agregarNodo(cuota, fecha, capital, interes);
            fecha = fecha.plusMonths(1);
            cuota++;
            capital += 100;
            interes -= 100;
        }

        System.out.println("Cuota\t Fecha\t Capital\t Interes");
        lista.mostrarLista();

        Scanner oLector = new Scanner(System.in);
        System.out.println("PAGO PRESTAMO");
        double montoPres;
        double interesPorc;
        double montoCuota;
        int nCuotas;
        System.out.println("Ingresar Monto Prestamo: ");
        montoPres = oLector.nextDouble();
        System.out.println("Ingresar Porcentaje Interes: ");
        interesPorc = oLector.nextDouble();
        System.out.println("Ingresar total cuotas: ");
        nCuotas = oLector.nextInt();
        String cadInteres = String.format("%.4f", interesPorc / 100.0);
        interesPorc = Double.parseDouble(cadInteres.replace(',', '.'));
        montoCuota = (interesPorc * (Math.pow((interesPorc + 1), nCuotas)) * montoPres) / ((Math.pow((interesPorc + 1), nCuotas)) - 1);
        System.out.println("Monto Cuota: " + montoCuota);
        // double interesPagado = saldo * tasaInteresPeriodica;
        // double capitalPagado = cuotaX - interesPagado;
        // saldo -= capitalPagado; P=893,49   I=8,99   NC=7  CUOTA=177,47
        // =(INTERES *(1+INTERES)^CUOTAS)*PRESTAMO/(((1+INTERES)^CUOTAS)-1)
        oLector.close();
    }
}
