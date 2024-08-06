/** Clase que representa una computadora portatil. */
public class Portatil extends Computadora {
	// Campos de datos
	private static final String DEFAULT_POR_FAB = "MarcaX";
	private double tamanoPantalla;
	private double peso;

	public double getTamanoPantalla() {
		return tamanoPantalla;
	}

	public void setTamanoPantalla(double tamanoPantalla) {
		this.tamanoPantalla = tamanoPantalla;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	// Metodos
	/**
	 * Inicia el portatil con las propiedades especificadas
	 * 
	 * @param fab     The computer manufacturer
	 * @param proc    The processor type
	 * @param ram     The RAM size
	 * @param disco   The disk size
	 * @param velProc The processor speed
	 */
	public Portatil(String fab, String proc, double ram, int disco, double velProc) {
		super(fab, proc, ram, disco, velProc);
		this.tamanoPantalla = 0;
		this.peso = 0;
	}

	/** Initializes a Notebook object with 6 properties specified. */
	public Portatil(String fab, int ram, int disco, double velProc, double pantalla, double peso) {
		this(DEFAULT_POR_FAB, fab, ram, disco, velProc, pantalla, peso);
	}

	/**
	 * Inicia el portatil con las propiedades especificadas
	 * 
	 * @param fab      The computer manufacturer
	 * @param proc     The processor type
	 * @param ram      The RAM size
	 * @param disco    The disk size
	 * @param velProc  The processor speed
	 * @param pantalla The screen size
	 * @param peso     The weight
	 */
	public Portatil(String fab, String proc, double ram, int disco, double velProc, double pantalla, double peso) {
		super(fab, proc, ram, disco, velProc);
		this.tamanoPantalla = pantalla;
		this.peso = peso;
	}

	public String toString() {
		String result = super.toString() + "\nTamaño pantalla: " + tamanoPantalla + " pulg." 
				+ "\nPeso: " + peso	+ " kg.";
		return result;
	}
}
