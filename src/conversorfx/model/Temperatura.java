package conversorfx.model;
public class Temperatura {
	//Atributos de la clase:
	private float grado;

	//Constructor:
	public Temperatura() {}
	
	public Temperatura(float grado) {
		this.grado = grado;
	}

	//Métodos:

	public void asignarGrado(float grado) {
		this.grado = grado;
	}

	public float obtenerGrado() {
		return grado;
	}

	/* Celsius a Fahrenheit */
	public float convertirCelsiusToFahrenheit() {
		return 9.0f/5.0f * grado + 32;
	}

	//método sobrecargado:
	public float convertirCelsiusToFahrenheit(float grado) {
		asignarGrado(grado);
		return 9.0f/5.0f * grado + 32;
	}

	/* Fahrenheit a Celsius*/
	public float convertirFahrenheitToCelsius() {
		return 5.0f/9.0f * (grado - 32);
	}

	//método sobrecargado:
	public float convertirFahrenheitToCelsius(float grado) {
		asignarGrado(grado);
		return 5.0f/9.0f * (grado - 32);
	}
}
