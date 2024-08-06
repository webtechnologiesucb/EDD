import java.util.Iterator;
import java.util.Random;

public class Main {

	public static void operacionTrad() {
		Random random = new Random();
		int total = 1000; //Definir el tamaño del array
		int[] vec = new int[total];

		for (int i = 0; i < vec.length; i++) {
			vec[i] = random.nextInt(100); //Genera un número aleatorio entre 0 y 99
		}
		//Imprimir los elementos del array
		System.out.println("Array de 1000 elementos aleatorios: ");
		for (int valor : vec) {
			System.out.print(valor + "\t");
		}
		System.out.println("");
	}

	// Método para intercambiar valores usando una clase auxiliar 
	// para simular referencias
	public static void intercambiar(NumeroEntero x, NumeroEntero y) {
		if (x.valor == y.valor) { // Verifica si los valores son iguales
			return;
		}
		x.valor = x.valor + y.valor;
		y.valor = x.valor - y.valor;
		x.valor = x.valor - y.valor;

		/* Con multiplicacion y division
		 * x.valor = x.valor * y.valor; 
		 * y.valor = x.valor / y.valor; 
		 * x.valor = x.valor / y.valor;
		 */
		/* Con el operador de bits XOR ^
		 * x.valor = x.valor ^ y.valor; 
		 * y.valor = x.valor ^ y.valor; 
		 * x.valor = x.valor ^ y.valor;
		 */
	}

	public static void main(String args[]) {
		System.out.println("Vectores usando clase optimizada");
		MPArray oVector = new MPArray(1000, 100);
		oVector.imprimir();
		
		System.out.println("Vectores usando programacion tradicional");
		operacionTrad();
		
		System.out.println("Intercambio optimo de 2 numeros");
		NumeroEntero oNum1 = new NumeroEntero(5);
		NumeroEntero oNum2 = new NumeroEntero(8);
		intercambiar(oNum1, oNum2);
		System.out.println(oNum1.valor + " " + oNum2.valor);
		
		System.out.println("Matrices usando clase optimizada");
		MPMatrix oMatriz = new MPMatrix(4, 4, 10);
		oMatriz.imprimir();
		oMatriz.determinante();
		System.out.println("Inversa: ");
		oMatriz.imprimirInversa();
		
		System.out.println("Ejemplo de generalización");
		Computadora c1 = new Computadora();
		Computadora c2 = new Computadora("Ace", "AMD", 8.0, 500, 3.5);
		Portatil c3 = new Portatil("Ace", "AMD", 4.0, 500, 3.0);
		Portatil c4 = new Portatil("Bravo", "Intel", 4.0, 750, 3.0, 15.5, 5.5);
		System.out.println(c2.getFabricante() + ", " + c4.getProcesador());
		System.out.println(c2.getTotalDisco() + ", " + c4.getTotalRAM());
		System.out.println(c2.toString() + "\n\n" + c4.toString());
		
		System.out.println("Ejemplo de Lista Personalizada");
		Lista<Integer> oLista = new Lista<>();
		oLista.add(1);
		oLista.add(2);
		oLista.add(3);
		
		oLista.insert(4, 1);

		Iterator<Integer> iterator = oLista.iterator();

        // Recorrer la lista usando el iterador
        while (iterator.hasNext()) {
            int item = iterator.next();
            System.out.print(item + "\t");
        }
        System.out.println();
        
        /* Otra forma de imprimir la lista
        System.out.println();
        for(int i =0; i< oLista.size(); i++){
            System.out.print(oLista.get(i)+ "\t");
        }
        System.out.println();
        */
	}
}
