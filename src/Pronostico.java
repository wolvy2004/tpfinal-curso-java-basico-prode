
public class Pronostico {
	private int id;
	private Equipo equipo;
	private Partido partido;
	private Resultado resultado;
	
	public Pronostico(int id, Equipo equipo, Partido partido, Resultado resultado) {
		this.id = id;
		this.equipo = equipo;
		this.partido = partido;
		this.resultado = resultado;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}
	
	public int puntos() {
		int puntos = 0;
		if(this.partido.resultado(this.equipo)==this.resultado) {
			return puntos = 1;
		}
		return puntos;
	}
	
	

}
