
public class Partido {
	
	private int id, golesEquipo1, golesEquipo2;
	private Equipo equipo1;
	private Equipo equipo2;
	

	
	public int getGolesEquipo1() {
		return golesEquipo1;
	}

	public Partido(int id, int golesEquipo1, int golesEquipo2, Equipo equipo1, Equipo equipo2) {
		this.id = id;
		this.golesEquipo1 = golesEquipo1;
		this.golesEquipo2 = golesEquipo2;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
	}

	public void setGolesEquipo1(int golesEquipo1) {
		this.golesEquipo1 = golesEquipo1;
	}

	public int getGolesEquipo2() {
		return golesEquipo2;
	}


	public void setGolesEquipo2(int golesEquipo2) {
		this.golesEquipo2 = golesEquipo2;
	}

	public Equipo getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}


	public Equipo getEquipo2() {
		return equipo2;
	}


	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}


	public Resultado resultado(Equipo equipo) {
		
		//System.out.println(this.golesEquipo1 + this.equipo1.getNombre());
		//System.out.println(this.golesEquipo2 + this.equipo2.getNombre());
		
		if(this.golesEquipo1==this.golesEquipo2) {
			return Resultado.EMPATE;	
		}
		if(this.equipo1.getNombre().equals(equipo.getNombre())) {
			if(this.golesEquipo1>this.golesEquipo2) {
				return Resultado.GANADOR;
			}else {
				return Resultado.PERDEDOR;
			}
			
		} else if (this.equipo2.getNombre().equals(equipo.getNombre()))
			{
			if(this.golesEquipo1<this.golesEquipo2) {
				return Resultado.GANADOR;
			}else {
				return Resultado.PERDEDOR;
			}
		}
		return null;
		
		
		
	}

	public int getId() {
		return id;
	}


}
