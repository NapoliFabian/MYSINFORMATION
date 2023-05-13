package Control;

import Model.Notizia;

public class ControllerFakeFight {

	public void ricezioneNotizia(Notizia n) {
		
		System.out.println(n.toString());
	}
	
	/*public String estrazioneContenuto(Notizia n) {
		String infoPrincipali = " ";
		String[]elimina = {"il","lo","la","li","gli","già",""};
		String contenuto = n.getTesto();
		
		
		return infoPrincipali;
	}*/
}
