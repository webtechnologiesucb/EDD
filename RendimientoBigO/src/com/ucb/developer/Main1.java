package com.ucb.developer;

public class Main1 {
	//Ejemplos de complejitud
    // O(n) - Recorrer un arreglo y sumar sus elementos
    public static int linearFunction(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    // O(n^2) - Verificar si hay pares duplicados en un arreglo
    public static boolean quadraticFunction(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // O(n^3) - Encontrar todas las tripletas que suman cero
    public static void cubicFunction(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (array[i] + array[j] + array[k] == 0) {
                        System.out.println("Tripleta encontrada: " + array[i] + ", " + array[j] + ", " + array[k]);
                    }
                }
            }
        }
    }

    // O(n!) - Generar todas las permutaciones de una cadena
    public static void factorialFunction(String str) {
        permutar(str, "");
    }

    private static void permutar(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                permutar(str.substring(0, i) + str.substring(i + 1), prefix + str.charAt(i));
            }
        }
    }

    // O(log n) - Búsqueda binaria en un arreglo ordenado
    public static int funcionLogaritmica(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Elemento no encontrado
    }

    // O(n log n) - Ordenamiento por mezcla (Merge Sort)
    public static void nLogNFunction(int[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;

            // Dividir el arreglo en dos mitades
            int[] left = new int[mid];
            int[] right = new int[array.length - mid];

            System.arraycopy(array, 0, left, 0, mid);
            System.arraycopy(array, mid, right, 0, array.length - mid);

            // Ordenar cada mitad
            nLogNFunction(left);
            nLogNFunction(right);

            // Combinar las mitades ordenadas
            merge(array, left, right);
        }
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0; // Índice para el arreglo izquierdo
        int j = 0; // Índice para el arreglo derecho
        int k = 0; // Índice para el arreglo combinado

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Copiar los elementos restantes
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }
    
    // Función recursiva para calcular el factorial de n
    public static int factorial(int n) {
        if (n == 0 || n == 1) { 
            return 1; // Caso base: 0! = 1 y 1! = 1
        } else {
            return n + factorial(n - 1); // Llamada recursiva  O(n)
        }
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        // O(n)
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("Suma: " + linearFunction(array));

        // O(n^2)
        int[] arrayWithDuplicates = {1, 2, 3, 2};
        System.out.println("Tiene duplicados: " + quadraticFunction(arrayWithDuplicates));

        // O(n^3)
        int[] arrayForTriplets = {-1, 0, 1, 2, -1, -4};
        cubicFunction(arrayForTriplets);

        // O(n!)
        String str = "ABC";
        System.out.println("Permutaciones de " + str + ":");
        factorialFunction(str);

        // O(log n)
        int[] sortedArray = {1, 2, 3, 4, 5, 6};
        int target = 4;
        int index = funcionLogaritmica(sortedArray, target);
        System.out.println("Elemento encontrado en el índice: " + index);

        // O(n log n)
        int[] arrayToSort = {5, 2, 4, 6, 1, 3};
        nLogNFunction(arrayToSort);
        System.out.println("Arreglo ordenado:");
        for (int num : arrayToSort) {
            System.out.print(num + " ");
        }
    }
}
