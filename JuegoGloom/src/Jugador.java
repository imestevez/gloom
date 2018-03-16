import java.util.Scanner;

public class Jugador {

	private String nombre;
	private Mano cartasJugador;
	private Familia cartasMesa;

	Scanner in = new Scanner(System.in);

	public Jugador(String nombre, Familia cartasMesa) {
		this.nombre = nombre;
		this.cartasMesa = cartasMesa;
		cartasJugador = new Mano();
	}
	
	//Se llama al final de cada turno de jugador en Principal (jugar()) y para inicializar
	//las manos en (repartirCartas())
	public void añadirToMano(CartaModificadora carta) { 
		cartasJugador.añadirCarta(carta); 
	}

	// Elige la carta de la mano que va utilizar y la devuelve
	public CartaModificadora seleccionarCarta() {
		int pos;
		
		do{
			System.out.println("Selecciona la carta Modificadora que desea poner");
			
			pos = Integer.parseInt(in.nextLine());
		
			if(pos<0 || pos >= cartasJugador.getNumCartas()){
				 System.err.println("\nSelecciona la carta Modificadora correctamente\n");
			}
		
		}while(pos<0 || pos >= cartasJugador.getNumCartas());
		
		return cartasJugador.quitarCarta(pos);
	}

	// Coloca una carta en un personaje
	public void ponerCarta(CartaModificadora cm) {
		CartaPersonaje cartaTemp;
		
		// Elige la posición del personaje mientras no esté muerto
		int pos;
		do{
			do {
			System.out.println("Elige posicion carta");
			pos = Integer.parseInt(in.nextLine());
			
		} while (pos<0 || pos >= cartasMesa.NUM_PERSONAJES);
			
			cartaTemp = cartasMesa.getPersonaje(pos);
		}while(cartaTemp.isMuerto() == true);
		
		// añade carta al personaje
		do {
			if (cm.isMuertePrematura() == true && cartaTemp.isMuerto() == false && cartaTemp.getAutoestima() >= 0) {
				System.err.println("NO PUEDES MATAR A ESE PERSONAJE");
				System.out.println("Elige posicion carta");
				pos = Integer.parseInt(in.nextLine());
				cartaTemp = cartasMesa.getPersonaje(pos);
			}

		} while (cm.isMuertePrematura() == true && cartaTemp.isMuerto() == false && cartaTemp.getAutoestima() >= 0);

		cartaTemp.añadirCartaModificadora(cm);

	}

	public int getNumCartasMano() {
		return cartasJugador.getNumCartas();
	}

	public int getAutoestima() {
		return cartasMesa.getAutoestima();
	}

	public Familia getFamilia() {
		return cartasMesa;
	}

	public String getNombre() {
		return nombre;
	}

	public String toString(int fami) {
		StringBuilder toret = new StringBuilder();

		toret.append("\n\n");
		toret.append("\t\t\t\t\t\t* *" + nombre + "* *\n\n");
		toret.append("\t\t\t\t\t\t- CARTAS MANO -\n");
		toret.append(cartasJugador.toString());
		toret.append("\n\n\t\t\t\t\t\t- CARTAS MESA -\n");
		toret.append(cartasMesa.toString(fami));

		return toret.toString();
	}

}