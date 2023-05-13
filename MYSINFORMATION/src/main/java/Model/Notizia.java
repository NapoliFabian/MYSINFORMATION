package Model;

import java.io.File;

public class Notizia {

	private String testo;
	private File file;
	private float indice;
	private String fonteProvenienza;
	
	public Notizia(String testo, File file, float indice,String fonteProvenienza) {
		super();
		this.testo = testo;
		this.file = file;
		this.indice = indice;
		this.fonteProvenienza = fonteProvenienza;
	}
	
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public float getIndice() {
		return indice;
	}
	public void setIndice(float indice) {
		this.indice = indice;
	}

	public String getFonteProvenienza() {
		return fonteProvenienza;
	}
	public void setFonteProvenienza(String fonteProvenienza) {
		this.fonteProvenienza = fonteProvenienza;
	}

	@Override
	public String toString() {
		return "Notizia [testo=" + testo + ", file=" + file + ", indice=" + indice + ", fonteProvenienza="
				+ fonteProvenienza + "]";
	}
	
	
}


