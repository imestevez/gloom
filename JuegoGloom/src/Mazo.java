import java.util.Random;

public class Mazo {

	public static final int CARTAS_MAZO = 78;
	private static CartaModificadora[] mazoCartas;
	private static int numCartas;

	public Mazo() {
		mazoCartas = new CartaModificadora[CARTAS_MAZO];
		numCartas = 78;
		// crear 17 cartas de muerte prematura
		int i = 0;
		for (; i < 17; i++)
			mazoCartas[i] = new CartaModificadora(true, -1, -1, -1);
		// crear 3 cartas de muerte prematura
		mazoCartas[i++] = new CartaModificadora(true, -15, -1, -1);
		mazoCartas[i++] = new CartaModificadora(true, -1, -1, -15);
		mazoCartas[i++] = new CartaModificadora(true, 0, 0, 0);
		// crear las 58 cartas de modificadores
		// las que restan puntos
		for (int j = 1; j <= 5; j++)
			mazoCartas[i++] = new CartaModificadora(false, -10, -1, -1);
		for (int j = 1; j <= 5; j++)
			mazoCartas[i++] = new CartaModificadora(false, -15, -1, -1);
		for (int j = 1; j <= 6; j++)
			mazoCartas[i++] = new CartaModificadora(false, -20, -1, -1);
		for (int j = 1; j <= 2; j++)
			mazoCartas[i++] = new CartaModificadora(false, -1, -10, -1);
		for (int j = 1; j <= 2; j++)
			mazoCartas[i++] = new CartaModificadora(false, -1, -15, -1);
		for (int j = 1; j <= 3; j++)
			mazoCartas[i++] = new CartaModificadora(false, -1, -20, -1);
		mazoCartas[i++] = new CartaModificadora(false, -1, -25, -1);
		mazoCartas[i++] = new CartaModificadora(false, -1, -1, -10);
		mazoCartas[i++] = new CartaModificadora(false, -1, -1, -15);
		mazoCartas[i++] = new CartaModificadora(false, -1, -1, -25);
		mazoCartas[i++] = new CartaModificadora(false, -5, -5, -1);
		mazoCartas[i++] = new CartaModificadora(false, -10, -5, -1);
		mazoCartas[i++] = new CartaModificadora(false, -10, -10, -1);
		mazoCartas[i++] = new CartaModificadora(false, -10, -10, -1);
		mazoCartas[i++] = new CartaModificadora(false, -15, -10, -1);
		mazoCartas[i++] = new CartaModificadora(false, -15, -15, -1);
		mazoCartas[i++] = new CartaModificadora(false, -15, -15, -1);
		mazoCartas[i++] = new CartaModificadora(false, -20, -10, -1);
		mazoCartas[i++] = new CartaModificadora(false, -1, -10, -10);
		mazoCartas[i++] = new CartaModificadora(false, -1, -15, -20);
		mazoCartas[i++] = new CartaModificadora(false, -1, -20, -20);
		mazoCartas[i++] = new CartaModificadora(false, -10, -1, -15);
		mazoCartas[i++] = new CartaModificadora(false, -15, -1, -10);
		mazoCartas[i++] = new CartaModificadora(false, -10, -1, -20);
		for (int j = 1; j <= 2; j++)
			mazoCartas[i++] = new CartaModificadora(false, -15, -1, -15);
		mazoCartas[i++] = new CartaModificadora(false, -15, -15, -15);

		// crear las que suman puntos
		for (int j = 1; j <= 2; j++)
			mazoCartas[i++] = new CartaModificadora(false, 10, -1, -1);
		mazoCartas[i++] = new CartaModificadora(false, 15, -1, -1);
		mazoCartas[i++] = new CartaModificadora(false, -1, 10, -1);
		mazoCartas[i++] = new CartaModificadora(false, -1, 15, -1);
		mazoCartas[i++] = new CartaModificadora(false, 10, 5, -1);
		mazoCartas[i++] = new CartaModificadora(false, 10, 0, -1);
		for (int j = 1; j <= 2; j++)
			mazoCartas[i++] = new CartaModificadora(false, 0, -1, 15);
		for (int j = 1; j <= 2; j++)
			mazoCartas[i++] = new CartaModificadora(false, 0, -1, 20);
		mazoCartas[i++] = new CartaModificadora(false, 0, 10, -1);
		for (int j = 1; j <= 2; j++)
			mazoCartas[i++] = new CartaModificadora(false, 0, 15, -1);

		barajar();
	}

	public CartaModificadora quitarCartaMazo() {
		CartaModificadora carta = mazoCartas[numCartas - 1];
		numCartas--;

		return carta;
	}

	private void barajar() {
		CartaModificadora[] aux = new CartaModificadora[78];
		Random rnd = new Random();
		int pos;
		for (int i = 0; i < CARTAS_MAZO; i++) {
			do {
				pos = rnd.nextInt(78);
			} while (aux[pos] != null);

			aux[pos] = mazoCartas[i];
		}

		for (int j = 0; j < CARTAS_MAZO; j++) {
			mazoCartas[j] = aux[j];
		}

	}

	@Override
	public String toString() {
		StringBuilder toret = new StringBuilder();
		for (int i = 0; i < CARTAS_MAZO; i++) {
			toret.append(mazoCartas[i].toString());
		}
		return toret.toString();

	}

}
