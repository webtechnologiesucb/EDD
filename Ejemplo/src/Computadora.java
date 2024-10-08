/** Clase que representa un computador */
public class Computadora {
	// Campos de datos
	private String fabricante;
	private String procesador;
	private double totalRAM;
	private int totalDisco;
	private double velocidadProcesador;
	
	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getProcesador() {
		return procesador;
	}

	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}

	public double getTotalRAM() {
		return totalRAM;
	}

	public void setTotalRAM(double totalRAM) {
		this.totalRAM = totalRAM;
	}

	public int getTotalDisco() {
		return totalDisco;
	}

	public void setTotalDisco(int totalDisco) {
		this.totalDisco = totalDisco;
	}

	public double getVelocidadProcesador() {
		return velocidadProcesador;
	}

	public void setVelocidadProcesador(double velocidadProcesador) {
		this.velocidadProcesador = velocidadProcesador;
	}

	// Metodos
	public Computadora() {
		this.fabricante = "";
		this.procesador = "";
		this.totalRAM = 0;
		this.totalDisco = 0;
		this.velocidadProcesador = 0;
	}
	
	/**
	 * Inicia la computadora con los elementos definidos
	 * @param fab       Fabricante del equipo
	 * @param procesador Tipo de procesador
	 * @param ram       Tamaño de la RAM
	 * @param disco      Tamaño del disco
	 * @param velProc Velocidad del procesador
	 */
	public Computadora(String fab, String procesador, double ram, int disco, double velProc) {
		this.fabricante = fab;
		this.procesador = procesador;
		this.totalRAM = ram;
		this.totalDisco = disco;
		this.velocidadProcesador = velProc;
	}

	public double rendimientoComputadora() {
		return totalRAM * velocidadProcesador;
	}

	public double obtenerRAM() {
		return totalRAM;
	}

	public double obtenerVelocidadProcesador() {
		return velocidadProcesador;
	}

	public int obtenerDisco() {
		return totalDisco;
	}

	// Ingrese otros accesos o metodos aqui
	public String toString() {
		String result = "Fabricante: " + fabricante + "\nCPU: " 
				+ procesador + "\nRAM: " + totalRAM + " GB"
				+ "\nDisco: " + totalDisco + " GB" 
				+ "\nVelocidad procesador: " + velocidadProcesador + " GHz";
		return result;
	}
}
