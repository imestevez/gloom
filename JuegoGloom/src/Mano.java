public class Mano {

	CartaModificadora[] cartasMano;
	private static final int MAX_MANO = 5;
	private int numCartas;

	public Mano() {
		this.numCartas = 0;
		cartasMano = new CartaModificadora[MAX_MANO];
	}

	public int getNumCartas() {
		return numCartas;
	}

	public void setNumCartas(int numCartas) {
		this.numCartas = numCartas;
	}

	public void añadirCarta(CartaModificadora carta) {
		cartasMano[numCartas] = carta;
		numCartas++;
	}

	public CartaModificadora quitarCarta(int pos) {
		CartaModificadora carta = cartasMano[pos];
		cartasMano[pos] = cartasMano[numCartas - 1];
		cartasMano[numCartas - 1] = null;
		numCartas--;
		return carta;

	}

	public String toString() {

		StringBuilder toret = new StringBuilder();
		toret.append("\n\n");

		for (int i = 0; i < numCartas; i++) {

			toret.append("Carta " + i + "\t\t\t");
		}
		toret.append("\n");

		for (int i = 0; i < numCartas; i++) {
			toret.append(" _______________\t");
		}
		toret.append("\n");

		for (int i = 0; i < numCartas; i++) {
			toret.append("|" + cartasMano[i].esMuerte() + "\t\t|");
			toret.append("\t");

		}
		toret.append("\n");

		for (int i = 0; i < numCartas; i++) {

			if(cartasMano[i].getPuntoAlto() == -1){
				toret.append("|" + " " + "\t\t|");
				toret.append("\t");
			}else{
			toret.append("|" + cartasMano[i].getPuntoAlto() + "\t\t|");
			toret.append("\t");
			}
		}
		toret.append("\n");

		for (int i = 0; i < numCartas; i++) {

			if(cartasMano[i].getPuntoMedio() == -1){
				toret.append("|" + " " + "\t\t|");
				toret.append("\t");
			}else{
			toret.append("|" + cartasMano[i].getPuntoMedio() + "\t\t|");
			toret.append("\t");
			}
		}
		toret.append("\n");

		for (int i = 0; i < numCartas; i++) {

			if(cartasMano[i].getPuntoBajo() == -1){
				toret.append("|" + " " + "\t\t|");
				toret.append("\t");
			}else{
			toret.append("|" + cartasMano[i].getPuntoBajo() + "\t\t|");
			toret.append("\t");
			}
		}
		toret.append("\n");

		for (int i = 0; i < numCartas; i++) {

			toret.append("|_______________|\t");
		}
		toret.append("\n");

		return toret.toString();
	}

}