import java.util.Random;
import java.util.stream.IntStream;

public class MPArray {
	private Random random = new Random();
	private int total;
	private int[] vec;
	private int limite;
	
	public MPArray() {
		this.total =  1000;
		this.limite = 1000;
		//para generar un flujo infinito de números aleatorios y limita este flujo a 1000 elementos
		this.vec = IntStream.generate(() -> random.nextInt(limite)).limit(total).toArray();
	}
	
	public MPArray(int total, int limite) {
		this.vec = IntStream.generate(() -> random.nextInt(limite)).limit(total).toArray();
	}
	
	public void imprimir() {
		for(int valor: vec) {
			System.out.print(valor + "\t");
		}
		System.out.println("");
	}
	
}
