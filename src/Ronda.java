import java.util.ArrayList;
import java.util.List;

public class Ronda {
	int numRonda;
	private List <Partido> partidos = new ArrayList<Partido>();
	
	public int puntosRonda(){
		int puntos = 0;
		
		return puntos;
	}

	public List<Partido> getPartidos() {
		return partidos;
	}

	public void addPartidos(Partido nuevoPartido) {
		this.partidos.add(nuevoPartido);
		
	}
}

