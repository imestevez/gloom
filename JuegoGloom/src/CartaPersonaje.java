public class CartaPersonaje {
	
	private String nombre;
	private int autoestima;
	private CartaModificadora[] cartasParaAutoestima;
	private int []puntuacion;
	private int pos = 0;
	
	private boolean muerto = false;
	
	public CartaPersonaje(String nombre){
		this.nombre = nombre;
		cartasParaAutoestima = new CartaModificadora[78];
		puntuacion = new int[3];
	}
	
	public void añadirCartaModificadora(CartaModificadora carta){
		
		if(carta.isMuertePrematura()==true){
			setMuerto(true);
		}	
		if(carta.getPuntoAlto()!=-1){
			puntuacion[0] = carta.getPuntoAlto();
		}
		if(carta.getPuntoMedio()!=-1){
			puntuacion[1] = carta.getPuntoMedio();
		}
		if(carta.getPuntoBajo()!=-1){
			puntuacion[2] = carta.getPuntoBajo();
		}
		
		cartasParaAutoestima[pos++] = carta;
		
	}
	public int getPuntuacionAlta(){
		return puntuacion[0];
	}
	public int getPuntuacionMedia(){
		return puntuacion[1];
	}
	public int getPuntuacionBaja(){
		return puntuacion[2];
	}
	public String getNombre(){
		return nombre;
	}
	
	public int getAutoestima(){
		autoestima = puntuacion[0]+puntuacion[1]+puntuacion[2];
		
		return autoestima;
	}

	public boolean isMuerto() {
		return muerto;
	}

	public String estaMuerto() {
		if(isMuerto() == true){
		return "Muerto";
		}else{
			return "Vivo";
		}
	}
	
	public void setMuerto(boolean muerto) {
		this.muerto = muerto;
	}
}
