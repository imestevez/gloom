public class Familia {

	private CartaPersonaje[] familias;
	private int autoestima ;
	public static final int NUM_PERSONAJES = 5;

	public Familia(CartaPersonaje[] familias) {
		this.familias = familias;
		autoestima = 0;
	}

	public CartaPersonaje getPersonaje(int pos) {

		return familias[pos];
	}
	
	public boolean familiaIsMuerta(){
		int i = 0;
		while(i<NUM_PERSONAJES && familias[i].isMuerto() == true){
			i++;
		}
		if(i==NUM_PERSONAJES){
			return true;
		}
		else{
			return false;
		}
	}

	public int getAutoestima() {
		for (int i = 0; i < NUM_PERSONAJES; i++) {
			if (familias[i].isMuerto() == true) {
				autoestima += familias[i].getAutoestima();
			}
		}
		return (autoestima/2);
	}


	public String toString(int fami) {
		StringBuilder toret = new StringBuilder();
		
		if (fami == 0){

			toret.append("\n\nPersonaje 0\t\tPersonaje 1\t\tPersonaje 2\t\tPersonaje 3\t\tPersonaje 4");
			toret.append("\n _______________\t"+" _______________\t"+" _______________\t"+" _______________\t"+" _______________\n");
			toret.append("|"+familias[0].getNombre()+"\t|" +"\t|" +familias[1].getNombre()+"\t|"+"\t|"+familias[2].getNombre()+"\t|"+"\t|"+familias[3].getNombre()+"\t\t|"+"\t|"+familias[4].getNombre()+"\t\t|\n");
			toret.append("|"+familias[0].getPuntuacionAlta()+"\t\t|"+"\t|"+familias[1].getPuntuacionAlta()+"\t\t|"+"\t|"+familias[2].getPuntuacionAlta()+"\t\t|"+"\t|"+familias[3].getPuntuacionAlta()+"\t\t|"+"\t|"+familias[4].getPuntuacionAlta()+"\t\t|\n");
			toret.append("|"+familias[0].getPuntuacionMedia()+"\t\t|"+"\t|"+familias[1].getPuntuacionMedia()+"\t\t|"+"\t|"+familias[2].getPuntuacionMedia()+"\t\t|"+"\t|"+familias[3].getPuntuacionMedia()+"\t\t|"+"\t|"+familias[4].getPuntuacionMedia()+"\t\t|\n");
			toret.append("|"+familias[0].getPuntuacionBaja()+"\t\t|"+"\t|"+familias[1].getPuntuacionBaja()+"\t\t|"+"\t|"+familias[2].getPuntuacionBaja()+"\t\t|"+"\t|"+familias[3].getPuntuacionBaja()+"\t\t|"+"\t|"+familias[4].getPuntuacionBaja()+"\t\t|\n");
			toret.append("|"+familias[0].estaMuerto()+"\t\t|"+"\t|"+familias[1].estaMuerto()+"\t\t|"+"\t|"+familias[2].estaMuerto()+"\t\t|"+"\t|"+familias[3].estaMuerto()+"\t\t|"+"\t|"+familias[4].estaMuerto()+"\t\t|\n");
			toret.append("|"+"Total: "+familias[0].getAutoestima()+"\t|"+"\t|"+"Total: "+familias[1].getAutoestima()+"\t|"+"\t|"+"Total: "+familias[2].getAutoestima()+"\t|"+"\t|"+"Total: "+familias[3].getAutoestima()+"\t|"+"\t|"+"Total: "+familias[4].getAutoestima()+"\t|\n");
			toret.append("|_______________|\t"+"|_______________|\t"+"|_______________|\t"+"|_______________|\t"+"|_______________|\n");

		}else if(fami ==1){
			
			toret.append("\n\nPersonaje 0\t\tPersonaje 1\t\tPersonaje 2\t\tPersonaje 3\t\tPersonaje 4");
			toret.append("\n _______________\t"+" _______________\t"+" _______________\t"+" _______________\t"+" _______________\n");
			toret.append("|"+familias[0].getNombre()+"\t|" +"\t|" +familias[1].getNombre()+"\t|"+"\t|"+familias[2].getNombre()+"\t|"+"\t|"+familias[3].getNombre()+"\t\t|"+"\t|"+familias[4].getNombre()+"\t\t|\n");
			toret.append("|"+familias[0].getPuntuacionAlta()+"\t\t|"+"\t|"+familias[1].getPuntuacionAlta()+"\t\t|"+"\t|"+familias[2].getPuntuacionAlta()+"\t\t|"+"\t|"+familias[3].getPuntuacionAlta()+"\t\t|"+"\t|"+familias[4].getPuntuacionAlta()+"\t\t|\n");
			toret.append("|"+familias[0].getPuntuacionMedia()+"\t\t|"+"\t|"+familias[1].getPuntuacionMedia()+"\t\t|"+"\t|"+familias[2].getPuntuacionMedia()+"\t\t|"+"\t|"+familias[3].getPuntuacionMedia()+"\t\t|"+"\t|"+familias[4].getPuntuacionMedia()+"\t\t|\n");
			toret.append("|"+familias[0].getPuntuacionBaja()+"\t\t|"+"\t|"+familias[1].getPuntuacionBaja()+"\t\t|"+"\t|"+familias[2].getPuntuacionBaja()+"\t\t|"+"\t|"+familias[3].getPuntuacionBaja()+"\t\t|"+"\t|"+familias[4].getPuntuacionBaja()+"\t\t|\n");
			toret.append("|"+familias[0].estaMuerto()+"\t\t|"+"\t|"+familias[1].estaMuerto()+"\t\t|"+"\t|"+familias[2].estaMuerto()+"\t\t|"+"\t|"+familias[3].estaMuerto()+"\t\t|"+"\t|"+familias[4].estaMuerto()+"\t\t|\n");
			toret.append("|"+"Total: "+familias[0].getAutoestima()+"\t|"+"\t|"+"Total: "+familias[1].getAutoestima()+"\t|"+"\t|"+"Total: "+familias[2].getAutoestima()+"\t|"+"\t|"+"Total: "+familias[3].getAutoestima()+"\t|"+"\t|"+"Total: "+familias[4].getAutoestima()+"\t|\n");
			toret.append("|_______________|\t"+"|_______________|\t"+"|_______________|\t"+"|_______________|\t"+"|_______________|\n");

		}
		else if (fami == 2){
			toret.append("\nPersonaje 0\t\tPersonaje 1\t\tPersonaje 2\t\tPersonaje 3\t\tPersonaje 4");
			toret.append("\n _______________\t"+" _______________\t"+" _______________\t"+" _______________\t"+" _______________\n");
			toret.append("|"+familias[0].getNombre()+"\t\t|" +"\t|" +familias[1].getNombre()+"\t|"+"\t|"+familias[2].getNombre()+"\t\t|"+"\t|"+familias[3].getNombre()+"\t\t|"+"\t|"+familias[4].getNombre()+"\t\t|\n");
			toret.append("|"+familias[0].getPuntuacionAlta()+"\t\t|"+"\t|"+familias[1].getPuntuacionAlta()+"\t\t|"+"\t|"+familias[2].getPuntuacionAlta()+"\t\t|"+"\t|"+familias[3].getPuntuacionAlta()+"\t\t|"+"\t|"+familias[4].getPuntuacionAlta()+"\t\t|\n");
			toret.append("|"+familias[0].getPuntuacionMedia()+"\t\t|"+"\t|"+familias[1].getPuntuacionMedia()+"\t\t|"+"\t|"+familias[2].getPuntuacionMedia()+"\t\t|"+"\t|"+familias[3].getPuntuacionMedia()+"\t\t|"+"\t|"+familias[4].getPuntuacionMedia()+"\t\t|\n");
			toret.append("|"+familias[0].getPuntuacionBaja()+"\t\t|"+"\t|"+familias[1].getPuntuacionBaja()+"\t\t|"+"\t|"+familias[2].getPuntuacionBaja()+"\t\t|"+"\t|"+familias[3].getPuntuacionBaja()+"\t\t|"+"\t|"+familias[4].getPuntuacionBaja()+"\t\t|\n");
			toret.append("|"+familias[0].estaMuerto()+"\t\t|"+"\t|"+familias[1].estaMuerto()+"\t\t|"+"\t|"+familias[2].estaMuerto()+"\t\t|"+"\t|"+familias[3].estaMuerto()+"\t\t|"+"\t|"+familias[4].estaMuerto()+"\t\t|\n");
			toret.append("|"+"Total: "+familias[0].getAutoestima()+"\t|"+"\t|"+"Total: "+familias[1].getAutoestima()+"\t|"+"\t|"+"Total: "+familias[2].getAutoestima()+"\t|"+"\t|"+"Total: "+familias[3].getAutoestima()+"\t|"+"\t|"+"Total: "+familias[4].getAutoestima()+"\t|\n");
			toret.append("|_______________|\t"+"|_______________|\t"+"|_______________|\t"+"|_______________|\t"+"|_______________|\n");
			
		}
		else if( fami==3){
			toret.append("\nPersonaje 0\t\tPersonaje 1\t\tPersonaje 2\t\tPersonaje 3\t\tPersonaje 4");
			toret.append("\n _______________\t"+" _______________\t"+" _______________\t"+" _______________\t"+" _______________\n");
			toret.append("|"+familias[0].getNombre()+"\t\t|" +"\t|" +familias[1].getNombre()+"\t\t|"+"\t|"+familias[2].getNombre()+"\t\t|"+"\t|"+familias[3].getNombre()+"\t\t|"+"\t|"+familias[4].getNombre()+"\t\t|\n");
			toret.append("|"+familias[0].getPuntuacionAlta()+"\t\t|"+"\t|"+familias[1].getPuntuacionAlta()+"\t\t|"+"\t|"+familias[2].getPuntuacionAlta()+"\t\t|"+"\t|"+familias[3].getPuntuacionAlta()+"\t\t|"+"\t|"+familias[4].getPuntuacionAlta()+"\t\t|\n");
			toret.append("|"+familias[0].getPuntuacionMedia()+"\t\t|"+"\t|"+familias[1].getPuntuacionMedia()+"\t\t|"+"\t|"+familias[2].getPuntuacionMedia()+"\t\t|"+"\t|"+familias[3].getPuntuacionMedia()+"\t\t|"+"\t|"+familias[4].getPuntuacionMedia()+"\t\t|\n");
			toret.append("|"+familias[0].getPuntuacionBaja()+"\t\t|"+"\t|"+familias[1].getPuntuacionBaja()+"\t\t|"+"\t|"+familias[2].getPuntuacionBaja()+"\t\t|"+"\t|"+familias[3].getPuntuacionBaja()+"\t\t|"+"\t|"+familias[4].getPuntuacionBaja()+"\t\t|\n");
			toret.append("|"+familias[0].estaMuerto()+"\t\t|"+"\t|"+familias[1].estaMuerto()+"\t\t|"+"\t|"+familias[2].estaMuerto()+"\t\t|"+"\t|"+familias[3].estaMuerto()+"\t\t|"+"\t|"+familias[4].estaMuerto()+"\t\t|\n");
			toret.append("|"+"Total: "+familias[0].getAutoestima()+"\t|"+"\t|"+"Total: "+familias[1].getAutoestima()+"\t|"+"\t|"+"Total: "+familias[2].getAutoestima()+"\t|"+"\t|"+"Total: "+familias[3].getAutoestima()+"\t|"+"\t|"+"Total: "+familias[4].getAutoestima()+"\t|\n");
			toret.append("|_______________|\t"+"|_______________|\t"+"|_______________|\t"+"|_______________|\t"+"|_______________|\n");
		}
		return toret.toString();
	}
	

}
