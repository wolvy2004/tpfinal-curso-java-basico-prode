import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PronosticoMain {
 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Ronda ronda01 = new Ronda();	
		List <Pronostico> pronosticos = new ArrayList<Pronostico>();
		
		BufferedReader lector = null;
		// cargar los partidos y resultados de cada ronda //---
		try {
			lector = new BufferedReader(new FileReader("src/resultados.csv"));
			String line = lector.readLine();
			while(line != null) {
				String [] campos = line.split(",");
				int id = Integer.parseInt(campos[0]);
				Equipo equipo1 = new Equipo(campos[1]);
				Equipo equipo2 = new Equipo(campos[4]);
				int golesEquipo1 = Integer.parseInt(campos[2])	;
				int golesEquipo2 = Integer.parseInt(campos[3])	;
				Partido partido = new Partido (id, golesEquipo1, golesEquipo2, equipo1, equipo2);
				ronda01.addPartidos(partido);
				line = lector.readLine();
				//System.out.println("partido "  + ronda01.getPartidos().get(id).getId());
			}
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		finally {
			if(lector!=null) {
				lector.close();
			};
		}
		BufferedReader lector2 = null;
		
		try{
			lector2 = new BufferedReader(new FileReader("src/pronostico.csv"));
			String line = lector2.readLine();
			Equipo equipo = null;
			Resultado resultado = null;
			int indice = 0;
			while(line != null) {
				String [] campos = line.split(",");
				int id = Integer.parseInt(campos[0]);
				String equipo1 = campos[1];
				String equipo2 = campos[5];
				String ganador1 = campos[2];
				String empate = campos[3];
				String ganador2 = campos[4];
				Partido partido = ronda01.getPartidos().get(indice);
			
				
				if(ganador1.equals("x")) {
				 equipo = new Equipo(equipo1);
				 resultado = Resultado.GANADOR;
				}
				if(ganador2.equals("x")) {
					equipo = new Equipo (equipo2);
					resultado = Resultado.GANADOR;
				} else if(empate.equals("x")) {
					equipo = new Equipo(equipo1);
					resultado = Resultado.EMPATE;
					
				}
			
			
				Pronostico nuevoPronostico = new Pronostico (id, equipo, partido, resultado );
				pronosticos.add(nuevoPronostico);
				line = lector2.readLine();
				indice ++;
			}
		}
		catch (IOException e) {
			System.out.print(e.getMessage());
		}
		catch (Exception e) {
			System.out.print("error");
		}
		finally {
			if(lector2!=null) {
				lector2.close();
			};
		}
			int puntos = 0;
		 for( Pronostico p: pronosticos) {
			 
			  Resultado  resultado = p.getPartido().resultado(p.getEquipo());
			  puntos = puntos + p.puntos();
			  
			 
		 }
		 int porcentaje = (puntos * 100) / ronda01.getPartidos().size();
		 System.out.println("los puntos del jugador fueron " + puntos + " sobre  " + ronda01.getPartidos().size() + " puntos posibles");
		 System.out.print("con un "+porcentaje + "% de acierto");
		 

	}

}
