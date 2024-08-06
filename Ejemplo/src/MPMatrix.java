import java.util.Random;

public class MPMatrix {
	// Definir el tamaño del array bidimensional y el límite superior 
    private int filas;
    private int columnas;
    private int limite;
    private double[][] matriz;
    
    public MPMatrix() {
    	this.filas = 4;
    	this.columnas = 4;
    	this.limite = 100;
    	this.matriz = generadorAleatorio(filas, columnas, limite);
    }
    
    public MPMatrix(int filas, int columnas, int limite) {
    	this.filas = filas;
    	this.columnas = columnas;
    	this.limite = limite;
    	this.matriz = generadorAleatorio(filas, columnas, limite);
    }

	public double[][] generadorAleatorio(int filas, int columnas, int limite) {
        Random random = new Random();
        matriz = new double[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
            	matriz[i][j] = random.nextInt(limite);
            }
        }
        return matriz;
    }
	
	// Método para calcular el determinante de una matriz n*n
    public void determinante() {
        int n = matriz.length;
        double det = 1;
        double[][] mat = copiar(matriz);

        for (int i = 0; i < n; i++) {
            int pivot = i;
            // Buscar el pivote
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(mat[j][i]) > Math.abs(mat[pivot][i])) {
                    pivot = j;
                }
            }
            // Intercambiar filas si es necesario
            if (i != pivot) {
                double[] temp = mat[i];
                mat[i] = mat[pivot];
                mat[pivot] = temp;
                det *= -1;
            }
            // Si el pivote es cero, el determinante es cero
            if (mat[i][i] == 0) {
                det = 0;
            }
            det *= mat[i][i];
            // Eliminar elementos debajo del pivote
            for (int j = i + 1; j < n; j++) {
                double factor = mat[j][i] / mat[i][i];
                for (int k = i; k < n; k++) {
                    mat[j][k] -= factor * mat[i][k];
                }
            }
        }
        System.out.println("Determinante: " + det);
    }

    // Método para calcular la inversa de una matriz n*n
    public double[][] inversa() {
        int n = matriz.length;
        double[][] mat = copiar(matriz);
        double[][] inv = new double[n][n];
        // Inicializar la matriz identidad
        for (int i = 0; i < n; i++) {
            inv[i][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            int pivot = i;
            // Buscar el pivote
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(mat[j][i]) > Math.abs(mat[pivot][i])) {
                    pivot = j;
                }
            }
            // Intercambiar filas en ambas matrices si es necesario
            if (i != pivot) {
                double[] temp = mat[i];
                mat[i] = mat[pivot];
                mat[pivot] = temp;
                temp = inv[i];
                inv[i] = inv[pivot];
                inv[pivot] = temp;
            }
            // Si el pivote es cero, la matriz no tiene inversa
            if (mat[i][i] == 0) {
                throw new ArithmeticException("La matriz no tiene inversa porque su determinante es 0.");
            }
            // Normalizar la fila del pivote
            double pivotValue = mat[i][i];
            for (int j = 0; j < n; j++) {
                mat[i][j] /= pivotValue;
                inv[i][j] /= pivotValue;
            }
            // Eliminar los elementos por encima y por debajo del pivote
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    double factor = mat[j][i];
                    for (int k = 0; k < n; k++) {
                        mat[j][k] -= factor * mat[i][k];
                        inv[j][k] -= factor * inv[i][k];
                    }
                }
            }
        }
        return inv;
    }
    

    // Método para copiar una matriz
    private double[][] copiar(double[][] matrix) {
        int n = matrix.length;
        double[][] copy = new double[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, copy[i], 0, n);
        }
        return copy;
    }
    
    public void imprimir() {
        for (double[] row : matriz) {
            for (double element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }
    
    public void imprimirInversa() {
    	double[][] inv = inversa(); 
        for (double[] row : inv) {
            for (double element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }
}
