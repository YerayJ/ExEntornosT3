package examen;

/**
 * Clase que hace una fracción de dos números
 * @author yjimenez
 *
 */
public class Fraccion {
	/**
	 * Esta variable es el numerador
	 */
	private int num;

	/**
	 * Esta variable es el denominador
	 */
	private int den;

	/**
	 * Constructor por defecto
	 */
	public Fraccion() { // debe generar el valor neutro que es 0/1
		num = 0;
		den = 1;
	}

	/**
	 * Constructor con parámetros
	 * @param num Es el numerador
	 * @param den Es el denominador
	 */
	public Fraccion(int num, int den) {
		// debo evitar crear fracciones con 0 en el divisor
		this.num = num;
		if (den == 0) {
			this.den = 1;}
		else {
			this.den = den;
		// devuelvo la fracci�n simplificada
		simplificar(); }
	}

	/**
	 * Constructor copia
	 * @param fraccion Es la variable que contendrá la fracción
	 */
	public Fraccion(final Fraccion fraccion) {
		num = fraccion.num;
		den = fraccion.den;
	}

	/**
	 * Setter
	 * @param num La variable numerador
	 */
	public void setNum(int num) {
		this.num = num;

	}
	/**
	 * Getter
	 * @return devuelve el número
	 */
	public int getNum() {
		return num;

	}
	/**
	 * Setter
	 * @param den La variable denominador
	 */
	public void setDen(int den) {
		this.den = den;
	}
	/**
	 * Getter
	 * @return devuelve la variable denominador
	 */
	public int getDen() {
		return den;
	}

	/**
	 * Función que calcula el máximo común divisor por el algoritmo de Euclides
	 * @return devuelve la variable u que es el valor absoluto del numerador
	 */
	private int maxComunDivisor() {
		int resultado = 0;
		int numerador = Math.abs(num); // valor absoluto del numerador
		int denominador = Math.abs(den); // valor absoluto del denominador
		if (denominador == 0) {
			resultado =  numerador;
		}
		int result;
		while (denominador != 0) {
			result = numerador % denominador;
			numerador = denominador;
			denominador = result;
		}
		return resultado;
	}

	/**
	 * Método para simplificar fracciones
	 */
	public void simplificar() {
		int valor = maxComunDivisor();
		num = num / valor;
		den = den / valor;
	}

	/**
	 * Método para pasar variables a una cadena
	 */
	public String toString() {
		return num + "/" + den;

	}

	/**
	 * Suma de fracciones
	 * @param fracción variable fracción
	 * @return devuelve la suma de estos
	 */
	public Fraccion sumar(Fraccion fracción) {
		Fraccion aux = new Fraccion();
		int cruce1 = num * fracción.den;
		int cruce2 = den * fracción.num;
		aux.num = cruce1 + cruce2;
		aux.den = cruce2;
		aux.simplificar();
		return aux;

	}

	/**
	 * Resta de fracciones
	 * @param fraccion variable fracción
	 * @return devuelve la resta de estos
	 */
	public Fraccion restar(Fraccion fraccion) {
		Fraccion aux = new Fraccion();
		int cruce1 = num * fraccion.den;
		int cruce2 = den * fraccion.num;
		aux.num = cruce1 - cruce2;
		aux.den = cruce2;
		aux.simplificar();
		return aux;

	}

	/**
	 * Multiplicación de fracciones
	 * @param fraccion variable fracción
	 * @return devuelve la multiplicación de estos
	 */
	public Fraccion multiplicar(Fraccion fraccion) {
		Fraccion aux = new Fraccion();
		aux.num = num * fraccion.num;
		aux.den = den * fraccion.den;
		aux.simplificar();
		return aux;

	}

	/**
	 * División de fracciones
	 * @param fraccion variable fracción
	 * @return devuelve la división de estos
	 */
	public Fraccion dividir(Fraccion fraccion) {
		Fraccion aux = new Fraccion();
		aux.num = num * fraccion.den;
		aux.den = den * fraccion.num;
		aux.simplificar();
		return aux;

	}

}
