import java.util.Scanner;

public class Principal {

	private static int numJugadores = 0;
	private static final int MAX_CARTAS = 5;
	private static Jugador[] jugadores; // Array de jugadores
	private static Mazo mazo;
	private static int[] fami;
	static Scanner in = new Scanner(System.in);

	// *********************************************************
	public static int menu() {
		int op = 0;

		System.out.println("* * * Juego Gloom * * *\n");
		do {
			System.out.println("1: Si desea Jugar\n2: Si desea salir");
			op = Integer.parseInt(in.nextLine());
			if (op < 1 || op > 2) {
				System.out.println("Seleccione la opcion correcta");

			}

		} while (op < 1 || op > 2);
		return op;
	}

	public static void getNumJugadores() {
		do {

			System.out.println("Elige el numero de jugadores: ");
			numJugadores = Integer.parseInt(in.nextLine());

			if (numJugadores < 2 || numJugadores > 4) {
				System.err.println("\nInserte un numero entre 2 y 4\n");

			}
		} while (numJugadores < 2 || numJugadores > 4);

		jugadores = new Jugador[numJugadores]; // Inicializa el array con tantas posiciones
											 //como jugadores
		fami = new int[numJugadores];
		for (int x = 0; x < numJugadores; x++) { // asigna -1 a todas las
												// posiciones del array
			fami[x] = -1;
		}
	}

	public static void creaJugador(int pos) {

		int familia = -1;
		boolean FamiliaEscogida = false;

		System.out.println("\nJugador " + (pos) + "\nEscribe tu nombre");
		String nombre = in.nextLine();

		do {
			if (FamiliaEscogida == true) {
				System.err.println("La familia " + familia + " esta seleccionada, elija otra.\n");
			}

			for (int i = 0; i < 4; i++) {
				System.out.println("Familia " + (i) + " :" + FamiliasDelJuego.getFamilia(i).toString(i) + "\n");
			}

			System.out.println("Elige la familia\n");
			familia = Integer.parseInt(in.nextLine()); 

			if (familia < 0 || familia > 3) {

				System.err.println("Familia no valida, elija un numero del 0 al 3");
			}
			FamiliaEscogida = false;
			
			for (int j = 0; j < numJugadores; j++) {
				if (fami[j] == familia) {
					FamiliaEscogida = true;
				}
			}

		} while (familia < 0 || familia > 3 || FamiliaEscogida == true);

		// Crea objeto de jugador
		if (FamiliaEscogida == false) {
			Jugador jugador = new Jugador(nombre, FamiliasDelJuego.getFamilia(familia));

			jugadores[pos] = jugador;
			fami[pos] = familia;   
		}
	}

	// Reparte 5 cartas inicialmente a cada jugador creado

	public static void repartirCartas() {
		for (int i = 0; i < numJugadores; i++) {
			for (int j = 0; j < MAX_CARTAS; j++) {
				jugadores[i].añadirToMano(mazo.quitarCartaMazo());
			}
		}
	}

	public static void jugar() {

		CartaModificadora cartaTemp;
		int turno = 0;
		int turnoAux = 0;
		int jug = 0;
		boolean finalizar = false;
		String pasar = null;

		do {

			do {
				System.out.println("Jugador "+turno+": Pulsa cualquier tecla (N: Pasar turno)");
				pasar = in.nextLine().toUpperCase();

				if (pasar.charAt(0) == 'N') {
					turnoAux++;
				} else {

					for (int i = 0; i < 40; i++) {
						System.out.println();
					}

					System.out.println("\n\nTurno de " + jugadores[turno].getNombre() + "(JUGADOR " + turno + ") :\n");
					System.out.println(jugadores[turno].toString(fami[turno]));

					for (int i = 0; i < fami.length; i++) {
						if (i != turno) {
							int imprimeFamilia = fami[i];
							System.out.println("\n\t\t\t\t\t\tJUGADOR " + i + " :");
							System.out.println(FamiliasDelJuego.getFamilia(imprimeFamilia).toString(imprimeFamilia));
						}
					}

					do {

						cartaTemp = jugadores[turno].seleccionarCarta(); // selecciona carta de la mano

						if (cartaTemp.isMuertePrematura() == true && turnoAux == 1) {
							System.err.println("En el segundo turno no puedes usar una carta de muerte");
						}
					} while (cartaTemp.isMuertePrematura() == true && turnoAux == 1);
					do {
						System.out.println("Elige el Jugador sobre el que jugar la carta seleccionada:");
						jug = Integer.parseInt(in.nextLine());

						if (jug < 0 || jug >= numJugadores) {
							System.err.println("\nElige el Jugador correctamente\n");
						}

					} while (jug < 0 || jug >= numJugadores);

					jugadores[jug].ponerCarta(cartaTemp);

					turnoAux++;
					finalizar = finPartida();
				}

			} while (turnoAux < 2 && finalizar == false);

			turnoAux = 0;
			turno++;

			if (turno == numJugadores) {
				turno = 0;
			}
			finalizar = finPartida();

			while (jugadores[turno].getNumCartasMano() < 5) {

				jugadores[turno].añadirToMano(mazo.quitarCartaMazo());  // rellena la mano con carta del mazo
			}

		} while (finalizar == false);

	}

	public static boolean finPartida() {
		int i = 0;
		while (i < numJugadores && jugadores[i].getFamilia().familiaIsMuerta() == false) {
			i++;
		}
		if (i == numJugadores) {
			return false;
		}
		return true;
	}

	public static void recuentoFinal() {
		System.out.println("\n\n\n\t\t\t\t****EL JUEGO HA TERMINADO****");
		Jugador ganador = jugadores[0];

		for (int i = 1; i < numJugadores; i++) {
			if (jugadores[i].getAutoestima() < ganador.getAutoestima()) {
				ganador = jugadores[i];
			}
		}

		System.out.println("\t\t**EL GANADOR ES :" + ganador.getNombre() + ", Puntos: " + ganador.getAutoestima());

	}

	public static void instrucciones() {

		System.err.println("\n\n\nINSTRUCCIONES:");
		System.out.println("El juego consiste en conseguir que los personajes de tu familia tengan la menor "
				+ "cantidad de autoestima posible.\n"
				+ "El juego termina cuando un jugador logra matar a todos sus personajes.");
		System.out.println(
				"El turno del jugador se dividirá en dos jugadas, en las cuales podrá usar únicamente una carta en cada uno, o si lo desea, pasar sin jugar ninguna carta.\n"
						+ "Una vez que un jugador haya jugado la primera carta, no podrá jugar a continuación una carta de muerte prematura.\n\n\n\n");
	}

	public static void main(String[] args) {

		switch (menu()) {
		case 1: {
			mazo = new Mazo();
			instrucciones();
			getNumJugadores();

			for (int i = 0; i < numJugadores; i++) {
				creaJugador(i);
			}

			repartirCartas(); // inicializa mano
			jugar();

			recuentoFinal();

			System.out.println("Gracias por jugar");
		}
			break;
		case 2: {
			System.out.println("Gracias por jugar");
		}
			break;

		default:

			break;
		}

	}
}
