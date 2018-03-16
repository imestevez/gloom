
public class CartaModificadora {
	
	private boolean muertePrematura;
	private int puntoAlto;
	private int puntoMedio;
	private int puntoBajo;
	
	
	public CartaModificadora(boolean muertePrematura, int puntoAlto, int puntoMedio, int puntoBajo){
		this.muertePrematura = muertePrematura;
		this.puntoAlto = puntoAlto;
		this.puntoMedio = puntoMedio;
		this.puntoBajo = puntoBajo;
	}

	public String esMuerte(){
		if(muertePrematura == true)
			return "Muerte";
		else{
			return "    ";
		}
	}
	
	public boolean isMuertePrematura() {
			return muertePrematura;
	}
	
	public int getPuntoAlto() {
		return puntoAlto;
	}


	public int getPuntoMedio() {
		return puntoMedio;
	}


	public int getPuntoBajo() {
		return puntoBajo;
	}
	
	
	
	

}
