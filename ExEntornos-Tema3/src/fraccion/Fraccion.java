package fraccion;

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
		if (den == 0)
			this.den = 1;
		else
			this.den = den;
		// devuelvo la fracci�n simplificada
		simplificar();
	}

	/**
	 * Constructor copia
	 * @param f Es la variable que contendrá la fracción
	 */
	public Fraccion(final Fraccion f) {
		num = f.num;
		den = f.den;
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
	private int mcd() {
		int u = (Math.abs(num)); // valor absoluto del numerador
		int v = (Math.abs(den)); // valor absoluto del denominador
		if (v == 0) {
			return u;
		}
		int r;
		while (v != 0) {
			r = u % v;
			u = v;
			v = r;
		}
		return u;
	}

	/**
	 * Método para simplificar fracciones
	 */
	public void simplificar() {
		int n = mcd();
		num = num / n;
		den = den / n;
	}

	/**
	 * Método para pasar variables a una cadena
	 */
	public String toString() {
		String mensaje = num + "/" + den;
		return mensaje;

	}

	/**
	 * Suma de fracciones
	 * @param f variable fracción
	 * @return devuelve la suma de estos
	 */
	public Fraccion sumar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den + den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

	/**
	 * Resta de fracciones
	 * @param f variable fracción
	 * @return devuelve la resta de estos
	 */
	public Fraccion restar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den - den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

	/**
	 * Multiplicación de fracciones
	 * @param f variable fracción
	 * @return devuelve la multiplicación de estos
	 */
	public Fraccion multiplicar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

	/**
	 * División de fracciones
	 * @param f variable fracción
	 * @return devuelve la división de estos
	 */
	public Fraccion dividir(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den;
		aux.den = den * f.num;
		aux.simplificar();
		return aux;

	}

}
