package modelo;

public class PartidoProgramado {

	private String dia;
	private String mes;
	private String año;
	private String hora;
	private String local;
	private String visitante;
	
	public PartidoProgramado(String dia, String mes, String año, String hora, String local, String visitante) {

		this.dia = dia;
		this.mes = mes;
		this.año = año;
		this.hora = hora;
		this.local = local;
		this.visitante = visitante;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getVisitante() {
		return visitante;
	}

	public void setVisitante(String visitante) {
		this.visitante = visitante;
	}
	
	
	
	
}
